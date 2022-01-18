package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        if (str.contains("msg=Hello")) {
                            out.write("Hello".getBytes(StandardCharsets.UTF_8));
                        } else if (str.contains("msg=Exit")) {
                            server.close();
                        } else {
                            if (str.contains("msg=")) {
                                out.write("What".getBytes(StandardCharsets.UTF_8));
                            }
                        }
                    }
                    out.flush();
                }
            }
        }
    }
}
