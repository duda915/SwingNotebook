/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdud.swingnotebook;

import javax.swing.JFrame;

/**
 *
 * @author DuDa
 */
public class View {
    private JFrame mainFrame;
    private MainPanel mainPanel;
    
    public View() {
        mainFrame = new JFrame("Notebook");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new MainPanel();
        mainFrame.getContentPane().add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
}
