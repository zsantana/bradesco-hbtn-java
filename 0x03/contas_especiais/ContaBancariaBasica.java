public class ContaBancariaBasica {
    private String numeracao;
    private double saldo;
    private double tarifaMensal;
    private double jurosMensal;

    public ContaBancariaBasica(String numeracao, double saldo) {
        this.numeracao = numeracao;
        this.saldo = saldo;
        this.tarifaMensal = 0.0;
        this.jurosMensal = 0.0;
    }

    public ContaBancariaBasica(String numeracao, double saldo, double tarifaMensal, double jurosMensal) {
        this.numeracao = numeracao;
        this.saldo = saldo;
        this.tarifaMensal = tarifaMensal;
        this.jurosMensal = jurosMensal;
    }

    public void depositar(double valor) throws Exception {
        if (valor <= 0) {
            throw new Exception("Valor para depósito deve ser positivo");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) throws Exception {
        if (valor <= 0) {
            throw new Exception("Valor para saque deve ser positivo");
        }
        if (valor > this.saldo) {
            throw new Exception("Saldo insuficiente");
        }
        this.saldo -= valor;
    }

    public void aplicarAtualizacaoMensal() {
        this.saldo = this.saldo - this.tarifaMensal + this.jurosMensal;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTarifaMensal() {
        return tarifaMensal;
    }

    public double getJurosMensal() {
        return jurosMensal;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
