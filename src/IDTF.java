
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;



public class IDTF {
	
	
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> listTitre = new ArrayList<String>();
		
		try {
            
			File repertoire= new File("C:/Users/Mehdi/Desktop/Brev");
			 String[] listefichiers = repertoire.list();
            
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            for (int k=0; k<listefichiers.length;k++)
            {
            	 if(listefichiers[k].endsWith(".xml")==true)
            	 {             
            File fXmlFile = new File("C:/Users/Mehdi/Desktop/Brev/"+listefichiers[k]);
            Document doc = dBuilder.parse(fXmlFile);
            
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("fr-bibliographic-data");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                     
                    Node nNode = nList.item(temp);
     
                 //   System.out.println("\nCurrent Element :" + nNode.getNodeName());
     
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            
                            Element eElement = (Element) nNode;
                           
                                    
                            
                           // System.out.println("Titre : " + eElement.getElementsByTagName("invention-title").item(0).getTextContent());
                            listTitre.add(eElement.getElementsByTagName("invention-title").item(0).getTextContent().toLowerCase());
                        
                            
                    }
                    
                    

            }
            }
            	 }
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
     
    
    


}
