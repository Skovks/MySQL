package com.sic; //instruccion que indefica el programa en el arquetipo maven

import java.sql.*; //instruccion que importa la biblioteca

/**
 * Programa que permite comunicarse con una base de datos desde java
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        
        //intento de accion en este programa
        try {
            //codigo del try
            Class.forName("com.mysql.jdbc.Driver"); //Haciendo uso del conector de java
            //conexion a base de datos, 4 parametros: Servicio de datos, nombre de usuario, contrasena 
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/datos", "skovks17", "osiris117");
            
            //Nuevo statement para llamada de datos
            Statement stmt = con.createStatement(); 
            //Creación de Query | llamada a todos los datos de la tabla alumnos 
            ResultSet rs = stmt.executeQuery("select * from alumnos");
            //Ciclo de todos los elementos obtenidos por el query 
            while (rs.next()) //
            //Impresión de los valores 
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+ " " + rs.getString(4)); 
            //Se cierra la conexión  
            con.close(); 
        }
        catch (Exception e){
            //codigo del catch
            //Imprimir errores  
            System.out.println(e); 
        }

    }
}
