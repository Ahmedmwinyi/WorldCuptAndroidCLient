package com.example.androidclient.Model;

public class Team {


    private Long id;
    private String name;
    private String title;
    private String cont;
    private String coach;
    private String keyplayer;

    public Team(Long id, String name, String title, String cont, String coach, String keyplayer) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.cont = cont;
        this.coach = coach;
        this.keyplayer = keyplayer;
    }

    public Team() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getCont() {
        return cont;
    }

    public String getCoach() {
        return coach;
    }

    public String getKeyplayer() {
        return keyplayer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public void setKeyplayer(String keyplayer) {
        this.keyplayer = keyplayer;
    }
}
