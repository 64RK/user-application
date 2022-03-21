package com.userapplication.user.application.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    private long id;
    private String userName;
    private int userAge;
    private long userAccountId;

    public Account() {
    }

    public Account(User user) {
        this.id = user.id;
        this.userName = user.userName;
        this.userAge = user.userAge;
        this.userAccountId = user.userAccountId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userAccountId=" + userAccountId +
                '}';
    }
}
