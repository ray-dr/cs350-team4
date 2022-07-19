package edu.odu.cs.cs350;

import java.time.format.DateTimeFormatter;  
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
