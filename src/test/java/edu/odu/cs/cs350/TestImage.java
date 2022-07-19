/**
 * 
 */
package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *  1 - Does this piece of code perform the operations
 *      it was designed to perform?
 *
 *  2 - Does this piece of code do something it was not
 *      designed to perform?
 */

class TestImage {

    Image defaultImage;
    Image newImage;
    URL testPath;
    String testURL = ("http://test.url");
    Classification internal = Classification.INTERNAL;
    Classification intrapage = Classification.INTRAPAGE;
    Classification external = Classification.EXTERNAL;
    
    @BeforeEach
    public void setupThis() throws MalformedURLException 
    {
        defaultImage = new Image();
        testPath = new URL(testURL);
    }

    @Test
    public void testDefualtConstructor() 
    {
        assertNull(defaultImage.getPath());
        assertEquals(defaultImage.getLinkType(), external);
        assertThat(defaultImage.toString(), 
                   containsString(Classification.EXTERNAL.name()));
        
    }
    
    @Test
    public void testNonDefualtConstructor() 
    {
        newImage = new Image(testPath, intrapage);
        
        assertEquals(newImage.getPath(), testPath);
        assertEquals(newImage.getLinkType(), intrapage);
        assertThat(newImage.toString(), 
                containsString(Classification.INTRAPAGE.name()));
        
        assertNotEquals(defaultImage.getPath(), newImage.getPath());
        assertNotEquals(defaultImage.getLinkType(), newImage.getLinkType());
        assertNotEquals(defaultImage.toString(), newImage.toString());
        
    }
    
    @Test
    public void testSetLinkType() 
    {
        newImage = new Image();
        newImage.setLinkType(internal);
        
        assertNull(newImage.getPath());
        assertEquals(newImage.getLinkType(), internal);
        assertThat(newImage.toString(), 
                containsString(Classification.INTERNAL.name()) );
        
        assertEquals(defaultImage.getPath(), newImage.getPath());
        assertNotEquals(defaultImage.getLinkType(), newImage.getLinkType());
        assertNotEquals(defaultImage.toString(), newImage.toString());
        
    }
    
    @Test
    public void testSetPath() 
    {
        newImage = new Image();
        newImage.setPath(testPath);
        
        assertEquals(newImage.getPath(), testPath);
        assertEquals(newImage.getLinkType(), external);
        assertThat (newImage.toString(), 
                containsString(Classification.EXTERNAL.name()) );
        
        assertNotEquals(newImage.getPath(), defaultImage.getPath());
        assertEquals(newImage.getLinkType(), defaultImage.getLinkType());
        assertEquals(defaultImage.toString(), newImage.toString());
        
    }

}
