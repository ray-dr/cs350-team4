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
    * Creates an image with empty path and linkType
    * 
    */
    public Image()
    {
        //not implemented yet
    }
    
    /**
    * Creates an image 
    * @param locPath is path of image
    * 
    */
    public Image(String locPath, Classification type) 
    {
        //not implemented yet
    }

    /**
     * @return the linkType
     */
    public Classification getLinkType() 
    {
        //not implemented yet
        return linkType;
    }

    /**
     * @param locPath to compare to path
     * linkType is set to INTERNAL if locPath==path
     * linkType is set to INTRAPAGE if path contains a locPath
     * linkType is set to EXTERNAL if  path doesn't contain locPath 
     *  
     */
    public void setLinkType(Path locPath) 
    {
        //not implemented yet
    }

    /**
     * @return the path
     */
    public URL getPath() {
        //not implemented yet
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(Path path) {
        //not implemented yet
    }
    
    public String toString()
    {
        return "not implemented yet";
    }
    
}