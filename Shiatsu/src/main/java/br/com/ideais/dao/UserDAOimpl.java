package br.com.ideais.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.ideais.exceptions.UserNotFoundException;
import br.com.ideais.models.User;

@Repository
public class UserDAOimpl implements UserDAO{

    @PersistenceContext
	private EntityManager em;

    public long add(User user){	
		em.persist(user);
		return user.getId();
	}

	public void edit(User user) throws UserNotFoundException{
		
		try{
			em.getReference(User.class, user.getId());
			em.merge(user);
		}catch(EntityNotFoundException e){
			throw new UserNotFoundException();
		}
	}

	public void remove(long id) throws UserNotFoundException{
		try{
			User user = em.getReference(User.class, new Long(id));
			em.remove(user);
		}catch(EntityNotFoundException e){
			throw new UserNotFoundException();
		}
	}

	public User get(long id) throws UserNotFoundException{	
		User user = em.find(User.class, new Long(id));
			
		if (user == null){
			throw new UserNotFoundException();
		}

		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll(){	
		List<User> users = em
			.createQuery("select u from User u order by u.id asc")
			.getResultList();

		return users;
	}

}

