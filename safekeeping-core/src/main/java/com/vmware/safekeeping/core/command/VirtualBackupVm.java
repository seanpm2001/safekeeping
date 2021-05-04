/*******************************************************************************
 * Copyright (C) 2021, VMware Inc
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package com.vmware.safekeeping.core.command;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.amazonaws.SdkClientException;
import com.vmware.jvix.JVixException;
import com.vmware.safekeeping.common.Utility;
import com.vmware.safekeeping.core.command.interactive.AbstractVirtualBackupDiskInteractive;
import com.vmware.safekeeping.core.command.options.CoreVirtualBackupOptions;
import com.vmware.safekeeping.core.command.results.AbstractCoreResultActionVirtualBackupForEntityWithDisks;
import com.vmware.safekeeping.core.command.results.CoreResultActionDiskVirtualBackup;
import com.vmware.safekeeping.core.command.results.CoreResultActionLoadProfile;
import com.vmware.safekeeping.core.command.results.CoreResultActionPrepeareGeneration;
import com.vmware.safekeeping.core.command.results.CoreResultActionVmVirtualBackup;
import com.vmware.safekeeping.core.command.results.miscellanea.CoreResultActionCloneConfigurationFiles;
import com.vmware.safekeeping.core.control.FcoArchiveManager;
import com.vmware.safekeeping.core.control.target.ITargetOperation;
import com.vmware.safekeeping.core.core.ThreadsManager;
import com.vmware.safekeeping.core.core.ThreadsManager.ThreadType;
import com.vmware.safekeeping.core.exception.CoreResultActionException;
import com.vmware.safekeeping.core.core.VirtualJvddk;
import com.vmware.safekeeping.core.logger.MessagesTemplate;
import com.vmware.safekeeping.core.profile.GenerationProfile;
import com.vmware.safekeeping.core.soap.VimConnection;
import com.vmware.safekeeping.core.type.GenerationInfo;

public class VirtualBackupVm extends AbstractBackupFcoWithDisks {

    public VirtualBackupVm(final VimConnection vimConnection, final CoreVirtualBackupOptions options,
            final Logger logger) {
        super(vimConnection, options, logger);
    }

    private boolean cloneConfigurationFiles(final CoreResultActionVmVirtualBackup rac)
            throws CoreResultActionException {

        final CoreResultActionCloneConfigurationFiles resultAction = new CoreResultActionCloneConfigurationFiles(rac);
        resultAction.start();
        try {
            final GenerationProfile dstProfile = rac.getProfile();
            final GenerationProfile srcProfile = rac.getSourceProfile();
            final ITargetOperation target = dstProfile.getTargetOperation();
            resultAction.setSrcNvramContentPath(srcProfile.getNvramContentPath());
            resultAction.setSrcVmxContentPath(srcProfile.getVmxContentPath());
            resultAction.setDstNvramContentPath(dstProfile.getNvramContentPath());
            resultAction.setDstVmxContentPath(dstProfile.getVmxContentPath());

            if (!target.doesObjectExist(resultAction.getSrcVmxContentPath())) {
                resultAction.failure(resultAction.getSrcVmxContentPath() + " content doesn't exist");
            } else if (!target.doesObjectExist(resultAction.getSrcNvramContentPath())) {
                resultAction.failure(resultAction.getSrcNvramContentPath() + " content doesn't exist");
            } else {
                target.copyObject(resultAction.getSrcVmxContentPath(), resultAction.getDstVmxContentPath());
                target.copyObject(resultAction.getSrcNvramContentPath(), resultAction.getDstNvramContentPath());
            }
            if (srcProfile.isVappConfigAvailable()) {
                resultAction.setSrcVappContentPath(srcProfile.getvAppConfigPath());
                resultAction.setDstVappContentPath(dstProfile.getvAppConfigPath());
                if (!target.doesObjectExist(resultAction.getSrcVappContentPath())) {
                    resultAction.failure(resultAction.getSrcVappContentPath() + " content doesn't exist");
                } else {
                    target.copyObject(resultAction.getSrcVappContentPath(), resultAction.getDstVappContentPath());
                }
            }
        } catch (final SdkClientException e) {
            resultAction.failure(e);
            Utility.logWarning(this.logger, e);
        } finally {
            resultAction.done();
        }
        return resultAction.isSuccessful();
    }

    public final CoreResultActionVmVirtualBackup virtualBackup(final FcoArchiveManager fcoArcMgr,
            final CoreResultActionVmVirtualBackup rac) throws CoreResultActionException {
        if (this.logger.isLoggable(Level.INFO)) {
            this.logger.info("backupVm() start.");
        }
        if (!getOptions().isDryRun()) {
            try {

                /**
                 * Start Section RetrieveProfile
                 */
                rac.getInteractive().startRetrieveProfile();
                if (this.logger.isLoggable(Level.INFO)) {
                    this.logger.info("restoreVm() start.");

                }
                final CoreResultActionLoadProfile resultActionLoadProfile = actionLoadProfile(fcoArcMgr, rac);
                final CoreResultActionLoadProfile resultActionLoadSourceProfile = actionLoadProfile(fcoArcMgr, rac);
                if (resultActionLoadProfile.isSuccessful() && resultActionLoadSourceProfile.isSuccessful()) {
                    rac.setProfile(resultActionLoadProfile.getProfile());
                    rac.setSourceProfile(resultActionLoadSourceProfile.getProfile());
                    rac.setLocations(rac.getProfile());
                    rac.getInteractive().endRetrieveProfile();
                    rac.setNumberOfDisk(rac.getProfile().getNumberOfDisks());
                    /**
                     * End Section RetrieveProfile
                     */

                    if (generationComputation(rac, fcoArcMgr) && cloneConfigurationFiles(rac)) {
                        for (int diskId = 0; diskId < resultActionLoadSourceProfile.getProfile()
                                .getNumberOfDisks(); diskId++) {
                            new CoreResultActionDiskVirtualBackup(diskId, rac);
                        }
                        final VirtualJvddk jvddk = new VirtualJvddk(this.logger, rac.getFirstClassObject());
                        if (virtualBackupDisks(rac, jvddk) && finalizeProfile(rac, fcoArcMgr)) {
                            final String msg = rac.getFcoToString() + " Backup Success - start cleaning";
                            if (this.logger.isLoggable(Level.INFO)) {
                                this.logger.info(msg);
                            }
                        }
                    }
                }
            } catch (final JVixException | NoSuchAlgorithmException | IOException e) {
                Utility.logWarning(this.logger, e);
                rac.failure(e);
            }
        }
        if (this.logger.isLoggable(Level.INFO)) {
            this.logger.info("backupVm() end.");
        }
        return rac;
    }

    private void virtualBackupVmdk(final CoreResultActionDiskVirtualBackup radc, final VirtualJvddk jvddk)
            throws CoreResultActionException {

        radc.start();
        final AbstractVirtualBackupDiskInteractive diskInteractive = ((AbstractCoreResultActionVirtualBackupForEntityWithDisks) radc
                .getParent()).getInteractive().newDiskInteractiveInstance(radc);
        try {
            /**
             * Start Section DiskRestore
             */
            diskInteractive.startVirtualBackupDisk();

            jvddk.doVirtualBackupJava(radc.getProfile().getFcoArchiveManager(), getOptions(), radc, diskInteractive);
            if (radc.isAbortedOrFailed()) {
                final String msg = String.format("Restoring vmdk %d failed.", radc.getDiskId());
                this.logger.warning(msg);
            }

        } finally {
            radc.done();
            diskInteractive.endVirtualBackupDisk();
            /**
             * End Section DiskRestore
             */
        }
    }

    private boolean virtualBackupDisks(final CoreResultActionVmVirtualBackup rar, final VirtualJvddk jvddk)
            throws CoreResultActionException {
        boolean result = false;
        try {
            final GenerationProfile profile = rar.getProfile();
            if (this.logger.isLoggable(Level.INFO)) {
                final String msg = String.format("Restore %d disks.", profile.getNumberOfDisks());
                this.logger.info(msg);
            }
            /**
             * Start Section DisksRestore
             */
            rar.getInteractive().startDisksVirtualBackup();

            final List<Future<CoreResultActionDiskVirtualBackup>> futures = new ArrayList<>();
            for (final CoreResultActionDiskVirtualBackup radr : rar.getResultActionsOnDisk()) {

                final Future<CoreResultActionDiskVirtualBackup> f = submit(radr, jvddk, this.logger);
                futures.add(f);
            }
            // A) Await all runnable to be done (blocking)
            for (final Future<CoreResultActionDiskVirtualBackup> future : futures) {
                if (future != null) {
                    // get will block until the future is done
                    final CoreResultActionDiskVirtualBackup obj = future.get();
                    if ((obj != null) && this.logger.isLoggable(Level.FINE)) {
                        this.logger.fine(obj.toString());
                    }
                } else {
                    final String msg = "Internal error - check server logs";
                    rar.failure(msg);
                }

            }
            result = true;

        } catch (final InterruptedException e) {
            this.logger.log(Level.WARNING, "Interrupted!", e);
            rar.failure(e);
            // Restore interrupted state...
            Thread.currentThread().interrupt();
        } catch (final ExecutionException e) {
            rar.failure(e);
            Utility.logWarning(this.logger, e);
        } finally {
            rar.getInteractive().endDisksVirtualBackup();
            /**
             * End Section DiskRestore
             */
        }
        return result;
    }

    protected boolean finalizeProfile(final CoreResultActionVmVirtualBackup rab, final FcoArchiveManager fcoArcMgr)
            throws NoSuchAlgorithmException, IOException {
        boolean result = false;
        /**
         * Start Section FinalizeProfile
         */
        rab.getInteractive().startFinalizeProfile();
        final GenerationProfile profile = rab.getProfile();
        final ITargetOperation target = profile.getTargetOperation();
        result = fcoArcMgr.finalizeBackup(profile, rab.getDiskActionsResult());
        if (rab.isFails()) {
            this.logger.warning("Backup finalization failed.");
        }

        result &= target.postGenerationProfile(profile);
        if (target.postMd5(profile)) {
            fcoArcMgr.postGenerationsCatalog();
        }
        rab.getInteractive().endFinalizeProfile();
        /**
         * End Section FinalizeProfile
         */
        return result;
    }

    protected boolean generationComputation(final AbstractCoreResultActionVirtualBackupForEntityWithDisks rab,
            final FcoArchiveManager fcoArcMgr) throws CoreResultActionException {
        /**
         * Start Section GenerationComputation
         */
        rab.getInteractive().startGenerationComputation();
        if (this.logger.isLoggable(Level.INFO)) {
            this.logger.info(MessagesTemplate.getLocationString(rab));
        }
        final GenerationProfile profile = rab.getProfile();
        final CoreResultActionPrepeareGeneration resultPrepareNewProfile = prepareNewGeneration(profile, rab);

        final GenerationInfo generationInfo = new GenerationInfo();
        generationInfo.setGenerationId(profile.getGenerationId());
        generationInfo.setPreviousGenerationId(profile.getPreviousGenerationId());
        generationInfo.setTargetUri(fcoArcMgr.getRepositoryTarget().getUri(profile.getGenerationPath()));
        generationInfo.setBackupMode(getOptions().getRequestedBackupMode());
        rab.setGenerationInfo(generationInfo);
        if (this.logger.isLoggable(Level.INFO)) {
            this.logger.info(MessagesTemplate.getGenerationInfo(rab));
        }
        rab.getInteractive().endGenerationComputation();
        /**
         * end Section GenerationComputation
         */

        return resultPrepareNewProfile.isSuccessful();
    }

    protected Future<CoreResultActionDiskVirtualBackup> submit(final CoreResultActionDiskVirtualBackup radr,
            final VirtualJvddk jvddk, final Logger logger) {
        return ThreadsManager.executor(ThreadType.ARCHIVE).submit(() -> {
            try {

                if (radr.isQueuing()) {
                    virtualBackupVmdk(radr, jvddk);
                } else {
                    if (radr.isDone()) {
                        logger.warning("Disk operation on disk" + radr.getDiskId() + " over");
                    } else {
                        final String msg = "Disk operation state is inconsistent " + radr.getState().toString();
                        logger.warning(msg);
                        radr.failure(msg);
                    }
                }
            } catch (final CoreResultActionException e) {
                Utility.logWarning(logger, e);

            }
            return radr;

        });
    }

}
