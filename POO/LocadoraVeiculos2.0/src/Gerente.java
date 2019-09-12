import java.util.Date;

public class Gerente extends Funcionario implements IFuncionario {

    private String departamento;
    private float salario;
    private String matricula;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public float getSalario() {
        return salario;
    }

    @Override
    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float calculaSalario() {
        return salario * 1.5f;
    }
}
