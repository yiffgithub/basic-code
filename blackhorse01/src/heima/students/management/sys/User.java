package heima.students.management.sys;

public class User {
    private String username;
    private String password;
    private String personalid;
    private String phonenumber;

    public User() {
    }

    public User(String username, String password, String personalid, String phonenumber) {
        this.username = username;
        this.password = password;
        this.personalid = personalid;
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonalid() {
        return personalid;
    }

    public void setPersonalid(String personalid) {
        this.personalid = personalid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
