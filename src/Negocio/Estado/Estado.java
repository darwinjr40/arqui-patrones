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
public class Estado {
    
    protected IEstado estado;
    
    public String estadoActual = "";
    public String mensaje = "";

    public Estado(IEstado estado) {
        this.estado = estado;
    }

    public Estado(String estadoactual, IEstado estado) {
        this.estado = estado;
        this.estadoActual = estadoactual;
    }
    
    public void setEstado(IEstado estado) {
        this.estado = estado;
    }
    
    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public IEstado getEstado() {
        return estado;
    }

    public String getMensaje() {
        return mensaje;
    }
    
}
