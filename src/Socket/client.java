
//Client
package Socket;

import java.net.Socket;

import javax.swing.JOptionPane;

public class client {
    
    
    public void createClient(String ipAddress){
        Socket socket = null;
        try {
            socket = new Socket(ipAddress, 15678); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ClientThread(socket).start();
    }
    public static void main(String[] args) {
        String ipAddress = JOptionPane.showInputDialog("Nhập địa chỉ ip server");
        client client = new client();
        client.createClient(ipAddress);
    }
}