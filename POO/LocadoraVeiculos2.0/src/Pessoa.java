import java.util.Date;

public class Pessoa {

    private String nome_pessoa;
    private String cpf;
    private String endereco;
    private String telefone;
    private Date dt_nascimento;

    Pessoa (){};

    public void pessoaNome(String nome_pessoa){
        this.nome_pessoa = nome_pessoa;
    }
    public String pessoaGetNome(){
        return nome_pessoa;
    }

    public void pessoaCpf(String cpf){
        this.cpf = cpf;
    }
    public String pessoaGetCpf(){
        return cpf;
    }

    public void pessoaEndereco(String endereco){
        this.endereco = endereco;
    }
    public String pessoaGetEndereco(){
        return endereco;
    }

    public void pessoaTelefone(String telefone){
        this.telefone = telefone;
    }
    public String pessoaGetTelefone(){
        return telefone;
    }

    public void pessoaNascimento(Date dt_nascimento){
        this.dt_nascimento = dt_nascimento;
    }
    public String pessoaGetNascimento(){ return "Hello, To com a data de nascimento aqui"; };
}
