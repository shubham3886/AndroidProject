package com.example.sistec_event;

public class Post {


    String name;
    String college;
    String email;
    String phone;
    String event;

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "name='" + name + '\'' +
                ", college='" + college + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", event='" + event + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}


