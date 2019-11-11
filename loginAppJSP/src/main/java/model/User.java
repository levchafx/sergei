package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {

	private int id;
	private String name;
	private String surname;
	private String email;
	private int age;
	private String login;
	private String password;
	private Role role;
	private boolean profile_enable;

	public User() {
		super();
		profile_enable = true;
	}

	public User(String name, String surname, int age, String email, String login, String password, Role role) {
		profile_enable = true;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.age = age;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public User(String name, String surname, int age, String email, String login, String password) {

		profile_enable = true;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.age = age;
		this.login = login;
		this.password = password;
		this.role = Role.USER;
	}

	public User(String login, String password) {
		profile_enable = true;
		this.login = login;
		this.password = password;
	}

	public User(String login, String password, Role role) {
		profile_enable = true;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", age=" + age
				+ ", login=" + login + ", password=" + password + ", role=" + role + ", profile_enable="
				+ profile_enable + "]";
	}

}