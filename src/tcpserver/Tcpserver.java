/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author GOKUL
 */
public class Tcpserver {

 
 public static PrintWriter out;

public static void main(String[] args) throws IOException {
    int port = 8899;

    ServerSocket serverSocket = null;
    
    try
    {
        
        serverSocket = new ServerSocket(port);
        
        System.out.println("Server started on port: " + port);

    } 
    
    catch (IOException e) 
    {
        System.err.println("IOException: " + e);

        return;
    }

   while ( true )
   {
      Socket clientSocket = null;

     try
      {
         System.out.println("Waiting for a client");
         clientSocket = serverSocket.accept();
         System.out.println("Client Connected on port: " + port);
      }
    catch (IOException e) 
    {
        System.err.println("IOException at accept(): " + e);

        break;
    }

    Scanner in1 = new Scanner(clientSocket.getInputStream());
    String message;

    while (true) 
        {
        if(in1.hasNext())
            {
            System.out.println("going to read line");
            message = in1.nextLine();
            if(message.equals("xwww"))
            {
                
               try {
                 PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println("ERROR");
                    System.out.println("response sent");
                  }
            
                  catch (IOException e)
                   {
                    System.out.println(e);
                   }
            }
            System.out.println("Client message : "+message);

            break;
            }            

        //System.out.println("no message");
        }

    }

   serverSocket.close();
}
}
    

