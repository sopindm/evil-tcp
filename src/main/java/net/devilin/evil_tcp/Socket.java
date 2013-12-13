package net.devilin.evil_tcp;

import java.lang.*;
import java.io.InputStreamReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.IOException;

class Socket implements AutoCloseable
{
    protected Socket(java.net.Socket socket) throws IOException
    {
        this.socket = socket;

        socket.setTcpNoDelay(true);

        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        this.input = new DataInputStream(input);
        this.output = new DataOutputStream(output);

        reader = new InputStreamReader(input);
    }

    @Override
    public void close() throws IOException
    {
        if(socket != null)
            socket.close();
    }

    private java.net.Socket socket;

    private DataInputStream input;
    private DataOutputStream output;

    private InputStreamReader reader;

    public String read() throws IOException
    {
        int size = input.readInt();
        char[] chars = new char[size];

        int read = reader.read(chars);

        return new String(chars);
    }

    public void write(String data) throws IOException
    {
        output.writeInt(data.length());
        output.write(data.getBytes());
    }
}
