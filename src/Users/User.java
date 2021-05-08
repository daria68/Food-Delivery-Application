package Users;

//import javax.mail.internet.InternetAddress;
import java.util.Date;

public abstract class User {

    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    protected String phoneNumber;
    protected Date birthDate;

    public User() {}

    public User(String firstName, String lastName, String username, String password, String phoneNumber, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getbirthDate() {
        return birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setbirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Name: " + this.firstName + " " + this.lastName +
              "\nPhone number: " + this.phoneNumber + "\nDate birth: " + this.birthDate.toString() + "\n";
    }
}
