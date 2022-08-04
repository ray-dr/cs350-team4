/**
 * 
 */
package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * HTMLDocument represents an HTML page of a website.
 */
public class HTMLDocument {
    
    private Path localPath;
    private List<Image> images;
    
    /**
     * Create an empty HTML object with localPath set to null
     * and empty set of collection of images
     */
    public HTMLDocument()
    {
        localPath = null;
        images = new ArrayList<Image>();
    }
    
    /**
     * Create an empty HTML object with localPath set to @param
     * and empty set of collection of images.
     * @param newPath is a path of image
     */
    public HTMLDocument(Path newPath)
    {
        localPath = newPath;
        images = new ArrayList<Image>();
    }

    /**
     * @return the images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(List<Image> images) {
        this.images = images;
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
    public void setLocalPath(Path localPath) {
        this.localPath = localPath;
    }
    
    /*
     * returns number of images in collection
     */
    public int numberOfImages()
    {
        return images.size();
    }
    
    /*
     * An image can be added to collection of images only once
     * @param newImage is image object to be added to collection of images
     */
    public boolean addImage(Image newImage)
    {
        if(images.contains(newImage))
        {
            return false;
        }
        
        images.add(newImage);
        return true;
    }
    

}
