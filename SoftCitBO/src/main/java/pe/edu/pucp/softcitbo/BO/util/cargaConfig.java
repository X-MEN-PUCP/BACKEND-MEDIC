/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 *
 * @author luisa
 */
public class cargaConfig {
    private static final Properties prop = new Properties();
    static{
        try(InputStream input = cargaConfig.class.getClassLoader().getResourceAsStream("configCorreo.properties")){
            if(input == null) System.err.println("Error: No se pudo encontrar el archivo de configuracion");
            prop.load(input);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("Error al cargar el archivo de configuracion",ex);
        }
    }
    public static String getPropiedad(String llave){
        return prop.getProperty(llave);
    }
}
