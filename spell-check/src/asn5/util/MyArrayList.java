package asn5.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyArrayList implements Element {

	@Override
	public String toString() {
		return "MyArrayList [myList=" + myList + "]";
	}

	public List<MyElement> getMyList() {
		return myList;
	}

	public void setMyList(ArrayList<MyElement> myList) {
		this.myList = myList;
	}

	public List<MyElement> myList = new ArrayList<MyElement>();

	public static class Builder {
		private FileProcessor fp;

		public Builder withFileProcessor(FileProcessor fileProcessor) {
			this.fp = fileProcessor;
			return this;
		}

		public Element build() {
			String line = this.fp.getLine();
			List<String> sentences = Arrays.asList(line.split("[.]"));
			List<String> list;
			MyElement myElement;
			MyArrayList myArrayList = new MyArrayList();
			for (String sentence : sentences) {
				list = Arrays.asList(sentence.trim().split(" "));
				myElement = new MyElement();
				myElement.setListOfStrings(list);
				myArrayList.myList.add(myElement);
			}

			return myArrayList;
		}
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Iterator<MyElement> getIterator() {
		return myList.iterator();
	}
}
