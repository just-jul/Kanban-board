package com.julia;

public class Card {
    String taskTitle;
    String taskDescription;
    String color;
    public enum Priority // how to use in constructor?
    {
        HIGHT,MEDIUM,LOW
    }


    public Card(String taskTitle, String taskDescription, String color){
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.color = color;
    }



}
