package br.com.ideais.dao;

import java.util.List;

import br.com.ideais.exceptions.UserNotFoundException;
import br.com.ideais.models.User;

public interface UserDAO {

	public long add(User user);
	
	public void remove(long id) throws UserNotFoundException;
	
	public void edit(User user) throws UserNotFoundException;
	
	public User get(long id) throws UserNotFoundException;
	
	public List<User> getAll();
	
}
