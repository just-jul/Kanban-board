package com.julia;

import javax.swing.*;
import java.awt.*;

public class Card extends JPanel {
    String taskTitle;
    JLabel taskTitleLabel;
    String taskDescription;
    JLabel descriptionLabel;
    String color;
    Priority priority;
    JLabel priorityLabel;


    public Card(String taskTitle, Priority priority) { // , String taskDescription, String color,
        this.taskTitle = taskTitle;
        this.priority = priority;
        this.taskTitleLabel = new JLabel(taskTitle);
        this.descriptionLabel = new JLabel(taskDescription);
        this.priorityLabel = new JLabel(priority.getPriorityText(priority));

        setLayout(new BorderLayout());

        add(taskTitleLabel, BorderLayout.NORTH);
        add(descriptionLabel, BorderLayout.CENTER);
        add(priorityLabel, BorderLayout.SOUTH);

        setPreferredSize(new Dimension(180, 40));
        setBackground(Color.WHITE);
        setOpaque(true);
    }
}
