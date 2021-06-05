package asn5.util;

import java.util.Iterator;

public interface Element {

	void accept(Visitor visitor);
	Iterator getIterator();

}
