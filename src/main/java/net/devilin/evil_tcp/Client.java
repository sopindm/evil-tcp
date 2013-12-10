package net.devilin.evil_tcp;

import java.io.IOException;
import java.net.UnknownHostException;

public class Client extends Socket
{
    public Client(String host, int port) throws UnknownHostException, IOException
    {
        super(new java.net.Socket(host, port));
    }
}