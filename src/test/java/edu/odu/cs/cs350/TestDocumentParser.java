/**
 * 
 */
package edu.odu.cs.cs350;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.IsNull;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 */
class TestDocumentParser {

    @BeforeEach
    public void setUp(){
        //not yet implemented 
    }

    @Test
    public void testExtractAnchor() {
       
    String htmlSource = <a href='https://www.google.com'>Google Search!</a>";
    DocumentParser document = new DocumentParser("a", "href");  

    List<Element> anchors = document.extractAllTags(htmlSource);

    assertThat(anchors, is(notNullValue()));
    assertThat(anchors.size(), equalTo(1));

}

@Test 
public void testExtractAnchors()
throws IOException, FileNotFoundException
{
    BufferedReader htmlSource = new BufferedReader(new FileReader("src/test/resources/anchors.html"));

    DocumentParser document = new DocumentParser("a", "href" );
    
    List<Element> anchors = document.extractAllTags(htmlSource);

    assertThat(anchors, is(notNullValue()));
    assertThat(anchors.size(), equalTo(2));

}

@Test 
public void testExtractSnchorURI(){

    String htmlSource = "<a href= ";

    DocumentParser document = new DocumentParser("a", "href");

    List<String> anchors = document.extractAllURIs(htmlSource);

    assertThat(anchors, is(notNullValue()));
    assertThat(anchors.size(), equalTo(1));
    assertThat(anchors.get(0), equalTo("https://www.google.com"));
}

@Test 
public void testExtractAnchorURIs()
throws IOException, FileNotFoundException
{
    BufferedReader htmlSource = new DocumentParser("a", "href");

    List<String> anchors = document.extractAllURIs(html source);
    
    assertThat(anchors, is(notNullValue()));
    assertThat(anchors.size(), equalTo(2));

    Iterator<String> uriIt = anchors.iterator();
    assertThat(uriIt.next(), equalTo("https://www.cs.odu.edu/~tkennedy/cs350/sum22/Directory/outline/"));
    assertThat(uriIt.next(), equalTo("https://www.cs.odu.edu/~tkennedy/cs417/sum22/Directory/outline/"));
}


}
