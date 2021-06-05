package asn5.util;

import java.util.Iterator;
import java.util.List;

public class MyElement implements Element {

	private List<String> listOfStrings;
	
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String toString() {
		return "MyElement [listOfStrings=" + listOfStrings + "]";
	}

	
	public List<String> getListOfStrings() {
		return listOfStrings;
	}
	

	public void setListOfStrings(List<String> listOfStrings) {
		this.listOfStrings = listOfStrings;
	}
}
