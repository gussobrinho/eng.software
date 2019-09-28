import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientManager extends Thread {

    private Socket cliente;
    private String nomeCliente;

    private static final Map<String, ClientManager> clientList = new HashMap<>();
    private BufferedReader leitor;
    private PrintWriter escritor;

    public ClientManager(Socket cliente){
        this.cliente = cliente;
        start();
    }

    /*
    * Conversa entre os clientes
    * */
    @Override
    public void run() {
        try {
            leitor =  new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            escritor = new PrintWriter(cliente.getOutputStream(), true);

            escritor.println("Informe seu nome:");
            String msg = leitor.readLine();
            this.nomeCliente = msg.toLowerCase().replaceAll(",", "");

            escritor.println("Ola " + this.nomeCliente + "!");
            clientList.put(this.nomeCliente, this);

            // Recebe todas as mensagens enviadas pelo cliente
            while(true){
                msg = leitor.readLine();
                if(msg.equalsIgnoreCase("::sair")){
                    clientList.remove(this.nomeCliente, this);
                    this.cliente.close();
                }else if(msg.toLowerCase().startsWith("::msg")){
                    String nomeDestinatario = msg.substring(5, msg.length());
                    System.out.println("Enviando para: " + nomeDestinatario);
                    ClientManager destinatario = clientList.get(nomeDestinatario);
                    if(destinatario == null){
                        escritor.println("O cliente informado nao existe ou nao esta conectado!");
                    }else{
                        escritor.println("Digite uma mensagem para: " + destinatario.getNomeCliente());
                        destinatario.getEscritor().println(this.nomeCliente + " disse: " + leitor.readLine());
                    }
                }else if(msg.equalsIgnoreCase("::list")){
                    StringBuffer stringBuffer = new StringBuffer();
                    for(String cm: clientList.keySet()){
                        stringBuffer.append(cm);
                        stringBuffer.append(",");
                    }
                    stringBuffer.delete(stringBuffer.length()-1, stringBuffer.length());
                    escritor.println(stringBuffer.toString());
                } else {
                    escritor.println(this.nomeCliente + " voce disse: " + msg);
                }
            }

        } catch (IOException e) {
            System.err.println("\nO cliente " + this.nomeCliente + " fechou a conexao.\n\n");
            e.printStackTrace();
        }
    }

    public PrintWriter getEscritor() {
        return escritor;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
}
