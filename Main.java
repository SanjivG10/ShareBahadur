package com.company;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner user_input = new Scanner(System.in);

        ServerSocket server = new ServerSocket(9990);
        System.out.println(" Waiting for Connection ");
        Socket connection = server.accept();
        System.out.println(" Connection Established ");

        //setting up stream
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeUTF(" Start Chatting ");
        while (true) {
            String  user_msg = user_input.nextLine();
            if(user_msg=="QUIT")
            {
                dataOutputStream.close();
                connection.close();
            }
            else
            {
                dataOutputStream.writeUTF(user_msg);
                System.out.println("");
            }
        }


    }


}

