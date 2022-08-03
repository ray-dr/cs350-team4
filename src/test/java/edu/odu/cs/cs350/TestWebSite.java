
package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *  1 - Does this piece of code perform the operations
 *      it was designed to perform?
 *
 *  2 - Does this piece of code do something it was not
 *      designed to perform?
 */

class TestWebSite {

    WebSite defaultWebsite;
    WebSite newWebsite;
    static final String TEST_PATH = "src/test/resources/cs417-one-lecture";
    static final String TEST_URL = "https://www.cs.odu.edu/~tkennedy/cs417/sum22/Public/leastSquaresExampleSinx/";
    Path path;
    URL url;
    
    @BeforeEach
    public void setUp() throws Exception {
        defaultWebsite = new WebSite();
    }

    @Test
    public void testDefaultConstructor() 
    {
        assertNull(defaultWebsite.getLocalPath());
        
        assertEquals(defaultWebsite.numberOfURLs(), 0);
        assertEquals(defaultWebsite.numberOfPages(), 0);
    }
    
    @Test
    public void testNonDefaultConstractor() throws MalformedURLException 
    {
        path = Paths.get(TEST_PATH);
        url = new URL(TEST_URL);
        List<URL> testCollection = new ArrayList<URL>();
        testCollection.add(url);
        
        newWebsite = new WebSite(path, testCollection);
        
        assertEquals(newWebsite.getLocalPath(), path);
        assertEquals(newWebsite.numberOfURLs(), 1);
        assertEquals(newWebsite.numberOfPages(), 0);
    }
    
    @Test
    public void testAddPage() 
    {
        HTMLDocument newPage = new HTMLDocument();
        newWebsite = new WebSite();
        newWebsite.AddPage(newPage);
        
        assertNull(newWebsite.getLocalPath());
        
        assertEquals(newWebsite.numberOfPages(), 1);
        assertEquals(newWebsite.numberOfURLs(), 0);
        
        //test iterator
        assertTrue(newWebsite.itPages().hasNext());
        assertEquals(newWebsite.itPages().next(), newPage);
        
    }
    
    @Test
    public void testSetLocalPath()
    {
    	newWebsite = new WebSite();
    	path = Paths.get(TEST_PATH);
    	newWebsite.setLocalPath(path);
    	
    	assertEquals(newWebsite.getLocalPath(), path);
    	assertNotEquals(newWebsite.getLocalPath(), defaultWebsite.getLocalPath());
    	assertEquals(newWebsite.numberOfURLs(),0);
    	assertEquals(newWebsite.numberOfPages(),0);
    	
    }
    
    @Test
    public void testSetSiteURLs() throws MalformedURLException
    {
    	newWebsite = new WebSite();
    	url = new URL(TEST_URL);
    	ArrayList<URL> newList = new ArrayList<URL>();
    	newList.add(url);
    	newWebsite.setSiteURLs(newList);
    	
    	assertEquals(newWebsite.numberOfURLs(), 1);
    	assertNotEquals(newWebsite.numberOfURLs(), defaultWebsite.numberOfURLs());
    	assertEquals(newWebsite.getLocalPath(), defaultWebsite.getLocalPath());
    	assertEquals(newWebsite.numberOfPages(),0);
    	
    	//test iterator
    	assertTrue(newWebsite.itURLs().hasNext());
    	assertEquals(newWebsite.itURLs().next(), url);
    	
    }
    
}
