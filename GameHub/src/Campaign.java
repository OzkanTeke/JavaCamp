
public class Campaign {
	
	int id;
	String campaignName;
	float discount;
	
	public Campaign() {
		
	}
	
	public Campaign(int id, String campaignName, float discount) {
		super();
		this.id = id;
		this.campaignName = campaignName;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

}
