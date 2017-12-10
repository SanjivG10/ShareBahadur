package com.company;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSide  {

    public static void main (String [] args) throws IOException {
        Socket clientSocket = new Socket("localhost",9990);

        DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
        while (true)
        {
            String messageFromServer = dataInputStream.readUTF();
            System.out.println(messageFromServer);
            if (messageFromServer=="QUIT")
            {
                dataInputStream.close();
                clientSocket.close();
            }
        }


    }

}
