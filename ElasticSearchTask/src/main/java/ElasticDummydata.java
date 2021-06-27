import java.util.Date;

public class ElasticDummydata {
	
	public String firstName;
    public String lastName;
    public String books;
    public int date_of_issue;
    public int date_of_return;
    public int fine;
    
   
 
    public ElasticDummydata(String firstName, String lastName, String books, int date_of_issue, int date_of_return, int fine) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = books;
		this.date_of_issue =date_of_issue;
		this.date_of_return = date_of_return;
		this.fine = fine;
	}



    
 
    public String name() {
        return this.firstName + " " + this.lastName + " " + this.books + " " + this.date_of_issue + " " + this.date_of_return + " " + this.fine ;
    }

	@Override
	public String toString() {
		return "ElasticDummydata [firstName=" + firstName + ", lastName=" + lastName + ", books=" + books
				+ ", date_of_issue=" + date_of_issue + ", date_of_return=" + date_of_return + ", fine=" + fine + "]";
	}
 
	
	
  

}
