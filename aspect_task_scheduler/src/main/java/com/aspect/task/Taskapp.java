package com.aspect.task;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import comparator.SortingID;
import comparator.TaskIDComparison;
import service.Task_ID;

@Path("/task")
public class Taskapp {
	private static final long start_time = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
	public static Object[] arr ;
	@POST
	@Path("/addtask/{id}/{date}")
	public Response addTask(@PathParam("id") int id, @PathParam("date") SimpleDateFormat date){
		System.out.println("Before adding "+Task_Utility.task_id.size());
		if(Task_Utility.task_id.size() >0)
		{
			if(Task_Utility.checkTaskID(id) ==null){
				Task_Utility.addTask(id, date);
				System.out.println("After adding "+Task_Utility.task_id.size());
				return Response.status(200).entity("Task "+id+"has been added in the Queue").build();
			}
			else{
				return Response.status(200).entity("Task "+id+"exist in quque").build();
			}
		}
		else 
		{
			Task_Utility.addTask(id, date);
			return Response.status(200).entity("Task "+id+" added in quque").build();
		}
	}
	
	@GET
	@Path("/gettasklist")
	public Response getTaskList() {
		Object arr[] = Task_Utility.getList();
		String output ="";
		if(arr.length >0) 
		{
			for(int i=0; i<arr.length;i++)
			{
				Task_ID element = (Task_ID) arr[i]; 
				output = output +" "+element.getID();
				
			}
			
				return Response.status(200).entity(output).build();
		}
		else
			return Response.status(200).entity("No task in the list").build();
 
	}
	@GET
	@Path("/averagewaittime")
	public Response getAverageWaitTime() {
		String output=""; 
		long average_time=0;
		long current_seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		arr = Task_Utility.task_id.toArray();
		if(arr.length>0)
			Arrays.sort(Arrays.copyOfRange(arr,0, arr.length),new SortingID<Object>());
		else 
			return Response.status(200).entity("No Task Present in Queue").build();
 
		for(int i=0; i<arr.length;i++)
		{
			Task_ID element = (Task_ID) arr[i]; 
			average_time = average_time+element.getSeconds();
			
		}
		output = output+" "+(average_time/arr.length)+" has average wait time :"+(current_seconds-element.getSeconds())+System.lineSeparator();
		return Response.status(200).entity(output).build();
 
	}
	@DELETE
	@Path("/removetask/{id}")
	public Response removeTask(@PathParam("id") int id){
		Object obj =Task_Utility.checkTaskID(id);
		if(obj!=null){
			Task_Utility.deleteTask((Task_ID) obj);
			return Response.status(200).entity("Task has been removed :"+ id).build();
		}
		return Response.status(200).entity("Task :"+ id+" does not exist in quque").build();
		
		
	}
	
}





