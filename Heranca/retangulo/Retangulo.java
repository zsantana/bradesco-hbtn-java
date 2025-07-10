public class Retangulo extends FormaGeometrica{

    private double altura;
    private double largura;

    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {

        if (altura < 0 ) throw new IllegalArgumentException("Altura deve ser maior ou igual a 0");

        this.altura = altura;
    }
    public double getLargura() {
        return largura;
    }
    public void setLargura(double largura) {

        if (largura < 0 ) throw new IllegalArgumentException("Largura deve ser maior ou igual a 0");

        this.largura = largura;
    }
    
}
