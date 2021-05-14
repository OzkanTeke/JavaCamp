package eTicaretHw.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTicaretHw.dataAccess.abstracts.UserDao;
import eTicaretHw.entities.concretes.User;

public class HibernateUserDao implements UserDao{
	
	private List<User> users;

	public HibernateUserDao() {
		this.users = new ArrayList<User>();
	}

	@Override
	public void add(User user) {
		this.users.add(user);
		System.out.println("Kullanýcý eklendi " + user.getFirstname() + " " + user.getLastname());
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return this.users;
	}

}
