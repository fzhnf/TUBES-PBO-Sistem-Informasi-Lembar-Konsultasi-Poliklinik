package emr.consultationsheetapp;

public abstract class UserModel {
    protected String username;
    protected String password;
    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public UserModel() {
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


    @Override
    public String toString() {
        return "UserModel{" +
                "username='" + username + '\'' +
                ", password='" + password +
                '}';
    }
}
