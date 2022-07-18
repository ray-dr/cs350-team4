/**
 * 
 */
package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

/**
 *  1 - Does this piece of code perform the operations
 *      it was designed to perform?
 *
 *  2 - Does this piece of code do something it was not
 *      designed to perform?
 */


class TestHTMLDocument {

    HTMLDocument defaultHTML;
    Path testPath;
    String pathValue = "test/path";
    
    @BeforeEach
    public void setupThis() 
    {
       defaultHTML = new HTMLDocument();
       testPath = Paths.get(pathValue);
    }

    @Test
    public void testDefaultConstractor() 
    {
        assertNull(defaultHTML.getLocalPath());
        assertEquals(defaultHTML.numberOfImages(), 0);
        assertEquals(defaultHTML.toString(), "empty");
    }
    
    @Test
    public void testNonDefaultConstractor() 
    {
        HTMLDocument anotherHTML = new HTMLDocument(testPath);
        
        assertEquals(anotherHTML.getLocalPath(), testPath);
        assertEquals(anotherHTML.numberOfImages(), 0);
        assertEquals(anotherHTML.toString(), pathValue);
        
        assertNotEquals(anotherHTML.getLocalPath(), defaultHTML.getLocalPath());
        assertEquals(anotherHTML.numberOfImages(), defaultHTML.numberOfImages());
        assertNotEquals(anotherHTML.toString(), defaultHTML.toString());
        
    }
    
    @Test
    public void testSetLocalPath()
    {
        HTMLDocument newHTML = new HTMLDocument();
        newHTML.setLocalPath(testPath);
        
        assertEquals(newHTML.getLocalPath(), testPath);
        assertEquals(newHTML.numberOfImages(), 0);
        assertEquals(newHTML.toString(), pathValue);
        
        assertNotEquals(newHTML.getLocalPath(), defaultHTML.getLocalPath());
        assertEquals(newHTML.numberOfImages(), defaultHTML.numberOfImages());
        assertNotEquals(newHTML.toString(), defaultHTML.toString());
        
    }
    
    @Test
    public void testAddImage()
    {
        Image mockImage = new Image();
        defaultHTML.addImage(mockImage);
        
        assertNull(defaultHTML.getLocalPath());
        assertEquals(defaultHTML.numberOfImages(), 1);
        assertEquals(defaultHTML.toString(), "empty");
    }
    
}
