package br.com.syonet.users.business;

import br.com.syonet.users.model.DAOs.UserDAO;
import br.com.syonet.users.model.entity.User;

public class UserService {
	UserDAO dao;

	public UserService (UserDAO dao) {
		this.dao = dao;
	}
	
	public User registerUser(User user) {
		return this.dao.registerUser(user);
		
	}

}
