/**
 * 
 */
package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.BeforeAll;
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

    HTMLDocument newHTML;
    

    @BeforeEach
    public void setupThis() 
    {
       newHTML = new HTMLDocument();
    }

    @Test
    public void testDefaultConstractor() 
    {
        fail("Not yet implemented");
    }
    
    @Test
    public void testNonDefaultConstractor() 
    {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSetPath()
    {
        fail("Not yet implemented");
    }
    
    @Test
    public void testAddImage()
    {
        fail("Not yet implemented");
    }
    
}
