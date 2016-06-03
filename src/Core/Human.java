package Core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
//Done
public abstract class Human implements Serializable {

    //Login attributes
    protected String userName;
    protected String password;
    protected String profilePicture;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Checks the username oif true or not
    public static boolean checkUserName(String userName) throws IOException, ClassNotFoundException {
        ObjectInputStream file = new ObjectInputStream(new FileInputStream("Database\\login.bin"));
        HashMap<String, ArrayList<String>> List = (HashMap<String, ArrayList<String>>) file.readObject();
        if (List.get(userName) == null) {
            return false;
        }
        return true;
    }

    //When the username is correct, then he will match the passwrod with the username
    //and returns the userID
    public static int Login(String userName, String password) throws IOException, ClassNotFoundException {
        ObjectInputStream file = new ObjectInputStream(new FileInputStream("Database\\login.bin"));
        HashMap<String, ArrayList<String>> List = (HashMap<String, ArrayList<String>>) file.readObject();

        ArrayList<String> value = new ArrayList<>();
        value = List.get(userName);
        if (value.get(0).equals(password)) {
            char ch = value.get(1).charAt(0);
            if (ch == 'H') {
                return 1;
            }
            if (ch == 'L') {
                return 2;
            }
            if (ch == 'A') {
                return 3;
            }
            if (ch == 'T') {
                return 4;
            }
            if (ch == 'I') {
                return 5;
            }
            if (ch == 'C') {
                return 6;
            }
            if (ch == 'M')
            {
                return 7;
            }

        }
        return 0;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
