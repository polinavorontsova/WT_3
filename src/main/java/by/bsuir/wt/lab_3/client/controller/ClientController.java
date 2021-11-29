package by.bsuir.wt.lab_3.client.controller;

import by.bsuir.wt.lab_3.server.controller.ServerController;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

@Log4j2
public class ClientController extends Thread{
    private PrintWriter writer;
    private boolean running = true;

    @Override
    public void run() {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), ServerController.PORT);
            ClientMessageController input = new ClientMessageController(this);
            input.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            String request;

            while ((request = reader.readLine()) != null) {
                System.out.println(request);
            }

        } catch (IOException e) {
            log.error("Failed connect to server. Exception message: {}", e.getMessage());
        }

        running = false;
    }

    public void sendMessage(String message) {
        writer.println(message);
        writer.flush();
    }

    public boolean isRunning() {
        return running;
    }
}
