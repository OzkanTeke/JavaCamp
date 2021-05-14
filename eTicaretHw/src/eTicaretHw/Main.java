package eTicaretHw;

import eTicaretHw.business.concretes.UserCheck;
import eTicaretHw.business.concretes.UserManager;
import eTicaretHw.core.concretes.GoogleUserManagerAdapter;
import eTicaretHw.core.concretes.NoAdapter;
import eTicaretHw.dataAccess.concretes.HibernateUserDao;
import eTicaretHw.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		User user1 = new User(1, "O", "Teke", "oz57kan@gmail.com", "123456789");
		User user2 = new User(2, "Ozkan", "T", "oz57kan@gmail.com", "123456789");
		User user3 = new User(3, "Ozkan", "Teke", "oz57kagmail.com", "123456789");
		User user4 = new User(4, "Ozkan", "Teke", "oz57kan@gmail.com", "1234");
		User user5 = new User(5, "Ozkan", "Teke", "oz57kan@gmail.com", "123456789");
		User user6 = new User(6, "Osman", "Tekin", "oz57kan@gmail.com", "123456789");
		User user7 = new User(7, "Osman", "Tekin", "", "123456789");
		User user8 = new User(8, "Osman", "Tekin", "ozkan@gmail.com", "");
		User user9 = new User(9, "Ayşe", "Tekin", "ayse@hotmail.com", "1234567");
		
		
		UserManager userManager = new UserManager(new UserCheck(), new HibernateUserDao(), new NoAdapter());
		
		userManager.register(user1);
		userManager.register(user2);
		userManager.register(user3);
		userManager.register(user4);
		userManager.register(user5);
		userManager.register(user6);
		userManager.register(user7);
		userManager.register(user8);
		
		UserManager userManager1 = new UserManager(new UserCheck(), new HibernateUserDao(), new GoogleUserManagerAdapter());
		
		userManager1.register(user9);
		userManager.signIn("Ozkan", "123456789");
		userManager.signIn("oz57kan@gmail.com", "123456789");
	}
}
