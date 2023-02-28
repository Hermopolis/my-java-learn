package org.com.hermopolis.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient2 {
    public static void main(String[] args) throws IOException {
        String serverHost = "127.0.0.1";
        int serverPort = 996;
        String targetHost = "127.0.0.1";
        int targetPort = 997;

        clientConnect(serverHost, serverPort, targetHost, targetPort);
    }

    private static void clientConnect(String hostName, int portNumber, String targetHost, int targetPort) {
        try (
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out =
                        new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in =
                        new BufferedReader(
                                new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn =
                        new BufferedReader(
                                new InputStreamReader(System.in))
        ) {
            out.println("client-connect:" + targetHost + ":" + targetPort);
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {

                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }
}