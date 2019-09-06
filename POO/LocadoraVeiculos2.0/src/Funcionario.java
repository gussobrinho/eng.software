public class Funcionario extends Pessoa {

    private String codigo;
    private String usuario;
    private String senha;

    Funcionario () {};

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
}