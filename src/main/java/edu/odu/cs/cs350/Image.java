/**
 * 
 */
package edu.odu.cs.cs350;

import java.net.URL;
import java.nio.file.Path;

/**
 *  Image is an object that contains URL and
 *  classification based on URL.
 *
 */
public class Image {
    
    private URL path;
    private Classification linkType;
    
    /**
    * Create an image with empty path and linkType
    * path is assigned to null
    * linkType is assigned as external by default
    */
    public Image()
    {
        path = null;
        linkType = Classification.EXTERNAL;
    }
    
    /**
    * Create an image object
    * @param url is path to image
    * @param locPath is a path to directory
    * 
    */
    public Image(URL url, String locPath) 
    {
        path = url;
        classifyImage(locPath);
    }
    
    /*
     * Classify a linkType
     * @param locPath is a path to directory
     */
    private void classifyImage(String locPath)
    {

    	if(this.path.toString().contains(locPath))
    	{
    		this.linkType = Classification.INTERNAL;
    	}
    	else {
    		this.linkType = Classification.EXTERNAL;
    	}
    }
    
    /**
    * Create an image 
    * @param locPath is path of image
    * 
    */
    public Image(URL url, Classification type) 
    {
        path = url;
        linkType = type;
    }

    /**
     * Return linkType
     * @return the linkType
     */
    public Classification getLinkType() 
    {
        return linkType;
    }

    /**
     * Set linkType
     * @param type classifies the image
     * linkType is set to INTERNAL if locPath==path
     * linkType is set to INTRAPAGE if path contains a locPath
     * linkType is set to EXTERNAL if  path doesn't contain locPath 
     *  
     */
    public void setLinkType(Classification type) 
    {
        linkType = type;
    }

    /**
     * Return path
     * @return the path
     */
    public URL getPath() {

        return path;
    }

    /**
     * Set path
     * @param testPath the path to set
     */
    public void setPath(URL imageURL) {
        path = imageURL;
    }
    
}