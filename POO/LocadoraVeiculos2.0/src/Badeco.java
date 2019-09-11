public class Badeco extends Funcionario implements IFuncionario {

    private String funcao;
    private float salario;

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public float getSalario() {
        return salario;
    }

    @Override
    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float calculaSalario() {
        return salario * 0.8f;
    }
}
