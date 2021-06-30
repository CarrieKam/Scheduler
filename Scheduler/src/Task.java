
public class Task {

	private String name, date, time, description;
	
	public Task(String name, String date, String time, String description ) {
		this.name = name;
		this.date = date;
		this.time = time;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}	
	
}
