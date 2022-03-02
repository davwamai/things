package things;
import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UserLoader extends UserConstants{
    
    public static ArrayList<User> getUsers() {
        
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < usersJSON.size(); i++){
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                UUID id = UUID.fromString((String)userJSON.get(USER_ID));
                String userName = (String)userJSON.get(USER_USER_NAME);
                String firstName = (String)userJSON.get(USER_FIRST_NAME);
                String lastName = (String)userJSON.get(USER_LAST_NAME);
                int age = ((Long)userJSON.get(USER_AGE)).intValue();
                String phoneNumber = (String)userJSON.get(USER_PHONE_NUMBER);

                //users.add(new User(id, userName, firstName, lastName, age, phoneNumber));
            }
            return users;
        }
        catch (Exception e){
            e.printStackTrace();
        }
            return null;
    }
    
}
