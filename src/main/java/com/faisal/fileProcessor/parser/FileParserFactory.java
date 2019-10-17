package com.faisal.fileProcessor.parser;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.faisal.fileProcessor.util.FileFormat;

@Component
public class FileParserFactory {

	@Resource(name = "fixedWidthFileParser")
	private FileParser fixedWidthFileParser;

	@Resource(name = "csvFileParser")
	private FileParser csvFileParser;

	public FileParser getFileParser(FileFormat fileFormat) {
		if (fileFormat.equals(FileFormat.FIXED)) {
			return fixedWidthFileParser;
		} else if (fileFormat.equals(FileFormat.CSV)) {
			return csvFileParser;
		} else {
			throw new RuntimeException("Invalid file format");
		}
	}

}
