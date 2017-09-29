package compareDataTypes;

public class Records {
// i need to keep some info, time, size, type and ID to show which one this came from... . 

	private String iD;
	private String type;
	private long time;
	private int size;
	
	
	
	
	public Records(String iD, String type, long time, int size) {
		
		this.iD = iD;
		this.type = type;
		this.time = time;
		this.size = size;
	}


	public String getiD() {
		return iD;
	}


	public void setiD(String iD) {
		this.iD = iD;
	}

	public long getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Records [time(ms)=" + time + ", size=" + size + ", type=" + type + ", iD=" + iD + "]";
	}
	
	
	
}
