/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdud.swingnotebook.views;


import com.mdud.swingnotebook.Controller;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author DuDa
 */
public class MainPanel extends javax.swing.JPanel {

    /**
     * Creates new form MainPanel
     */
    private Controller controller;
    
    public MainPanel(Controller controller) {
        initComponents();
        itemList.setCellRenderer(new DoneListRenderer());
        this.controller = controller;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        logoLable = new javax.swing.JLabel();
        scrollPaneList = new javax.swing.JScrollPane();
        itemList = new javax.swing.JList<>();
        addButton = new javax.swing.JButton();
        minusButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();
        rightPanel = new javax.swing.JPanel();
        titleTextField = new javax.swing.JTextField();
        scrollPaneNote = new javax.swing.JScrollPane();
        noteTextArea = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();
        dateField = new javax.swing.JTextField();

        logoLable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mdud/res/icon.png"))); // NOI18N

        itemList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                itemListValueChanged(evt);
            }
        });
        scrollPaneList.setViewportView(itemList);

        addButton.setText("+");
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addButtonMousePressed(evt);
            }
        });

        minusButton.setText("-");
        minusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minusButtonMousePressed(evt);
            }
        });

        doneButton.setText("✓");
        doneButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                doneButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(logoLable))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(leftPanelLayout.createSequentialGroup()
                                .addComponent(doneButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minusButton))
                            .addComponent(scrollPaneList, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(minusButton)
                    .addComponent(doneButton))
                .addGap(15, 15, 15))
        );

        titleTextField.setText("Add note");

        noteTextArea.setColumns(20);
        noteTextArea.setLineWrap(true);
        noteTextArea.setRows(5);
        scrollPaneNote.setViewportView(noteTextArea);

        saveButton.setText("Save All");
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveButtonMousePressed(evt);
            }
        });

        dateField.setEnabled(false);

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(titleTextField)
                        .addGap(91, 91, 91))
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPaneNote, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(saveButton)))
                        .addContainerGap())))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPaneNote, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMousePressed
        // TODO add your handling code here:
        controller.addNote();
    }//GEN-LAST:event_addButtonMousePressed

    private void saveButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMousePressed
        // TODO add your handling code here:
        controller.saveNotesToFile();
    }//GEN-LAST:event_saveButtonMousePressed

    private void doneButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneButtonMousePressed
        // TODO add your handling code here:
        controller.toggleDone();
    }//GEN-LAST:event_doneButtonMousePressed

    private void minusButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minusButtonMousePressed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog(this, "Would you like to remove active note?",
                "Delete note", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION)
            controller.removeNote();
    }//GEN-LAST:event_minusButtonMousePressed

    private void itemListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_itemListValueChanged
        // TODO add your handling code here:
        int itemIndex = itemList.getSelectedIndex();
        
        if(itemIndex != -1 && !evt.getValueIsAdjusting())
            controller.setActiveNote(itemIndex);
    }//GEN-LAST:event_itemListValueChanged

    //Custom cell renderer to mark done notes
    private class DoneListRenderer extends DefaultListCellRenderer{

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
            if(controller.getDoneIndices().contains(index))
                setForeground(new Color(80, 150, 80));
            if(controller.getEditedElements().contains(index))
                setText(getText()+"*");
            
            return this;
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField dateField;
    private javax.swing.JButton doneButton;
    private javax.swing.JList<String> itemList;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel logoLable;
    private javax.swing.JButton minusButton;
    private javax.swing.JTextArea noteTextArea;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JButton saveButton;
    private javax.swing.JScrollPane scrollPaneList;
    private javax.swing.JScrollPane scrollPaneNote;
    private javax.swing.JTextField titleTextField;
    // End of variables declaration//GEN-END:variables

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getDateField() {
        return dateField;
    }

    public JButton getDoneButton() {
        return doneButton;
    }

    public JList<String> getItemList() {
        return itemList;
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public JLabel getLogoLable() {
        return logoLable;
    }

    public JButton getMinusButton() {
        return minusButton;
    }

    public JTextArea getNoteTextArea() {
        return noteTextArea;
    }

    public JPanel getRightPanel() {
        return rightPanel;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JScrollPane getScrollPaneList() {
        return scrollPaneList;
    }

    public JScrollPane getScrollPaneNote() {
        return scrollPaneNote;
    }

    public JTextField getTitleTextField() {
        return titleTextField;
    }

    
    
}
