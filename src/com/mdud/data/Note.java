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
    
    private int noteId;
    private static int counter = 0;
            
    private String noteTitle;
    private Date noteDate;
    private String noteContent;
    private Boolean isDone = false;
    private Boolean isEdited = false;
    
    
    public Note(String noteTitle, Date noteDate, String note) {
        this.noteId = counter;
        counter++;
        
        this.noteTitle = noteTitle;
        this.noteDate = noteDate;
        this.noteContent = note;
    }
    
    public String getNoteTitle() {
        return noteTitle;
    }

    public Date getNoteDate() {
        return noteDate;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public void setNoteContent(String note) {
        this.noteContent = note;
    }
    
    public void setNote(Note note) {
        this.noteTitle = note.getNoteTitle();
        this.noteDate = note.getNoteDate();
        this.noteContent = note.getNoteContent();
    }
    
    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }
    
    public Boolean getIsDone() {
        return isDone;
    }
    
    public int getNoteId() {
        return noteId;
    }
    
    public void setIsEdited(boolean edited) {
        isEdited = edited;
    }
    
    public boolean getIsEdited() {
        return isEdited;
    }
    
    
    
}
