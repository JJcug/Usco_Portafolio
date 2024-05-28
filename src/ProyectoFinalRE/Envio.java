/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinalRE;

import java.util.ArrayList;
import java.util.Date;

public class Envio {
    private static int contador = 1;
    private int idEnvio;
    private Date fechaEnvio;
    private ArrayList<Traje> trajes;

    public Envio() {
        this.idEnvio = contador++;
        this.fechaEnvio = new Date();
        this.trajes = new ArrayList<>();
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public ArrayList<Traje> getTrajes() {
        return trajes;
    }

    public void añadirTraje(Traje traje) {
        trajes.add(traje);
    }

    @Override
    public String toString() {
        return "Envio ID: " + idEnvio + ", Fecha: " + fechaEnvio + ", Trajes: " + trajes.size();
    }
}