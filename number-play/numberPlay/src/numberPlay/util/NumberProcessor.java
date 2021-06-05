package numberPlay.util;
import numberPlay.observer.ObserverI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import numberPlay.subject.SubjectI;

public class NumberProcessor implements SubjectI {
	Map<FilterI, List<ObserverI>> observers;
//	public static String[] arrNums = {};
	ArrayList<Integer> arr = new ArrayList<Integer>(9);
	

	public void getFileData() throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		FileProcessor obj = new FileProcessor("input.txt");
		NumberProcessor numProc = new NumberProcessor();
	
		while (obj != null) {
			String num = obj.poll();
			numProc.process(generateEvent(num), num);
		}
	}
	
	@Override
	public void process(Events events, String num) {
		// TODO Auto-generated method stub
		notifyAll(events, num);
	}
	
	@Override
	public void notifyAll(Events events, String num) {
		for (Map.Entry<FilterI, List<ObserverI>> entry : observers.entrySet()) {
			if (entry.getKey().check(events)) {
				for (ObserverI o : entry.getValue()) {
					o.update(num);
				}
			}
		}
	}

	public Events generateEvent(String no) {
		try {
			Integer.parseInt(no);
			return Events.INTEGER_EVENT;
		} catch (NumberFormatException e) {
			try {
				Float.parseFloat(no);
				return Events.FLOATING_POINT_EVENT;
			}
			catch(NumberFormatException e1) {
				e1.printStackTrace();
			}
		}
		return null; 
	}
	
	@Override
	public void register(ObserverI o, FilterI f) {
		if (!observers.containsKey(f)) {
			observers.put(f, new ArrayList<ObserverI>());
		}

		observers.get(f).add(o);
	}

}