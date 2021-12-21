package Transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {
    //nesta posiçao antes do método, os objetos passsama  ser globais, podendo ser utilizados em
    // vários métodos da classe

    Cliente xuxa;
    Cliente silvioSantos;

    Conta contaXuxa;
    Conta contaSilvio;

    @BeforeEach  // anotação que cria um setup que é executado no início de cada teste da classe
    void setUp() {
       xuxa = new Cliente("Xuxa","12345678900", "11111111");
       silvioSantos = new Cliente("Silvio Santos", "00987654321", "2222222");

       contaXuxa = new Conta("0025","2254", 2500.00, xuxa);
       contaSilvio = new Conta("0026","2251",3500.00, silvioSantos);

    }
    @Test
    // Verif se o codigo retorna corretamente as informações do Cliente
    public void validaCliente() {
        assertEquals("Silvio Santos", silvioSantos.getNome());
        assertEquals("00987654321", silvioSantos.getCpf());
        assertEquals("2222222",silvioSantos.getRg());
    }

    @Test
    // Verif se o código retorna corretamente as informações da Conta
    public void validaConta() {
        assertEquals("0026", contaSilvio.getAgencia());
        assertEquals("2251", contaSilvio.getNumeroConta());
        // A comparação é com o objeto silvioSantos que é do tipo Cliente
        assertEquals(silvioSantos, contaSilvio.getProprietario());
    }

    @Test  //anotação que indica que esse método é de teste
    public void realizarTransacao() {

     // Transfere 1.000,00 da contaXuxa para a contaSilvio
     contaXuxa.realizarTransferencia(1000.00, contaSilvio);

     //Valida se o saldo confere com o valor esperado (1500.00).
    // o retorno é um booolean
     assertEquals(1500.00, contaXuxa.getSaldo());

     // Valida se o valor foi recebido da contaSilvio
    assertEquals(4500.00, contaSilvio.getSaldo());

    }
@Test
    public void validarTransferenciaInvalida(){
    // Testa a linha de código que retorna False na transferencia
    boolean resultado = contaXuxa.realizarTransferencia(3500.00, contaSilvio);
        assertFalse(resultado);

}

}