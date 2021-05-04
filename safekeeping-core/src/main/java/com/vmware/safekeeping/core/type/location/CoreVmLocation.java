/*******************************************************************************
* Copyright (C) 2019, VMware Inc
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
package com.vmware.safekeeping.core.type.location;

import java.util.ArrayList;
import java.util.List;

import com.vmware.safekeeping.core.type.ManagedEntityInfo;

public class CoreVmLocation extends AbstractCoreFcoLocation {

	/**
     * 
     */
    private static final long serialVersionUID = -1672303767633154170L;

    private List<ManagedEntityInfo> resourcePoolPath;

	private ManagedEntityInfo resourcePoolInfo;

	private ManagedEntityInfo vmFolderInfo;

	private List<ManagedEntityInfo> vmFolderPath;

	private String vmxFullPath;

	private String datastorePath;

	private ManagedEntityInfo datastoreInfo;

	private boolean vAppMember;

	private String vmxFileName;
	private String resourcePoolFullPath;

	private String vmFolderFullPath;

	public CoreVmLocation() {
		super();
	}

	/**
	 * @return the datastoreInfo
	 */

	public ManagedEntityInfo getDatastoreInfo() {
		return this.datastoreInfo;
	}

	public String getDatastorePath() {
		return this.datastorePath;
	}

	public String getResourcePoolFullPath() {
		return this.resourcePoolFullPath;
	}

	public ManagedEntityInfo getResourcePoolInfo() {
		return this.resourcePoolInfo;
	}

	public List<ManagedEntityInfo> getResourcePoolPath() {
		return this.resourcePoolPath;
	}

	public String getVmFolderFullPath() {
		return this.vmFolderFullPath;
	}

//    public String getResourcePoolFullPath() {
//	return ManagedEntityInfo.composeEntityInfoName(getResourcePoolPath());
//    }

	public ManagedEntityInfo getVmFolderInfo() {
		return this.vmFolderInfo;
	}

	public List<ManagedEntityInfo> getVmFolderPath() {
		return this.vmFolderPath;
	}

//    public String getVmFolderFullPath() {
//	return ManagedEntityInfo.composeEntityInfoName(getVmFolderPath());
//    }

	/**
	 * @return the vmxFileName
	 */
	public String getVmxFileName() {
		return this.vmxFileName;
	}

	/**
	 * Gets the value of the vmPathName property.
	 *
	 * @return possible object is {@link String }
	 *
	 */

	public String getVmxFullPath() {
		return this.vmxFullPath;
	}

	public boolean isvAppMember() {
		return this.vAppMember;
	}

	/**
	 * @param datastoreInfo the datastoreInfo to set
	 */

	public void setDatastoreInfo(final ManagedEntityInfo datastoreInfo) {
		this.datastoreInfo = datastoreInfo;
	}

	/**
	 * @param vmDatastorePath
	 */

	public void setDatastorePath(final String vmDatastorePath) {
		this.datastorePath = vmDatastorePath;
	}

	public void setResourcePoolFullPath(final String resourcePoolFullPath) {
		this.resourcePoolFullPath = resourcePoolFullPath;
	}

	public void setResourcePoolInfo(final ManagedEntityInfo resourcePoolInfo) {
		this.resourcePoolInfo = resourcePoolInfo;
	}

	/**
	 * @param resourcePoolPath
	 */

	public void setResourcePoolPath(final ArrayList<ManagedEntityInfo> resourcePoolPath) {
		this.resourcePoolPath = resourcePoolPath;

	}

	/**
	 * @param resourcePoolPath the resourcePoolPath to set
	 */
	public void setResourcePoolPath(final List<ManagedEntityInfo> resourcePoolPath) {
		this.resourcePoolPath = resourcePoolPath;
	}

	public void setvAppMember(final boolean isAMember) {
		this.vAppMember = isAMember;
	}

	public void setVmFolderFullPath(final String vmFolderFullPath) {
		this.vmFolderFullPath = vmFolderFullPath;
	}

	public void setVmFolderInfo(final ManagedEntityInfo vmFolderInfo) {
		this.vmFolderInfo = vmFolderInfo;
	}

	/**
	 * @param folderPath the folderPath to set
	 */
	public void setVmFolderPath(final List<ManagedEntityInfo> folderPath) {
		this.vmFolderPath = folderPath;
	}

	/**
	 * @param vmxFileName the vmxFileName to set
	 */
	public void setVmxFileName(final String vmxFileName) {
		this.vmxFileName = vmxFileName;
	}

	/**
	 * Sets the value of the vmPathName property.
	 *
	 * @param value allowed object is {@link String }
	 *
	 */

	public void setVmxFullPath(final String value) {
		this.vmxFullPath = value;
	}
}