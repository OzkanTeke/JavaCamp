
public class Gamer {
	
	int id;
	String firstName;
	String lastName;
	String nalionalityId;
	int birthYear;
	double walletBalance;
	int gamesOwned;

	public Gamer() {
		
	}
	
	public Gamer(int id, String firstName, String lastName, String nalionalityId, int birthYear,
			double walletBalance) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nalionalityId = nalionalityId;
		this.birthYear = birthYear;
		this.walletBalance = walletBalance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getNalionalityId() {
		return nalionalityId;
	}

	public void setNalionalityId(String nalionalityId) {
		this.nalionalityId = nalionalityId;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}
	
	public int getGamesOwned() {
		return gamesOwned;
	}
	
	public void setGamesOwned(int gamesOwned) {
		this.gamesOwned = gamesOwned;
	}

}
