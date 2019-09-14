import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {

    ArrayList<Funcionario> funcionarioList = new ArrayList<>();
    ArrayList<Cliente> clienteList = new ArrayList<>();

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
            case 2:
                menuCliente();
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

        System.out.println("## Menu Funcionario ##");
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
            case 3:
                buscarFuncionario();
                break;
            case 4:
                System.out.println("Funcao em desenvolvimento!");
                break;
            case 5:
                removeFuncionario();
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
        Scanner sci = new Scanner(System.in);
        int tipoFunc = 0;

        Funcionario funcionario = new Funcionario();

        System.out.println("#!# Cadastro de Funcionario #!#");
        System.out.println("Qual o tipo de Funcionario ? [1- Gerente, 2- Badeco, 3-Funcionario Comum]");
        tipoFunc = sci.nextInt();

        if(tipoFunc != 1 && tipoFunc != 2 && tipoFunc != 3){
            System.out.println("O tipo informado e invalido ou nao existe! Tente novamente.");
            cadastroFuncionario();
        }else{
            System.out.println("> Informe o nome: ");
            funcionario.setNome(sc.nextLine());

            System.out.println("> Informe o CPF: ");
            funcionario.setCpf(sc.nextLine());

            System.out.println("> Informe o endereco: ");
            funcionario.setEndereco(sc.nextLine());

            System.out.println("> Informe o telefone: ");
            funcionario.setTelefone(sc.nextLine());

            try {
                System.out.println("> Informe a data de nascimento: ");
                String data = sc.nextLine();
                Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                funcionario.setDt_nascimento(dt);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("> Informe o codigo: ");
            funcionario.setCodigo(sci.nextInt());

            System.out.println("> Informe o usuario: ");
            funcionario.setUsuario(sc.nextLine());

            System.out.println("> Informe a senha: ");
            funcionario.setSenha(sc.nextLine());

            if(tipoFunc == 1){
                Gerente gerente = new Gerente();

                gerente.mapFuncionarioToGerente(funcionario);

                System.out.println("> Informe a matricula: ");
                gerente.setMatricula(sc.nextLine());

                System.out.println("> Informe o departamento: ");
                gerente.setDepartamento(sc.nextLine());

                System.out.println("> Informe o salario: ");
                gerente.setSalario(sci.nextFloat());

                funcionario = gerente;
            }else if(tipoFunc == 2){
                Badeco badeco = new Badeco();

                badeco.mapFuncionarioToBadeco(funcionario);

                System.out.println("> Informe a funcao: ");
                badeco.setFuncao(sc.nextLine());

                System.out.println("> Informe o salario: ");
                badeco.setSalario(sci.nextFloat());

                funcionario = badeco;
            }else {
                System.out.println("> Informe o salario: ");
                funcionario.setSalario(sci.nextFloat());
            }

            funcionarioList.add(funcionario);
        }
    }

    public void listarFuncionario(){

        System.out.println("#!# Lista de Funcionarios #!#");
        for(Funcionario f: funcionarioList){
            System.out.println("\n#-----------------------------------------------#");
            System.out.println("| Nome: " + f.getNome());
            System.out.println("| Telefone: " + f.getTelefone());
            System.out.println("| Codigo: " + f.getCodigo());
            System.out.println("#-----------------------------------------------#");
        }
    }

    public void buscarFuncionario(){

        Scanner sc = new Scanner(System.in);

        System.out.println("# Busca de Funcionários");
        System.out.println(">Informe o codigo do funcionario:");
        int codFunc = sc.nextInt();

        for(Funcionario f: funcionarioList){
            if (f.getCodigo() == codFunc){
                System.out.println("| Nome: " + f.getNome());
                System.out.println("| CPF: " + f.getCpf());
                System.out.println("| Endereco: " + f.getEndereco());
                System.out.println("| Telefone: " + f.getTelefone());
                System.out.println("| Data de Nascimento: " + f.getDt_nascimento());
                System.out.println("| Codigo: " + f.getCodigo());
                System.out.println("| Usuario: " + f.getUsuario());
                System.out.println("| Senha: " + f.getSenha());
                System.out.println("| Salario: " + f.calculaSalario());
            }
        }

    }

    public void removeFuncionario(){
        Scanner sc = new Scanner(System.in);

        System.out.println("# Exclusão de Funcionarios");
        System.out.println("> Informe o codigo do funcionário:");
        int codFunc = sc.nextInt();

        List<Funcionario> removeFuncionario = new ArrayList<>();

        for(Funcionario f: funcionarioList){
            if(f.getCodigo() == codFunc){
                removeFuncionario.add(f);
            }
        }

        funcionarioList.removeAll(removeFuncionario);
    }

    public void menuCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("## Menu Cliente ##");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Buscar");
        System.out.println("4 - Alterar");
        System.out.println("5 - Excluir");
        System.out.println("0 - Voltar");
        System.out.println("Digite sua opção: ");
        int op = sc.nextInt();

        switch(op){
            case 1:
                cadastrarCliente();
                break;
            case 2:
                listarCliente();
                break;
            case 3:
                buscarCliente();
                break;
            case 5:
                removeCliente();
                break;
            default:
                System.out.println("Opcao invalida, tente novamente!");
                menuCliente();
                break;
        }
    }

    public void cadastrarCliente(){
        Cliente cliente = new Cliente();

        Scanner sc = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);

        System.out.println("> Informe o nome: ");
        cliente.setNome(sc.nextLine());

        System.out.println("> Informe o CPF: ");
        cliente.setCpf(sc.nextLine());

        System.out.println("> Informe o endereco: ");
        cliente.setEndereco(sc.nextLine());

        System.out.println("> Informe o telefone: ");
        cliente.setTelefone(sc.nextLine());

        try {
            System.out.println("> Informe a data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            cliente.setDt_nascimento(dt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe o codigo:");
        cliente.setCodigo(sci.nextInt());

        clienteList.add(cliente);
    }

    public void listarCliente(){
        System.out.println("#!# Lista de Clientes #!#");
        for(Cliente c: clienteList){
            System.out.println("\n#-----------------------------------------------#");
            System.out.println("| Nome: " + c.getNome());
            System.out.println("| Telefone: " + c.getTelefone());
            System.out.println("| Codigo: " + c.getCodigo());
            System.out.println("| Endereco: " + c.getEndereco());
            System.out.println("#-----------------------------------------------#");
        }
    }

    public void buscarCliente(){
        Scanner sc = new Scanner(System.in);

        System.out.println("#!# Busca de Funcionario #!#");
        System.out.println("> Informe o nome do cliente: ");
        String bscCliente = sc.nextLine();

        System.out.println("\n#-----------------------------------------------#");
        for(Cliente c: clienteList){
            if(c.getNome().equals(bscCliente)){
                System.out.println("| Nome: " + c.getNome());
                System.out.println("| CPF: " + c.getCpf());
                System.out.println("| Endereco: " + c.getEndereco());
                System.out.println("| Telefone: " + c.getTelefone());
                System.out.println("| Data de Nascimento: " + c.getDt_nascimento());
                System.out.println("| Codigo: " + c.getCodigo());
            }
        }
        System.out.println("\n#-----------------------------------------------#");
    }

    public void removeCliente(){
        Scanner sc = new Scanner(System.in);

        System.out.println("# Exclusão de Funcionarios");
        System.out.println("> Informe o codigo do funcionário:");
        int codFunc = sc.nextInt();

        List<Cliente> removeCliente = new ArrayList<>();

        for(Cliente c: clienteList){
            if(c.getCodigo() == codFunc){
                removeCliente.add(c);
            }
        }

        clienteList.removeAll(removeCliente);
    }
}
