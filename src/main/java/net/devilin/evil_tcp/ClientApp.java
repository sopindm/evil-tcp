package net.devilin.evil_tcp;
import static java.lang.System.out;

public class ClientApp
{
    public static void main(String[] args)
    {
        try(Client client = new Client("127.0.0.1", 8080)) {
                for(int i=0;i<10;i++) {
                    client.write("Hello from client.");
                    out.println(client.read());
                }
            }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}