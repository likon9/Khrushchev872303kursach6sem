package com.example.demo.p1;

import com.example.demo.work.WorkPA;

public class Autorisation  {

  public String password;
  public String login;

    public Autorisation() {
    }

    public Autorisation(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
