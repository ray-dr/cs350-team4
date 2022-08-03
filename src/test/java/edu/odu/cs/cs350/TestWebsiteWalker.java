package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestWebsiteWalker {

	@BeforeEach
    public void setUp()
    {
		WebSite website = new WebSite();
        WebsiteWalker walker = new WebsiteWalker(website);
    }
	
    @Test
    void TestNonDefualtConstractor() {
        fail("Not yet implemented");
    }
    
    @Test
    void TestFindByExtension() {
        fail("Not yet implemented");
    }
    
    @Test
    void TestPopulateAllPaths() {
        fail("Not yet implemented");
    }

    @Test
    void TestPopulatePagesToAnalyze() {
        fail("Not yet implemented");
    }
    
    @Test
    void TestPopulateWebsite() {
        fail("Not yet implemented");
    }
}
