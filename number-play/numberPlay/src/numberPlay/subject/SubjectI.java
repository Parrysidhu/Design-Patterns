package numberPlay.subject;
import numberPlay.observer.ObserverI;
import numberPlay.util.Events;
import numberPlay.util.FilterI;

import numberPlay.subject.SubjectI;
public interface SubjectI {
	void register(ObserverI o, FilterI f);
	void notifyAll(Events events, String num);
	void process(Events events, String num);
}
