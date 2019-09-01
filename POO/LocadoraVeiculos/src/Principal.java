import java.text.DateFormat;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Principal {

    List<Funcionario> listaFuncionarios = new ArrayList<>();
    List<Cliente> listaClientes = new ArrayList<>();
    List<Automovel> listaAutomoveis = new ArrayList<>();
    List<Marca> listaMarcas = new ArrayList<>();

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
                menuCliente();
                break;

            case 3:
                menuAutomoveis();
                break;

            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida, tente novamente!\n");
                menuPrincipal();
                break;
        }

    }

    // Funcionario

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
                System.out.println("Função ainda em desenvolvimento");
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
                System.out.println("Opção inválida, tente novamente!\n");
                menuFuncionario();
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

    public void removeFuncionario() // AGORA ESTA FUNCIONANDO ESSA MERDA
    {
        Scanner sc = new Scanner(System.in);
        String bscNome;

        System.out.println("#Exclusão de Funcionários");
        System.out.println(">Informe o nome do Funcionário:");
        bscNome = sc.nextLine();

        List<Funcionario> removerFuncionarios = new ArrayList<>();

        for(Funcionario f: listaFuncionarios)
        {

            if(f.nome.equals(bscNome)) {
                removerFuncionarios.add(f);
            }
        }

        listaFuncionarios.removeAll(removerFuncionarios);

        System.out.println();
    }

    // Cliente

    public void menuCliente()
    {

        System.out.println("\t***Menu Cliente***");
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
                listarCliente();
                break;

            case 2:
                cadastrarCliente();
                break;

            case 3:
                System.out.println("Função ainda em desenvolvimento");
                break;

            case 4:
                buscaCliente();
                break;

            case 5:
                removeCliente();
                break;

            case 0:
                menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida, tente novamente!\n");
                menuCliente();
                break;
        }

        menuCliente();
    }

    public void cadastrarCliente()
    {
        Scanner sc = new Scanner(System.in);

        Cliente cliente = new Cliente();

        System.out.println("#Cadastro de Cliente");
        System.out.println("> Informe o nome: ");
        cliente.nome = sc.nextLine();

        System.out.println("> Informe o CPF: ");
        cliente.cpf = sc.nextLine();

        System.out.println("> Informe o endereço: ");
        cliente.endereco = sc.nextLine();

        System.out.println("> Informe o telefone: ");
        cliente.telefone = sc.nextLine();

        try {
            System.out.println("> Informe a data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            cliente.dt_nascimento = dt;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe o código: ");
        cliente.codigo = sc.nextLine();

        listaClientes.add(cliente);
    }

    public void listarCliente()
    {
        System.out.println("#Lista de Clientes \n");
        System.out.println("Código | " + "Nome | " + "CPF | ");
        for(Cliente c: listaClientes)
        {
            System.out.println(c.codigo + " | " + c.nome + " | " + c.cpf + " | ");
        }
        System.out.println();
    }

    public void buscaCliente()
    {
        Scanner sc = new Scanner(System.in);
        String bscNome;

        System.out.println("#Busca de Cliente");
        System.out.println(">Informe o nome:");
        bscNome = sc.nextLine();

        System.out.println("Código | " + "Nome | " + "CPF | " + "Endereco | " + "Telefone | " + "Data de Nascimento | ");
        for(Cliente c: listaClientes)
        {
            if(c.nome.equals(bscNome)) {
                System.out.println(c.codigo + " | " + c.nome + " | " + c.cpf + " | " + c.endereco + " | " + c.telefone + " | " + c.dt_nascimento + " | ");
            }
        }
        System.out.println();
    }

    public void removeCliente() // AGORA ESTA FUNCIONANDO ESSA MERDA
    {
        Scanner sc = new Scanner(System.in);
        String bscNome;

        System.out.println("#Exclusão de Cliente");
        System.out.println(">Informe o nome do Cliente:");
        bscNome = sc.nextLine();

        List<Cliente> removerClientes = new ArrayList<>();

        for(Cliente c: listaClientes)
        {
            if(c.nome.equals(bscNome)) {
                removerClientes.add(c);
            }
        }

        listaClientes.removeAll(removerClientes);

        System.out.println();
    }

    //Automovel - Nao Esta Funcionanado

    public void menuAutomoveis()
    {

        System.out.println("\t***Menu Automovel***");
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
                listarAutomovel();
                break;

            case 2:
                cadastrarAutomovel();
                break;

            case 3:
                System.out.println("Função ainda em desenvolvimento");
                break;

            case 4:
                buscarAutomovel();
                break;

            case 5:
                removeAutomoveis();
                break;

            case 0:
                menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida, tente novamente!\n");
                menuAutomoveis();
                break;
        }

        menuAutomoveis();
    }

    public void cadastrarAutomovel()
    {
        Scanner sc = new Scanner(System.in);

        Automovel automovel = new Automovel();
        Marca marca = new Marca();

        System.out.println("#Cadastro de Automovel");
        System.out.println("> Informe o modelo: ");
        automovel.nome = sc.nextLine();

        System.out.println("> Informe a marca: ");
         marca.nome = sc.nextLine();

        System.out.println("> Informe o tipo (Carro ou Moto): ");
        automovel.tipo = sc.nextLine();

        try {
            System.out.println("> Informe o ano de fabricação: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("yyyy").parse(data);
            automovel.ano_fab = dt;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("> Informe o ano do modelo: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("yyyy").parse(data);
            automovel.ano_modelo = dt;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe a cor: ");
        automovel.cor = sc.nextLine();

        System.out.println("> Informe o chassi: ");
        automovel.chassi = sc.nextLine();

        System.out.println("> Informe a placa: ");
        automovel.placa = sc.nextLine();

        System.out.println("> Informe a quillometragem: ");
        automovel.km = Float.parseFloat(sc.nextLine());

        System.out.println("> Informe o valor: ");
        automovel.valor = Float.parseFloat(sc.nextLine());

        listaAutomoveis.add(automovel);
        listaMarcas.add(marca);
    }

    void listarAutomovel()
    {
        System.out.println("#Lista de Automoveis");

        for(Automovel a: listaAutomoveis){
            System.out.println("\n------------------------------");
            System.out.println("Modelo: " + a.nome);
            System.out.println("Marca: ");
            System.out.println("Placa: " + a.placa);
            System.out.println("Valor: R$" + a.valor);
            System.out.println("Quilometragem: " + a.km + "KM");
            System.out.println("Cor: " + a.cor);
            System.out.println("Tipo: " + a.tipo);
            System.out.println("Ano de Fabricação: " + a.ano_fab);
            System.out.println("Ano do Modelo: " + a.ano_modelo);
            System.out.println("------------------------------");
        }
        System.out.println();
    }

    // Nao implementado ainda
    void buscarAutomovel(){

        Scanner sc = new Scanner(System.in);
        String bscNome;

        int pos = 0;

        System.out.println("#Busca de Automovel");
        System.out.println(">Informe o modelo:");
        bscNome = sc.nextLine();

        System.out.println();
        for(Automovel a: listaAutomoveis)
        {
            if(a.nome.equals(bscNome)) {
                System.out.println("\n------------------------------");
                System.out.println("Modelo: " + a.nome);
                System.out.println("Marca: ");
                System.out.println("Placa: " + a.placa);
                System.out.println("Valor: R$" + a.valor);
                System.out.println("Quilometragem: " + a.km + "KM");
                System.out.println("Chassi: " + a.chassi);
                System.out.println("Cor: " + a.cor);
                System.out.println("Tipo: " + a.tipo);
                System.out.println("Ano de Fabricação: " + a.ano_fab);
                System.out.println("Ano do Modelo: " + a.ano_modelo);
                System.out.println("------------------------------");
            }
        }

        System.out.println();
    }

    public void removeAutomoveis() // AGORA ESTA FUNCIONANDO ESSA MERDA
    {
        Scanner sc = new Scanner(System.in);
        String bscNome;

        System.out.println("#Exclusão de Automovel");
        System.out.println(">Informe o nome do Automovel:");
        bscNome = sc.nextLine();

        List<Automovel> removerAutomoveis = new ArrayList<>();

        for(Automovel a: listaAutomoveis)
        {
            if(a.nome.equals(bscNome)) {
                removerAutomoveis.add(a);
            }
        }

        listaAutomoveis.removeAll(removerAutomoveis);

        System.out.println();
    }
}
