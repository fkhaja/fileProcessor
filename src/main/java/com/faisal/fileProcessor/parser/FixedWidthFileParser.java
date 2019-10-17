package com.faisal.fileProcessor.parser;

import java.io.BufferedReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.faisal.fileProcessor.model.Employee;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.fixed.FixedWidthParser;
import com.univocity.parsers.fixed.FixedWidthParserSettings;

@Component
public class FixedWidthFileParser implements FileParser {

	private FixedWidthParserSettings empParser;

	public FixedWidthFileParser(
			@Qualifier(value = "employeeFixedWidthParserSettings") FixedWidthParserSettings empParser) {
		this.empParser = empParser;
	}

	@Override
	public List<?> processFile(BufferedReader br) {
		BeanListProcessor<Employee> rowProcessor = new BeanListProcessor<Employee>(Employee.class);
		empParser.setProcessor(rowProcessor);
		FixedWidthParser parser = new FixedWidthParser(empParser);
		parser.parse(br);

		List<Employee> beans = rowProcessor.getBeans();
		beans.stream().forEach(i -> i.toString());

		return beans;
	}
}
