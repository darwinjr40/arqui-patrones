/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Estado;

/**
 *
 * @author steph
 */
public class Devuelto implements IEstado{
    public Devuelto() {
    }

    @Override
    public void Disponible(Estado e) {
        e.setEstado(new Disponible());
        e.setMensaje("La Bicicleta paso a estar disponible");
        e.setEstadoActual("Disponible");
    }

    @Override
    public void Reservado(Estado e) {
       e.setMensaje("La bicicleta no puede estar reservada");
       e.setEstadoActual("Devuelto");
    }

    @Override
    public void Alquilado(Estado e) {
          e.setMensaje("La Bicicleta no puede ser alquilada");
       e.setEstadoActual("Devuelto");
    }

    @Override
    public void Devuelto(Estado e) {
       e.setMensaje("La Bicicleta ya fue devuelta");
       e.setEstadoActual("Devuelto");
    }
}
