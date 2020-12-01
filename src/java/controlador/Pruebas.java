/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
import modelo.dto.AspiranteDTO;
import modelo.dto.CoordinadorProyectosDTO;
import modelo.dto.FormacionAspiranteDTO;






public class Pruebas {

    public static void main(String[] args){   
        facade fac=new facade();
   
       List<FormacionAspiranteDTO> estudios=fac.listarFormaciones();
      for(int i=0;i<estudios.size();i++){
          System.out.println(estudios.get(i).getHoja());
      }
}
    }


    

