package br.com.syonet.users;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.syonet.users.model.entity.User;

public class InsertUserFromFile {
	static String url = "jdbc:postgresql://localhost:5432/usuarios";
	static String username = "syonet";
	static String password = "syonet";

//	static String query = "INSERT INTO public.syo_usuarios(user.get, id_grupo, id_dominio, id_tipo, ap_usuario, nm_usuario, ds_email, ic_ativo) VALUES"
//			+ "("user.getLogin+","+'SYONET','SYONET','DIRETOR','SYONET','SYONET','a@b.c',true)"";

	public void insertUsers() {
		User user = new User();

		
	try(Connection conn = DriverManager.getConnection(url, username, password);
	Statement stmt = conn.createStatement();{


//	ResultSet rs = stmt.executeQuery(query);)
	

	}catch(SQLException e){
		e.printStackTrace();
	}
	
}
}