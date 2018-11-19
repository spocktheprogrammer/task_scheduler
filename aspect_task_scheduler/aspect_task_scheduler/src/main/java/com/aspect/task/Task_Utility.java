package com.aspect.task;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

import comparator.ManagemnetQueueSort;
import comparator.QueueSort;
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
	private static Object sortedQueue[] = task_id.toArray();;
	
	public static boolean addTask(int id, SimpleDateFormat date){
		int management_id_count =0;
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
		sortedQueue = task_id.toArray();
		management_id_count = getManagementSorted(sortedQueue);
		Arrays.sort(Arrays.copyOfRange(sortedQueue,management_id_count, sortedQueue.length),new QueueSort<Object>(start_time));
		Arrays.sort(Arrays.copyOfRange(sortedQueue,0, management_id_count),new ManagemnetQueueSort<Object>());
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
	
	public static boolean deleteTask(Task_ID task)
	{
		
		return task_id.remove(task);
	}
	
	public static Object[] getList()
	{
		Object arr[] = task_id.toArray();
		if(arr.length>0)
			Arrays.sort(arr,new SortingID<Object>());
		else 
			return null;
 
		return arr;
	}
	
	public static int getManagementSorted(Object[]  arr) {
		int count =0;
		for(int i=0; i<arr.length;i++) {
			Task_ID elements = (Task_ID) arr[i]; 
			if(elements instanceof Management_Override_ID) {
				Task_ID managemnet = (Task_ID)arr[count];
				arr[count] = arr[i];
				arr[i] = managemnet;
				count++;
				continue;
			}
			
			
		}
		return count;
	}
	
	public static String getTopID() 
	{
		String output="No Task are present in Queue";
		Task_ID elements = (Task_ID) sortedQueue[0];
		if(elements ==null)
			return output;
		else 
		{
			output = "The Top Task present in Queue is :"+elements.getID()+" added at "+ new Date(elements.getSeconds()); 
			return output;
		}
		
		
		
	}	
	
}
