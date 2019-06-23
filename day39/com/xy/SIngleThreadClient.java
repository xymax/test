package com.xy.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SIngleThreadClient {
    public static void main(String[] args) {
        String ip="127.0.0.1";
        int port=2568;
        try {
            Socket socket=new Socket(ip,port);

            //发送数据（将数据发送给服务端）
            OutputStream out =socket.getOutputStream();
            PrintStream printStream=new PrintStream(out);
            printStream.println("服务器，我来了");
            printStream.flush();
            //接收数据（接收服务端的数据）
            InputStream in=socket.getInputStream();
            Scanner scanner=new Scanner(in);
            System.out.println("来自服务端的数据"+scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
