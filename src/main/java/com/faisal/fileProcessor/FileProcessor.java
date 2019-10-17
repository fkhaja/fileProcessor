package com.faisal.fileProcessor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.faisal.fileProcessor.model.Employee;
import com.faisal.fileProcessor.model.EmployeeComparator;
import com.faisal.fileProcessor.parser.FileParser;
import com.faisal.fileProcessor.parser.FileParserFactory;
import com.faisal.fileProcessor.util.ArgumentEnum;
import com.faisal.fileProcessor.util.FileFormat;
import com.faisal.fileProcessor.util.FileFormatException;

@Component
public class FileProcessor implements ApplicationRunner {
	private static Logger LOG = LoggerFactory.getLogger(FileProcessor.class);

	@Autowired
	private Environment env;

	@Autowired
	FileParserFactory fileParserFactory;

	@SuppressWarnings("unchecked")
	@Override
	public void run(ApplicationArguments args) {
		LOG.debug("EXECUTING: Application runner");

		if (!args.containsOption(ArgumentEnum.INPUT_FILE.getArgument())) {
			LOG.error("--inputFile argument missing. Please provide an input file and run again");
			System.exit(0);
		}

		String filePath = env.getProperty(ArgumentEnum.INPUT_FILE.getArgument());
		LOG.info("Input file path=" + filePath);

		Path path = Paths.get(filePath);
		FileParser parser = null;
		List<Employee> employees = new ArrayList<Employee>();
		try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
			String headerLine = br.readLine();
			if (headerLine.trim().equals(FileFormat.FIXED.getHeaderValue())) {
				parser = fileParserFactory.getFileParser(FileFormat.FIXED);
			} else if (headerLine.trim().equals(FileFormat.CSV.getHeaderValue())) {
				parser = fileParserFactory.getFileParser(FileFormat.CSV);
			} else {
				throw new FileFormatException("Invalid file format. Please provide a CSV or FIXED format.");
			}
			employees = (List<Employee>) parser.processFile(br);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// set default values
		employees.stream().forEach(Employee::setDefaultValues);
		LOG.info("Input file read successfully");

		LOG.info("Applying sorting if required...");
		// sort results before writing to file
		String sortBy = env.getProperty(ArgumentEnum.SORT_BY.getArgument());
		if (sortBy != null) {
			Collections.sort(employees, new EmployeeComparator(sortBy));
			LOG.info("Output sorted successfully");
		} else {
			LOG.info("Sorting order not provided. Sort order can be provided by using --sortBy argument");
		}

		saveOutputFile(employees, path);
		LOG.info("File processing done");

	}

	private void saveOutputFile(List<Employee> employees, Path path) {
		// TODO Auto-generated method stub
		String fileName = path.toFile().getParentFile().getAbsolutePath()
				.concat("\\outputFile-" + System.currentTimeMillis());
		LOG.info("Output file saved to: " + fileName);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			employees.stream().forEach(i -> {
				try {
					writer.write(employees.indexOf(i) + 1 + "\n");
					writer.write(i.toString() + "\n");
				} catch (IOException e) {
					LOG.error("Error writing record to file: " + i.toString());
				}
			});
		} catch (IOException e) {
			LOG.error("Error writing to file");
			e.printStackTrace();
		}

	}

}
