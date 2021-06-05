package numberPlay.util;

import numberPlay.observer.ObserverI;

public class RunningAverageData implements PersisterI, RunningAverageResultsI, ObserverI {
	
	@Override
	public void update(String num) {
		NumberProcessor.arrNums[NumberProcessor.arrNums.length+1] = num;
		if( NumberProcessor.arrNums.length <= 3 ) {
			
		}
//
//		int[] data = { 10, 20, 30, 40, 50, 60, 71, 80, 90, 91 };
//		double d = 0;
//		int arr[] = new int[3];
		int i = 0;
//		int sum = 0;
//		int index = 0;

		for (i = 0; i < data.length; i++) {
			if (data.length == index)
				break;
			int value = data[index];
			index++;
			arr[i] = value;
			sum = value + sum;
			double res = calculate(sum, i);
			if (i == arr.length - 1) {
				swap(arr, i);
				i--;
				// arr[2]=value;
			}
		}
	}

	public void swap(int[] arr, int i) {
		// int temp;

		arr[0] = arr[1];
		arr[1] = arr[2];
		arr[2] = arr[3];
		// arr[2]=
		// return arr;
	}

	public double calculate(int sum, int i) {
		i++;
		double average = sum / i;
		return average;
	}

	@Override
	public void store(Double d) {
	}

	@Override
	public void writeToFile() {
	}

	@Override
	public void close() {
	}

	
	

}
