/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdud.swingnotebook;

import com.mdud.data.Note;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author DuDa
 */
public class Model {
    private List<Note> notesList;
    
    public Model() {
        notesList = new ArrayList<>();
        loadNotes();
    }
    
    public void addNote(Note note) {
        notesList.add(note);
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
    
    public void setNote(int id, Note note) {
        notesList.get(id).setNote(note);
    }
    
    public void markAsDone(int id) {
        Note note = notesList.get(id);
        if(note.getIsDone())
            note.setIsDone(false);
        else
            note.setIsDone(true);
    }
    
    public List<Integer> getDoneNotes() {
        List<Integer> indices = new ArrayList<>();
        
        for(int i = 0; i < notesList.size(); i++) {
            if(notesList.get(i).getIsDone())
                indices.add(i);
        }
        
        return indices;
    }
    
    public void removeNote(int id) {
        notesList.remove(id);
    }
    
    public int getNotesCount() {
        return notesList.size();
    }
    
    public void saveNotes() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            
            //rootelement
            Element rootElement = doc.createElement("notes");
            doc.appendChild(rootElement);
            
            //saving all notes to <notes> </notes>
            for(Note n : notesList) {
                // <note>
                Element noteElement = doc.createElement("note");
                rootElement.appendChild(noteElement);
                
                //isDoneAttr
                Attr noteDone = doc.createAttribute("isDone");
                noteDone.setValue(n.getIsDone().toString());
                noteElement.setAttributeNode(noteDone);
                
                //date
                Element dateElement = doc.createElement("date");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                dateElement.setTextContent(sdf.format(n.getNoteDate()));
                noteElement.appendChild(dateElement);
                
                //title
                Element titleElement = doc.createElement("title");
                titleElement.setTextContent(n.getNoteTitle());
                noteElement.appendChild(titleElement);
                
                //content
                Element contentElement = doc.createElement("content");
                contentElement.setTextContent(n.getNoteContent());
                noteElement.appendChild(contentElement);
            }
            
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult stream = new StreamResult(new File("notes.xml"));
            transformer.transform(source, stream);
            
        } catch(Exception e) {
            System.out.println("Saving error");
        }
    }
    
    private void loadNotes() {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("notes.xml"));
            
            NodeList notesNodes = doc.getElementsByTagName("note");
            
            for(int i = 0; i < notesNodes.getLength(); i++) {
                Element noteElement = (Element) notesNodes.item(i);
                Boolean isDone = Boolean.parseBoolean(noteElement.getAttribute("isDone"));
                
                Element dateElement = (Element) noteElement.getElementsByTagName("date").item(0);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date date = sdf.parse(dateElement.getTextContent());
                
                Element titleElement = (Element) noteElement.getElementsByTagName("title").item(0);
                String title = titleElement.getTextContent();
                
                Element contentElement = (Element) noteElement.getElementsByTagName("content").item(0);
                String content = contentElement.getTextContent();
                
                Note newNote = new Note(title, date, content);
                newNote.setIsDone(isDone);
                notesList.add(newNote);
            }  
        }catch(Exception e) {
            System.out.println("Data loading error.");
        }
    }
    
}
