public class Gerente extends Funcionario implements IFuncionario {

    private String departamento;
    private float salario;

    Gerente () {}

    public void gerenteDepartamento(String departamento){
        this.departamento = departamento;
    }
    public String gerenteSetDepartamento(){
        return departamento;
    }

    public void gerenteSalario(Float salario){
        this.salario = salario;
    }
    public Float gerenteSetSalario(){
        return salario;
    }

    public float calculaSalario() {
        return salario * 1.5f;
    }
}
