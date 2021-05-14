
public class Main {

	public static void main(String[] args) {
		
		Game game1 = new Game(1, "Call of Duty: Infinite Warfare", "FPS", "Activision", 103);
		Game game2 = new Game(2, "Assassin's Creed Odeyssey", "Action", "Ubisoft", 269);
		Game game3 = new Game(3, "Need for Speed Heat", "Race", "EA Games", 499.99);
		Game game4 = new Game(4, "Rome Total War", "Strategy", "SEGA", 87.50);
		
		BuyingManager buyingManager = new BuyingManager(new MernisServiceAdapter());
		CampaignManager campaignManager = new CampaignManager();
		Campaign campaign1 = new Campaign(1, "Ubisoft Developer Week", 50);
		campaignManager.addCampaign(campaign1);
		
		GamerManager gamerManager = new GamerManager(new MernisServiceAdapter());
		Gamer gamer1 = new Gamer(1, "Özkan", "Teke", "61141303524", 1993, 800);
		gamerManager.add(gamer1);
		
		buyingManager.buyWithoutCampaign(gamer1, game1);
		buyingManager.buyWithCampaign(gamer1, game2, campaign1);
		buyingManager.buyWithoutCampaign(gamer1, game3);
		buyingManager.buyWithoutCampaign(gamer1, game4);
		
		Campaign campaign2 = new Campaign(2, "Make war not love!", 75);
		campaignManager.addCampaign(campaign2);
		
		buyingManager.buyWithoutCampaign(gamer1, game4);
		
		gamerManager.update(gamer1, 30);
		
		buyingManager.buyWithoutCampaign(gamer1, game4);

	}

}
