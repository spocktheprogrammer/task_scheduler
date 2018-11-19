package comparator;

import java.util.Comparator;

import service.Task_ID;


public class ManagemnetQueueSort<Object> implements Comparator<Object>
{

	public int compare(Object o1, Object o2) {
		Task_ID  element1 = (Task_ID) o1;
		Task_ID element2 = (Task_ID) o2;
		
		if(element1.getSeconds() > element2.getSeconds()) {
			return -1;
		}
		else if(element1.getSeconds() < element2.getSeconds())
		{
			return 1;
		}
		else 
			return 0;
	}
	

}

