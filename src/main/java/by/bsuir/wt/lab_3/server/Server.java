package by.bsuir.wt.lab_3.server;


import by.bsuir.wt.lab_3.server.controller.ServerController;

public class Server {
    public static void main(String[] args) {
        ServerController server = new ServerController();
        server.start();
    }
}
