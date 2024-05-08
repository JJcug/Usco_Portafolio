/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoapp.Parcial2;

/**
 *
 * @author javax
 */
public class Vehiculo {
  private String placa;
  private String marca;
  private double precio;
  private int cilindraje;
  double impuestoCirculacion;
  private double cuotaMesGaraje;
  private static double cuotames100 = 100;
          
    public Vehiculo(String placa, String marca, double precio, int cilindraje, double impuestoCirculacion, double cuotaMesGaraje) {
        this.placa = null;
        this.marca = marca;
        this.precio = precio;
        this.cilindraje = cilindraje;
        this.impuestoCirculacion = impuestoCirculacion;
        this.cuotaMesGaraje = cuotames100;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public double getImpuestoCirculacion() {
        return impuestoCirculacion;
    }

    public void setImpuestoCirculacion(double impuestoCirculacion) {
        this.impuestoCirculacion = impuestoCirculacion;
    }

    public static double getCuotames100() {
        return cuotames100;
    }

    public void setCuotaMesGaraje(double cuotaMesGaraje) {
        if (cuotaMesGaraje >= 0) {
            this.cuotaMesGaraje = cuotaMesGaraje;
        } else {
            System.out.println("Error: La cuota mensual del garaje no puede ser negativa.");
        }
  
    }
    public  void calcularimpuestoCirculacion() {
        impuestoCirculacion = precio * 0.02;
    }
     public boolean matricular(String matricula) {
        if (matricula.length() == 6) {
            this.placa = matricula;
            return true;
        } else {
            return false;
    }
}
     }
