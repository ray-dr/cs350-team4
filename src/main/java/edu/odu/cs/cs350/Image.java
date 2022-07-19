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
    * path is assigned to null
    * linkType is assigned as external by default
    */
    public Image()
    {
        path = null;
        linkType = Classification.EXTERNAL;
    }
    
    /**
    * Creates an image 
    * @param locPath is path of image
    * 
    */
    public Image(URL locPath, Classification type) 
    {
        path = locPath;
        linkType = type;
    }

    /**
     * @return the linkType
     */
    public Classification getLinkType() 
    {
        return linkType;
    }

    /**
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
     * @return the path
     */
    public URL getPath() {

        return path;
    }

    /**
     * @param testPath the path to set
     */
    public void setPath(URL imageURL) {
        path = imageURL;
    }
    
    public String toString()
    {
        return linkType.name();
    }
    
}