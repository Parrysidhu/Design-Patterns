package asn5.util;

import asn5.driver.Driver;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Class for analyzing top k 
 * 
 * @author 
 *
 */
public class TopKMostFreqAnalyzer implements Visitor {
	
	/**
	 * 
	 * @param k
	 * @param results
	 */
	public TopKMostFreqAnalyzer(int k, Results results) {

	}

	/**
	 * 
	 */
	@Override
	public void visit(MyArrayList myArrayList) {
		List<MyElement> elements = myArrayList.getMyList();
		List<String> listOfWords;
		for (MyElement element : elements) {
			listOfWords = element.getListOfStrings();
			getTopK(listOfWords);
		}
	}

	private void getTopK(List<String> listOfWords) {
		Map<String, Integer> words = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		for (String str : listOfWords) {
			if (words.containsKey(str)) {
				words.put(str, 1 + words.get(str));
			} else {
				words.put(str, 1);
			}
		}

		Iterator itr = words.entrySet().iterator();
		Comparator<Map.Entry> freqComparator = new Comparator<Map.Entry>() {
			@Override
			public int compare(Entry o1, Entry o2) {
				if ((int) o1.getValue() > (int) o2.getValue())
					return -1;
				else if ((int) o1.getValue() < (int) o2.getValue())
					return 1;
				else
					return 0;
			}
		};

		PriorityQueue<Map.Entry> pq = new PriorityQueue<Map.Entry>(freqComparator);

		while (itr.hasNext()) {
			Map.Entry entry = (Map.Entry) itr.next();
			pq.add(entry);
		}

		int c = 0;
		String temp = "[";
		while (c < Driver.Dk) {
			if (c < (Driver.Dk - 1))
				temp += pq.poll().toString().split("=")[0] + ", ";
			else
				temp += pq.poll().toString().split("=")[0];
			c++;
		}

		temp += "]\n";
		Driver.mostFrequent.append(temp);
	}
}
