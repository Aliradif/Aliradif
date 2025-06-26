import java.net.*;
import java.io.*;
import java.util.*;



public class ClientSide {

    public static void main(String[] args) {
       
        String serverName = "localhost";
        int port = 6067;

        System.out.println(" Welcome to Inventory Client");
        String itemcode = "";

        Scanner in = new Scanner(System.in);

        try {

            while (true) {
                System.out.println(" Please enter an itemcode or X to exit: ");
                itemcode = in.next();
                System.out.println(" Connecting to " + serverName + "on port " + port);

                Socket client = new Socket (serverName, port);
                OutputStream outToServer= client.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToServer);

                System.out.println(" Sending itemcode = " + itemcode);
                out.writeUTF(itemcode);

                if (itemcode.equals("X")) {
                    System.out.println(" Terminating client and serverside");
                    
                    in.close();
                    out.close();
                    outToServer.close();
                    client.close();
                    break;
                  
                }

                InputStream inFromServer = client.getInputStream();
                DataInputStream inData = new DataInputStream(inFromServer);
                inData.readUTF();

                System.out.println(" The number of items for  " + itemcode + "=" + inData.readUTF());
                client.close();

            }

        } catch (Exception e){}
       
    }
    }