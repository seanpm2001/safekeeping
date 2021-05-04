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

import java.util.LinkedList;
import java.util.List;

import com.vmware.safekeeping.core.control.target.ITarget;
import com.vmware.safekeeping.core.type.enums.phase.StatusProfilePhases;

public abstract class AbstractCoreResultActionArchiveStatus extends AbstractCoreResultActionArchive {

    /**
     * 
     */
    private static final long serialVersionUID = 3415000915385117046L;
    private int latestSucceededGenerationId;
    private StatusProfilePhases phase;
    private boolean available;
    private String generationStatus;
    private int numOfGeneration;
    private int numOfSuccceededGeneration;
    private final List<Integer> generationList;

    /**
     * @param target
     */
    AbstractCoreResultActionArchiveStatus(final ITarget target) {
        super(target);
        this.generationList = new LinkedList<>();
        this.phase = StatusProfilePhases.NONE;
    }

    /**
     * @return the generationList
     */
    public List<Integer> getGenerationList() {
        return this.generationList;
    }

    public String getGenerationStatus() {
        return this.generationStatus;
    }

    public int getLatestSucceededGenerationId() {
        return this.latestSucceededGenerationId;
    }

    /**
     * @return the numOfGeneration
     */
    public int getNumOfGeneration() {
        return this.numOfGeneration;
    }

    /**
     * @return the numOfSuccceededGeneration
     */
    public int getNumOfSuccceededGeneration() {
        return this.numOfSuccceededGeneration;
    }

    /**
     * @return the phase
     */
    public StatusProfilePhases getPhase() {
        return this.phase;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public boolean isEmpty() {
        return this.latestSucceededGenerationId < 0;
    }

    public void setAvailable(final boolean available) {
        this.available = available;
    }

    public void setGenerationStatus(final String generationStatus) {
        this.generationStatus = generationStatus;
    }

    public void setLatestSucceededGenerationId(final int activeGenerationId) {
        this.latestSucceededGenerationId = activeGenerationId;
    }

    /**
     * @param numOfGeneration the numOfGeneration to set
     */
    public void setNumOfGeneration(final int numOfGeneration) {
        this.numOfGeneration = numOfGeneration;
    }

    /**
     * @param numOfSuccceededGeneration the numOfSuccceededGeneration to set
     */
    public void setNumOfSuccceededGeneration(final int numOfSuccceededGeneration) {
        this.numOfSuccceededGeneration = numOfSuccceededGeneration;
    }

    /**
     * @param phase the phase to set
     */
    public void setPhase(final StatusProfilePhases phase) {
        this.phase = phase;
    }
}
