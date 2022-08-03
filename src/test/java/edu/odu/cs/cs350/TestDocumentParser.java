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
 * 1 - Does this piece of code perform the operations
 *     it was designed to perform?
 *
 * 2 - Does this piece of code do something it was not
 *     designed to perform?
 *
 * 1 Test per mutator
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestDocumentParser
{
    @BeforeEach
    public void setUp()
    {
        // Placeholder
    }

    @Test
    public void testExtractImage()
    {
        String htmlSource = "<img src=\"img_girl.jpg\" alt=\"Girl in a jacket\" width=\"500\" height=\"600\">";

        DocumentParser simple = new DocumentParser("img", "src");

        List<Element> imgList = simple.extractAllTags(htmlSource);

        assertThat(imgList, is(notNullValue()));
        assertThat(imgList.size(), equalTo(1));
    }

    @Test
    public void testExtractImages()
        throws IOException, FileNotFoundException
    {
        BufferedReader htmlSource = new BufferedReader(new FileReader("src/test/resources/cs417-one-lecture/index.html"));

        DocumentParser simple = new DocumentParser("img", "src");

        List<Element> imgList = simple.extractAllTags(htmlSource);

        assertThat(imgList, is(notNullValue()));
        assertThat(imgList.size(), equalTo(6));
    }

    @Test
    public void testExtractImageURI()
    {
    	String htmlSource = "<img src=\"img_girl.jpg\" alt=\"Girl in a jacket\" width=\"500\" height=\"600\">";

    	DocumentParser simple = new DocumentParser("img", "src");

        List<String> imgList = simple.extractAllURIs(htmlSource);

        assertThat(imgList, is(notNullValue()));
        assertThat(imgList.size(), equalTo(1));
        assertThat(imgList.get(0), equalTo("img_girl.jpg"));
    }

    @Test
    public void testExtractImageURIs()
        throws IOException, FileNotFoundException

    {
        BufferedReader htmlSource = new BufferedReader(new FileReader("src/test/resources/cs417-one-lecture/index.html"));

        DocumentParser simple = new DocumentParser("img", "src");

        List<String> imgList = simple.extractAllURIs(htmlSource);

        assertThat(imgList, is(notNullValue()));
        assertThat(imgList.size(), equalTo(6));

        Iterator<String> it = imgList.iterator();
        assertThat(it.next(), equalTo("../../graphics/home.png"));
        assertThat(it.next(), containsString("./../graphics/email.png"));
        assertThat(it.next(), containsString("integralDI1.png"));
        assertThat(it.next(), containsString("integralDI2.png"));
        assertThat(it.next(), equalTo("../../graphics/home.png"));
        assertThat(it.next(), containsString("./../graphics/email.png"));
    }
}

