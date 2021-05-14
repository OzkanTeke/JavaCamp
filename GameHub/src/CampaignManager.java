
public class CampaignManager implements CampaignService{

	@Override
	public void addCampaign(Campaign campaign) {
		System.out.println("New " + campaign.campaignName + " campaign added wtih %" + campaign.discount + " discount.");
		
	}

	@Override
	public void updateCampaign(Campaign campaign) {
		System.out.println(campaign.campaignName + " campaign updated.");		
		
	}

	@Override
	public void deleteCampaign(Campaign campaign) {
		System.out.println(campaign.campaignName + " campaign deleted.");
		
		
	}

}
