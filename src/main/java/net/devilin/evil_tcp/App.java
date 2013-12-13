package net.devilin.evil_tcp;

import java.io.EOFException;
import java.io.IOException;

class ConnectionHandler implements Runnable
{
    public ConnectionHandler(Socket s) 
    {
        socket = s;
    }

    private Socket socket;

    @Override
    public void run()
    {
        try {
            try {
                for(;;) {
                    String s = socket.read();
                    socket.write("Answer on " + s);
                }
            }
            catch(EOFException e) {
            }
            finally {
                socket.close();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}

public class App 
{
    public static void main( String[] args )
    {
        try(Server server = new Server(8080)) {
                for(;;) {
                    Socket s = server.accept();
                    
                    new Thread(new ConnectionHandler(s)).start();
                }
            }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
