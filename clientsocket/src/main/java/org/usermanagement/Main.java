package org.usermanagement;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("localhost", 8081);
        client.connectToServer();
    }
}