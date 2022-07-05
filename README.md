Website Analysis

CS350, Old Dominion Univ., Summer 2022

Tuesday 4

* [Stories](https://trello.com/invite/b/8A9dWd5C/35d2e9bab555664f90f9aa84abcc998e/web-analysis)



Domain Model
* (https://www.planttext.com/)

@startuml

title Web Analysis Design - Initial Domain Model

class Website {
  Path localPath
  Collection<URL> siteURLs
  Collection<HTMLDocument> allPages
}

Class HTMLDocument {
  Path localPath
  Collection<StyleSheet> styles
  Collection<JavaScript> scripts
  Collection<Anchor> links
  Collection<Image> images
  
}

class Stylesheet {

}

class Script {
    URL path
    Classification linkType
    TargetType destinationType
}

class Image {
    URL path
    Classification linkType
    TargetType destinationType
}

class Anchor {
    URL path
    Classification linkType
    TargetType destinationType
}

enum Classification {
    INTERNAL
    INTRAPAGE
    EXTERNAL
}

enum TargetType {
    HTMLDOCUMENT
    ARCHIVE
    VIDEO
    AUDIO
}

class DocumentParser {

}

class WebsiteWalker {

}

class ExcelWriter {

}

class JSONWriter {

}

class TextWriter {

}

class CLI{
Validating Directory
Validating URL
Output Report File Names 
Input 
}

Website *-- HTMLDocument
DocumentParser -->"populates" HTMLDocument
