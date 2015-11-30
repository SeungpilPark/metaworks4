package io.uengine.web.registe;

import java.util.Date;

/**
 * Created by uengine on 2015. 6. 3..
 */
public class Registe {

    long id;
    long user_id;
    String token;
    Date registration;

    public Registe(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    @Override
    public String toString() {
        return "Registe{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", token='" + token + '\'' +
                ", registration=" + registration +
                '}';
    }
}
