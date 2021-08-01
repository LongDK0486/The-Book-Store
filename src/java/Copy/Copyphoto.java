/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author PRREDETOR
 */
public class Copyphoto {
    public static void copyfile(File src,File dest) throws IOException  {
        InputStream is=null;
        OutputStream os=null;
        try {
            is=new FileInputStream(src) ;
            os=new FileOutputStream(dest);
            byte[] buffer=new byte[1024];
            int lenght;
            while((lenght=is.read(buffer))>0){
                os.write(buffer,0,lenght);
            }
        } finally{
            if(os!=null){
                os.close();
            }
            if(is!=null){
                is.close();
            }
        }
    
    }
}
