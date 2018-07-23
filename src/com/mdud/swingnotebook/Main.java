/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdud.swingnotebook;

import com.bulenkov.darcula.DarculaLaf;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicLookAndFeel;

/**
 *
 * @author DuDa
 */
public class Main {
    private static Controller controller;
    
    public static void main(String[] args) {
        try {
            BasicLookAndFeel darcula = new DarculaLaf();
            UIManager.setLookAndFeel(darcula);
        } catch(Exception e) {
            System.out.println("UI Error");
        }
        controller = new Controller();
    }
}
