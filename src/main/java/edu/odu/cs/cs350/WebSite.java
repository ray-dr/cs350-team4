package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.net.URL;
import java.util.Iterator;

/*
 * Website is a collection of HTML documents.
 * localPath  is path to local copy of the site
 * siteURLs is collection of URLs passed as arguments to main
 * allPages contains pages to be analyzed
 */

public class WebSite
{
    private Path localPath;
    private Collection<URL> siteURLs;
    private Collection<HTMLDocument> allPages;
    
    
    /*
     * Default constructor
     * Set localPath to null
     * siteURLs and allPages are empty
     */
    public WebSite()
    {
        localPath = null;
        siteURLs = new ArrayList<URL>();
        allPages = new ArrayList<HTMLDocument>();
    }
    
    /*
     * Non-default constructor
     * @param locPath is a local path to website copy
     * @param urls is a collection of URLs
     */
    public WebSite(Path locPath, Collection<URL> urls)
    {
        localPath = locPath;
        siteURLs = urls;
        allPages = new ArrayList<HTMLDocument>();
    }
    
    /**
     * @return the localPath
     */
    public Path getLocalPath() 
    {
        return localPath;
    }

    /**
     * @param localPath the localPath to set
     */
    public void setLocalPath(Path locPath) 
    {
        this.localPath = locPath;
    }

    /**
     * @param siteURLs is a collection of of urls
     */
    public void setSiteURLs(Collection<URL> urls) 
    {
       siteURLs = urls;
    }
    
    /**
     * @return the siteURLs size
     */
    public int numberOfURLs()
    {
        return siteURLs.size();
    }
    
    /**
     * @return the allPages size
     */
    public int numberOfPages()
    {
        return allPages.size();
    }
    
    public void AddPage(HTMLDocument newPage)
    {
        allPages.add(newPage);
    }
    
    /*
     * return Iterator over all HTML documents
     */
    public Iterator<HTMLDocument> itPages()
    {
        return allPages.iterator();
    }
    
    /*
     * return Iterator over all HTML documents
     */
    public Iterator<URL> itURLs()
    {
        return siteURLs.iterator();
    }
    
 }
