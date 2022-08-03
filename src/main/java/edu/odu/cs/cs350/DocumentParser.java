/**
 * 
 */
package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.io.BufferedReader;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;




/**
 *  Parse an HTML file
 */
public class DocumentParser {
	private String theTag;
	private String theAttribute;



	private DocumentParser(){

	}


	public DocumentParser(String tag, String attribute){
		
		this.theTag = tag;
		this.theAttribute = attribute;

		}

		/*Extract tags 
		 * @param source code 
		 * 
		 * @param return list of all tags 
		 */

		 public List<Element> extractAllTags(BufferedReader htmlSource){

			Document doc = Jsoup.parse(htmlSource);
			Elements elements = doc.select(this.theTag);

			List<Element> elementList = new ArrayList<>();
			for (Element elm : elements) {
				elementList.add(elm);
			}
			
		 }
	
	
}
