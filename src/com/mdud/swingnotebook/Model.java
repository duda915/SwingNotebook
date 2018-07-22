/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdud.swingnotebook;

import com.mdud.data.Note;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DuDa
 */
public class Model {
    private List<Note> notesList;
    private Controller controller;
    
    public Model(Controller controller) {
        this.controller = controller;
        notesList = new ArrayList<>();
        notesList.add(new Note("Test1", new Date(), "Testing note 1"));
        notesList.add(new Note("Test2", new Date(), "Testing note 2"));
    }
    
    public void addNote(Note note) {
        notesList.add(note);
        controller.updateViewNotesList();
    }
    
    
    public List<String> getTitlesList() {
        List<String> titlesList = new ArrayList<>();
        
        for(Note n : notesList)
            titlesList.add(n.getNoteTitle());
        
        return titlesList;
            
    }
    
    public Note getNote(int id) {
        return notesList.get(id);
    }
    
}
