package com.sic3;

import java.sql.*; //instruccion que importa la biblioteca para la base de datos
import java.io.FileWriter;  //Biblioteca para acceder a archivos

/**
 * Programa que permite extraer "datos" desde una base de datos desde java
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        // Try-Catch para manejo de errores 
        try{ 
            // Generar un nuevo archivo csv 
            FileWriter csvWriter = new FileWriter("archivo.csv"); 
            //Se crea la cabecera que contiene los nombres de las columnas 
            //Que se establecieron al crear la tabla 
            csvWriter.append("Id,Nombre,Apellido,Matricula\n"); 
            // Llamada a la librería mysql conector 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            // Nueva conexión conexión a localhost | nombre de bd | ususario mysql | contraseña 
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/datos", "skovks17", "osiris117"); 
            // Nuevo statement para llamada de datos 
            Statement stmt = con.createStatement(); 
            // Creación de Query | llamada a todos los datos de la tabla alumnos 
            ResultSet rs = stmt.executeQuery("select * from alumnos"); 
            // Ciclo de todos los elementos obtenidos por el query 
            while (rs.next()){ 
            //Se guardan los valores obtenidos por el query en una línea nueva del archivo 
            csvWriter.append(String.valueOf(rs.getInt(1))+","+String.valueOf(rs.getString(2))+","+String.valueOf(rs.getString(3))+","+String.valueOf(rs.getString(4))+'\n'); 
            // Impresión de los valores 
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " " + rs.getString(4)); 
        } 
        //Cerrar conexión de sql 
        con.close(); 
        //Cerrar archivo csv 
        csvWriter.flush(); 
        csvWriter.close(); 
        // Se cierra la conexión 
        } 
        catch (Exception e) { 
            // Imprimir errores 
            System.out.println(e); 
        } 
    }

}
