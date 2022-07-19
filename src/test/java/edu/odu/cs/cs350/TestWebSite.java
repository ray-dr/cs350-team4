<<<<<<< HEAD
/**
 * 
 */
package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeAll;
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
    static final String TEST_PATH = "http;//test.url.com";
    static final String TEST_URL = "http;//test.url.com/just/some/test";
    Path path;
    URL url;
    
    @BeforeAll
    public void setUpBeforeClass() throws Exception {
        defaultWebsite = new WebSite();
    }

    @Test
    public void testDefaultConstructor() 
    {
        assertNull(defaultWebsite.getLocalPath());
        assertNull(defaultWebsite.getSiteURLs());
        assertNull(defaultWebsite.getAllPages());
        
        assertEquals(defaultWebsite.numberOfURLs(), 0);
        assertEquals(defaultWebsite.numberOfPages(), 0);
    }
    
    @Test
    public void testNonDefaultConstractor() throws MalformedURLException 
    {
        path = Paths.get(TEST_PATH);
        url = new URL(TEST_URL);
        Collection<URL> testCollection = new ArrayList<URL>();
        testCollection.add(url);
        
        newWebsite = new WebSite(path, testCollection);
        
        assertEquals(newWebsite.getLocalPath(), path);
        assertEquals(newWebsite.getSiteURLs(), testCollection);
        assertNull(newWebsite.getAllPages());
        
        assertEquals(newWebsite.numberOfURLs(), 1);
        assertEquals(newWebsite.numberOfPages(), 0);
    }
    
    @Test
    public void testAddURL() throws MalformedURLException 
    {
        url = new URL(TEST_URL);
        newWebsite = new WebSite();
        newWebsite.AddURL(url);
        
        assertNull(newWebsite.getLocalPath());
        assertNull(newWebsite.getAllPages());
        assertNotNull(newWebsite.getSiteURLs());
        
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
        assertNull(newWebsite.getSiteURLs());
        assertNotNull(newWebsite.getAllPages());
        
        assertEquals(newWebsite.numberOfPages(), 1);
        assertEquals(newWebsite.numberOfURLs(), 0);
    }
    
    @Test
    public void testToString() 
    {
        fail("Not yet implemented");
    }
=======
package edu.odu.cs.cs350;
>>>>>>> 20ef6563474dd749e09588709249d0a9d7756fad

}
