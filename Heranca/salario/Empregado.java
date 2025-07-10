public class Empregado {

    protected double salarioFixo;

    public Empregado(double salarioFixo){
        this.salarioFixo = salarioFixo;
    }


    public double calcularBonus(Departamento departamento){

        double valorBonus = 0;

        if (departamento.alcancouMeta()){
            valorBonus = (salarioFixo * 0.10);
        }

        return valorBonus;
    }

    public double calcularSalarioTotal(Departamento departamento){

        var valorBonus = calcularBonus(departamento);
        return (salarioFixo + valorBonus);
        
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }
    
}
