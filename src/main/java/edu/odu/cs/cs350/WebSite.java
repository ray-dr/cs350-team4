package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/*
 * Website is a collection of HTML documents.
 * localPath  is path to local copy of the site
 * siteURLs is collection of URLs passed as arguments to main
 * allPages contains pages to be analyzed
 */

public class WebSite
{
    private Path localPath;
    private List<URL> siteURLs;
    private List<HTMLDocument> allPages;
    
    
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
    public WebSite(Path locPath, List<URL> urls)
    {
        //is this valid assignment?
        localPath = locPath;
        siteURLs = new ArrayList<URL>(urls);
        allPages = new ArrayList<HTMLDocument>();
    }
    
    /**
     * Return localPath
     * @return the localPath
     */
    public Path getLocalPath() 
    {
        return localPath;
    }

    /**
     * Set localPath to passed parameter
     * @param localPath the localPath to set
     */
    public void setLocalPath(Path path) 
    {
        this.localPath = path;
    }

    /**
     * Set siteURLs to passed parameter
     * @param siteURLs is a collection of of urls
     */
    public void setSiteURLs(List<URL> urls) 
    {
       siteURLs = urls;
    }
    
    /**
     * Return size of siteURLs
     * @return the siteURLs size
     */
    public int numberOfURLs()
    {
        return siteURLs.size();
    }
    
    /**
     * Returns size of allPages
     * @return the allPages size
     */
    public int numberOfPages()
    {
        return allPages.size();
    }
    
    /*
     * Add @newPage to allPages
     * 
     */
    public void AddPage(HTMLDocument newPage)
    {
        allPages.add(newPage);
    }
    
    /*
     * Return Iterator over all allPages
     */
    public Iterator<HTMLDocument> itPages()
    {
        return allPages.iterator();
    }
    
    /*
     * Return Iterator over siteURLs
     */
    public Iterator<URL> itURLs()
    {
        return siteURLs.iterator();
    }
    
 }


