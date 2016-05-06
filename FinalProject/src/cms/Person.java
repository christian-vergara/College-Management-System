package cms;

public class Person {

	private String firstName;
	private String lastName;
	private static int id = 0;
	private String phnNbr;
	private Address address;

	
	public Person(String firstName, String lastName, String phnNbr, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phnNbr = phnNbr;
		this.address = address;
        id++;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhnNbr() {
		return phnNbr;
	}

	public void setPhnNbr(String phnNbr) {
		this.phnNbr = phnNbr;
	}

	public Address getAddress() {
		return address;
	}

	public static int getId(){
		return id;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

    public void setId(int id) {
        this.id = id;
    }
}
