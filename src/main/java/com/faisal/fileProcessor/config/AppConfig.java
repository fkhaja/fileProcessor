package com.faisal.fileProcessor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.fixed.FixedWidthFields;
import com.univocity.parsers.fixed.FixedWidthParserSettings;

@Configuration
public class AppConfig {

	@Bean("employeeFixedWidthParserSettings")
	public FixedWidthParserSettings getEmployeeFileFixedWidthParser() {
		// creates the sequence of field lengths in the file to be parsed
		FixedWidthFields fields = new FixedWidthFields(10, 17, 8, 10, 10, 10, 2, 3, 10);

		// creates the default settings for a fixed width parser
		FixedWidthParserSettings settings = new FixedWidthParserSettings(fields);

		settings.getFormat().setLineSeparator(System.lineSeparator());
		settings.setSkipEmptyLines(true);
		settings.setRecordEndsOnNewline(true);
		return settings;
	}

	@Bean("employeeCsvParserSettings")
	public CsvParserSettings getEmployeeCsvWidthParser() {
		// creates the default settings for a fixed width parser
		CsvParserSettings settings = new CsvParserSettings();
		settings.detectFormatAutomatically();

		settings.getFormat().setLineSeparator(System.lineSeparator());
		settings.setSkipEmptyLines(true);
		return settings;
	}

}
