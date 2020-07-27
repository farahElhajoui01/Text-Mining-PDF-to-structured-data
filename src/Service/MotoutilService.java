/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import bean.Mot;
import bean.Motoutil;

/**
 *
 * @author farah
 */
public class MotoutilService extends AbstractFacade<Motoutil>{
    public MotoutilService() {
        super(Motoutil.class);
}
    public void save(Motoutil mot){
     
        if(mot!=null)
            edit(mot);
    
    }
     
     public void create(Motoutil mot){
         
         super.create(mot);
     }
     
     public void insertmotoutil(){
         
           String[] motoutils={"il","dans","y","a","le","la","l","un","une","elle",
              "sur","est","avec","des","les","c","et","se","à","va","de","pour",
              "du","fait","ils","qui","par","que","par","mais","ne","vais","chez"
             ,"fais","fait","au","dit","comme","peut","avoir","voir","en","mon",
             "tout","tous","nous","plus","plus","on","ce","pouvoir","voit","soit",
             "faire","être","où","dire","elles","ils"};
          
          for (int i = 0; i < motoutils.length; i++) {
              Motoutil mot=new Motoutil();
              mot.setMot(motoutils[i]);
              save(mot);
              
          }
     }
}
