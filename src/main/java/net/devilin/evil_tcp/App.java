package net.devilin.evil_tcp;

import java.io.IOException;

class ConnectionHandler 
{
    public ConnectionHandler(Socket s) 
    {
        socket = s;
    }

    private Socket socket;

    public void run() throws IOException
    {
        while(!socket.isClosed()) {
            String s = socket.read();
            socket.write("Answer on " + s);
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

                    new ConnectionHandler(s).run();
                }
            }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
