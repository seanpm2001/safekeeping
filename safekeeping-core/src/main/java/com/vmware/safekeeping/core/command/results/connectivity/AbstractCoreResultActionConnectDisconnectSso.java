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
package com.vmware.safekeeping.core.command.results.connectivity;

import java.net.URL;

import com.vmware.safekeeping.core.command.results.AbstractCoreResultActionImpl;
import com.vmware.safekeeping.core.type.ManagedFcoEntityInfo;

public abstract class AbstractCoreResultActionConnectDisconnectSso extends AbstractCoreResultActionImpl {

    /**
     * 
     */
    private static final long serialVersionUID = 7779535579977567896L;
    private URL ssoEndPointUrl;
    private boolean connected;
    private String token;
private CoreResultActionDisconnectVcenter child;
    protected AbstractCoreResultActionConnectDisconnectSso(final boolean connected) {
        this.connected = connected;
        this.token = null;
        this.ssoEndPointUrl = null;
        setFcoEntityInfo(ManagedFcoEntityInfo.newNullManagedEntityInfo());
    }

    public URL getSsoEndPointUrl() {
        return this.ssoEndPointUrl;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return this.token;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public void setConnected(final boolean connected) {
        this.connected = connected;
    }

    /**
     * @param endPointUrl
     */
    public void setSsoEndPointUrl(final URL endPointUrl) {
        this.ssoEndPointUrl = endPointUrl;

    }

    /**
     * @param element the token to set
     */
    public void setToken(final String element) {
        this.token = element;
    }

	public CoreResultActionDisconnectVcenter getChild() {
		return child;
	}

	public void setChild(CoreResultActionDisconnectVcenter child) {
		this.child = child;
	}

}
