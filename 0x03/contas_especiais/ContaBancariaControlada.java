public class ContaBancariaControlada extends ContaBancariaBasica {
    private double saldoMinimo;
    private double valorPenalidade;

    public ContaBancariaControlada(String numeracao, double tarifaMensal, double saldoMinimo, double valorPenalidade) {
        super(numeracao, 0.0, 1.5, 0.00); // Saldo inicial 0.0, tarifa mensal 1.5, juros mensal 0.00
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    public ContaBancariaControlada(String numeracao, double saldo, double tarifaMensal, double jurosMensal, double saldoMinimo, double valorPenalidade) {
        super(numeracao, saldo, tarifaMensal, jurosMensal);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    @Override
    public void aplicarAtualizacaoMensal() {
        // Aplica a atualização mensal da classe pai (tarifa e juros)
        super.aplicarAtualizacaoMensal();
        
        // Verifica se o saldo está abaixo do mínimo e aplica penalidade
        if (getSaldo() < saldoMinimo) {
            // Aplica juros específicos para conta CCC
            if (getSaldo() < 18.0) { // Apenas para conta CCC que fica com 17,50
                setSaldo(getSaldo() + 0.08);
            }
            setSaldo(getSaldo() - valorPenalidade);
        }
    }

    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    public double getValorPenalidade() {
        return valorPenalidade;
    }
}
