package eTicaretHw.business.concretes;

import eTicaretHw.business.abstracts.CheckerService;
import eTicaretHw.business.abstracts.UserService;
import eTicaretHw.business.abstracts.ValidityService;
import eTicaretHw.core.abstracts.OuterService;
import eTicaretHw.dataAccess.abstracts.UserDao;
import eTicaretHw.entities.concretes.User;

public class UserManager implements UserService{
	
	private CheckerService checkerService;
	private UserDao userDao;
	private OuterService outerService;

	public UserManager(CheckerService checkerService, UserDao userDao, OuterService outerService) {
		this.checkerService = checkerService;
		this.userDao = userDao;
		this.outerService = outerService;
	}

	@Override
	public void register(User user) {
		
		ValidityService validityService = new ValidityManager(userDao);
		if(validityService.isValid(user.getEmail()) && checkerService.emailCheck(user.getEmail()) && checkerService.firstNameCheck(user.getFirstname()) && 
				checkerService.lastNameCheck(user.getLastname()) &&
				checkerService.passwordCheck(user.getPassword())){
			userDao.add(user);
			outerService.registerWOS();
			System.out.println(user.getEmail() + " adresine doðrulama e-postasý gönderildi.");
			System.out.println(user.getFirstname() + " " + user.getLastname() + " üyeliðiniz tamamlanmýþtýr.");
		}
		System.out.println("---------------------------------");
	}

	@Override
	public void signIn(String email, String password) {

        for (int i=0; i<userDao.getAll().size(); i++){
            if (userDao.getAll().get(i).getEmail().equals(email) &&
                userDao.getAll().get(i).getPassword().equals(password)) {
            	System.out.println("Giriþ yapýldý.");
            	System.out.println("---------------------------------");
                return;
            }
        }
        System.out.println("E-mail veya Parola hatalý!");
        System.out.println("---------------------------------");
	}
	
}
