package br.com.syonet.users;

import java.sql.Connection;
import java.util.Scanner;
import java.util.logging.Logger;

import br.com.syonet.users.business.UserService;
import br.com.syonet.users.controller.UserController;
import br.com.syonet.users.model.DAOs.UserDAO;

public class ServiceLoader implements AutoCloseable{
	static Logger log = Logger.getGlobal();
	Connection connection;
	Scanner scanner;
	UserDAO userDAO;
	UserService userService;
	UserController userController;
	
	public ServiceLoader() {
		this.connection = ConnectionFactory.getConnection();
		
	}
	
	
	
	
	@Override
	public void close() throws Exception {
		this.scanner.close();
		this.connection.close();
		
	}

}
