package com.userapplication.user.application.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {

    @Id
    private long id;
    private String userName;
    private int userAge;
    private long userDepartmentId;

    public Department() {
    }

    public Department(User user) {
        this.id = user.id;
        this.userName = user.userName;
        this.userAge = user.userAge;
        this.userDepartmentId = user.userDepartmentId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userDepartmentId=" + userDepartmentId +
                '}';
    }
}
