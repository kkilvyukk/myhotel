package com.example.retrofitmy.bottomnav.reservation;

public class Reserve {
    String email;
    String type;
    String start;
    String end;

    public Reserve(String email, String type, String start, String end){
        this.email = email;
        this.type = type;
        this.start = start;
        this.end = end;
    }

    public Reserve(){
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
