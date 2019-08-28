import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Principal {

    List<Funcionario> listaFuncionarios = new ArrayList<>();

    public static void main(String args[])
    {
        System.out.println("\t***Garagem***");

        Principal principal = new Principal();
        principal.menuPrincipal();
    }

    public void menuPrincipal()
    {

        System.out.println("\t***Menu Principal***");
        System.out.println("01 - Funcionário");
        System.out.println("02 - Cliente");
        System.out.println("03 - Automóvel");
        System.out.println("04 - Vendas");
        System.out.println("00 - Sair");
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op)
        {
            case 1:
                menuFuncionario();
                break;

            case 2:
                break;

            case 3:
                break;

            case 0:
            default:
                System.exit(0);
                break;


        }

    }

    public void menuFuncionario()
    {

        System.out.println("\t***Menu Funcionario***");
        System.out.println("01 - Listar");
        System.out.println("02 - Cadastrar");
        System.out.println("03 - Alterar");
        System.out.println("04 - Buscar");
        System.out.println("05 - Excluir");
        System.out.println("00 - Voltar");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op){
            case 1:
                listarFuncionario();
                break;

            case 2:
                cadastrarFuncionario();
                break;

            case 3:
                break;

            case 4:
                buscaFuncionario();
                break;

            case 5:
                removeFuncionario();
                break;

            case 0:
                menuPrincipal();
                break;
            default:
                System.exit(0);
                break;
        }

        menuFuncionario();
    }

    public void cadastrarFuncionario()
    {
        Scanner sc = new Scanner(System.in);

        Funcionario funcionario = new Funcionario();

        System.out.println("# Cadastro de Funcionario ");
        System.out.println("> Informe o nome: ");
        funcionario.nome = sc.nextLine();

        System.out.println("> Informe o CPF: ");
        funcionario.cpf = sc.nextLine();

        System.out.println("> Informe o endereço: ");
        funcionario.endereco = sc.nextLine();

        System.out.println("> Informe o telefone: ");
        funcionario.telefone = sc.nextLine();

        try {
            System.out.println("> Informe a data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            funcionario.dt_nascimento = dt;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe o código: ");
        funcionario.codigo = sc.nextLine();

        System.out.println("> Informe o usuário: ");
        funcionario.usuario = sc.nextLine();

        System.out.println("> Informe a senha: ");
        funcionario.senha = sc.nextLine();

        listaFuncionarios.add(funcionario);
    }

    public void listarFuncionario()
    {
        System.out.println("#Lista de Funcionários ");
        System.out.println();
        System.out.println("Código | " + "Nome | " + "CPF | " + "Usuario | ");
        for(Funcionario f: listaFuncionarios)
        {
            System.out.println(f.codigo + " | " + f.nome + " | " + f.cpf + " | " + f.usuario + " | ");
        }
        System.out.println();
    }

    public void buscaFuncionario()
    {
        Scanner sc = new Scanner(System.in);
        String bscNome;
        int posNome = 0;

        Funcionario funcionario = new Funcionario();

        System.out.println("#Busca de Funcionários");
        System.out.println(">Informe o nome do Funcionario:");
        bscNome = sc.nextLine();

        System.out.println("Código | " + "Nome | " + "CPF | " + "Endereco | " + "Telefone | " + "Data de Nascimento | " + "Usuário | " + "Senha | ");
        for(Funcionario f: listaFuncionarios)
        {
            if(f.nome.equals(bscNome)) {
                System.out.println(f.codigo + " | " + f.nome + " | " + f.cpf + " | " + f.endereco + " | " + f.telefone + " | " + f.dt_nascimento + " | " + f.usuario + " | " + f.senha + " | ");
            }
        }
        System.out.println();
    }

    public void removeFuncionario()
    {
        Scanner sc = new Scanner(System.in);
        String bscNome;

        System.out.println("#Exclusão de Funcionários");
        System.out.println(">Informe o nome do Funcionário:");
        bscNome = sc.nextLine();

        for(Funcionario f: listaFuncionarios)
        {
            if(f.nome.equals(bscNome)) {
                listaFuncionarios.remove(f);
            }
        }
        System.out.println();
    }
}
