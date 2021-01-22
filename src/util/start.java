package util;

import client.TCPClient;
import server.TCPServer;

import java.io.IOException;

public class start {

    public static void main(String[]args) throws IOException, InterruptedException {
        if(args.length>=2){
            TCPClient.main(args);
            return;
        }
        if(args.length==1){
            TCPServer.main(args);
            return;
        }else{
            System.out.println("wrong parameters!");
            System.out.println("Server args[0] = filetext random name : test.txt");
            System.out.println("Client args[0] = hostname, args[1] = port, args[2] = filename");
        }

        /**
         * in /out Ordner eine text Datei anlegen, die später bie Client args[2] eingegeben wird.
         * CMD: java -jar copy.txt // server
         * CMD: java -jar localhost 4444 test.txt // client
         */


    }
}
