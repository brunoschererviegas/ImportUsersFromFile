package br.com.syonet.users.ImportFromFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.syonet.users.exceptions.InvalidFileException;
import br.com.syonet.users.exceptions.InvalidFileFormatException;
import br.com.syonet.users.model.entity.User;

public class ImportUsers {

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
//			listUsers.stream().forEach(System.out::println);
		}

		catch (InvalidFileFormatException | InvalidFileException | IOException e) {
			System.out.println(e);

		} catch (Exception e) {
			System.out.println(e);

		}
		return (ArrayList<User>) listUsers;
	}
}

//		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//			while ((line = reader.readLine()) != null) {
//				
//				
//				String[] info = line.split(",");
//				for (int i = 0; i < useresNames.length; i++) {
//					if (info[0].equalsIgnoreCase(useresNames[i] && info[7].equalsIgnoreCase(path))) {
//						System.out.println("JA EXISTE");
//						i++;
//					} else {
//						importedUser.setLogin(info[0]);
//						System.out.println(importedUser.getLogin());
//						i++;
//					}
//				}

//						System.out.println(info[0]+"\n" + info[1]+"\n" + info[2]+"\n" + info[3]+"\n" + info[4]+"\n" +
//								info[5]+"\n" + info[6]+"\n" + info[7]+"\n" + info[8]+"\n" );
//						System.out.println("========================================================");

//			}
//		}