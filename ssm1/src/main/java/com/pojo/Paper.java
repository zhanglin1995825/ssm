package com.pojo;
import org.springframework.stereotype.Component;


public class Paper {
    private String name;
    private int id;

    public Paper() {
    }

    public Paper(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString(){
     return "Paper[id="+id+",name="+name+"]";
    }
}
