Website Analysis

CS350, Old Dominion Univ., Summer 2022

Tuesday 4

* [Stories](https://trello.com/invite/b/8A9dWd5C/35d2e9bab555664f90f9aa84abcc998e/web-analysis)



Initial Domain:

![Initial](https://www.planttext.com/api/plantuml/png/hLDDJyCm3BttLrWSaVeNaAgsGD7MJgNRk8RER1PkKYMfj6dYlvE4TT32aLlydlty6KkM4RRu2eaKV39a84D3Uman598i2OPCTO8aBDKEEMfP6EC335c4SmIm4lO0h5h1_kM0L35ZQqb9y4xhUc6cg63dkaUFVaHf47nibejCjKE7qi8PVid2JDUU6CqSR3NrTeuooVSvHjqr_QMXvo1uG7JPemaHHBzASfr0FnRZMNgZLbopDASUFTK8lKSRh1qQIpAuZEnLkV15_9FmJzr4jWUb_wrYfujowERXGRuecxmkayNbNIUhv27tHlxoJOm2FvA4uB3oAbqlyxBnTbAdZyKcX6-ABAy2jiwAQZAryKXMGXlKVbbNwdAKMy7lCoO_jiXRxSWf_lHSbN_03Hxj7t2wA4BX6y6qSrEGUyX8kvDI-ZJ3_TmTKWss7opKs2jjuPuuJBiKtTVj5jApeJk0QFnJjt4y_GxHhESulhlfLJ-mi6Xk9hwV)

```java
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
```