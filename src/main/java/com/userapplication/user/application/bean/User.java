package com.userapplication.user.application.bean;

import com.userapplication.user.application.repository.AuditTrailListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@EntityListeners(AuditTrailListener.class)
@Entity
public class User {

    @Id
    @GeneratedValue
    protected long id;
    protected String userName;
    protected int userAge;
    protected long userAccountId;
    protected long userDepartmentId;

    public User(){

    }
    public User(long id, String userName, int userAge, long userAccountId, long userDepartmentId) {
        this.id = id;
        this.userName = userName;
        this.userAge = userAge;
        this.userAccountId = userAccountId;
        this.userDepartmentId = userDepartmentId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public long getUserDepartmentId() {
        return userDepartmentId;
    }

    public void setUserDepartmentId(long userDepartmentId) {
        this.userDepartmentId = userDepartmentId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userAccountId=" + userAccountId +
                ", userDepartmentId=" + userDepartmentId +
                '}';
    }
}

