package technonet.com.allwitz.Models;

/**
 * Created by vakhtanggelashvili on 4/12/17.
 */

public class EmailLoginRequestBody {
    public String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String password;

    public EmailLoginRequestBody(String email, String password) {
        this.email=email;
        this.password=password;
    }
}
