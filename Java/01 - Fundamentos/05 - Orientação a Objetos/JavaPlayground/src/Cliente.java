public class Cliente {
    String nome;
    Double limiteCredito = 10.0;

    public Cliente (String nome) {
        this.nome = nome;
    }

    public void solicitarLimiteCredito (Double valorSolicitado) {
        this.limiteCredito = valorSolicitado;
    }

    public void comprar (Double valorProduto) {
        this.limiteCredito -= valorProduto;
    }
}
