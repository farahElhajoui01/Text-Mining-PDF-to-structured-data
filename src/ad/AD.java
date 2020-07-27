/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad;

import Service.MotoutilService;
import Service.RowService;
import bean.Motoutil;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author farah
 */
public class AD {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) throws IOException {
        RowService rowService=new RowService();
 
        String[] chemins={"rm","acp","afc","acm","ad","c"};
        
        for (int i = 0; i < 6; i++) {
           PDFTextStripper pdfStripper = null;
        PDDocument pdDoc = null;
        File file = new File("C:\\Users\\farah\\Documents\\NetBeansProjects\\AD\\src\\ad\\"+chemins[i]+".pdf");
            System.out.println("C:\\Users\\farah\\Documents\\NetBeansProjects\\AD\\src\\ad\\"+chemins[i]+".pdf");
      /*  PDFParser parser =new PDFParser(new org.apache.pdfbox.io.RandomAccessFile(file, "r"));
        parser.parse();
        try (COSDocument cosDoc = parser.getDocument()) {
            pdfStripper = new PDFTextStripper();
            pdDoc = new PDDocument(cosDoc);
            pdfStripper.setStartPage(1);
            String parsedText = pdfStripper.getText(pdDoc);
            //System.out.println(parsedText);
            System.out.println(chemins[i]);
        // rowService.inserermot(parsedText,chemins[i]);
        // rowService.supprimeroutils();*/
           
          //rowService.concatenerDoubles();
          
         
           
       // }  
        }
       

         rowService.lowerthan17();
          // rowService.sup150();

      }
}