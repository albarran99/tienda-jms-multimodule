package org.iesfm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class User {

    private String username;
    private String emailUser;
    private int phone;

    @JsonCreator
    public User(
            @JsonProperty("username") String username,
            @JsonProperty("emailUser") String emailUser,
            @JsonProperty("phone") int phone) {
        this.username = username;
        this.emailUser = emailUser;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return phone == user.phone && Objects.equals(username, user.username) && Objects.equals(emailUser, user.emailUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, emailUser, phone);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", emailUser='" + emailUser + '\'' +
                ", phone=" + phone +
                '}';
    }
}
