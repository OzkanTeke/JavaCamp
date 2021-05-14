
public interface GameBuyingService {
	
	public void buyWithCampaign(Gamer gamer, Game game, Campaign campaign);
	
	public void buyWithoutCampaign(Gamer gamer, Game game);

}
