package com.quansou.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class NetTest {
    public static void main(String[] args){
        try(ServerSocket ss = new ServerSocket(8189)){
            while (true){
                Socket s = ss.accept();
                System.out.println("有一个连接进入！");
                InputStream is = s.getInputStream();
                OutputStream os = s.getOutputStream();
                Scanner scanner = new Scanner(is);
                PrintWriter pw = new PrintWriter(os,true);
                pw.println("Hi,Welcome to Socket world!");
                s.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
