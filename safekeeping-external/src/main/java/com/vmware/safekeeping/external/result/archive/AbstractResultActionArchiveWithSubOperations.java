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
package com.vmware.safekeeping.external.result.archive;

import java.util.LinkedList;
import java.util.List;

import com.vmware.safekeeping.core.command.results.AbstractCoreResultActionImpl;
import com.vmware.safekeeping.core.command.results.archive.AbstractCoreResultActionArchiveWithSubOperations;
import com.vmware.safekeeping.external.command.support.Task;

public abstract class AbstractResultActionArchiveWithSubOperations extends AbstractResultActionArchive {
    public static void convert(final AbstractCoreResultActionArchiveWithSubOperations src,
            final AbstractResultActionArchiveWithSubOperations dst) {
        if ((src == null) || (dst == null)) {
            return;
        }
        AbstractResultActionArchive.convert(src, dst);
        for (final AbstractCoreResultActionImpl _rabChild : src.getSubOperations()) {
            dst.getSubOperations().add(new Task(_rabChild));
        }
    }

    private List<Task> subOperations;

    protected AbstractResultActionArchiveWithSubOperations() {
        this.subOperations = new LinkedList<>();
    }

    /**
     * @return the subOperations
     */
    public List<Task> getSubOperations() {
        return this.subOperations;
    }

    /**
     * @param subOperations the subOperations to set
     */
    public void setSubOperations(final List<Task> subOperations) {
        this.subOperations = subOperations;
    }

}
