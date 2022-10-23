package com.programmers.engine.model;


import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Formula {
    private String content;
    public void addData(DataBase db){db.addData(this.content);}
    public void clearContent(){this.content = "";};
}
