package com.julia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App extends JFrame implements ActionListener {

    JScrollPane scrollPane = new JScrollPane();
    JPanel notStartedColumn = new JPanel();
    JPanel inProgressColumn = new JPanel();
    JPanel completeColumn = new JPanel();

    JPanel card = new JPanel();

    JButton addCard = new JButton("Add card");
    JButton deleteCard = new JButton("Delete card");


    static void main(String[] args) throws Exception {
        App window = new App("Kanban board");
        window.init();

        window.setVisible(true);


    }

    public App (String title){
        super(title);
    }


    void init(){

        setSize(1000,1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        add(addCard);
        add(deleteCard);
        add(notStartedColumn);
        add(inProgressColumn);
        add(completeColumn);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
