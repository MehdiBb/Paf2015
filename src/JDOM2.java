
import java.io.*;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;


import java.util.List;
import java.util.Iterator;

public class JDOM2
{
   static org.jdom2.Document document;
   static Element racine;

   public static void main(String[] args)
   {
      //On cr�e une instance de SAXBuilder
      SAXBuilder sxb = new SAXBuilder();
      try
      {
         //On cr�e un nouveau document JDOM avec en argument le fichier XML
         //Le parsing est termin� ;)
         document = sxb.build(new File("D:\\PAF\\Git PAf\\src\\2706406.xml"));
      }
      catch(Exception e){}
      

      //On initialise un nouvel �l�ment racine avec l'�l�ment racine du document.
     racine = document.getRootElement();
     racine = racine.getChild("fr-bibliographic-data");
     racine = racine.getChild("parties");
     racine = racine.getChild("inventors");
     		
   

      //M�thode d�finie dans la partie 3.2. de cet article
      afficheALL();
   }
   
 //Ajouter cette m�thodes � la classe JDOM2
   static void afficheALL()
   {
      //On cr�e une List contenant tous les noeuds "etudiant" de l'Element racine
      List listEtudiants = racine.getChildren("inventor");
      //On cr�e un Iterator sur notre liste
      Iterator i = listEtudiants.iterator();
      while(i.hasNext())
      {
         //On recr�e l'Element courant � chaque tour de boucle afin de
         //pouvoir utiliser les m�thodes propres aux Element comme :
         //s�lectionner un n�ud fils, modifier du texte, etc...
         Element courant = (Element)i.next();
         //On affiche le nom de l��l�ment courant
         System.out.println(courant.getChild("addressbook").getChild("first-name").getText());
      }
   }
}