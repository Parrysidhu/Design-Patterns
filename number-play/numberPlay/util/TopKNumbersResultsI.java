package numberPlay.util;

/**
* TopKNumbersResultsI defines an interface to be implemented by
* classes that intend to store the top K numbers when processing
* a stream of numbers.
*/
public interface TopKNumbersResultsI {
	void store(Double d);
}
