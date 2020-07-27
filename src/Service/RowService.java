/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import bean.Mot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author farah
 */
public class RowService extends AbstractFacade<Mot>{
    public RowService() {
        super(Mot.class);
}
   
     
     public void create(Mot mot){
         
         super.create(mot);
     }
     public void save(Mot mot){
     
        if(mot!=null)
            edit(mot);
    
    }
     
     //diviser un texte en tableau de mots
     public void inserermot(String texte,String nomfile){
         String text =texte.toLowerCase();
         text=text.replaceAll("[$&\"+,:;=?@#|'<>.^*()%!-]","");
      
         text=RemoveDigit(text);
          String mots[] = text.split(" ");
         for (int i = 0; i < mots.length; i++) {
              //suppression des espaces
              mots[i]=mots[i].replaceAll("\\s+","");
         }
           /// trier par ordre alphabetique
           List<String> mottriés = new ArrayList(Arrays.asList(mots));
            mottriés.sort(Comparator.naturalOrder());
            mots=mottriés.toArray(mots);
 
        for (int i = 0; i < mots.length; i++) {
          
           if(!mots[i].equals("") && mots[i]!=" ")
         
              traitermot(mots[i],nomfile);
         
            System.out.println(i+": " +mots[i]);
        }
        }
    
     //suppression des mots outils
   
      public void supprimeroutils( ){
           String requete= "select m from Mot m where m.mot in (select  mo.mot from Motoutil mo where 1=1 )";
      List<Mot> mots =getEntityManager().createQuery(requete).getResultList();
        
        
          for (Mot mot : mots) {
              remove(mot);
              
          }
      
      }
    
     //incrementer le count d'un mot pour un chapitre donné
    public void traitermot(String word,String nomfile){
    
       
       String requete= "select m from Mot m where m.mot like '"+word+"'";
      List<Mot> mots =getEntityManager().createQuery(requete).getResultList();
        
        System.out.println(requete);
     
       if(mots.isEmpty()){
         Mot mot=new Mot();
         mot.setMot(word);
         incrementerCount(mot,nomfile);

         save(mot);
            System.out.println("n exte pas maintenat le mot est inséré");
        }
       else{
           
          
       incrementerCount(mots.get(0),nomfile);
       save( mots.get(0));
 }
       
        
     } 
    
    //supprimer les nombres dans une chaine de caractere.
    static String RemoveDigit(String ch){
        int m = 0;
        char[] chr = new char[ch.length()];

        char[] chaine = ch.toCharArray();
        char[] k = {'0','1','2','3','4','5','6','7','8','9'};

        for(int i = 0; i < ch.length(); i++){
           for(int j = 0; j < k.length; j++){  
               if(chaine[i]==k[j]){
                   m--;
                   break;
               }
               else {
                   chr[m]=chaine[i];
               }
            }
            m++;
         }

         String st = String.valueOf(chr);
         return st;
     }

     public void incrementerCount(Mot mot,String nomfile){
          if(nomfile=="rm")     
            mot.setRm( mot.getRm()+1);
           if(nomfile=="acp")     
           mot.setAcp( mot.getAcp()+1);
           if(nomfile=="afc")     
            mot.setAfc( mot.getAfc()+1);
           if(nomfile=="acm")     
          mot.setAcm( mot.getAcm()+1);
           if(nomfile=="ad")     
           mot.setAd( mot.getAd()+1);
           if(nomfile=="c")     
          mot.setC( mot.getC()+1);
         
} 
     public void lowerthan17(){
            String requete= "select m from Mot m ";
             List<Mot> mots =getEntityManager().createQuery(requete).getResultList();
             
             for (Mot mot : mots) {
              Long somme=mot.getAcm()+mot.getAcp()+mot.getAfc()+mot.getAd()+mot.getC()+mot.getRm();

             if(somme<17)
             remove(mot);    
                 
         }

     }
     public void sup150(){
         
             String requete= "select m from Mot m ";
             List<Mot> mots =getEntityManager().createQuery(requete).getResultList();
             Collections.sort(mots, Collections.reverseOrder( compareByTotal));
             
             
             for (Mot mot : mots) {
                  Long somme=mot.getAcm()+mot.getAcp()+mot.getAfc()+mot.getAd()+mot.getC()+mot.getRm();
                 System.out.println(mot.getMot()+": " +somme);
         }
             
             for(int i =150; i < mots.size(); i++) {
              System.out.println(mots.get(i).getRm());

               remove(mots.get(i));  
            }
             
         
         
     }
     Comparator<Mot> compareByTotal = new Comparator<Mot>() {
    @Override
    public int compare(Mot mot, Mot mot2) {
       Long tot1=mot.getAcm()+mot.getAcp()+mot.getAfc()+mot.getAd()+mot.getC()+mot.getRm();
       Long tot2=mot2.getAcm()+mot2.getAcp()+mot2.getAfc()+mot2.getAd()+mot2.getC()+mot2.getRm();
       
        return tot1.compareTo(tot2);
    }
};

     //éliminer les doubles
     public void concatenerDoubles(){
           String requete= "select m from Mot m";
      List<Mot> mots =getEntityManager().createQuery(requete).getResultList();
        
        
          for (Mot mot : mots) {
              
          requete= "select m from Mot m where m.mot like '"+mot.getMot()+"'";
                List<Mot> doubles =getEntityManager().createQuery(requete).getResultList();
                if(doubles.size()>1){
                    Long afc=Long.valueOf(0);
                    Long acp=Long.valueOf(0);
                    Long acm=Long.valueOf(0);
                    Long rm=Long.valueOf(0);
                    Long ad=Long.valueOf(0);
                    Long c=Long.valueOf(0);
                    for (int i = 0; i < doubles.size(); i++) {
                      
                       afc+=doubles.get(i).getAfc();
                       acp+=doubles.get(i).getAcp();
                       acm+=doubles.get(i).getAcm();
                       rm+=doubles.get(i).getRm();
                       ad+=doubles.get(i).getAd();
                       c+=doubles.get(i).getC();
                       
                   }
                   doubles.get(0).setAcm(acm);           
                   doubles.get(0).setAfc(afc);
                   doubles.get(0).setAcp(acp);
                   doubles.get(0).setAd(ad);
                   doubles.get(0).setRm(rm);
                   doubles.get(0).setC(c);
                    for (int i = 1; i < doubles.size(); i++) {
                        System.out.println(doubles.get(i));
                     remove(doubles.get(i));

                    }              
                }
              
          }
      
      }
     
     }
     

