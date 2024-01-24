/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package todolist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Todolist extends JFrame {
    
    private JList<String> list;
    private JTextField inputfield;
    private DefaultListModel<String> model;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //new to do list 
        Todolist todolist = new Todolist();
        //display frame
        new Todolist().setVisible(true);
        
    }
    
    public Todolist()
    {
        //title of frame 
        super("To do list");
        
        //size of frame
        this.setSize(650,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        //input and buttons 
        JPanel input = new JPanel();
        inputfield = new JTextField(30);
        JButton add = new JButton("Add task");
        JButton remove = new JButton("Remove task");
        
        //model for list 
        model = new DefaultListModel<>();
        list = new JList<>(model);
        JScrollPane scroll = new JScrollPane(list);
        this.add(scroll, BorderLayout.CENTER);
        
        //add components 
        input.add(inputfield);
        input.add(add);
        input.add(remove);
        
        this.add(input, BorderLayout.NORTH);
        
        //action listeners for add and remove button
        
        //add
        add.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               String inputs = inputfield.getText();
               if(!inputs.isEmpty())
               {
                   model.addElement(inputs);
                   inputfield.setText(""); //leaves box empty
               }
           }
        });
        
        //remove
        remove.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               int selectedIndex = list.getSelectedIndex();
               if(selectedIndex != -1)
               {
                   model.remove(selectedIndex);
               }
           }
        });
    }
}
