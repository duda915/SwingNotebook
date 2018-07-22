/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdud.swingnotebook;

import com.mdud.swingnotebook.panels.MainPanel;
import com.mdud.data.Note;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.ListModel;

/**
 *
 * @author DuDa
 */
public class View {
    private JFrame mainFrame;
    private MainPanel mainPanel;
    private Controller controller;
    
    public View(Controller controller) {
        this.controller = controller;
        
        mainFrame = new JFrame("Notebook");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new MainPanel(this);
        mainFrame.getContentPane().add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    public void updateNotesList(String[] titleList) {
        mainPanel.getItemList().setListData(titleList);
    }
    
    public void addNote(Note note){
        controller.addNote(note);
    }
    
    public void updateActiveNote(int index) {
        Note activeNote = controller.getNote(index);
        
        mainPanel.getTitleTextField().setText(activeNote.getNoteTitle());
        mainPanel.getNoteTextArea().setText(activeNote.getNote());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm");
        mainPanel.getDateField().setText(sdf.format(activeNote.getNoteDate()));
    }
}
