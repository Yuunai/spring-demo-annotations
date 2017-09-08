package com.krystianminta.springdemo.impls;

import com.krystianminta.springdemo.interfaces.Coach;

public class WarriorsCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Swing your sword 500 times!";
	}

}
