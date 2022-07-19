<<<<<<< HEAD

package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

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
    static final String TEST_PATH = "http://test.url.com";
    static final String TEST_URL = "http://test.url.com/just/some/test";
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
        Collection<URL> testCollection = new ArrayList<URL>();
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
    }
    
=======
package edu.odu.cs.cs350;

public class TestWebSite
{

>>>>>>> a58a4cfc523cac2a95ae5ebedfea3adf6a9c7973
}
