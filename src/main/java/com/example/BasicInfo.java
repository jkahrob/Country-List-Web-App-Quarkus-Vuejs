package com.example;

import javax.swing.*;

public class BasicInfo extends JFrame {
    private JButton registerUserButton;
    private JPanel mainPanel;

    public BasicInfo() {
        setTitle("Welcome");
        setContentPane(mainPanel);
        setSize(1200, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)  //static method
    {
        System.out.println("Static method");
    }
}
