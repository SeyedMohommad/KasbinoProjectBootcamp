package org.usermanagement.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8081;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}


class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
        ) {
            createDirectory("newDirectory");

            String text;
            do {
                text = reader.readLine();
                System.out.println("Message from client: " + text);

                writer.println("Echo: " + text);

            } while (!text.equals("bye"));

            socket.close();
            System.out.println("Connection with client closed");

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void createDirectory(String dirName) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("mkdir", dirName);

        try {
            Process process = processBuilder.start();
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Directory created successfully");
            } else {
                System.out.println("Could not create directory");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}


