import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Principal {

    ArrayList<Funcionario> funcionarioList = new ArrayList<>();

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
        Scanner sc2 = new Scanner(System.in);
        int tipoFunc = 0;

        Funcionario funcionario = new Funcionario();

        System.out.println("Qual o tipo de Funcionario ? [1- Gerente, 2- Badeco, 3-Funcionario Comum");
        tipoFunc = sc.nextInt();
        sc.nextLine();

        if(tipoFunc != 1 && tipoFunc != 2 && tipoFunc != 3){
            System.out.println("O tipo informado e invalido ou nao existe! Tente novamente.");
            cadastroFuncionario();
        }else{
            System.out.println("> Informe o nome: ");
            funcionario.setNome(sc.nextLine());

            System.out.println("> Informe o CPF: ");
            funcionario.setNome(sc.nextLine());

            System.out.println("> Informe o endereco: ");
            funcionario.setNome(sc.nextLine());

            System.out.println("> Informe o telefone: ");
            funcionario.setNome(sc.nextLine());

            try {
                System.out.println("> Informe a data de nascimento: ");
                String data = sc.nextLine();
                Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                funcionario.setDt_nascimento(dt);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("> Informe o codigo: ");
            funcionario.setCodigo(sc.nextInt());
            sc.nextLine();

            System.out.println("> Informe o usuario: ");
            funcionario.setUsuario(sc.nextLine());

            System.out.println("> Informe a senha: ");
            funcionario.setSenha(sc.nextLine());

            if(tipoFunc == 1){
                Gerente gerente = new Gerente();

                System.out.println("> Informe a matricula: ");
                gerente.setMatricula(sc.nextLine());

                System.out.println("> Informe o departamento: ");
                gerente.setDepartamento(sc.nextLine());

                System.out.println("> Informe o salario: ");
                gerente.setSalario(sc.nextFloat());

                funcionario = gerente;
            }else if(tipoFunc == 2){
                Badeco badeco = new Badeco();

                System.out.println("> Informe a funcao: ");
                badeco.setFuncao(sc.nextLine());

                System.out.println("> Informe o salario: ");
                badeco.setSalario(sc.nextFloat());

                funcionario = badeco;
            }else {
                System.out.println("> Informe o salario: ");
                funcionario.setSalario(sc.nextFloat());
            }

            funcionarioList.add(funcionario);
        }
    }

    public void listarFuncionario(){

        System.out.println("Informe o tipo de funcionario que deseja ser listado: ");

        for(Funcionario f: funcionarioList){
            System.out.println("\n#-----------------------------------------------#");
            System.out.println("| Nome: " + f.getNome());
            System.out.println("| CPF: " + f.getCpf());
            System.out.println("| Endereco: " + f.getEndereco());
            System.out.println("| Telefone: " + f.getTelefone());
            System.out.println("| Data de Nascimento: " + f.getDt_nascimento());
            System.out.println("| Codigo: " + f.getCodigo());
            System.out.println("| Usuario: " + f.getUsuario());
            System.out.println("| Senha: " + f.getSenha());
            System.out.println("#-----------------------------------------------#");
        }
    }
}
