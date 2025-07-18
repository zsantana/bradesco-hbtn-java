public class ContaBancariaTarifada extends ContaBancariaBasica {
    private int quantidadeTransacoes;
    private static final double TARIFA_TRANSACAO = 0.10;

    public ContaBancariaTarifada(String numeracao, double tarifaMensal) {
        super(numeracao, 0.0, tarifaMensal, 0.0);
        this.quantidadeTransacoes = 0;
    }

    public ContaBancariaTarifada(String numeracao, double saldo, double tarifaMensal, double jurosMensal) {
        super(numeracao, saldo, tarifaMensal, jurosMensal);
        this.quantidadeTransacoes = 0;
    }

    @Override
    public void depositar(double valor) throws Exception {
        // Chama o método da classe pai
        super.depositar(valor);
        
        // Aplica a tarifa da transação
        setSaldo(getSaldo() - TARIFA_TRANSACAO);
        
        // Incrementa o contador de transações
        quantidadeTransacoes++;
    }

    @Override
    public void sacar(double valor) throws Exception {
        // Chama o método da classe pai
        super.sacar(valor);
        
        // Aplica a tarifa da transação
        setSaldo(getSaldo() - TARIFA_TRANSACAO);
        
        // Incrementa o contador de transações
        quantidadeTransacoes++;
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }
}
