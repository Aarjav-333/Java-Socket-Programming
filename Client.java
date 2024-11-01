import java.net.*;
import java.io.*;

public class Client {
    private Socket socket;
    private BufferedReader input;
    private DataOutputStream output;

    public Client(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
            input = new BufferedReader(new InputStreamReader(System.in));
            output = new DataOutputStream(socket.getOutputStream());
            String line = "";
            while (!line.equalsIgnoreCase("Over")) {
                line = input.readLine();
                output.writeUTF(line);
            }
            input.close();
            output.close();
            socket.close();
        } catch (Exception u) {
            System.out.println(u);
        
    }
    }
    public static void main(String args[]) {
        Client client = new Client("127.0.0.1", 5000);
    }
}
