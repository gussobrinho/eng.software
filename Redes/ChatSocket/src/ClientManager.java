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

    /*
    Lista pra armazenar os clientes
     */
    private static final Map<String, ClientManager> clientList = new HashMap<>();

    /*
    Le o texto de uma cadeia de caracteres, aplicando o buffer nos caracteres para tornar mais eficiente
    ler os caracteres, array de caracteres e linhas.
     */
    private BufferedReader leitor;

    /*
    Apresenta a representacao dos objetos formatados para texto de apresentacao
     */
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
            /*
            Passando o nome pra minusculo
             */
            this.nomeCliente = msg.toLowerCase().replaceAll(",", "");

            escritor.println("Ola " + this.nomeCliente + "!");
            /*
            Passando os clientes para a lista
             */
            clientList.put(this.nomeCliente, this);

            /*
            Recebe todas as mensagens enviadas pelo cliente
             */
            while(true){
                msg = leitor.readLine();

                if(msg.equalsIgnoreCase("::sair")){
                    /*
                    Tira o cliente da lista e finaliza a conexao
                     */
                    clientList.remove(this.nomeCliente, this);
                    this.cliente.close();
                }else if(msg.toLowerCase().startsWith("::msg")){
                    /*
                     Ignora as 5 primeiras posicoes do que foi escrito (::msg) para pegar o nome do destinatario
                     */
                    String nomeDestinatario = msg.substring(5, msg.length());
                    System.out.println("Enviando para: " + nomeDestinatario);
                    /*
                    Busca o nome do destinatario na lista de clientes
                     */
                    ClientManager destinatario = clientList.get(nomeDestinatario);
                    if(destinatario == null){
                        escritor.println("O cliente informado nao existe ou nao esta conectado!");
                    }else{
                        escritor.println("Digite uma mensagem para: " + destinatario.getNomeCliente());
                        /*
                        Apresenta essa mensagem pro destinatario
                         */
                        destinatario.getEscritor().println(this.nomeCliente + " disse: " + leitor.readLine());
                    }
                }else if(msg.equalsIgnoreCase("::list")){
                    StringBuffer stringBuffer = new StringBuffer();
                    /*
                    Apresenta todos os nomes da lista com "," depois de cada valor
                     */
                    for(String cm: clientList.keySet()){
                        stringBuffer.append(cm);
                        stringBuffer.append(",");
                    }
                    /*
                    Tira a ultima virgula da lista, se n tivesse ia apresentar, por exemplo, a seguinte lista -> jorge, joao,
                    com tratamento -> jorge, joao
                     */
                    stringBuffer.delete(stringBuffer.length()-1, stringBuffer.length());
                    escritor.println(stringBuffer.toString());
                }else if(msg.startsWith("::")){
                    getEscritor().println("Comando nao encontrado! Tente novamente.");
                } else {
                    escritor.println(this.nomeCliente + " voce disse: " + msg + " para o servidor.");
                }
            }

        } catch (IOException e) {
            clientList.remove(this.nomeCliente, this);
            System.err.println("\nO cliente " + this.nomeCliente + " fechou a conexao.\n\n");
            e.printStackTrace();
        }
    }

    /*
    Retorna o valor de escritor pois o atrubuto esta privado
     */
    public PrintWriter getEscritor() {
        return escritor;
    }

    /*
    Retorna o valor de escritor pois o atrubuto esta privado
     */
    public String getNomeCliente() {
        return nomeCliente;
    }
}
