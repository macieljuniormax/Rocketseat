package exercicio;

import java.time.LocalDate;

public class ContaCorrente {
    int numero;
    int agencia;
    String nomeCliente;
    LocalDate dataNascimento;
    double saldo;
    boolean ativo = true;

    double consultarSaldo () {
        return this.saldo;
    }
    void consultarExtrato (LocalDate dataInicial, LocalDate dataFinal) {} 
    void sacar (Double valorSolicitado) {}
    void transferir (ContaCorrente contaDestino, Double valorTransferido) {}
    void cancelar (String justificativa) {}
}
