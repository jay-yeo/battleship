package com.matritellabs.utama.networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// Game Server
public class Server {

    // Start Server
    public static void start(int port) throws IOException {
        try {
            ServerSocket ss = new ServerSocket(port);
            Socket socketToClient = ss.accept();

            InputStream is = socketToClient.getInputStream();
            OutputStream os = socketToClient.getOutputStream();
            System.out.println("Connection accepted from "+ socketToClient.getInetAddress());

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

//            is.close();
//            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // User input from stdIn
    public static String userInput() throws IOException {
        BufferedReader chatReader = new BufferedReader(new InputStreamReader(System.in));
        return chatReader.readLine();

    }
}
