
//Client
package Socket;

import java.net.Socket;

public class client {
    
    
    public void createClient(){
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 15678); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ClientThread(socket).start();
    }
    public static void main(String[] args) {
        client client = new client();
        client.createClient();
    }
}