
package proyectoapp.TallerPunto7.Punto7_a_1;


public class Triangulo {

    private int base;
    private int altura;

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public void setBase(int nuevaBase) {
        this.base = nuevaBase;
    }

    public int getBase() {
        return base;
    }

    public void setAltura(int nuevaAltura) {
        this.altura = nuevaAltura;
    }

    public int getAltura() {
        return altura;
    }

    public double calcularArea() {
        return (base * altura) / 2.0;
    }
}