package numberPlay.util;

import numberPlay.observer.ObserverI;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import numberPlay.subject.SubjectI;

/**
 * This class works as a subject in observer pattern It is used to notify all
 * the observers for particular filter based on the generated event
 * 
 * @author Parneet LNU
 *
 */
public class NumberProcessor implements SubjectI {
	Map<FilterI, List<ObserverI>> observers;
	public static ArrayList<String> avgNums = new ArrayList<String>();
	public static ArrayList<String> peakNums = new ArrayList<String>();
	public static List<BigDecimal> topKNums = new ArrayList<BigDecimal>();
	public static List<Double> finalPeaks = new ArrayList<Double>();
	public static List<Double> finalAvg = new ArrayList<Double>();
	public static List<Double> finalTopK = new ArrayList<Double>();

	/**
	 * This constructor is used to register a hash map of observers with filter as
	 * key and list of observers as value
	 */
	public NumberProcessor() {
		this.observers = new HashMap<FilterI, List<ObserverI>>();
	}

	/**
	 * This method is used to process the events and call another method to notify
	 * observers
	 */
	@Override
	public void process(Events events, String num) {
		notifyAll(events, num);
	}

	/**
	 * This method is used to notify all the observers based on the event it got
	 * from the check method of the filter
	 */
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

	/**
	 * This method is used to generate an event This method checks if the passed
	 * number is an integer or a float and based on that it sets an event from enum
	 * 
	 * @param no
	 * @return
	 */
	public Events generateEvent(String no) {
		try {
			Integer.parseInt(no);
			return Events.INTEGER_EVENT;
		} catch (NumberFormatException e) {
			try {
				Float.parseFloat(no);
				return Events.FLOATING_POINT_EVENT;
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * This method is used to register the observers with filters and store into a
	 * hash map
	 */
	@Override
	public void register(ObserverI o, FilterI f) {
		try {
			if (!observers.containsKey(f)) {
				observers.put(f, new ArrayList<ObserverI>());
			}

			observers.get(f).add(o);
		} catch(NullPointerException npe) {
			throw npe;
		}
	}

}