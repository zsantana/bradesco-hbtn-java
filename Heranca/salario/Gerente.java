public class Gerente extends Empregado {

    private double BONUS_BASE = 0.20;
    private double BONUS_ADICIONAL = 0.01;



    public Gerente(double salarioFixo) {
            super(salarioFixo);
    }
    
    @Override
    public double calcularBonus(Departamento departamento){

        if (departamento.alcancouMeta()){
            
            var valorBonus = salarioFixo * BONUS_BASE;
            var valorDiff =  departamento.getValorAtingidoMeta() - departamento.getValorMeta();
            var valorBonusAdicional = valorDiff * BONUS_ADICIONAL;

            return valorBonus + valorBonusAdicional;

        }

        return 0;
    }
    
}
