import java.net.*;
import java.io.*;
import java.util.*;

public class InvServer extends Thread {

    private ServerSocket serverSocket;
    public InvServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(1000000000);
    }

    public void run() {

        System.out.println("Welcome to InvServer");
        Random rand = new Random(111);

        while (true) {

            try {
                System.out.println("Waiting for connection..." + serverSocket.getLocalPort());
                Socket serv = serverSocket.accept();
                System.out.println("Accepted connection..." + serv.getRemoteSocketAddress());
                DataInputStream dis = new DataInputStream(serv.getInputStream());

                String itemcode = dis.readUTF();
                if (itemcode.equals("X")) {
                    System.out.println("Server is terminating upon request...");
                    System.out.println("Bye now...");
                    serv.close();
                    serverSocket.close();
                    break;

                } else {
                    DataOutputStream out = new DataOutputStream(serv.getOutputStream());
                    out.writeUTF(" Thank you for connecting to " + serv.getLocalAddress());
                    int rNumb = rand.nextInt(51);
                    System.out.println("Server responded to " + rNumb);
                    out.writeUTF("  " +  rNumb + "\n");
                    serv.close();
                }
            } catch (Exception e) {
                break;
            }
        }
    }
    public static void main (String[] args) {

        try {
            InvServer is = new InvServer(6067);
            Thread t = new Thread(is);
            t.start();
        }
        catch (Exception e) {
        }
    }

}