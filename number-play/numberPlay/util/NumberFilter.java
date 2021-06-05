package numberPlay.util;

public class NumberFilter implements FilterI {
	
	private Events event;
	
	public NumberFilter(Events eventIn) {
		this.event = eventIn;
	}
	
	@Override
	public boolean check(Events eventIn) {
		// TODO Auto-generated method stub
		if(this.event.name().equals(eventIn.name())) {
			return true;
		} else {
			return false;
		}
	}
}
