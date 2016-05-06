package cms;

import java.util.ArrayList;

public class Student extends Person {

	private double gpa;
	private String major;
	private ArrayList cTaken;
	private ArrayList cTaking;
	private ArrayList cNeeded;
	private double currentCredits;
	private int studentId;
	private String firstName;
	private String lastName;
	private String phnNbr;
	private Address address;

	// Course[] cTaken, Course[] cTaking, Course[] cNeeded,

	public Student(String firstName, String lastName, String phnNbr, Address address, double gpa, String major, double currentCredits) {
		super(firstName, lastName, phnNbr, address);
		this.gpa = gpa;
		this.major = major;
		this.currentCredits = currentCredits;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phnNbr = phnNbr;
		this.address = address;
		studentId = Person.getId();
	}

	public Student(String firstName, String lastName, String phnNbr, Address address, double gpa, String major, ArrayList cTaken, ArrayList cTaking, ArrayList cNeeded,
				   double currentCredits) {
		super(firstName, lastName, phnNbr, address);
		this.gpa = gpa;
		this.major = major;
		this.cTaken = cTaken;
		this.cTaking = cTaking;
		this.cNeeded = cNeeded;
		this.currentCredits = currentCredits;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String getPhnNbr() {
		return phnNbr;
	}

	@Override
	public void setPhnNbr(String phnNbr) {
		this.phnNbr = phnNbr;
	}

	@Override
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public ArrayList getcTaken() {
		return cTaken;
	}

	public void setcTaken(ArrayList cTaken) {
		this.cTaken = cTaken;
	}

	public ArrayList getcTaking() {
		return cTaking;
	}

	public void setcTaking(ArrayList cTaking) {
		this.cTaking = cTaking;
	}

	public ArrayList getcNeeded() {
		return cNeeded;
	}

	public void setcNeeded(ArrayList cNeeded) {
		this.cNeeded = cNeeded;
	}

	public double getCurrentCredits() {
		return currentCredits;
	}

	public void setCurrentCredits(double currentCredits) {
		this.currentCredits = currentCredits;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "Student{" +
				"gpa=" + gpa +
				", major='" + major + '\'' +
				", cTaken=" + cTaken +
				", cTaking=" + cTaking +
				", cNeeded=" + cNeeded +
				", currentCredits=" + currentCredits +
				", id=" + getStudentId() +
				", address=" + super.getAddress() +
				'}';
	}
}
