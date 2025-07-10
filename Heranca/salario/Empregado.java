public class Empregado {

    protected double salarioFixo;
    protected double valorBonus = 0;

    public Empregado(double salarioFixo){
        this.salarioFixo = salarioFixo;
    }


    public double calcularBonus(Departamento departamento){

        if (departamento.alcancouMeta()){
            valorBonus = (salarioFixo * 0.10);
            salarioFixo = salarioFixo + (valorBonus); 
        }

        return valorBonus;
    }

    public double calcularSalarioTotal(Departamento departamento){
        return (salarioFixo + valorBonus);
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }
    
}
