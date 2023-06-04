package tubespbo.lembarkonsultasi.Model;

public class UserDoctorModel extends UserModel {
    private int userId;
    private int clinic;

    public UserDoctorModel(String username, String password, int clinic) {
        super(username, password);
        this.clinic = clinic;
    }

    public UserDoctorModel(String username, String password, Integer userId, int clinic) {
        super(username, password);
        this.clinic = clinic;
        this.userId = userId;
    }

    public UserDoctorModel(int clinic) {
        this.clinic = clinic;
    }
}
