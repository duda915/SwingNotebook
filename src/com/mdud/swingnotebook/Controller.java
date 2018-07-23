/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdud.swingnotebook;

import com.mdud.data.Note;
import com.mdud.swingnotebook.views.MainPanel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.plaf.basic.BasicListUI;

/**
 *
 * @author DuDa
 */
public class Controller {
    
    private Model model;
    
    //View
    private JFrame mainFrame;
    private MainPanel view;
    private int activeNoteIndex = 0;
    
    //List data model
    private DefaultListModel<String> dlm;
    
    
    public Controller() {
        model = new Model();
        
        //View init
        mainFrame = new JFrame("Notebook");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view = new MainPanel(this);
        mainFrame.getContentPane().add(view);
        mainFrame.pack();
        mainFrame.setVisible(true);
        
        dlm = new DefaultListModel<>();
        getItemList();
        view.getItemList().setModel(dlm);
        updateItemData();
        view.getItemList().setSelectedIndex(activeNoteIndex);
        //First update
        
        
        
    }
    
    public void addNote() {
        Note note = new Note("Title", new Date(), "");
        model.addNote(note);
        dlm.addElement(note.getNoteTitle());
        
        view.getItemList().setSelectedIndex(view.getItemList().getLastVisibleIndex());
    }
    
    public void removeNote() {
        model.removeNote(activeNoteIndex);
        dlm.remove(activeNoteIndex);
        activeNoteIndex--;
        
        
        //Empty list handler
        if(activeNoteIndex == -1 && model.getNotesCount() == 0) {
            activeNoteIndex = 0;
            Note note = new Note("Title", new Date(), "");
            model.addNote(note);
            dlm.addElement(note.getNoteTitle());
        } else if(activeNoteIndex == -1) {
            activeNoteIndex = 0;
        }
        
        view.getItemList().setSelectedIndex(activeNoteIndex);

    }
    
    public void setActiveNote(int index) {
        saveActiveNoteChanges();
        activeNoteIndex = index;
        
        updateItemData();
    }
    
    public void saveActiveNoteChanges() {
        try {
            String noteTitle = view.getTitleTextField().getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date noteDate = sdf.parse(view.getDateField().getText());
            String noteContent = view.getNoteTextArea().getText();
            
            Note note = new Note(noteTitle, noteDate, noteContent);
            model.setNote(activeNoteIndex, note);
            dlm.set(activeNoteIndex, noteTitle);
    
        }catch(ParseException e) {
            System.out.println("Date parsing error");
            e.printStackTrace();
        }
        
    }
    
    public void saveNotesToFile(){
        saveActiveNoteChanges();
        model.saveNotes();
    }

    private void getItemList() {
        dlm.clear();
        
        for(String s : model.getTitlesList())
            dlm.addElement(s);
        
    }
    
    private void updateItemData() { 
        //Update active note
        Note note = model.getNote(activeNoteIndex);
        view.getTitleTextField().setText(note.getNoteTitle());
        view.getNoteTextArea().setText(note.getNoteContent());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        view.getDateField().setText(sdf.format(note.getNoteDate()));
    }
    
    public void toggleDone() {
//        saveActiveNoteChanges();
        model.markAsDone(activeNoteIndex);
        view.repaint();
    }
    
    public List<Integer> getDoneIndices() {
        return model.getDoneNotes();
    }
    
    private void clearNote() {
        view.getTitleTextField().setText("");
        view.getNoteTextArea().setText("");
        view.getDateField().setText("");
    }
    
    
}
