package models

import groovy.transform.ToString

import java.time.LocalTime

class LogRecordModel {

    private LocalTime time;
    private String user;
    private String message;

    public LogRecordModel(String time, String user, String message) {
        this.time = LocalTime.parse(time)
        this.user = user;
        this.message = message;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return  time.toString() + ","+ user + "," + message;
    }
}
