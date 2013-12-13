package net.devilin.evil_tcp;

import java.io.IOException;
import java.net.ServerSocket;

class Server implements AutoCloseable
{
    public Server(int port) throws IOException
    {
        socket = new ServerSocket(port);
    }

    private ServerSocket socket;

    public Socket accept() throws IOException
    {
        return new Socket(socket.accept());
    }

    @Override
    public void close() throws IOException
    {
        socket.close();
    }
}