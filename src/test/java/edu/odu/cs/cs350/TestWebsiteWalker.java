package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import java.net.MalformedURLException;
import java.net.URL;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * 1 - Does this piece of code perform the operations
 *     it was designed to perform?
 *
 * 2 - Does this piece of code do something it was not
 *     designed to perform?
 *
 * 1 Test per mutator
 */

class TestWebsiteWalker {
	
	final String PATH = "src/test/resources/cs417-one-lecture/index.html";
	final String URL = "https://www.cs.odu.edu/~tkennedy/cs417/sum22/Public/leastSquaresExampleSinx/";
	final String EXTENSION = ".html";
	Path path;
	URL theURL;
	List<URL> listURLs;
	WebSite website;
	WebsiteWalker walker;
	List<Path> allPaths;

	@BeforeEach
    public void setUp() throws IOException
    {
		path = Paths.get(PATH);
		listURLs = new ArrayList<URL>();
		theURL = new URL(URL);
		listURLs.add(theURL);
		website = new WebSite(path, listURLs);
        walker = new WebsiteWalker(website);
        allPaths = new ArrayList<Path>();
        
        allPaths = walker.findByFileExtension(path, EXTENSION);
        walker.populateAllPaths();
    	walker.populatePagesToAnalyze();
    }
    
    @Test
    void TestFindByExtension() throws IOException {

        //List<Path> allPaths = new ArrayList<Path>();
        
        //allPaths = walker.findByFileExtension(path, EXTENSION);
    	
        Iterator<Path> it = allPaths.iterator();
        
        assertEquals(allPaths.size(), 1);
        assertTrue(it.hasNext());
        assertThat(it.next().getFileName().toString(), containsString(EXTENSION));
        
    }

    @Test
    void TestPopulatePagesToAnalyze() throws IOException {
        
    	//walker.populateAllPaths();
    	//walker.populatePagesToAnalyze();
    	
    	Iterator<HTMLDocument> it = walker.iteratorPagesToAnalyze();
    	
    	assertTrue(it.hasNext());
    	assertThat(it.next().getLocalPath().toString(), containsString(EXTENSION));

    	
    }
    
    @Test
    void TestPopulateWebsite() throws IOException {
    	//not implemented yet
    }
}
