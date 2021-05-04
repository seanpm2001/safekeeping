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
package com.vmware.safekeeping.external.result;

import java.util.LinkedList;
import java.util.List;

import com.vmware.safekeeping.core.command.results.AbstractCoreResultActionBackupRestore;
import com.vmware.safekeeping.core.command.results.CoreResultActionDiskRestore;
import com.vmware.safekeeping.core.command.results.CoreResultActionVmRestore;
import com.vmware.safekeeping.core.command.results.ICoreResultAction;
import com.vmware.safekeeping.core.type.GuestInfoFlags;
import com.vmware.safekeeping.core.type.ManagedFcoEntityInfo;
import com.vmware.safekeeping.external.command.support.Task;
import com.vmware.safekeeping.external.type.RestoreVmManagedInfo;

public class ResultActionVmRestore extends AbstractResultActionRestoreForEntityWithDisks {
    public static void convert(final CoreResultActionVmRestore src, final ResultActionVmRestore dst) {
        if ((src == null) || (dst == null)) {
            return;
        }
        AbstractResultActionRestoreForEntityWithDisks.convert(src, dst);
        try {
            dst.setGuestFlags(src.getGuestFlags());
            dst.setTemplate(src.isTemplate());
            dst.setNumberOfChildVm(src.getNumberOfChildVm());
            RestoreVmManagedInfo.convert(src.getManagedInfo(), dst.getManagedInfo());
            for (final CoreResultActionDiskRestore _radr : src.getResultActionsOnDisk()) {
                dst.getResultActionsOnDisk().add(new Task(_radr));
            }
            for (final AbstractCoreResultActionBackupRestore _rabChild : src.getResultActionOnsChildVm()) {
                dst.getResultActionOnChildVms().add(new Task(_rabChild));
            }
        } catch (final Exception e) {
            src.failure(e);
            ResultAction.convert(src, dst);
        }
    }

    //
    public static void convert(final List<CoreResultActionVmRestore> lRarList,
            final List<ResultActionVmRestore> rarList) {

        for (final CoreResultActionVmRestore _rar : lRarList) {
            final ResultActionVmRestore rab = new ResultActionVmRestore();
            rab.convert(_rar);
            rarList.add(rab);
        }
    }

    private RestoreVmManagedInfo managedInfo;
    private List<ManagedFcoEntityInfo> fcoChildren;
    private List<Task> resultActionsOnDisk;

    private boolean template;
    private GuestInfoFlags guestFlags;
    private int numberOfChildVm;

    private List<Task> resultActionOnChildVms;

    public ResultActionVmRestore() {
        this.managedInfo = new RestoreVmManagedInfo();
        this.resultActionsOnDisk = new LinkedList<>();
        this.fcoChildren = new LinkedList<>();
    }

    @Override
    public void convert(ICoreResultAction src) {
        ResultActionVmRestore.convert((CoreResultActionVmRestore) src, this);
    }

    /**
     * @return the fcoChildren
     */
    public List<ManagedFcoEntityInfo> getFcoChildren() {
        return this.fcoChildren;
    }

    /**
     * @return the guestFlags
     */
    public GuestInfoFlags getGuestFlags() {
        return this.guestFlags;
    }

    /**
     * @return the managedInfo
     */
    public RestoreVmManagedInfo getManagedInfo() {
        return this.managedInfo;
    }

    /**
     * @return the numberOfChildVm
     */
    public int getNumberOfChildVm() {
        return this.numberOfChildVm;
    }

    /**
     * @return the resultActionOnChildVms
     */
    public List<Task> getResultActionOnChildVms() {
        return this.resultActionOnChildVms;
    }

    /**
     * @return the subTaskResultActionsOnDisks
     */
    public List<Task> getResultActionsOnDisk() {
        return this.resultActionsOnDisk;
    }

    /**
     * @return the template
     */
    public boolean isTemplate() {
        return this.template;
    }

    /**
     * @param fcoChildren the fcoChildren to set
     */
    public void setFcoChildren(final List<ManagedFcoEntityInfo> fcoChildren) {
        this.fcoChildren = fcoChildren;
    }

    /**
     * @param guestFlags the guestFlags to set
     */
    public void setGuestFlags(final GuestInfoFlags guestFlags) {
        this.guestFlags = guestFlags;
    }

    /**
     * @param managedInfo the managedInfo to set
     */
    public void setManagedInfo(final RestoreVmManagedInfo managedInfo) {
        this.managedInfo = managedInfo;
    }

    /**
     * @param numberOfChildVm the numberOfChildVm to set
     */
    public void setNumberOfChildVm(final int numberOfChildVm) {
        this.numberOfChildVm = numberOfChildVm;
    }

    /**
     * @param resultActionOnChildVms the resultActionOnChildVms to set
     */
    public void setResultActionOnChildVms(final List<Task> resultActionOnChildVms) {
        this.resultActionOnChildVms = resultActionOnChildVms;
    }

    /**
     * @param subTaskResultActionsOnDisks the subTaskResultActionsOnDisks to set
     */
    public void setResultActionsOnDisk(final List<Task> subTaskResultActionsOnDisks) {
        this.resultActionsOnDisk = subTaskResultActionsOnDisks;
    }

    /**
     * @param template the template to set
     */
    public void setTemplate(final boolean template) {
        this.template = template;
    }

}
