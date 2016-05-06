package cms;

public class Textbook {

	private String bookTitle;
	private String author;
	private String publisher; 
	private double price;
	private Long isbn;
	private int yearPublished;
	
	public Textbook(String bookTitle, String author, String publisher, double price, Long isbn, int yearPublished) {
		super();
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.isbn = isbn;
		this.yearPublished = yearPublished;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getISBN() {
		return isbn;
	}

	public void setISBN(Long iSBN) {
		isbn = iSBN;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	@Override
	public String toString() {
		return "Textbook{" +
				"bookTitle='" + bookTitle + '\'' +
				", author='" + author + '\'' +
				", publisher='" + publisher + '\'' +
				", price=" + price +
				", isbn=" + isbn +
				", yearPublished=" + yearPublished +
				'}';
	}
}
