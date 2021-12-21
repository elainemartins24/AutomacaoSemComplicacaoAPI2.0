package Transferencia;

public class Cliente {
    //Visibilidade | Tipo | nome do objeto

    private String nome;  // Nesta parte as variáveis ainda estão null
    private String cpf;
    private String rg;

    //Criação do Construtor - que dá vidaao objeto
    public Cliente(String nome, String cpf, String rg) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
    }

    //Criação dos métodos - vai retornar as informações
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }
}
