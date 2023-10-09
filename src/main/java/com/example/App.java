package com.example;

import java.net.Socket;
import java.io.*;
import java.net.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            // leggo dalla tastiera
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String riga = in.readLine();

            // avvio la communicazione con socket
            Socket socket = new Socket("10.22.9.13", 3000);

            // invio la stinga messa dal utente
            DataOutputStream outVersoServer = new DataOutputStream(socket.getOutputStream());
            outVersoServer.writeBytes(riga+"\n");

            // metto in ascolto per leggere la riga dal server
            BufferedReader inDalServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String rigaRitornata = inDalServer.readLine();

            System.out.println("stringa ritornata : " + rigaRitornata);
            
        } catch (Exception e) {
            System.out.println("Errore");
        }
    }
}
