package util;

import error.ValidationException;
import model.User;

public class ValidationUtil {
	
	public static void validate(User user) throws ValidationException, NullPointerException{
		if(user.getUsername() == null) {
			throw new NullPointerException("Username is Null");
		}
		else if(user.getUsername().isBlank()) {
			throw new ValidationException("Username is blank");
		}
		else if(user.getPassword()== null) {
			throw new NullPointerException("Password is Null");
		}
		else if(user.getPassword().isBlank()) {
			throw new ValidationException("Password is blank");
		}
	}

}
