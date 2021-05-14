package eTicaretHw.core.concretes;

import eTicaretHw.GoogleUser.GoogleUserManager;
import eTicaretHw.core.abstracts.OuterService;

public class GoogleUserManagerAdapter implements OuterService{

	@Override
	public void registerWOS() {
		GoogleUserManager manager = new GoogleUserManager();
		manager.register();
		
	}

}
