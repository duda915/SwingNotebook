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
import javax.swing.JFrame;

/**
 *
 * @author DuDa
 */
public class Controller {
    
    private Model model;
    
    //View
    private JFrame mainFrame;
    private MainPanel view;
    private int activeNoteIndex;
    
    public Controller() {
        model = new Model();
        
        //View init
        mainFrame = new JFrame("Notebook");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view = new MainPanel(this);
        mainFrame.getContentPane().add(view);
        mainFrame.pack();
        mainFrame.setVisible(true);
        
        //First update
        updateView();
        
    }
    
    public void addNote() {
        Note note = new Note("Title", new Date(), "");
        model.addNote(note);
        
        saveNotesToFile();
        updateView();
    }
    
    public void removeNote() {
        model.removeNote(activeNoteIndex);
        activeNoteIndex--;
        
        saveNotesToFile();
        updateView();
    }
    
    public void setActiveNote(int index) {
        activeNoteIndex = index;
        updateView();
    }
    
    public void saveActiveNoteChanges() {
        try {
            String noteTitle = view.getTitleTextField().getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date noteDate = sdf.parse(view.getDateField().getText());
            String noteContent = view.getNoteTextArea().getText();
            
            Note note = new Note(noteTitle, noteDate, noteContent);
            model.setNote(activeNoteIndex, note);
    
        }catch(ParseException e) {
            System.out.println("Date parsing error");
        }
        
        saveNotesToFile();
        updateView();
    }
    
    private void saveNotesToFile(){
        model.saveNotes();
    }
    
    private void updateView() {
        if(activeNoteIndex == -1 && model.getNotesCount() == 0) {
            activeNoteIndex = 0;
            Note note = new Note("Title", new Date(), "");
            model.addNote(note);
        } else if(activeNoteIndex == -1) {
            activeNoteIndex = 0;
        }
        
        //Update item list
        List<String> titlesArray = model.getTitlesList();
        String[] listData = titlesArray.toArray(new String[titlesArray.size()]);
        view.getItemList().setListData(listData);
        
        //Update active note
        Note note = model.getNote(activeNoteIndex);
        view.getTitleTextField().setText(note.getNoteTitle());
        view.getNoteTextArea().setText(note.getNoteContent());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        view.getDateField().setText(sdf.format(note.getNoteDate()));
    }
    
    public void toggleDone() {
        saveActiveNoteChanges();
        model.markAsDone(activeNoteIndex);
        saveNotesToFile();
        updateView();
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
