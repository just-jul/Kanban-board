package com.julia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Card extends JPanel implements MouseListener {
    private App app;

    private String taskTitle;
    private JLabel taskTitleLabel;
    private String taskDescription;
    private JLabel descriptionLabel;
    private String color;
    private Priority priority;
    private JLabel priorityLabel;
    private boolean isSelected;



    public Card(String taskTitle, Priority priority, App app) { // , String taskDescription, String color,
        this.taskTitle = taskTitle;
        this.priority = priority;
        this.app = app;
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

        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if(app.selectedCard == this){
            setBackground(Color.WHITE);
            repaint();
            app.selectedCard = null;
        }
        else {
            if(app.selectedCard != null){
                app.selectedCard.setBackground(Color.WHITE); // deselect previous
                app.selectedCard.repaint();
            }
            app.selectedCard = this;

            setBackground(ColorEnum.LIGHT_BLUE.toColor());
            repaint();
            this.isSelected = true;
        }

    }
    public String getTaskTitle(){
        return this.taskTitle;
    }
    public Priority getTaskPriority(){
        return this.priority;
    }
    public boolean getSelected(){
        return isSelected;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {}


}
