package com.faisal.fileProcessor.parser;

import java.io.BufferedReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.faisal.fileProcessor.model.Employee;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

@Component
public class CsvFileParser implements FileParser {

	private CsvParserSettings empParser;

	public CsvFileParser(@Qualifier(value = "employeeCsvParserSettings") CsvParserSettings empParser) {
		this.empParser = empParser;
	}

	@Override
	public List<?> processFile(BufferedReader br) {
		BeanListProcessor<Employee> rowProcessor = new BeanListProcessor<Employee>(Employee.class);
		empParser.setProcessor(rowProcessor);
		CsvParser parser = new CsvParser(empParser);
		parser.parse(br);

		List<Employee> beans = rowProcessor.getBeans();
		beans.stream().forEach(i -> i.toString());

		return beans;
	}
}
