package com.example.baikiemtra1;

public class Singer {
    private String name;
    private String nickname;
    private int start;
    private String country;


    public Singer(String name, String nickname, int start, String country) {
        this.name = name;
        this.nickname = nickname;
        this.start = start;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
