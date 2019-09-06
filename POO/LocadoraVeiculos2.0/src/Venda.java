import java.util.Date;

public class Venda {

    Date dt_venda;
    String codigo;
    float comissao_venda;
    float valor_venda;

    Automovel automovel; /*Agregação todos dentro de vendas*/
    Funcionario funcionario;
    Cliente cliente;
}