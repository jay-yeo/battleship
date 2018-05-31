package com.matritellabs.utama.networking;

import java.io.IOException;

public class Chat {
    public static void main(String[] args) {

        // Server
        try {
            Server.start(12345);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Client
//        try {
//            Client.start("127.0.0.1", 12345);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
