package com.bittech.chatroom.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: secondriver
 * Created: 2019/6/23
 */
public class MultiThreadServer {
    
    
    public static void main(String[] args) {
        int defaultPort = 4406;
        int port = defaultPort;
        for (String arg : args) {
            if (arg.startsWith("--port=")) {
                String portStr = arg.substring("--port=".length());
                try {
                    port = Integer.parseInt(portStr);
                } catch (NumberFormatException e) {
                    port = defaultPort;
                }
            }
            
        }
        
        final ExecutorService executorService = Executors.newFixedThreadPool(2 * Runtime.getRuntime().availableProcessors());
        
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            
            System.out.println("服务端启动，运行在：" + serverSocket.getLocalSocketAddress());
            
            while (true) {
                
                final Socket socket = serverSocket.accept();
                System.out.println("客户端连接，来自：" + socket.getRemoteSocketAddress());
                
                executorService.execute(new ClientHandler(socket));
                
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        
    }
}
