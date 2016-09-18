package com.ludwigstralewiren.user;


import javax.persistence.*;

@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private Long phone;


    public User() {
    }

    public User(UserBuilder userBuilder){
        this.userName = userBuilder.userName;
        this.lastName = userBuilder.lastName;
        this.email = userBuilder.email;
        this.phone = userBuilder.phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public static class UserBuilder {
        private String userName;
        private String lastName;
        private String email;
        private Long phone;

        public UserBuilder(String userName, String lastName){
            this.userName = userName;
            this.lastName = lastName;
        }

        public UserBuilder withEmail(String email){
            this.email = email;
            return this;
        }

        public UserBuilder withPhone(Long phone){
            this.phone = phone;
            return this;
        }

        public User build(){
            return new User(this);
        }

    }
}

