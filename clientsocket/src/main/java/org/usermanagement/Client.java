package org.usermanagement;



import java.io.*;
import java.net.Socket;

public class Client {
    private String hostname;
    private int port;

    public Client(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void connectToServer() {
        try (Socket socket = new Socket(hostname, port)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println("Hello from Client!");
            String response = reader.readLine();
            System.out.println("Server says: " + response);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error connecting to server: " + e.getMessage());
        }
    }
}


