
public class BuyingManager implements GameBuyingService{
	
	GamerCheckService gamerCheckService;
	public BuyingManager(GamerCheckService gamerCheckService) {
		this.gamerCheckService = gamerCheckService;
	}

	@Override
	public void buyWithCampaign(Gamer gamer, Game game, Campaign campaign) {
		if(gamer.walletBalance > game.price && gamerCheckService.CheckIfRealPerson(gamer)) {
			gamer.setWalletBalance(gamer.getWalletBalance()-game.price*(campaign.discount/100));
			gamer.setGamesOwned(gamer.getGamesOwned()+1);
			System.out.println(gamer.firstName + " purchased " + game.name + " for " + (game.price*(campaign.discount/100)) 
					+ "TL Now has " + gamer.getGamesOwned() + " games.");
		}else if (gamer.walletBalance < game.price) {
			System.out.println("Not enough money to complete purchase for " + game.name);
		}else {
			System.out.println("Not authorized for purchasing!");
		}
		
		
	}

	@Override
	public void buyWithoutCampaign(Gamer gamer, Game game) {
		if(gamer.walletBalance > game.price && gamerCheckService.CheckIfRealPerson(gamer)) {
		gamer.setWalletBalance(gamer.getWalletBalance()-game.price);
		gamer.setGamesOwned(gamer.getGamesOwned()+1);
		System.out.println(gamer.firstName + " purchased " + game.name + " for " + game.price 
				+ "TL Now has " + gamer.getGamesOwned() + " games.");
		}else if (gamer.walletBalance < game.price) {
			System.out.println("Not enough money to complete purchase for " + game.name);
		}else {
			System.out.println("Not authorized for purchasing!");
		}
		
	}
	

}
