/*
 * Copyright 2004-2014 ICEsoft Technologies Canada Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS
 * IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package org.icefaces.samples.showcase.example.ace.date;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.faces.bean.CustomScoped;
import javax.inject.Named;
import javax.faces.event.ValueChangeEvent;

@Named(DateTimeBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class DateTimeBean implements Serializable {
	public static final String BEAN_NAME = "dateTime";
	public String getBeanName() { return BEAN_NAME; }

	private static final String PATTERN_DATE = "MM/dd/yyyy";
	private static final String PATTERN_TIME = "h:mm:ss a";
	private static final String PATTERN_BOTH = PATTERN_DATE + " "
			+ PATTERN_TIME;

	private Date selectedDate;
	private String timeType = "both";
	private String pattern = PATTERN_BOTH;
	private boolean timeOnly = false;

	public DateTimeBean() {
		Calendar calendar = Calendar.getInstance(
				TimeZone.getTimeZone("Canada/Mountain"), Locale.getDefault());
		selectedDate = calendar.getTime();
	}

	public Date getSelectedDate() {
		return selectedDate;
	}

	public String getTimeType() {
		return timeType;
	}

	public String getPattern() {
		return pattern;
	}

	public boolean getTimeOnly() {
		return timeOnly;
	}

	public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
	}

	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public void setTimeOnly(boolean timeOnly) {
		this.timeOnly = timeOnly;
	}

	public void typeChanged(ValueChangeEvent event) {
		String val = event.getNewValue().toString();

		if ("time".equals(val)) {
			pattern = PATTERN_TIME;
			timeOnly = true;
		} else if ("date".equals(val)) {
			pattern = PATTERN_DATE;
			timeOnly = false;
		} else {
			pattern = PATTERN_BOTH;
			timeOnly = false;
		}
	}

	// preserve all time parameters in date-only and time-only modes
	public void valueChanged(ValueChangeEvent event) {
		if (timeType != null) {
			Date oldDate = (Date) event.getOldValue();
			Date newDate = (Date) event.getNewValue();
			TimeZone timeZone = TimeZone.getTimeZone("Canada/Mountain");
			if ("time".equals(timeType)) {
				Calendar oldDateCalendar = Calendar.getInstance(timeZone);
				oldDateCalendar.setTime(oldDate);
				Calendar newDateCalendar = Calendar.getInstance(timeZone);
				newDateCalendar.setTime(newDate);
				int year = oldDateCalendar.get(Calendar.YEAR);
				int month = oldDateCalendar.get(Calendar.MONTH);
				int day = oldDateCalendar.get(Calendar.DATE);
				int hours = newDateCalendar.get(Calendar.HOUR_OF_DAY);
				int minutes = newDateCalendar.get(Calendar.MINUTE);
				int seconds = newDateCalendar.get(Calendar.SECOND);
				Calendar result = Calendar.getInstance(timeZone);
				result.set(year, month, day, hours, minutes, seconds);
				newDate.setTime(result.getTimeInMillis());
			} else if ("date".equals(timeType)) {
				Calendar oldDateCalendar = Calendar.getInstance(timeZone);
				oldDateCalendar.setTime(oldDate);
				Calendar newDateCalendar = Calendar.getInstance(timeZone);
				newDateCalendar.setTime(newDate);
				int year = newDateCalendar.get(Calendar.YEAR);
				int month = newDateCalendar.get(Calendar.MONTH);
				int day = newDateCalendar.get(Calendar.DATE);
				int hours = oldDateCalendar.get(Calendar.HOUR_OF_DAY);
				int minutes = oldDateCalendar.get(Calendar.MINUTE);
				int seconds = oldDateCalendar.get(Calendar.SECOND);
				Calendar result = Calendar.getInstance(timeZone);
				result.set(year, month, day, hours, minutes, seconds);
				newDate.setTime(result.getTimeInMillis());
			}			
		}
	}
}
