public class Cliente extends Pessoa {

    private String codigo;

    Cliente () {}

    public void clienteCodigo (String codigo){
        this.codigo = codigo;
    }
    public String clienteGetCodigo (){
        return codigo;
    }
}
