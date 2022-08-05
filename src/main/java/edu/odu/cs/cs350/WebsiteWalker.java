/**
 * 
 */
package edu.odu.cs.cs350;

import java.nio.file.Path;
import static java.nio.file.FileVisitResult.*;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  WebsiteWalker is a class to walk through directory and identify
 *  pages to be analyzed. It invokes DocumentParser class to parse and analyze pages,
 *  then it populates WebSite object with extracted information.
 *
 */
public class  WebsiteWalker{
    
	private List<Path> allPaths;
	private List<HTMLDocument> pagesToAnalyze;
	private WebSite website;
	private DocumentParser parser;
    
	
	/*
     * Default constructor cannot be created
     */
    private WebsiteWalker()
    {

    }
    
    /*
     * Non-default constructor
     * @param websiteCopy is a copy of website to be analyzed
     */
    public WebsiteWalker(WebSite websiteCopy)
    {
    	website = websiteCopy;
    	allPaths = new ArrayList<Path>();
    	pagesToAnalyze = new ArrayList<HTMLDocument>();
    }
    
    
    /*
     * Finds all files with passed fileExtension within passed path
     * @param path os a path to the copy of website
     * @param fileExtension is extension of pages that are needed to be analyzed
     * @return list of files' paths with provided fileExtension within provided directory
     */
    public List<Path> findByFileExtension(Path path, String fileExtension) throws IOException
    {   
        try (Stream<Path> walk = Files.walk(path))
        {
        	allPaths = walk
        			   .filter(Files::isRegularFile)
        			   .filter(p -> p.getFileName().toString().endsWith(fileExtension))
        			   .collect(Collectors.toList());
        }
        
        return allPaths;
        
    }
    
    
    /*
     * Populates allPaths with paths to html pages within directory of website
     */
    public void populateAllPaths() throws IOException
    {
    	final String EXTENSION = ".html";
    	allPaths = findByFileExtension(website.getLocalPath(), EXTENSION);
    }
    
    /*
     * Populates allPages with HTMLDocuments containing paths to them
     */
    public void populatePagesToAnalyze()
    {
    	for(Path p : allPaths)
    	{
    		HTMLDocument newPage = new HTMLDocument(p.getFileName());
    		pagesToAnalyze.add(newPage);
    	}
    }
    
    /*
     * Return iterator over pagesToAnalyze
     */
    public Iterator<HTMLDocument> iteratorPagesToAnalyze()
    {
    	return pagesToAnalyze.iterator();
    }
    
    /*
     * Populate website object with collection of HTML Documents to be analized
     */
    public WebSite populateWebsite() throws IOException
    {
    	//extract img tag
    	final String TAG = "img";
    	final String ATTR = "src";
    	parser = new DocumentParser(TAG, ATTR);
    	
    	for(HTMLDocument page : pagesToAnalyze)
    	{
    		this.website.AddPage(parser.parseHTML(page.getLocalPath()));
    	}
    	
    	
    	return this.website;
    }
    
}
