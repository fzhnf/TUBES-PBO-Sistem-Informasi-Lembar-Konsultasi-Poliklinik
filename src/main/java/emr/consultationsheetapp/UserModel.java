package emr.consultationsheetapp;

public abstract class UserModel {
    protected String username;
    protected String password;
    protected int clinic;


    public UserModel(String username, String password, int clinic) {
        this.username = username;
        this.password = password;
        this.clinic = clinic;
    }
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

    public int getClinic() {
        return clinic;
    }
    public void setClinic(int clinic) {
        this.clinic = clinic;
    }
}
