package br.com.syonet.users.ImportFromFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.syonet.users.exceptions.InvalidFileException;
import br.com.syonet.users.exceptions.InvalidFileFormatException;
import br.com.syonet.users.model.entity.User;

public class UserImporter {

	public void main(String[] args)
			throws InvalidFileFormatException, FileNotFoundException, IOException, InvalidFileException {

		importUsersFromFile();

	}

	public ArrayList<User> importUsersFromFile() {
		List<User> listUsers = new ArrayList<>();
		String line;
		String path = "/home/bruno/eclipse-workspace/br.com.syonet/src/main/java/br/com/syonet/users/ImportFromFile/users.syo";
		

		ReaderUsers readerUsers = new ReaderUsers();
		try {
			listUsers = readerUsers.readUsersFromFile(path);
		}

		catch (InvalidFileFormatException | InvalidFileException | IOException e) {
			System.out.println(e);

		} catch (Exception e) {
			System.out.println(e);

		}
		return (ArrayList<User>) listUsers;
	}
}