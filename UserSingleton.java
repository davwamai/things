package things;
import java.util.ArrayList;

public class UserSingleton {
	private static UserSingleton users;
	private ArrayList<User> userList;
	
	private UserSingleton() {
		userList = UserLoader.getUsers();
	}
	
	public static UserSingleton getInstance() {
		if(users == null) {
			users = new UserSingleton();
		}
		
		return users;
	}

	public boolean haveUser(String userName) {
		for(User user : userList) {
			if(user.getUserName().equals(userName)) {
				return true;
			}
		}
		
		return false;
	}
	
	public User getUser(String userName) {
		for(User user : userList) {
			if(user.getUserName().equals(userName)) {
				return user;
			}
		}
		
		return null;
	}
	
	public ArrayList<User> getUsers() {
		return userList;
	}
	
	public boolean addUser(String userName, String firstName, String lastName, int age, String phoneNumber) {
		if(haveUser(userName))return false;
		
		userList.add(new User(userName, firstName, lastName, age, phoneNumber));
		return true;
	}
	
	public void saveUsers() {
		UserWriter.saveUsers();
	}
}
