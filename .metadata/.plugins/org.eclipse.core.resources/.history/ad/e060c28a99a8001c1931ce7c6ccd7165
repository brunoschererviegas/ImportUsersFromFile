package br.com.syonet.users.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.syonet.users.model.entity.User;

public class UserRepository {

	Connection conn;
	static String querySelect = "SELECT * FROM syo_usuarios";
	static String queryInsert = "INSERT INTO public.syo_usuarios "
			+ "(id_usuario,nm_login,id_grupo,id_dominio,ds_senha," + "id_tipo,ap_usuario,nm_usuario,ds_email,ic_ativo)"
			+ "values(?,?,?,?,?,?,?,?,?,?)";
	static String queryIds = "SELECT max(id_usuario) from syo_usuarios";

	public UserRepository(Connection conn) {
		super();
		this.conn = conn;
	}

	public ArrayList<User> returnUsersInfosFromDB() {

		ArrayList<User> arrayUsersFromDB = new ArrayList<User>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(querySelect);
			while (rs.next())
			{
				User tempUser = new User();
				tempUser.setLogin(rs.getString("nm_login"));
				tempUser.setEmail(rs.getString("ds_email"));
				tempUser.setId(rs.getLong("id_empresa"));
				tempUser.setGroup(rs.getString("id_grupo"));
				tempUser.setActive(true);
				tempUser.setNm_usuario(rs.getString("nm_usuario"));
				tempUser.setType(rs.getString("id_tipo"));
				tempUser.setId_usuarioerp(rs.getString("id_usuarioerp"));

				arrayUsersFromDB.add(tempUser);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayUsersFromDB;
	}

	public void saveUserInDB(User user) throws Exception, SQLException {
		User userForPersist = user;

		try {
				Statement stmt = conn.createStatement();
				PreparedStatement preparedStatement = conn.prepareStatement(queryInsert);

			preparedStatement.setInt(1, maxId());
			preparedStatement.setString(2, userForPersist.getLogin());
			preparedStatement.setString(3, userForPersist.getGroup());
			preparedStatement.setString(4, userForPersist.getDomain());
			preparedStatement.setString(5, userForPersist.getPassword());
			preparedStatement.setString(6, userForPersist.getType());
			preparedStatement.setString(7, userForPersist.getAp_usuario());
			preparedStatement.setString(8, userForPersist.getNm_usuario());
			preparedStatement.setString(9, userForPersist.getEmail());
			preparedStatement.setBoolean(10, userForPersist.getActive());
			preparedStatement.execute();
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private Integer maxId() throws Exception {
		Integer maxId = 0;
		try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(queryIds);
			rs.next();
			maxId = rs.getInt(1) + 1;
			System.out.println(maxId);

			return maxId;

		} catch (Exception e) {
			throw e;

		}

	}

}
