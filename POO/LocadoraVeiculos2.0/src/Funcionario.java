public class Funcionario extends Pessoa implements IFuncionario{

    private String codigo;
    private String usuario;
    private String senha;
    private float salario;

    Funcionario () {}

    public void funcionarioCodigo (String codigo){
        this.codigo = codigo;
    }
    public String funcionarioGetCodigo (){
        return codigo;
    }

    public void funcionarioUser (String user){
        this.usuario = user;
    }
    public String funcionarioGetUser (){
        return usuario;
    }

    public void funcionarioSenha (String senha){
        this.senha = senha;
    }
    public String funcionarioGetSenha (){
        return senha;
    }

    @Override
    public float calculaSalario() {
        return salario * 15;
    }
}