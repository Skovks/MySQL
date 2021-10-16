package com.sic2;

import java.sql.*; //instruccion que importa la biblioteca para la base de datos

/**
 * Programa que permite eliminar "datos" a una base de datos desde java
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        try{
            //Llamada a la libreria mysql conector 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            //Nueva conexión                        conexión a localhost |   nombre de bd | ususario mysql | contraseña   
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/datos", "skovks17", "osiris117"); 
            //Nuevo statement para eliminar datos 
            PreparedStatement st = con.prepareStatement("DELETE FROM alumnos WHERE id = 2;"); 
            //Ejecutar statement 
            st.executeUpdate(); 
            //Se cierra la conexión 
            con.close(); 
        }
        catch(Exception e){
            //Imprimir errores 
            System.out.println(e);
        }
    }
}
