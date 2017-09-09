package com.krystianminta.springdemo.impls;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.krystianminta.springdemo.interfaces.Coach;
import com.krystianminta.springdemo.interfaces.FortuneService;

@Component
public class MagesCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${archMage.name}")
	private String name;
	
	@Value("${archMage.team}")
	private String team;
	
	@Autowired
	public MagesCoach(@Qualifier("fileFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Cast 15 fire balls, and then try to expand your mana pool through meditation!";
	}
	
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

	@PostConstruct
	public void welcomeMessage() {
		System.out.println("I'm " + name + " team " + team);
	}
}
