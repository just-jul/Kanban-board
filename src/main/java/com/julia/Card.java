package com.julia;

import javax.swing.*;

public class Card extends JPanel {
    String taskTitle;
    String taskDescription;
    String color;
    Priority priority;


    public Card(String taskTitle, String taskDescription, String color, Priority priority){
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.color = color;
        this.priority = priority;
    }



}
