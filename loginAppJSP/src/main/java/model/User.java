package model;

public class User {

	private long id;
	private String name;
	private String surname;
	private String email;
	private int age;
	private String login;
	private String password;
	private Role role;
	private boolean profile_enable;

	public boolean isProfile_enable() {
		return profile_enable;
	}

	public void setProfile_enable(boolean profile_enable) {
		this.profile_enable = profile_enable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}