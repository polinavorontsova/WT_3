package by.bsuir.wt.lab_3.client.controller;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Log4j2
public class ClientMessageController extends Thread {
    private final ClientController client;

    public ClientMessageController(ClientController client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (client.isRunning()) {
                String response = reader.readLine();
                client.sendMessage(response);
            }
        } catch (IOException e) {
            log.error("Failed send message on server. Exception message: {}", e.getMessage());
        }
    }
}
