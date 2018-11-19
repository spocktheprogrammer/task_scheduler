
	package comparator;

	import java.util.Comparator;

	import service.Task_ID;

	public class SortingID<Object> implements Comparator<Object>{


		public int compare(Object obj1, Object obj2) {
			Task_ID  element1 = (Task_ID) obj1;
			Task_ID element2 = (Task_ID) obj2;
			if(element1.getID() >element2.getID()) {
				return 1;
			}
			else if(element1.getID() < element2.getID())
			{
				return -1; 
			}
			else
				return 0;
		}
		
		
	}


