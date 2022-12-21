/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DBicicleta;
import javax.swing.table.DefaultTableModel;
import Datos.Plantilla.ListarIDTipo;
import Datos.Plantilla.ListarTodo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author steph
 */
public class NBicicleta {
    private DBicicleta dbicicleta;
    private ListarIDTipo dListarTipo;
    private ListarTodo dListarTodo;
    
    public NBicicleta(){
        dListarTipo = new ListarIDTipo();
        dListarTodo = new ListarTodo();
        
        dbicicleta = dListarTipo;
    }
    
    public int registrar (int idBicicleta, String modelo, String color, String estado, int idTipo){
        dbicicleta.setIdBicicleta(idBicicleta);
        dbicicleta.setModelo(modelo);
        dbicicleta.setColor(color);
        dbicicleta.setEstado(estado);
        dbicicleta.setIdTipo(idTipo);
        return dbicicleta.registrar( );
    }
    
    public int modificar(int idBicicleta,String modelo, String color,String estado, int idTipo){
        dbicicleta.setIdBicicleta(idBicicleta);
        dbicicleta.setModelo(modelo);
        dbicicleta.setColor(color);
        dbicicleta.setEstado(estado);
        dbicicleta.setIdTipo(idTipo);
        return dbicicleta.modificar(idBicicleta);
    }
    
    public int eliminar(int idBicicleta){
        dbicicleta.setIdBicicleta(idBicicleta);
        return dbicicleta.eliminar(idBicicleta);
    }
     
    public ArrayList Listar(int idTipo) throws SQLException{
//           dbicicleta.setIdTipo(idTipo);
        dListarTipo.setIdTipo(idTipo);
        dbicicleta = dListarTipo;
        return dbicicleta.template_method_listar();
    }
    
    public ArrayList ListarTodos() throws SQLException{
//            dbicicleta = new ListarTodo();
        dbicicleta = dListarTipo;
        return dbicicleta.template_method_listar();
    }
}
