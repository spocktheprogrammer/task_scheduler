# task_scheduler
Task Scheduler 
Getting Started

The current version of the API lives at  - http://localhost:8080/aspect_task_scheduler/aspect/task

Below are the EndPoints available for the API. 

EndPoints - All the Endpoints consume and Produce in String type.

/addtask	-	Takes two input parameter task-id and date of the task.
			Returns Success message on inserting the ID into Queue. 
			Returns Failure message if ID already present. 
						
/gettasklist	-	Returns the List of task id's present the in Queue ordered from Highest to Lowest.

/removetask	-	Take single parameter i.e. task_id.
			Returns Success message if task_id is removed
			Returns failure message if task_id is not present. 
						

/averagetime    -      Take input as current time in milliseconds. 
			Returns average waiting time for the ID's waiting in the Queue. 
			
/gettopid	-	Returns the TopID from the queue and the time the ID was added.
						
