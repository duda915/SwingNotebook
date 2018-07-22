/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdud.swingnotebook;

import com.mdud.data.Note;

/**
 *
 * @author DuDa
 */
public class Controller {
    private View view;
    private Model model;
    
    public Controller() {
        view = new View(this);
        model = new Model(this);
    }
    
    public void addNote(Note note) {
        model.addNote(note);
    }
    
    public void updateViewNotesList() {
        String[] passString = model.getTitlesList().toArray(new String[0]);
        view.updateNotesList(passString); 
    }
    
    public Note getNote(int id) {
        return model.getNote(id);
    }

    
}
