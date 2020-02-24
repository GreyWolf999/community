package com.greywolf.community.dbo;



public class GitHubUser {
    private String login;
    private long id;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GitHubUser{" +
                "login='" + login + '\'' +
                ", id=" + id +
                '}';
    }
}
