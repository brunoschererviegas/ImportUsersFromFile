package br.com.syonet.users.ImportFromFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.syonet.users.exceptions.InvalidFileException;
import br.com.syonet.users.exceptions.InvalidFileFormatException;
import br.com.syonet.users.model.entity.User;

public class ReaderUsers {

	public List<User> readUsersFromFile(String path)
			throws InvalidFileFormatException, FileNotFoundException, IOException, InvalidFileException {

		File file = new File(path);
		if (!file.isFile()) {
			throw new InvalidFileException();
		}
		List<User> users = new ArrayList<User>();

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = null;
			ValidatorUsers validatorUsers = new ValidatorUsers();

			while ((line = reader.readLine()) != null) {
				User user = getUserFromLine(line);
				if (validatorUsers.execute(user)) {
					users.add(getUserFromLine(line));
				}
			}
		}
		
		return users;
	}

	private User getUserFromLine(String userLine) throws InvalidFileFormatException {
		String[] info = userLine.split(",");
		User user = new User();
		for (String infoItem : info) {
			if (infoItem == null) {
				throw new InvalidFileFormatException();
			}
		}
		user.setLogin(info[0]);
		user.setGroup(info[1]);
		user.setDomain(info[2]);
		user.setPassword("f2QbDpp3vvt+cBRf5Va7Og==");
		user.setType(info[3]);
		user.setAp_usuario(info[4]);
		user.setNm_usuario(info[5]);
		user.setEmail(info[6]);
		user.setActive(info[7].equals("true"));

		return user;

	}
}
