public class Funcionario extends Pessoa {

    private String codigo;
    private String usuario;
    private String senha;

    Funcionario () {};

    public void funcionarioCodigo (String codigo){
        this.codigo = codigo;
    }
}