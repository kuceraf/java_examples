https://docs.oracle.com/javase/tutorial/essential/io/bytestreams.html

Great article encoding:
https://stackoverflow.com/questions/643694/what-is-the-difference-between-utf-8-and-unicode

## ASCII and UTF-8 vs unicode
* unicode:
    * is coded character set - i.e. a set of characters and a mapping between the characters and integer code points representing them
    * unicode assigns each character a unique number, or code point
* ASCII:
    * old character encoding type
        * character encoding = a way of converting from sequences of bytes to sequences of characters and vice versa. 
    * uses a predefined numbers of bytes per character
* UTF-8
    * newer character encoding type
    * uses a variable number of bytes per character
    * Unicode Transformation Format
    
The Java platform stores character values using Unicode conventions. Character stream I/O automatically translates this internal format to and from the local character set. In Western locales, the local character set is usually an 8-bit superset of ASCII.