package oop.simulatingoperationflighttrainingacademy;

import java.io.Serializable;

public class SignUp implements Serializable {
    String id;
    String email;
    String fullname;
    String password;
    String role;

    public SignUp(String id, String email, String fullname, String password, String role) {
        this.id = id;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    @Override
    public String toString() {
        return "SignUp{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
