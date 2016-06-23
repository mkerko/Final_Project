package by.epam.training.domain;

import java.io.Serializable;

public class User  implements Serializable{

    private static final long serialVersionID = 1L;
    private Long ID;
    private String login;
    private String password;
    private String role;
    private boolean isBanned;
    private String firstName;
    private String lastName;
    private String passportSeries;
    private String passportNumber;
    private String age;
    private String cashAccount;

    public User(Long ID, String login, String password, String role, boolean isBanned) {
        this.ID = ID;
        this.login = login;
        this.password = password;
        this.role = role;
        this.isBanned = isBanned;
    }
    public User(Long ID, String login, String password, String role) {
        this.ID = ID;
        this.login = login;
        this.password = password;
        this.role = role;
    }
    public User(Long ID, String login, String password, String role, boolean isBanned, String firstName, String lastName, String passportSeries, String passportNumber,
                String age, String cashAccount) {
        this.ID = ID;
        this.login = login;
        this.password = password;
        this.role = role;
        this.isBanned = isBanned;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
        this.passportSeries = passportSeries;
        this.age = age;
        this.cashAccount = cashAccount;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(String cashAccount) {
        this.cashAccount = cashAccount;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!ID.equals(user.ID)) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        return role.equals(user.role);

    }

    @Override
    public int hashCode() {
        int result = ID.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
