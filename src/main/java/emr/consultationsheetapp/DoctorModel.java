package emr.consultationsheetapp;

public class DoctorModel extends UserModel {
    private int userId;
    private int clinic;

    public DoctorModel(String username, String password, int clinic) {
        super(username, password);
        this.clinic = clinic;
    }

    public DoctorModel(String username, String password, Integer userId, int clinic) {
        super(username, password);
        this.clinic = clinic;
        this.userId = userId;
    }

    public DoctorModel(int clinic) {
        this.clinic = clinic;
    }
}
