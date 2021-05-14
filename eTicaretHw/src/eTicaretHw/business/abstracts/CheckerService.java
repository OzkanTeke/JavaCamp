package eTicaretHw.business.abstracts;

public interface CheckerService {

	boolean emailCheck(String email);
	boolean firstNameCheck(String firstName);
	boolean lastNameCheck(String lastName);
	boolean passwordCheck(String password);

}
