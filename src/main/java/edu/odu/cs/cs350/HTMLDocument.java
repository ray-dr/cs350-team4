/**
 * 
 */
package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.util.Collection;

/**
 * HTMLDocument represents an HTML page of a website.
 */
public class HTMLDocument {
    
    private Path localPath;
    private Collection<Image> images;
    
    /**
     * Create an empty HTML object with localPath set to null
     * and empty set of collection of images
     */
    public HTMLDocument()
    {
        //not implemented yet
    }
    
    /**
     * Create an empty HTML object with localPath set to @param
     * and empty set of collection of images.
     * @param newPath is a path of image
     */
    public HTMLDocument(Path newPath)
    {
        //not implemented yet
    }

    /**
     * @return the images
     */
    public Collection<Image> getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    //public void setImages(Collection<Image> images) {
    //    this.images = images;
    //}

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
        return -1;
    }
    
    /*
     * An image can be added to collection of images only once
     * @param newImage is image object to be added to collection of images
     */
    public boolean addImage(Image newImage)
    {
        //not implemented yet
        return false;
    }
    
    /*
     * Returns localPath as a string
     */
    public String toString()
    {
        return localPath.toString();
    }
    
    
    
    
}
