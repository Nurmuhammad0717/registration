public class User {

    private String fullName;
    private String phoneNumber;
    private String e_mail;
    private String password;

    public User(String fullName, String phoneNumber, String e_mail, String password) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.e_mail = e_mail;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return phoneNumber;
    }

    public void setBirthDate(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
