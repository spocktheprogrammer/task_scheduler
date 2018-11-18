package com.aspect.task;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.core.Response;

import comparator.SortingID;
import comparator.TaskIDComparison;
import service.Management_Override_ID;
import service.Normal_ID;
import service.Priority_ID;
import service.Task_ID;
import service.VIP_ID;

public class Task_Utility {
	public static PriorityQueue<Task_ID> task_id= new PriorityQueue<Task_ID>(100,new TaskIDComparison());
	private static final long start_time = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
	public static boolean addTask(int id, SimpleDateFormat date){
		if(id%3 ==0 && id%5==0) {
			task_id.add(new Management_Override_ID(id,date, System.currentTimeMillis()));
		}
		else if(id%5==0) {
			task_id.add(new VIP_ID(id,date, System.currentTimeMillis()));
		}
		else if(id%3==0)
		{
			task_id.add(new Priority_ID(id, date, System.currentTimeMillis()));
		}
		else {
			task_id.add(new Normal_ID(id,date, System.currentTimeMillis()));
		}	
		return true;
	}
	public static Object checkTaskID(int id){
		Object arr[] = task_id.toArray();
		for(int i=0; i<arr.length;i++)
		{
			Task_ID element = (Task_ID) arr[i]; 
			if(id == element.getID()){
				return arr[i];
			}
			
		}
		
		return null;
		}	
	public static boolean deleteTask(Task_ID task){
		return task_id.remove(task);
	}
	public static Object[] getList(){
		Object arr[] = task_id.toArray();
		if(arr.length>0)
			Arrays.sort(arr,new SortingID<Object>());
		else 
			return null;
 
		return arr;
	}
	
}
