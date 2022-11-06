package ru.ifmo.clientapp;
// ex3[jdk-versions]
public class ClientApp {
    public static void main(String[] args) {

        new Client("localhost", 8999).start();
    }
}