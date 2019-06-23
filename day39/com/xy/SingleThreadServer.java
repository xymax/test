package com.xy.serive;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadServer {
    public static void main(String[] args) {
        //1.
        int port = 2568;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务器运行在" + serverSocket.getLocalSocketAddress());
            System.out.println("等待客户端连接ing…");
            Socket socket = serverSocket.accept();
            //接收客户端的数据
            InputStream in = socket.getInputStream();
            Scanner scanner = new Scanner(in);
            System.out.println("客户端说：" + scanner.nextLine());
            //发送数据给客户端
            OutputStream out = socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println("欢迎，欢迎");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
