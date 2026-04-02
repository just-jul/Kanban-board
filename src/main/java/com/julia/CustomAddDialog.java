package com.julia;

import javax.swing.*;
import java.awt.*;

public class CustomAddDialog extends JPanel {
    JTextField taskNameFiled;
//    JTextField taskDescription; - for later
    JComboBox<Priority> priorityBox;

    public CustomAddDialog(){
        setLayout(new GridLayout(4, 1, 5, 5));
        this.taskNameFiled = new JTextField();
        this.priorityBox = new JComboBox<>(Priority.values());

        add(new JLabel("Task name:"));
        add(taskNameFiled);
        add(new JLabel("Priority:"));
        add(priorityBox);
    }

    public String getTaskName(){
        return taskNameFiled.getText();
    }
    public Priority getPriority(){
        return (Priority) priorityBox.getSelectedItem();
    }

}
