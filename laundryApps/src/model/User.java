package model;

public class User {
	String id, name, username, password;

	public User(String uname, String pass) {
		this.username = uname;
		this.password = pass;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setNama(String name) {
		this.name = name;}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public static boolean login(String text, String text2) {
		// TODO Auto-generated method stub
		//return false;
	//}
	
	//public static boolean login (String username, String password) {  
		//dibikin static biar bisa dipanggil di jframe lain 
	}
		//boolean isLoggin = false;
		//User user = new User ();
	//	user.setId("1");
		//user.setNama("Sherly");
		//user.setUsername("Sherly");
		//user.setPassword("12345");
		//username = username.trim(); //biar dia ga peduli spasi 
		//if(user.getUsername().equalsIgnoreCase (username) && user.getPassword().equals(password)) {  //kalo pake ignoreCase dia ga peduli huruf kecil/besar
		//	isLoggin = true;
		//}
		//else {
		//	isLoggin = false;
		//}
		//return isLoggin;
	//}

//}
