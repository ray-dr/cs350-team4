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

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

/**
 *  Class to parse an HTML file and extract urls based on tag and attribute
 *  passed to constructor
 */
public class DocumentParser {
	
	private String theTag;
	private String theAttribute;

	/**
     * A default DocumentParser can not be created.
     */
    private DocumentParser()
    {

    }
    
    /*
     * Non-default constructor
     * @param tag is a tag to be extracted
     * @param attribute is a attribute to be extracted
     */
    public DocumentParser(String tag, String attribute)
    {
        this.theTag = tag;
        this.theAttribute = attribute;
    }
    
    /*
     * Parse an HTML document
     * @param thePath is path to the HTML document to be parsed
     * @return parsed HTMLDocument
     */
    public HTMLDocument parseHTML(Path thePath) throws IOException
    {
        HTMLDocument doc = new HTMLDocument(thePath);

        extractImages(doc);

        return doc;
    }

    /*
     * Extract image tags and URIs
     * @param is an HTML document from which img tags and URIs to be extracted
     */
	private void extractImages(HTMLDocument doc) throws IOException {
		
		String content = Files.readString(doc.getLocalPath());
		
		//list of img tags
		List<Element> imgTags = new ArrayList<Element>();
		
		//list of all URIs as strings
		List<String> allURIStrings = new ArrayList<String>();
		
		imgTags = extractAllTags(content);
		allURIStrings = extractAllURIs(content);
		
		for(String s : allURIStrings)
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
