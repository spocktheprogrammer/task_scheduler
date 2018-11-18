package comparator;

import java.util.Comparator;

import service.Task_ID;

public class TaskIDComparison implements Comparator<Task_ID>{


	public int compare(Task_ID o1, Task_ID o2) {
		//System.out.println("o1 is of class type " + o1.getClass()+ " ID "+ o1.getID()+ " timeElapsed "+ o1.getSeconds());
		//System.out.println("o2 is of class type " + o2.getClass()+ " ID "+ o2.getID()+ " timeElapsed "+ o1.getSeconds());
		long time1 = o1.getSeconds(), time2 = o2.getSeconds();
		if(time1 >time2) {
			return 1;
		}
		else if(time1 < time2)
		{
			return -1; 
		}
		else
			return 0;
	}
	
	
}
