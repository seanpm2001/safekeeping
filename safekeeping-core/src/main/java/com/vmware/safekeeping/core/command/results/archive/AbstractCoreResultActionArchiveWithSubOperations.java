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
package com.vmware.safekeeping.core.command.results.archive;

import com.vmware.safekeeping.common.ConcurrentDoublyLinkedList;
import com.vmware.safekeeping.core.command.results.AbstractCoreResultActionImpl;
import com.vmware.safekeeping.core.command.results.support.OperationState;
import com.vmware.safekeeping.core.control.target.ITarget;

public abstract class AbstractCoreResultActionArchiveWithSubOperations extends AbstractCoreResultActionArchive {

    private static final long serialVersionUID = -6096653191992258510L;
    private final ConcurrentDoublyLinkedList<AbstractCoreResultActionImpl> subOperations;

    AbstractCoreResultActionArchiveWithSubOperations(final ITarget target) {
        super(target);
        this.subOperations = new ConcurrentDoublyLinkedList<>();
    }

    public OperationState getChildrenActionsResult() {
        for (final AbstractCoreResultActionImpl rd : this.subOperations) {
            switch (rd.getState()) {
            case ABORTED:
                return OperationState.ABORTED;
            case FAILED:
                return OperationState.FAILED;
            case QUEUED:
                return OperationState.STARTED;

            case STARTED:
                return OperationState.STARTED;
            case SKIPPED:

            case SUCCESS:

            default:
                break;

            }
        }
        return OperationState.SUCCESS;

    }

    /**
     * @return the subOperations
     */
    public ConcurrentDoublyLinkedList<AbstractCoreResultActionImpl> getSubOperations() {
        return this.subOperations;
    }

}
