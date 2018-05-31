package com.matritellabs.utama.networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static void main(String[] args) {

    }





    public static void startHosting() {
        try {
            int port = 23456;

            ServerSocket ss = new ServerSocket(port);
            Socket socketToClient = ss.accept();

            InputStream is = socketToClient.getInputStream();
            System.out.println("Connection accepted from "+ socketToClient.getInetAddress());
            int read;
            while ((read = is.read()) != -1) {
                System.out.print((char) read);
            }
            is.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
