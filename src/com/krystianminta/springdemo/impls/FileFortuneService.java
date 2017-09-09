package com.krystianminta.springdemo.impls;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.krystianminta.springdemo.interfaces.FortuneService;

@Component
public class FileFortuneService implements FortuneService {

	private String FILE_NAME = "D:\\fortunes.txt";
	
	private Random random = new Random();
	
	List<String> fileFortunes;

	public FileFortuneService() {
		fileFortunes = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
			
			String currentLine;
			
			while((currentLine = br.readLine()) != null) {
				fileFortunes.add(currentLine);
			}
		} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	
	@Override
	public String getDailyFortune() {
		return fileFortunes.get(random.nextInt(fileFortunes.size()));
	}

}
