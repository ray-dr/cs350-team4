package edu.odu.cs.cs350;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;  
/*
Each file shall be named using the data and time the processing started.
File names will take the form YYYYMMDD-hhmmss-summary.{json,txt,xlsx} where:
- YYYY is the 4-digit year - 20xx
- MM is the 2-digit month (zero padded) - 01 to 12
- DD is the 2-digit day (zero padded) - 01 to 31
- hh is the 2-digit hour (zero padded) - 00 to 23
- mm is the 2-digit minute (zero padded) - 00 to 59
- ss is the 2-digit second (zero padded) - 00 to 59
 */
public class CLI {

    private Path localPath;
	private List<URL> siteURLs;
    
    /*
     * Default Constructor
     */
    public CLI()
    {
    	localPath = null;
    	siteURLs = new ArrayList<URL>();
    }
    
    /*
     * Non-default Constructor
     * Takes array of strings 
     * first element of array is a path
     * the rest of elements are urls
     */
    public CLI(String[] args)
    {
        if(isValidPath(args[0]))
        {
        	localPath = Paths.get(args[0]);
        }
        else
        {
        	//print error message
        }
        
        
        for(int i=1; i < args.length; i++)
        {
        	//check if URL is malformed
        		//discard
        	//otherwise
        		//add to siteURLs
        }
        
    }
    
    /*
     * Return localPath
     */
    public Path getLocalPath() {
		return localPath;
	}

    /*
     * Set localPath
     */
	public void setLocalPath(Path localPath) {
		this.localPath = localPath;
	}

	/*
     * Return siteURLs
     */
	public List<URL> getSiteURLs() {
		return siteURLs;
	}
	
	/*
	 * Returns size of siteURLs
	 */
	public int numberOfURLs()
	{
		return siteURLs.size();
	}

	/*
     * Set siteURLs
     */
	public void setSiteURLs(List<URL> siteURLs) {
		this.siteURLs = siteURLs;
	}
    
    /*
     * Takes a path to a local directory and checks if it's valid
     * If path is valid it's assigned to localPath and return true
     * Otherwise return false
     */
    public boolean isValidPath(String path)
    {
    	//not implemented yet
    	return false;
    }
    
    /*
     * Takes an URL and checks if it's malformed
     */
    public boolean isMalformed(String testUrl)
    {
    	//not implemented yet
    	return true;
    }
    
    /*
     * Takes arguments from command line and checks if URLs are valid.
     * If URL is malformed it's discarded
     * Otherwise it's added to siteURLs
     */
    public void populateSiteURLs()
    {
    	//not implemeted yet
    }
    
    
	/*
	Collects system date and time, formats the output, and saves it to a string.
	*/  
    public String outputDateTime()
    {
        DateTimeFormatter systemTime = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss-"); 
        LocalDateTime timeStamp = LocalDateTime.now();
        String outputDateTime = systemTime.format(timeStamp);
        return outputDateTime;
    }
  
	// Placeholder
    public String fileSummary()
    {
        return fileSummary();
    }
    
	// Placeholder
    public String fileExtention()
    {
        return fileExtention();
    }
    
}
