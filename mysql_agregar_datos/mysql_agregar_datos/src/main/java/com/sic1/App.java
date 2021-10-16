package com.sic1;

import java.sql.*; //instruccion que importa la biblioteca para la base de datos

/**
 * Programa que permite agregar "datos" a una base de datos desde java
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
            //"jdbc:mysql://127.0.0.1:3306/datos", "skovks17", "osiris117"
            //Nuevo statement para crear datos 
            Statement stmt = con.createStatement(); 
            //Creación de Query | Insertar valores 
            //Estos valores deben coincidir con los valores que se asignaron durante la creación de la tabla 
            stmt.executeUpdate("INSERT INTO alumnos VALUES(4,'Javier','Marcial','2152000555')"); 
            //Se cierra la conexión 
            con.close();  
        }
        catch(Exception e){
            //Imprimir errores 
            System.out.println(e); 
        }
    }
}
