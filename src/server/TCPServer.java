package server;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private final int port;
    public final static int PORTNUMBER = 4444;

    public TCPServer(int port) {
        this.port = port;
    }

    public static void main(String[]args) throws IOException, InterruptedException {
        TCPServer tcpServer = new TCPServer(PORTNUMBER);

        tcpServer.readFile(args[0]);


    }

    private void readFile(String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        Socket socket = this.acceptSocket();
        InputStream is = socket.getInputStream();

        int read = 0;
        do{
            read = is.read();
            if(read != -1){
                fos.write(read);
            }
        }while (read!= -1);

    }

    private Socket acceptSocket() throws IOException {
        ServerSocket srvSocket = new ServerSocket(this.port);
        System.out.println("server socket created");
        return srvSocket.accept();
    }
}
