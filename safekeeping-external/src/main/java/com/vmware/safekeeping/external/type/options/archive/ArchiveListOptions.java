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
package com.vmware.safekeeping.external.type.options.archive;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.vmware.safekeeping.common.FirstClassObjectFilterType;
import com.vmware.safekeeping.core.command.options.CoreArchiveOptions;
import com.vmware.safekeeping.external.type.options.AbstractBasicCommandOptions;

/**
 * @author mdaneri
 *
 */
public class ArchiveListOptions extends AbstractArchiveOptions {
	static public void convert(final ArchiveListOptions src, final CoreArchiveOptions dst) throws ParseException {
		if ((src == null) || (dst == null)) {
			return;
		}

		AbstractBasicCommandOptions.convert(src, dst, FirstClassObjectFilterType.any);
		if (StringUtils.isNotEmpty(src.getDateFilter())) {
			String mTimeString = src.getDateFilter();
			boolean signNegative = (mTimeString.startsWith("-"));

			if (StringUtils.startsWithAny(mTimeString, new String[] { "+", "-" })) {
				mTimeString = mTimeString.substring(1);
			} else {
				signNegative = true;
			}

			final SimpleDateFormat format = new SimpleDateFormat("dd:hh:mm");
			final Date date = format.parse(mTimeString);
			if (signNegative) {
				dst.setDateTimeFilter(-date.getTime());
			} else {
				dst.setDateTimeFilter(date.getTime());
			}
		}
	}

	private String dateFilter;

	/**
	 * @return the dateFilter
	 */
	public String getDateFilter() {
		return this.dateFilter;
	}

	/**
	 * @param dateFilter the dateFilter to set
	 */
	public void setDateFilter(final String dateFilter) {
		this.dateFilter = dateFilter;
	}

}
