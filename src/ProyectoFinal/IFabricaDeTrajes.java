/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal;

import java.io.IOException;

public interface IFabricaDeTrajes {
    void añadirComponenteAAlmacen() throws IOException, IdException, MuchoExtracomunitarioException, MangaException;
    void listarComponentes();
    void añadirTrajeAAlmacen() throws IOException, ColoresException, TallaException, TrajeYaExisteException;
    void listarTrajes();
    void activarDesactivarRebajas();
    void crearEnvio();
}

