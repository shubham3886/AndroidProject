package com.example.sistec_event;

public class User {
    private String uid, name, mno, email,photo;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", mno='" + mno + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public String getPhoto() {
        return photo;
    }

    public User(String uid, String name, String mno, String email,String photo) {
        this.uid = uid;
        this.name = name;
        this.mno = mno;
        this.email = email;
        this.photo=photo;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getMno() {
        return mno;
    }

    public String getEmail() {
        return email;
    }

}
