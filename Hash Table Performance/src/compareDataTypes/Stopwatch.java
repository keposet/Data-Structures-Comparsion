package compareDataTypes;

public class Stopwatch {
	
	private long theTime;
	
	public Stopwatch() {
		
	}
	
	public void startwatch() {
		theTime = System.nanoTime();
	}
	
	public long stopWatch() {
		
		return theTime;
	}
	
	public boolean oneSecond() {
		boolean done = false;
		
		long thePast = theTime;
		while(thePast<= theTime + (1 *10^9)) {
			done = true;
		}
		
		return done;
	}

}
