class Book implements Comparable<Book> {
	private String name;
	private String author;
	private double price;
	Book(String n, String a, double p) {
		name = n;
		author = a;
		price = p;
	}
	String getName() {
		return name;
	}
	String getAuthor() {
		return author;
	}
	double getPrice() {
		return price;
	}
	public int compareTo(Book b) {
		return getName().compareTo(b.getName());
	}
}