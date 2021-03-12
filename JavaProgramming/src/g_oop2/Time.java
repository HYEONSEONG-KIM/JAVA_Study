package g_oop2;

public class Time {

	
	private int hour;
	private int minute;
	private int second;
	
	
	
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
		
		while(true){
		if(this.hour > 24){
			this.hour -= 24;
		}else{
			break;
		}
		}
		if(hour < 0){
			this.hour = 0;
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
		while(true){
		if(this.minute > 59){
			this.minute -= 60;
			hour++;
		}else{
			break;
		}
		}

		if(minute < 0){
			this.minute = 0;
		}
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
		while(true){
		if(this.second > 59){  
			this.second -= 60;
			minute++;
		}else{
	
			break;
		}
		
		}
		
		if(second < 0){
			this.second = 0;
		}
	}

	String getTime(){
		return hour + " : " + minute + " : " + second;
	}
	
	void clock(){
		while(true){
			System.out.println(getTime());
			stop(1000);
			setSecond(second + 1);
			setMinute(minute);
			setHour(hour);
		}
	}
	
	
	private void stop(int interval){
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}














