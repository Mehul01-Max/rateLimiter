
public class UserDetail {

    private final int user_id;
    private final String IPA;
    private final String location;

    public UserDetail(int user_id, String IPA, String location) {
        this.user_id = user_id;
        this.IPA = IPA;
        this.location = location;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getIPA() {
        return IPA;
    }

    public String getLocation() {
        return location;
    }

}