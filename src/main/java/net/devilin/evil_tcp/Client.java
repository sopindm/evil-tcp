package net.devilin.evil_tcp;

public class Client
{
    public Client(String host, int port) 
    {
        this.host = host;
        this.port = port;
    }

    @Override
    protected void finalize()
    {
    }

    public String read()
    {
        return "";
    }

    public String write()
    {
        return "";
    }

    private String host;
    private int port;
}