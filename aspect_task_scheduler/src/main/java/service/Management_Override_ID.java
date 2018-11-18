package service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Management_Override_ID implements Task_ID {

	private int ID; 
	private SimpleDateFormat date; 
	private long seconds; 
	public Management_Override_ID() {
		
	}
	
	public Management_Override_ID(int ID, SimpleDateFormat date, long seconds) {
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
		this.seconds = TimeUnit.MILLISECONDS.toSeconds(seconds);
	}
}