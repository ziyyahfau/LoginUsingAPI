package noosc.project.otrs.login.model;

/**
 * Created by Fauziyyah Faturahma on 8/30/2017.
 */

public class LoginModel {
    private String email;
    private String username;
    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}
