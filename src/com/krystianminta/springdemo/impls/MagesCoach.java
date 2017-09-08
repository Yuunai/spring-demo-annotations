package com.krystianminta.springdemo.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.krystianminta.springdemo.interfaces.Coach;
import com.krystianminta.springdemo.interfaces.FortuneService;

@Component
public class MagesCoach implements Coach {

	FortuneService fortuneService;
	
	@Autowired
	public void MagesCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Cast 15 fire balls, and then try to expand your mana pool through meditation!";
	}
	
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

}
