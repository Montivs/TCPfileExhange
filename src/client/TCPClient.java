package client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {


    private final String hostname;
    private final int port;

    public TCPClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public static void main(String[]args) throws IOException {

        if(args.length != 3){
            System.out.println("missing parameters: hostname, portnumber");
            return;
        }

        String hostname = args[0];
        int portnumber = Integer.parseInt(args[1]);
        String filename = args[2];

        TCPClient tcpClient = new TCPClient(hostname,portnumber);
        tcpClient.copyFile(filename);

    }

    private void copyFile(String filename) throws IOException {
        Socket socket = new Socket(this.hostname, this.port);

        FileInputStream fis = new FileInputStream(filename);
        OutputStream os = socket.getOutputStream();

        int read = 0;
        do{
            read = fis.read();
            if(read != -1){
                os.write(read);
            }
        }while(read!=-1);
        os.close();

    }
}
