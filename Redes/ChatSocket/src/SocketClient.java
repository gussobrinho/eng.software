import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient extends Thread{

    private static String ip_address = "127.0.0.1";
    static SocketServer ss = new SocketServer();

    public static void main(String[] args) {
        try {
            /*
            Final serve pra definir os valores como constante ("versao final")
             */
            final Socket cliente = new Socket(ip_address, ss.port);

            /*
            Thread necessaria pra escerver e receber as mensagens ao mesmo tempo
             */
            new Thread(){
                /*
                 * Lendo/Mostrando o que o servidor esta mandando
                 **/
                @Override
                public void run() {
                    try {
                        BufferedReader leitor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

                        System.out.println("\tComandos Base\n#-------------------#\n::sair -> Sai do Chat\n::msgNomeCliente -> Manda uma Mensagem Direta\n::list -> lista todos os clientes\n#-------------------#");
                        while(true){
                            String mensagem = leitor.readLine();
                            if(mensagem == null || mensagem.isEmpty()){
                                continue;
                            }
                            System.out.print("[S]: " + mensagem + "\n> ");
                        }
                    } catch (IOException e) {
                        System.out.println("Nao foi possivel ler a mensagem do servidor");
                        e.printStackTrace();
                    }
                }
            }.start();

            /*
             * Escrevendo para o servidor
             **/
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);
            BufferedReader leitorTerminal = new BufferedReader(new InputStreamReader(System.in));

            /*
            * Mandando mensagem pro servidor
            **/
            while(true){
                System.out.print("> ");
                String msgTerminal = leitorTerminal.readLine();
                if(msgTerminal == null || msgTerminal.length() == 0 ){
                    continue;
                }
                escritor.println(msgTerminal);
                if(msgTerminal.equalsIgnoreCase("::SAIR")){
                    System.exit(0);
                }
            }
        } catch (UnknownHostException e){
            System.err.println("Endereco informado invalido!\n");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Servidor indisponivel! Tente novamente mais tarde.\n");
            e.printStackTrace();
        }
    }
}
