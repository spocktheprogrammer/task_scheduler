package service;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Normal_ID implements Task_ID {

	
	private int ID; 
	private SimpleDateFormat date; 
	private long seconds; 
	public Normal_ID() {
		
	}
	
	public Normal_ID(int ID, SimpleDateFormat date, long seconds) {
		this.ID = ID; 
		this.date = date; 
		this.seconds = TimeUnit.MILLISECONDS.toSeconds(seconds); 
		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public SimpleDateFormat getDate() {
		return date;
	}
	public void setDate(SimpleDateFormat date) {
		this.date = date;
	}
	public long getSeconds() {
		return seconds;
	}
	public void setSeconds(long seconds) {
		this.seconds =  TimeUnit.MILLISECONDS.toSeconds(seconds);
	}

}



	
