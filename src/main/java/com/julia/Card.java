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
        this.priorityLabel = new JLabel("Priority: " + priority.getPriorityText(priority));

        setLayout(new BorderLayout());
        setBorder(new RoundedBorder(40));

        add(taskTitleLabel, BorderLayout.NORTH);
        add(descriptionLabel, BorderLayout.CENTER);
        add(priorityLabel, BorderLayout.SOUTH);

        setPreferredSize(new Dimension(180, 70));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 70)); // prevents stretching to full column height
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        setBorder(new RoundedBorder(30));

        setOpaque(false);
        setBackground(Color.WHITE);
        setBorder(new RoundedBorder(12));
    }


}
