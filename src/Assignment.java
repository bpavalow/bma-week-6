import java.util.Date;

public class Assignment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Task task = new TODOItem();
		printTask(task);
		
		Date currentDate = new Date();
		Date endDate = new Date(currentDate.getTime() + (4 * 60 * 60 * 1000));

		Task meeting = new Meeting("Crossfire Class", currentDate, false, true, endDate);
		printTask(meeting);
	}
	
	private static void printTask(Task task) {
		System.out.println(task.toString());
	}

}

abstract class Task {
	private String name;
	private Date date;
	private boolean completed;
	private boolean recurring;
	
	public Task(String name, Date date, boolean completed, boolean recurring) {
		this.name = name;
		this.date = date;
		this.completed = completed;
		this.recurring = recurring;
	}
	
	public Task() {
		this.name = "No Argument Task";
		this.date = new Date();
		this.completed = false;
		this.recurring = false;
	}
	
	public String toString() {
		return "Task, " + this.name + ", was " + ((completed) ? "" : "not ") + "completed on " + date.toString();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public boolean isRecurring() {
		return recurring;
	}
	
}

class TODOItem extends Task {
	public TODOItem(String name, Date date, boolean completed, boolean recurring) {
		super(name, date, completed, recurring);
	}
	
	public TODOItem() {
		super();
	}
	
	public String toString() {
		return "Task, " + this.getName() + ", must be completed by " + this.getDate();
	}
}

class Meeting extends Task {
	private Date endDate;
	
	public Meeting (String name, Date date, boolean completed, boolean recurring, Date endDate) {
		super(name, date, completed, recurring);
		this.endDate = endDate;
	}
	
	public Meeting() {
		super();
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String toString() {
		return "Meeting, " + this.getName() + ", will be run from " + this.getDate() + " until " + this.getEndDate();
	}
}