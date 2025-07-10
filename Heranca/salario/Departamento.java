public class Departamento {

    private double valorMeta;
    private double valorAtingidoMeta;


    public Departamento(double valorMeta, double valorAtingidoMeta){
        this.valorMeta = valorMeta;
        this.valorAtingidoMeta = valorAtingidoMeta;
    }


    public boolean alcancouMeta(){
        return this.valorAtingidoMeta > this.valorMeta;
    }

    public double getValorMeta() {
        return valorMeta;
    }
    public double getValorAtingidoMeta() {
        return valorAtingidoMeta;
    }
    
}
