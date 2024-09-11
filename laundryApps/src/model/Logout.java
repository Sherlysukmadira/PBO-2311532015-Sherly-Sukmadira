package model;

public class Logout {
	String id_logout, id_admin, username, logout_time, session_duration, logout_reason;

	public String getId_logout() {
		return id_logout;
	}

	public void setId_logout(String id_logout) {
		this.id_logout = id_logout;
	}

	public String getId_admin() {
		return id_admin;
	}

	public void setId_admin(String id_admin) {
		this.id_admin = id_admin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLogout_time() {
		return logout_time;
	}

	public void setLogout_time(String logout_time) {
		this.logout_time = logout_time;
	}

	public String getSession_duration() {
		return session_duration;
	}

	public void setSession_duration(String session_duration) {
		this.session_duration = session_duration;
	}

	public String getLogout_reason() {
		return logout_reason;
	}

	public void setLogout_reason(String logout_reason) {
		this.logout_reason = logout_reason;
	}
	
}
