package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyThread extends Thread {
   
    Socket s;
    String s1 = "";
    MyThread(Socket s) {
        this.s = s;
    }

    public void run() {
       
          
        try {
            BufferedReader  in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            do {      
                s1 = in.readLine();
                System.out.println(s1 + "\n");
            } while (!s1.equals("") );
            
            String finale  = "HTTP/1.1 404 Not Found\r\n"+ "Content-Length:0 \r\n" + "\r\n";
            out.writeBytes(finale);
            s.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
    }
}