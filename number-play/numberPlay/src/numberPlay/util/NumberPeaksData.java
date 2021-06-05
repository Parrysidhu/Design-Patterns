package numberPlay.util;
import java.math.*;

import numberPlay.observer.ObserverI;

public class NumberPeaksData implements PersisterI, NumberPeaksResultsI, ObserverI  {
	
	
	public void peaks() {
		int[] data = {10,20,30,40,50,60,71,80,90,91};
		int i=0;
		BigDecimal val;
		BigDecimal nextval;
		//float[] peak;
		BigDecimal[] peaks = new BigDecimal[100];
		
		for(i=0; i<data.length;i++){
			val=new BigDecimal(data[i]);
			nextval= new BigDecimal(data[i+1]);
			int res= val.compareTo(nextval);
			
			if(res==1) {
				for(int j=0;j<peaks.length;j++) {
					peaks[j]=val;
					
				}
				
			}
			
		}
	}
			
	
	
	@Override
	public void store(Double d) {}

	@Override
	public void writeToFile() {}

	@Override
	public void close() {}



	@Override
	public void update(String no) {
		// TODO Auto-generated method stub
		
	}
}
