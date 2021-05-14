
public class GamerManager implements GamerService{
	
	GamerCheckService gamerCheckService;
	public GamerManager(GamerCheckService gamerCheckService) {
		this.gamerCheckService = gamerCheckService;
	}

	@Override
	public void add(Gamer gamer) {
		if (gamerCheckService.CheckIfRealPerson(gamer)) {
			System.out.println("User created with " + gamer.firstName + " " + gamer.lastName + 
					" and has " + gamer.walletBalance + "TL wallet balance.");
		} else {
			System.out.println("This is not a valid person.");
		}
		
	}

	@Override
	public void update(Gamer gamer, double addedMoney) {
		if (gamerCheckService.CheckIfRealPerson(gamer)) {
			double newWallet = gamer.getWalletBalance()+addedMoney;
			gamer.setWalletBalance(newWallet);
			System.out.println("User updated. Now has " + Math.round(newWallet) + "TL");
		}else {
			System.out.println("Person is not validated.");
		}
		
		
	}

	@Override
	public void delete(Gamer gamer) {
		System.out.println("User deleted.");
		
	}

}
