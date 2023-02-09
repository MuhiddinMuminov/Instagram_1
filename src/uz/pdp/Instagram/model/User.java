package uz.pdp.Instagram.model;

public class User extends BaseModel {
    private String username;
    private String password;
    private String phoneNumber;
    private String fullName;
    private Integer followers;
    private Integer following;
    private String Bio;

    public User(String username, String password, String phoneNumber, String fullName, String bio) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        Bio = bio;
    }

    public User(String username, String password, String phoneNumber, String fullName) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String mittime, String mittivine, String s) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBio() {
        return Bio;
    }

    public void setBio(String bio) {
        Bio = bio;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    public User(String username, String password, String phoneNumber, String fullName, Integer followers, Integer following, String bio) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.followers = followers;
        this.following = following;
        Bio = bio;
    }

    @Override
    public String toString() {
        return
                "Username = " + username + "  ||  " +
                "FullName = " + fullName + "  ||  " +
                "Followers = " + followers +"  ||  " +
                "Following = " + following +"  ||  " +
                "Bio = " + Bio ;
    }
}
