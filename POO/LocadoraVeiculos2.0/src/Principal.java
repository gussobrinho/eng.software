import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Principal {

    ArrayList<Pessoa> pessoaList = new ArrayList<>();

    public static void main(String args[]){
        System.out.println("#!!# Garagem Tabajara #!!#");

        Principal principal = new Principal();
        principal.menuPrincipal();
    }

    public void menuPrincipal(){

        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Funcionario");
        System.out.println("2 - Cliente");
        System.out.println("3 - Automovel");
        System.out.println("4 - Vendas");
        System.out.println("0 - Sair");
        System.out.println("Digite sua opção: ");
        int op = sc.nextInt();

        switch (op){
            case 1:
                menuFuncionario();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opcao invalida, tente novamente!");
                menuPrincipal();
                break;
        }
    }

    public void menuFuncionario(){

        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Buscar");
        System.out.println("4 - Alterar");
        System.out.println("5 - Excluir");
        System.out.println("0 - Voltar");
        System.out.println("Digite sua opção: ");
        int op = sc.nextInt();

        switch (op){
            case 1:
                cadastroFuncionario();
                break;
            case 2:
                listarFuncionario();
                break;
            case 0:
                menuPrincipal();
                break;
            default:
                System.out.println("Opcao invalida, tente novamente!");
                menuFuncionario();
                break;
        }

        menuFuncionario();
    }

    public void cadastroFuncionario(){

        Scanner sc = new Scanner(System.in);
        int tipoFunc = 0;

        Pessoa pessoa = new Pessoa();
        Funcionario funcionario = new Funcionario();
        Funcionario badeco = new Badeco();
        Funcionario gerente = new Gerente();

        System.out.println("> Informe o nome: ");
        String nome = sc.nextLine();
        pessoa.pessoaNome(nome);

        System.out.println("> Informe o CPF: ");
        String cpf = sc.nextLine();
        pessoa.pessoaCpf(cpf);

        System.out.println("> Informe o endereco: ");
        String endereco = sc.nextLine();
        pessoa.pessoaEndereco(endereco);

        System.out.println("> Informe o telefone");
        String telefone = sc.nextLine();
        pessoa.pessoaTelefone(telefone);

        try {
            System.out.println("> Informe a data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            pessoa.pessoaNascimento(dt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Qual o tipo de Funcionario ? [0- Gerente, 1- Badeco, 2-Funcionario Comum");
        sc.nextLine();

        if(tipoFunc == 0){

        }

        pessoaList.add(pessoa);
    }

    public void listarFuncionario(){

        System.out.println("\n#-----------------------------------------------#");
        for(Pessoa p: pessoaList){
            System.out.println("| Nome: " + p.pessoaGetNome());
            System.out.println("| CPF: " + p.pessoaGetCpf());
            System.out.println("| Endereco: " + p.pessoaGetEndereco());
            System.out.println("| Telefone: " + p.pessoaGetTelefone());
            System.out.println("| Data de Nascimento: " + p.pessoaGetNascimento());
        }
        System.out.println("#-----------------------------------------------#\n");
    }
}
