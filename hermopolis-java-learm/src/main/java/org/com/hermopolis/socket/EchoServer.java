package org.com.hermopolis.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class EchoServer {

    public static ExecutorService executorService = Executors.newFixedThreadPool(6);

    ArrayBlockingQueue<Msg> blockingDeque = new ArrayBlockingQueue<>(10000);

    public static void main(String[] args) throws IOException {
        int portNumber = 996;
        server(portNumber);
    }

    private static void server(int portNumber) {
        System.out.println("server start ... ");
        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        ) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("收到一条 :" + inputLine);
                if (inputLine.startsWith("client-connect")) {
                    String connect[] = inputLine.split(":");
                    //获得一个请求要开一个新的监听端口
                   // executorService.execute(() -> server(Integer.parseInt(connect[2])));

                }
                out.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

    private static void serverSub(int portNumber) {
        System.out.println("server start ... ");
        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        ) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("收到一条 :" + inputLine);
                if (inputLine.startsWith("client-connect")) {
                    String connect[] = inputLine.split(":");
                    //获得一个请求要开一个新的监听端口
                    executorService.execute(() -> server(Integer.parseInt(connect[2])));

                }
                out.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
