package comparator;

import java.util.Comparator;
import service.Priority_ID;
import service.Task_ID;
import service.VIP_ID;

public class QueueSort<Object> implements Comparator<Object>{
	private  long start_time=0;
	public QueueSort(long start_time){
		this.start_time =start_time;
	}

	public int compare(Object obj1, Object obj2) {
		Task_ID  element1 = (Task_ID) obj1;
		Task_ID element2 = (Task_ID) obj2;
		
		double time1 =0, time2=0;
		if(element1 instanceof VIP_ID)
		{
			time1  =  Math.max(4,(2*((element1.getSeconds())-start_time)*(Math.log10(element1.getSeconds()-start_time))));
			System.out.println("Element1 :"+element1.getID()+" "+element1.getClass()+" "+(element1.getSeconds()-start_time)+" "+time1);
		}
		else if(element1 instanceof Priority_ID) 
		{
			time1 =  Math.max(3, ((element1.getSeconds()-start_time)*(Math.log10(element1.getSeconds()-start_time))));
			System.out.println("Element1 :"+element1.getID()+" "+element1.getClass()+" "+(element1.getSeconds()-start_time)+" "+time1);
		}
		else 
		{
			time1 = element1.getSeconds()-start_time;
			System.out.println("Element1 :"+element1.getID()+" "+element1.getClass()+" "+(element1.getSeconds()-start_time)+" "+time1);
		}
		if(element2 instanceof VIP_ID)
		{
			time2 =  Math.max(4,(2*((element2.getSeconds()-start_time))*(Math.log10(element2.getSeconds()-start_time))));
			System.out.println("Element2 :"+element2.getID()+" "+element2.getClass()+" "+(element2.getSeconds()-start_time)+" "+time2);
		}
		else if(element2 instanceof Priority_ID) 
		{
			time2 =  Math.max(3, ((element2.getSeconds()-start_time))*(Math.log10(element2.getSeconds()-start_time)));
			System.out.println("Element2 :"+element2.getID()+" "+element2.getClass()+" "+(element2.getSeconds()-start_time)+" "+time2);
		}
		else 
		{
			time2 = element2.getSeconds()-start_time;
			System.out.println("Element2 :"+element2.getClass()+" "+(element2.getSeconds()-start_time)+" "+time2);
		}
		if(time1 > time2) {
			System.out.println("1");
			return 1; 
		}
		else if(time1 < time2) {
			System.out.println("-1");
			return -1; 
		}
		else{
			System.out.println("0");
			return 0; 
		}
	}
	
	
}
