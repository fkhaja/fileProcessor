package com.faisal.fileProcessor.parser;

import java.io.BufferedReader;
import java.util.List;

public interface FileParser {

	public List<?> processFile(BufferedReader br);
}
