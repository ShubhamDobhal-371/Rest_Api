package com.shiubhu.RestApi_01.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_details") //set the table name using "@Table" annotation.
public class User {

    @Id //indicating primary key column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(name = "user_name")
    private String uname;

    @Column(name = "about_user")
    private String uabout;

    @Column(name = "user_mail")
    private String uemail;

    @Column(name = "user_age")
    private Long uage;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUabout() {
        return uabout;
    }

    public void setUabout(String uabout) {
        this.uabout = uabout;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public Long getUage() {
        return uage;
    }

    public void setUage(Long uage) {
        this.uage = uage;
    }
}
