/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package todolist;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.IOException;

public class Todolist extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //display frame
        new Todolist().setVisible(true);
        
    }
    
    public Todolist()
    {
        //title of frame 
        super("To do list");
        
        //size of frame
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
