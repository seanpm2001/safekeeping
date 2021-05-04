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
package com.vmware.safekeeping.core.command.options;

import com.vmware.safekeeping.core.type.SearchManagementEntity;

public class CoreRestoreVmdkOption {
    private SearchManagementEntity spbmProfile;

    private SearchManagementEntity datastore;

    private int diskId;

    public CoreRestoreVmdkOption(final int diskId) {
        this.diskId = diskId;
    }

    public CoreRestoreVmdkOption() {
        // Nothing to do
    }

    public SearchManagementEntity getDatastore() {
        return this.datastore;
    }

    public int getDiskId() {
        return this.diskId;
    }

    public SearchManagementEntity getSpbmProfile() {
        return this.spbmProfile;
    }

    public void setDatastore(final SearchManagementEntity datastore) {
        this.datastore = datastore;
    }

    public void setDiskId(final int diskId) {
        this.diskId = diskId;
    }

    public void setSpbmProfile(final SearchManagementEntity spbmProfile) {
        this.spbmProfile = spbmProfile;
    }
}
