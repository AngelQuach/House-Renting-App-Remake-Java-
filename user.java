class user {
	//name of user
	String user_name;
	
	//number corresponding to user avatar; from 0-6
	int avatar_num;
	
	//default constructor
	public user() {
		user_name = "user name";
		avatar_num = 0;
	}
	
	//specialized constructor
	public user(String name) {
		user_name = name;
	}
	
	//getters --> for user name and avatar number respectively
	public String getName() {
		return user_name;
	}
	public int getNum() {
		return avatar_num;
	}
	
	//setters --> for user name and avatar number respectively
	public void setName(String new_name) {
		user_name = new_name;
	}
	public void setNum(int new_num) {
		avatar_num = new_num;
	}
	
	//copy from an existing user object
	public void copy(user old_user) {
		this.setName(old_user.getName());
		this.setNum(old_user.getNum());
	}
}
