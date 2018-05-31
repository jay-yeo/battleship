package com.matritellabs.utama.networking;

import java.io.*;
import java.net.Socket;

// Game Client
public class Client {

    // Start Client
    public static void start(String host, int port) throws IOException {
        Socket client = new Socket(host, port);
        InputStream is = client.getInputStream();
        OutputStream os = client.getOutputStream();

        // Read Thread
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    int read;

                    while ((read = is.read()) != -1) {
                        System.out.print((char) read);
                    }

                } catch (IOException iox) {
                    iox.printStackTrace();
                }

            }
        }).start();

        // Write Thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String chatMessage = "";
                    while (!chatMessage.equals("quit")) {
                        os.write(chatMessage.getBytes());
                        chatMessage = userInput();
                    }
                } catch (IOException iox) {
                    iox.printStackTrace();
                }
            }
        }).start();

        is.close();
        os.close();
    }

    // User input from stdIn
    public static String userInput() {
        try {
            BufferedReader chatReader = new BufferedReader(new InputStreamReader(System.in));
            return chatReader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
