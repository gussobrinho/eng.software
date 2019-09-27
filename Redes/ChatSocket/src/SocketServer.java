import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static int port = 1006;

    public static void main(String[] args) {
        
        ServerSocket servidor = null;

        try {
            System.out.println("Iniciando o Servidor ...");
            servidor = new ServerSocket(port);
            System.out.println("Servidor iniciado.");

            while (true){
                Socket cliente = servidor.accept();
                new ClientManager(cliente);
            }
        } catch (IOException e) {
            try {
                if(servidor != null)
                    servidor.close();
            } catch (IOException ex) {}
            System.err.println("\nA porta " + port + " ja esta ocupada ou o servidor foi fechado!\n\n");
            e.printStackTrace();
        }
    }
}
