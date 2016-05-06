package cms;

public class Faculty extends Person {

	private String title;
	private String department;
	private int payScale;
	private Address homeAddress;
	private Address officeAddress;


	public Faculty(String firstName, String lastName, String phnNbr, Address homeAddress, Address officeAddress, String title,
			String department, int payScale) {
		super(firstName, lastName, phnNbr, homeAddress);
		this.officeAddress = officeAddress;
		this.title = title;
		this.department = department;
		this.payScale = payScale;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getPayScale() {
		return payScale;
	}
	public void setPayScale(int payScale) {
		this.payScale = payScale;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
}
