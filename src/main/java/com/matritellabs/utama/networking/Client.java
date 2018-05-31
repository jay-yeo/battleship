package com.matritellabs.utama.networking;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void start() throws IOException {
        Socket client = new Socket("192.168.0.193", 23456);
        InputStream is = client.getInputStream();
        OutputStream os = client.getOutputStream();

        String chatMessage = "";

        while (!chatMessage.equals("quit")) {
            os.write(chatMessage.getBytes());
            chatMessage = userInput();
        }

        is.close();
        os.close();
    }

    public static String userInput() throws IOException {
        BufferedReader chatReader = new BufferedReader(new InputStreamReader(System.in));
        return chatReader.readLine();

    }

}
