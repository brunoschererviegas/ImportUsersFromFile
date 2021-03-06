package br.com.syonet.users;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.syonet.users.ImportFromFile.UserImporter;
import br.com.syonet.users.model.entity.User;
import br.com.syonet.users.model.repository.UserRepository;

public class Main {

	public static void main(String[] args) throws SQLException {

		try {
			UserImporter userFile = new UserImporter();
			ArrayList<User> ImportUserFromFile = userFile.importUsersFromFile();
			UserRepository userRepository = new UserRepository(ConnectionFactory.getConnecion());

			ArrayList<User> ExportUserFromDB = userRepository.returnUsersInfosFromDB();

			System.out.println("User from DB : ");
			for (User user : ExportUserFromDB) {
				System.out.println(user.getLogin());
			}
			System.out.println("-------------------");
			System.out.println("User from File");
			for (User user : ImportUserFromFile) {
				System.out.println(user.getLogin());
			}
			ImportUserFromFile.removeAll(ExportUserFromDB);
			for (User user : ImportUserFromFile) {
				System.out.println(user.getLogin());
				try {
					userRepository.saveUserInDB(user);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("-------------------");

//		ConnectionFactory cF = new ConnectionFactory();
//		System.out.println(cF.maxId());

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
