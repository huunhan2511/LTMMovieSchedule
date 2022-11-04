/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;



import Models.Citi;
import Models.Film;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
/**
 *
 * @author admin 
 */
public class changeScreenController {
    
    private JPanel pnlRoot;
    private String selectedScreen = "";
    public changeScreenController(JPanel pnlRoot) {
        this.pnlRoot = pnlRoot;
    }
    
    public void setScreenMovieSchedule() throws IOException{
        
        this.selectedScreen = selectedScreen;
        pnlRoot.removeAll();
        pnlRoot.setLayout(new BorderLayout());
        pnlRoot.add(new GUI.MovieScheduleJPanel()); 
        pnlRoot.revalidate();
        pnlRoot.repaint();
       
        
    } 
    public void setLoading(){
        this.selectedScreen = selectedScreen;
        pnlRoot.removeAll();
        pnlRoot.setLayout(new BorderLayout());
        pnlRoot.add(new GUI.LoadingJPanel());
        pnlRoot.revalidate();
        pnlRoot.repaint();
    }
    public void setScreenDetailFilm(Film detailFilm) throws IOException, InterruptedException{
        
        this.selectedScreen = selectedScreen;
        pnlRoot.removeAll();
        pnlRoot.setLayout(new BorderLayout());
        pnlRoot.add(new GUI.DetailFilmJPanel(detailFilm));
            
        pnlRoot.revalidate();
        pnlRoot.repaint();
        
    } 
}

