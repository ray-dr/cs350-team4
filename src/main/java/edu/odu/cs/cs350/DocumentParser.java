/**
 * 
 */
package edu.odu.cs.cs350;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	
	/**
     * A default SimpleHTMLParser can not be created.
     */
    private DocumentParser()
    {

    }

    public DocumentParser(String tag, String attribute)
    {
        this.theTag = tag;
        this.theAttribute = attribute;
    }
    
    public HTMLDocument parseHTML(Path thePath) throws IOException
    {
        HTMLDocument doc = new HTMLDocument(thePath);

        extractImages(doc);

        return doc;
    }

    
	private void extractImages(HTMLDocument doc) throws IOException {
		
		String content = Files.readString(doc.getLocalPath());
		
		//list of img tags
		List<Element> imgTags = new ArrayList<Element>();
		//list of all URLs as strings
		List<String> allURLStrings = new ArrayList<String>();
		
		imgTags = extractAllTags(content);
		allURLStrings = extractAllURIs(content);
		
		for(String s : allURLStrings)
		{
			URL url = new URL(s);
			Image newImage = new Image(url, doc.getLocalPath().toString());
			
			doc.addImage(newImage);
			
			
		}
		
	}
	
	/**
     * Extract all HTML tags.
     *
     * @param HTML source code
     *
     * @return list of all HTML tags
     */
    public List<Element> extractAllTags(String htmlSource)
    {
        Document doc = Jsoup.parse(htmlSource);
        Elements elements = doc.select(this.theTag);

        List<Element> elementList = new ArrayList<>();
        for (Element elm : elements) {
            elementList.add(elm);
        }

        return elementList;
    }
    
    /**
     * Extract all HTML tags.
     *
     * @param HTML source code
     *
     * @return list of all HTML tags
     */
    public List<Element> extractAllTags(BufferedReader htmlSource)
    {
        String htmlAsString = htmlSource.lines()
                .collect(Collectors.joining(System.lineSeparator()));

        return this.extractAllTags(htmlAsString);
    }
    
    /**
     * Extract all URIs from HTML tags with the required attribute.
     *
     * @param HTML source code
     *
     * @return list of all HTML tags
     */
    public List<String> extractAllURIs(String htmlSource)
    {
        Document doc = Jsoup.parse(htmlSource);
        Elements elements = doc.select(this.getJSoupSelector());

        List<String> elementList = new ArrayList<>();
        for (Element elm : elements) {
        	//implement checking path
            elementList.add(elm.attr(this.theAttribute));
        }

        return elementList;
    }
    
    /**
     * Extract all URIs from HTML tags with the required attribute.
     *
     * @param HTML source code
     *
     * @return list of all HTML tags
     */
    public List<String> extractAllURIs(BufferedReader htmlSource)
    {
        String htmlAsString = htmlSource.lines()
                .collect(Collectors.joining(System.lineSeparator()));

        return this.extractAllURIs(htmlAsString);
    }
    
    /**
     * Combine the specified tag and attribute for use in JSoup selector
     * syntax.
     *
     * @returns Jsoup style selector
     */
    public String getJSoupSelector()
    {
        return String.format("%s[%s]", this.theTag, this.theAttribute);
    }
	
}
