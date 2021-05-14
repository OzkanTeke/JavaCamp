package eTicaretHw.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import eTicaretHw.business.abstracts.CheckerService;

public class UserCheck implements CheckerService{
	
	public UserCheck() {
		
	}
	
	@Override
	public boolean firstNameCheck(String firstName) {
		if(firstName.length() < 2) {
			System.out.println("Adýnýz 2 karakterden az olamaz.");
			return false;
		}
		return true;
	}
	
	@Override
	public boolean lastNameCheck(String lastName) {
		if(lastName.length() < 2) {
			System.out.println("Soyadýnýz 2 karakterden az olamaz.");
			return false;
		}
		return true;
	}
	
	@Override
	public boolean passwordCheck(String password) {
		if(password.isEmpty()) {
			System.out.println("Þifre giriniz.");
			return false;
		}else if(password.length() < 6) {
			System.out.println("Parolanýz 6 karakterden az olamaz.");
			return false;
		}
		return true;
	}
	
	@Override
	public boolean emailCheck(String email) {
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if(matcher.matches()) {
            return true;
        }else if(email.isEmpty()){
        	System.out.println("Email giriniz.");
        	return false;
        }else {
        	System.out.println("Geçersiz email adresi.");
            return false;
        }
    }

}
