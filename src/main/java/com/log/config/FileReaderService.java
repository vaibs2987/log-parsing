package com.log.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.log.parsing.service.EventProcessor;

@Service
public class FileReaderService {

	@Value("${log.file.path}")
	private String filePath;

	@Autowired
	private EventProcessor eventProcessor;

	public void readFile() {
		BufferedReader br = null;

		try {
			br = Files.newBufferedReader(
					Paths.get(filePath));
			String line;
			while ((line = br.readLine()) != null) {
				eventProcessor.process(line, 12l);
			}

		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
