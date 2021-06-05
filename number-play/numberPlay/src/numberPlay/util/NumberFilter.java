package numberPlay.util;

public class NumberFilter implements FilterI {
	
	private Events event;
	
	@Override
	public boolean check(Events eventIn) {
		// TODO Auto-generated method stub
		
		if(this.event.name().equals(eventIn.name()))
		{
			return true;
		}
		else {
			return false;
		}
	}

}
