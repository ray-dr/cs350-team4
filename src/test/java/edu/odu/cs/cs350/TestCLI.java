package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
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

class TestCLI {

	Path path;
	CLI defaultCLI;
    static final String TEST_PATH = "http://test.url.com";
    static final String TEST_URL = "http://test.url.com/just/some/test";
    static final String MALFORMED_URL = "http:/\test.url.com/just/some/test";
    static final String[] TEST_ARRAY = { TEST_PATH, TEST_URL, MALFORMED_URL };
    
    @BeforeEach
    public void setupThis() throws MalformedURLException 
    {
    	defaultCLI = new CLI();
    }

    @Test
    public void testDefualtConstructor() 
    {
    	assertNull(defaultCLI.getLocalPath());    
        assertEquals(defaultCLI.numberOfURLs(), 0);  
        assertTrue(defaultCLI.isValidPath(TEST_PATH));
        assertFalse(defaultCLI.isMalformed(TEST_URL));
        assertTrue(defaultCLI.isMalformed(MALFORMED_URL));
        
    }
    
    @Test
    public void testNonDefualtConstructor() 
    {
    	CLI newCLI = new CLI(TEST_ARRAY);
 
        
    }
    
    
} 
    