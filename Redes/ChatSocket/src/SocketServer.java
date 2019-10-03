import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static int port = 1006;

    public static void main(String[] args) {

        /*
        Instancia o ServerSocket na variavel servidor e inicializa ela como vazia (null)
         */
        ServerSocket servidor = null;

        try {
            System.out.println("Iniciando o Servidor ...");
            /*
            Atribui a porta passada na variavel estatatica, nesse caso, a porta 1006
             */
            servidor = new ServerSocket(port);
            System.out.println("Servidor iniciado.");

            /*
            Enquanto os cliente tentarem se conectar, o servidor aceita as conexoes, sem limite
             */
            while (true){
                Socket cliente = servidor.accept();
                new ClientManager(cliente);
            }
        } catch (IOException e) /*Caso a porta nao esteja disponivel ele apresenta esse erro*/{
            /*
            - Caso ele nao consiga iniciar o servidor, o servidor estara nulo.

            - Tambem e um modo de garantir que o servidor sera fechado. Nao ficara gastando recurso em segundo plano por exeplo
             */
            try {
                if(servidor != null)
                    servidor.close();
            } catch (IOException ex) {}
            System.err.println("\nA porta " + port + " ja esta ocupada ou o servidor nao foi fechado!\n\n");
            e.printStackTrace();
        }
    }
}
