package assignment4.util;

import java.util.ArrayList;

import assignment4.driver.Driver;

public class CalculateRunningAvg {

	public static ArrayList<Integer> avgNums = new ArrayList<Integer>();
	
	public double runningAvg(Integer amount) {
		avgNums.add(amount);
		if (avgNums.size() > Driver.DrunningAverageWindowSize) {
			avgNums.remove(0);
		}

		avgNums.trimToSize();

		double sum = 0;
		for (Integer number : avgNums) {
			sum += number;
		}

		return sum /avgNums.size();
	}
}
