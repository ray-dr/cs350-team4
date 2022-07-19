/**
 * 
 */
package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 *
 */
class TestImage {

    Image defaultImage;
    URL testPath;
    String testURL = ("http://test.url");
    
    @BeforeEach
    public void setupThis() throws MalformedURLException 
    {
        defaultImage = new Image();
        testPath = new URL(testURL);
    }

    @Test
    public void testDefualtConstructor() 
    {
        fail("not implemented yet");
        
    }
    
    @Test
    public void testNonDefualtConstructor() 
    {
        fail("not implemented yet");
        
    }
    
    @Test
    public void testSetLinkType() 
    {
        fail("not implemented yet");
        
    }
    
    @Test
    public void testSetPath() 
    {
        fail("not implemented yet");
        
    }

}
