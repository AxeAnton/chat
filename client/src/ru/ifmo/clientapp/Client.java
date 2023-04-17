package ru.ifmo.clientapp; // тест2

import ru.ifmo.lib.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    // Тест 1
    private int port;
    private String ip;
    private Scanner scanner;

    public Client(String ip, int port) {
        this.port = port;
        this.ip = ip;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Введите имя");
        String userName = scanner.nextLine();
        System.out.println("Введите сообщение");
        try {
            Socket socket = new Socket(ip, port);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            Reader reader = new Reader(new ObjectInputStream(socket.getInputStream()));
            reader.start();
            String text;

            while (socket.isConnected()) {

                text = scanner.nextLine();

                if ("exit".equals(text)) break;
                output.writeObject(new Message(userName, text));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
