package br.com.syonet.users.ImportFromFile;

import br.com.syonet.users.model.entity.User;

public class ValidatorUsers {

	public Boolean execute(User user) {

		if (user.getLogin() != null && user.getEmail() != null) {
			return true;
		}

		return false;

	}
}
