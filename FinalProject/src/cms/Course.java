package cms;

public class Course {
	private String courseTitle;
	private String crsNbr;
	private Textbook t;
	private Faculty f;
	private double numCredits;

	public Course(String courseTitle, String crsNbr, Textbook t, Faculty f, double numCredits) {
		super();
		this.courseTitle = courseTitle;
		this.crsNbr = crsNbr;
		this.t = t;
		this.f = f;
		this.numCredits = numCredits;
	}

	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCrsNbr() {
		return crsNbr;
	}
	public void setCrsNbr(String crsNbr) {
		this.crsNbr = crsNbr;
	}
	public Textbook getT() {
		return t;
	}
	public void setT(Textbook t) {
		this.t = t;
	}
	public Faculty getF() {
		return f;
	}
	public void setF(Faculty f) {
		this.f = f;
	}
	public double getNumCredits() {
		return numCredits;
	}
	public void setNumCredits(double numCredits) {
		this.numCredits = numCredits;
	}

	
}
