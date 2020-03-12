package com.baeldung.restassured;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.Random;
import java.util.Scanner;

final class Util {

    private static final int DEFAULT_PORT = 8069;

    private Util() {
    }

    static String inputStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    static int getAvailablePort() {
//        try (ServerSocket socket = new ServerSocket(0)) {
//            return socket.getLocalPort();
//        } catch (IOException e) {
//            return DEFAULT_PORT;
//        }

        int port = new Random()
                .ints(6000, 9000)
                .filter(Util::isFree)
                .findFirst()
                .orElse(DEFAULT_PORT);
        System.out.println("Port ##################: " + port);
        return port;
    }

    private static boolean isFree(int port) {
        try {
            new ServerSocket(port).close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
