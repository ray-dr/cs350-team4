package edu.odu.cs.cs350;

import java.nio.file.Path;
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
        //not implemented yet
    }
    
    /*
     * Non-default constructor
     * @param locPath local path
     * @param urls is set of URLs
     */
    public WebSite(Path locPath, Collection<URL> urls)
    {
        //not implemented yet
    }
    
    /**
     * @return the localPath
     */
    public Path getLocalPath() {
        return localPath;
    }

    /**
     * @param localPath the localPath to set
     */
    public void setLocalPath(Path locPath) {
        this.localPath = locPath;
    }

    /**
     * @return the siteURLs
     */
    public Collection<URL> getSiteURLs() {
        return siteURLs;
    }

    /**
     * @param siteURLs the siteURLs to set
     */
    public void setSiteURLs(Collection<URL> siteURLs) {
        this.siteURLs = siteURLs;
    }

    /**
     * @return the allPages
     */
    public Collection<HTMLDocument> getAllPages() {
        return allPages;
    }

    /**
     * @param allPages the allPages to set
     */
    public void setAllPages(Collection<HTMLDocument> allPages) {
        this.allPages = allPages;
    }
    
    /**
     * @return the siteURLs size
     */
    public int numberOfURLs()
    {
        //not implemented yet
        return -1;
    }
    
    /**
     * @return the allPages size
     */
    public int numberOfPages()
    {
        //not implemented yet
        return -1;
    }
    
    public void AddURL(URL newURL)
    {
        //not implemented yet
    
    }
    
    public void AddPage(HTMLDocument newPage)
    {
        //not implemented yet
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
