package com.faisal.fileProcessor.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AppUtils {

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);

	public static String getFormattedDate(Date date) {
		return DATE_FORMAT.format(date);
	}

	public static String getLineDelimiter() {
		return System.lineSeparator();
	}
}
