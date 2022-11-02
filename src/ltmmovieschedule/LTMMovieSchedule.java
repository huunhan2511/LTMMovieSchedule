/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltmmovieschedule;

import Socket.client;
import java.io.IOException;

/**
 *
 * @author huunh
 */
public class LTMMovieSchedule {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        client client = new client();
        client.createClient();
        new ltmmovieschedule.MovieSchedule().setVisible(true);
    }
    
}
