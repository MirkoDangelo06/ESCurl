package com.example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        ServerSocket ss = new ServerSocket(8080);
        

        while(true){
            Socket s = ss.accept();
            MyThread t = new MyThread(s);
            t.start();
        }
    
    }

   


}