package eTicaretHw.business.concretes;

import eTicaretHw.business.abstracts.ValidityService;
import eTicaretHw.dataAccess.abstracts.UserDao;
import eTicaretHw.entities.concretes.User;

public class ValidityManager implements ValidityService{
	
	private UserDao userDao;
	
	public ValidityManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean isValid(String email) {
		for(User user : userDao.getAll()) {
			if(email.equals(user.getEmail())) {
				System.out.println("Email mevcutta kullanýmdadýr.");
				return false;
			}
		}
		return true;
	}
	

}
