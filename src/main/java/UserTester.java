import java.util.List;

import controller.UserHelper;
import model.User;

/**
 * Hayden Harris - CIS175 
 * DMACC FALL 2022
 * Oct 6, 2022
 */
public class UserTester {
	public static void main(String[] args) {
		User bill = new User("Bill");
		UserHelper uh = new UserHelper();
		uh.insertUser(bill);
		
		List<User> allUsers = uh.showAllUsers();
		for(User a: allUsers) {
			System.out.println(a.toString());
		}
	}

}
