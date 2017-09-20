package noosc.project.otrs.login.model;

/**
 * Created by Fauziyyah Faturahma on 8/30/2017.
 */

public class LoginModel {
    private String username;
    private String status;
    private String message;
    private String name_company;
    private String email;
    private String type;

    public String getStatus() { return status;}

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }

    public String getName_company() {
        return name_company;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }
}
