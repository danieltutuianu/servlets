import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User {


    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String firstname;
    @Getter
    @Setter
    private String lastname;
    @Getter
    @Setter
    private Date dob;

    public static Integer register(String username,String email, String password, String firstname, String lastname, String dob) {
        return Db.register(username,email, password, firstname, lastname, dob);
    }


    public static User login(String username, String password) {
        return Db.login(username, password);
    }

    public static ArrayList validate(String username,String email, String password, String firstname, String lastname, String dob) {

            ArrayList<String> errors = new ArrayList<String>();

            if( username == null || username.length() == 0 ) {
                errors.add("Username is required");
            } else {
                if(!Db.checkUsernameAvailability(username)) {
                    errors.add("Username is already used");
                }
            }

            if( email == null || email.length() == 0 ) {
                errors.add("Email is required");
            } else {
                if(checkEmailFormat(email)) {
                    if(!Db.checkEmailAvailability(email)) {
                        errors.add("Email is already used");
                    }
                } else {
                    errors.add("Email is wrong");
                }
            }

            if( password == null || password.length() == 0 ) {
                errors.add("Password is required");
            }

            if( firstname == null || firstname.length() == 0 ) {
                errors.add("First name is required");
            }

            if( lastname == null || lastname.length() == 0 ) {
                errors.add("Last name is required");
            }

            if( dob == null || dob.length() == 0 ) {
                errors.add("Date of birth is required");
            }

            return errors;
    }


    public static Boolean checkEmailFormat( String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}

