/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestor;

import Clases.Ingrediente;
import Ventana.Ventana;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class GestorLogico {
    
    private ArrayList<Ingrediente> lista;
    private Iterator iterator;
    
    public GestorLogico(){
        lista = new ArrayList<>();
    }
    
    public void introduceElemento(Ingrediente e){
        lista.add(e);
    }
    
    /**
     * Devuelve una String con Todos los elementos
     * @return lista
     */
    public String devuelveLista(){
        if(lista.isEmpty()){
            return "Aun no hay elementos en la lista";
        }
        String res = "";
        iterator = lista.iterator();
        while(iterator.hasNext()){
            res+=iterator.next();
            res+="\n";
        }
        return res;
    }
    
    /**
     * Muestra una ventana encima del panel principal donde pide el nombre del elemento a borrar, lo busca y borra la primera instancia de este
     * @return Resultado de la operacion
     */
    public String borraElemento(){
        if(lista.isEmpty()){
            return "No hay elementos para borrar";
        }
        String input = JOptionPane.showInputDialog(Ventana.getFrames()[0], ("Escribe el elemento que quieres borrar \n" + this.devuelveLista()));
        iterator = lista.iterator();
        while(iterator.hasNext()){
            Ingrediente temp = (Ingrediente) iterator.next();
            if(temp.nombre.equals(input)){
                lista.remove(temp);
                return "Elemento borrado con exito";
            }
        }
        return "No se ha encontrado el elemento";
    }
    
    public String generaHTML(){
        if(lista.isEmpty()){
            return "La lista esta vacia";
        }
        String ruta = "src/Gestor/Listas";
        String nomarchivo = "Lista1.html";
        try{
            int counter = 1;
            File archivo = new File(ruta,nomarchivo);
            
            while(archivo.exists()){
                counter++;
                nomarchivo = ("Lista"+counter+".html");
                archivo = new File(ruta,nomarchivo);
            }
            
            System.out.println(ruta);
            archivo.createNewFile();
            //escribimos el head
            String codigo = ("<html>\n<head>\n<title>Lista " + counter + " </title>\n<link href=\"Estilo.css\" rel=\"stylesheet\" type=\"text/css\"></head>");
            //escribimos el body
            codigo += ("<body>\n<div>\n<h1>Lista " + counter + "</h1>\n<ul>\n");
            iterator = lista.iterator();
            while(iterator.hasNext()){
                codigo += ("<li>" + (Ingrediente) iterator.next() + "</li>\n");
            }
            codigo+=("</ul>\n</div>\n</body>\n</html>");
            
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(codigo);
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
            return "Ha habido un problema creando el archivo";
        }
        return ("Lista guardada con exito");
    }
}
