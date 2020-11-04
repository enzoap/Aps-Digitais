/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aps.Utils;

import Aps.Model.UsuarioModel;
import com.machinezoo.sourceafis.FingerprintImage;
import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 *
 * @author enzoa
 */
public class FingerPrintRecognition {
    private String path;

   public FingerPrintRecognition(){
       
   }

    public void setPath(String path) {
        this.path = path;
    }
   
   
   
   public boolean isMatch(UsuarioModel pUsuario) throws Exception{
       byte[] probeImage = null;
       byte[] candidateImage = null;
       try {
            probeImage = Files.readAllBytes(Paths.get(path));
            candidateImage = Files.readAllBytes(Paths.get("../impressoes/"+pUsuario.getPassword_Fingerprint()));
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
       if (probeImage == null || candidateImage == null){
           throw new Exception("Ocorreu um erro ao comparar as imagens, tente novamente.");
       }
        FingerprintTemplate probe = new FingerprintTemplate(new 
            FingerprintImage()
            .dpi(500)
            .decode(probeImage));
        
        FingerprintTemplate candidate = new FingerprintTemplate(new 
            FingerprintImage()
                .dpi(500)
                .decode(candidateImage));
        
        double score = new FingerprintMatcher()
                .index(probe)
                .match(candidate);
        
        double threshold = 40;
        boolean matches = score >= threshold;
        
        return matches;
   }    

}
