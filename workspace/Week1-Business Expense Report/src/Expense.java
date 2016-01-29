import java.io.Serializable;

public class Expense implements Serializable {

	private String name;
	private String amt;
	private String date;
	private transient String user;

	public Expense(String name, String amt, String date, String user) {

		this.name = name;
		this.amt = amt ;
		this.date = date;
		this.user = user;
	}

	public String expString() {
		return "Expense: " + name +
				", amount: " + amt +
				", date: " + date +
				", user: " + user;
	}
}
