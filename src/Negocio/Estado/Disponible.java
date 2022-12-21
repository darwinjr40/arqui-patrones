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
public class Disponible implements IEstado{
    
    public Disponible() {
    }
    
    @Override
    public void Disponible(Estado e) {
       e.setMensaje("La Bicicleta se encuentra Disponible");
       e.setEstadoActual("Disponible");
    }

    @Override
    public void Reservado(Estado e) {
        e.setEstado(new Reservado());
        e.setMensaje("La Bicicleta paso a ser Reservada");
        e.setEstadoActual("Reservado");
    }

    @Override
    public void Alquilado(Estado e) {
        e.setMensaje("La Bicicleta no puede pasar a ser alquilada");
        e.setEstadoActual("Disponible");
    }

    @Override
    public void Devuelto(Estado e) {
         e.setMensaje("La Bicicleta no puede ser devuelta");
        e.setEstadoActual("Disponible");
    }
}
