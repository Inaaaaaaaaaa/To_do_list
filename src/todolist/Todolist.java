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
import java.util.HashMap;
import java.util.Map;

public class Todolist extends JFrame {
    
    private JPanel listPanel;
    private JTextField inputfield;
    private Map<JButton, JPanel> task;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //new to do list 
        Todolist todolist = new Todolist();
        //display frame
        todolist.setVisible(true);
        
    }
    
    public Todolist()
    {
        //title of frame 
        super("To do list");
        
        //size of frame
        this.setSize(500,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        //Main panel 
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        JScrollPane scroll = new JScrollPane(listPanel);
        this.add(scroll, BorderLayout.CENTER);

        
        //input and buttons
        JPanel inputP = new JPanel();
        inputfield = new JTextField(30);
        JButton addBtn = new JButton("Add");
        inputP.add(inputfield);
        inputP.add(addBtn);
        
        
        //adding input and buttons on North of frame
        this.add(inputP, BorderLayout.NORTH);
        
        //Using map to keep track of tasks 
        task = new HashMap<>();
        
        //action listeners for add and remove button
        
        //add
        addBtn.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               String inputs = inputfield.getText();
               if(!inputs.isEmpty())
               {
                   JPanel taskP = new JPanel();
                   taskP.setLayout(new BoxLayout(taskP, BoxLayout.X_AXIS));
                   taskP.add(new JLabel(inputs));
                   JButton removeBtn = new JButton("Remove");
                   taskP.add(removeBtn);
                   listPanel.add(taskP);
                   listPanel.revalidate();
                   listPanel.repaint();
                   inputfield.setText("");
                   
                   task.put(removeBtn, taskP);
                   
                //remove
                removeBtn.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                {
                    JPanel panelRemove = task.get((JButton) e.getSource());
                    listPanel.remove(panelRemove);
                    listPanel.revalidate();
                    listPanel.repaint();
           
                }
        });

               }
           }
        });
        

    }
}
