package eTicaretHw.business.abstracts;

import eTicaretHw.entities.concretes.User;

public interface UserService {
	void register(User user);
	void signIn(String email, String password);

}
