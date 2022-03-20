package br.com.syonet.users.model.DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

import br.com.syonet.users.model.entity.User;

public class UserPostgresDAO implements UserDAO{
	private final Logger log = Logger.getLogger(this.getClass().getCanonicalName());
	private Connection conn;
	
	public UserPostgresDAO(Connection conn) {
		this.conn = conn;
	}
	
	public User registerUser(User user) {
		String sql = "INSERT INTO public.user (nome) VALUES ('$s);\n"
				.formatted(user.getLogin());
		
		try (Statement stm = conn.createStatement()){
			int afetedsLines = stm.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet generatedKeys = stm.getGeneratedKeys();
			
			generatedKeys.next();
			
			long id = generatedKeys.getLong(1);
			user.setId(id);
			this.log.info("Inserido %d  registro(s)".formatted(afetedsLines));
			return user;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	
}