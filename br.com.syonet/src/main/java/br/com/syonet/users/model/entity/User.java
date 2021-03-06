package br.com.syonet.users.model.entity;

public class User {

	private Long id;

	private String login;

	private String group;

	private String domain;

	private String password;

	private String type;

	private String ap_usuario;

	private String nm_usuario;

	private String id_usuarioerp;

	private String email;

	public String getId_usuarioerp() {
		return id_usuarioerp;
	}

	public void setId_usuarioerp(String id_usuarioerp) {
		this.id_usuarioerp = id_usuarioerp;
	}

	private Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAp_usuario() {
		return ap_usuario;
	}

	public void setAp_usuario(String ap_usuario) {
		this.ap_usuario = ap_usuario;
	}

	public String getNm_usuario() {
		return nm_usuario;
	}

	public void setNm_usuario(String nm_usuario) {
		this.nm_usuario = nm_usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return id + "," + login + "," + group + "," + domain + "," + password + "," + type + "," + ap_usuario + ","
				+ nm_usuario + "," + email + "," + active;
	}

	@Override
	public boolean equals(Object other) {

		if (other == null || !(other instanceof User)) {
			return false;
		}
		if (other == this) {
			return true;
		}

		User otherUser = (User) other;

		boolean teste = ((otherUser.getLogin().equals(this.getLogin()))
				|| (otherUser.getEmail().equals(this.getEmail())));

		return teste;
	}
}
