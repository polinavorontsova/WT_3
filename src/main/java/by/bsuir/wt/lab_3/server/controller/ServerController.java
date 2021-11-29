package by.bsuir.wt.lab_3.server.controller;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Log4j2
public class ServerController extends Thread {
    public static final int PORT = 25565;
    private static final int BACKLOG = 50;

    private ServerSocket serverSocket;

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(PORT, BACKLOG, null);
        } catch (IOException e) {
            log.fatal("Failed initialize server");
        }

        System.out.println("Server is running");

        while (true) {
            Socket clientSocket;
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                ServerClientController client = new ServerClientController(clientSocket, this);
                client.start();
            } catch (IOException e) {
                log.error("Cannot accept new user connection");
            }
        }
    }

    public void disconnect(ServerClientController client) {
        try {
            client.getSocket().close();
        } catch (IOException e) {
            log.error("Error while user disconnecting");
        }
        System.out.println("Client disconnected");
    }
}
