
public class Game {
	int id;
	String name;
	String genre;
	String developer;
	double price;
	
	public Game() {
		
	}
	
	public Game(int id, String name, String genre, String developer, double price) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.developer = developer;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
