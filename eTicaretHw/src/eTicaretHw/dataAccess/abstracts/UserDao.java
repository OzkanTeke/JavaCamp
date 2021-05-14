package eTicaretHw.dataAccess.abstracts;

import java.util.List;

import eTicaretHw.entities.concretes.User;

public interface UserDao {
	public void add(User user);
	public void update(User user);
	public void delete(User user);


	public List<User> getAll();

}
