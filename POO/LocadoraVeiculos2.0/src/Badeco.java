public class Badeco extends Funcionario implements IFuncionario {

    private String funcao;
    private float salario;

    Badeco () {}

    public void badecoFuncao(String funcao){
        this.funcao = funcao;
    }
    public String gerenteSetFuncao(){
        return funcao;
    }

    public void badecoSalario(Float salario){
        this.salario = salario;
    }
    public Float badecoSetSalario(){
        return salario;
    }

    public float calculaSalario() {
        return salario * 0.8f;
    }
}
