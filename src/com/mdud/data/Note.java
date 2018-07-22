/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdud.data;

import java.util.Date;

/**
 *
 * @author DuDa
 */
public class Note {
    
    private String noteTitle;
    private Date noteDate;
    private String note;
    
    public Note(String noteTitle, Date noteDate, String note) {
        this.noteTitle = noteTitle;
        this.noteDate = noteDate;
        this.note = note;
    }
    
    public String getNoteTitle() {
        return noteTitle;
    }

    public Date getNoteDate() {
        return noteDate;
    }

    public String getNote() {
        return note;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
