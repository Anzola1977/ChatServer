import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    ArrayList<Client> clients = new ArrayList<>();
    ServerSocket serverSocket;

    public ChatServer() throws Exception {
        this.serverSocket = new ServerSocket(1234);
    }

    public void run() {
        while(true) {
            System.out.println("Waiting...");
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");
                new Thread(new Client(socket)).start();
                clients.add(new Client(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws Exception {

        new ChatServer().run();

    }
}
