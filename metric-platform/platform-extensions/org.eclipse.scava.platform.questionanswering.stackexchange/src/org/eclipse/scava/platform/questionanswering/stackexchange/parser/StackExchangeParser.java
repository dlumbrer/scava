package org.eclipse.scava.platform.questionanswering.stackexchange.parser;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class StackExchangeParser
{
	private List<StackExchangePost> posts;
	
	public StackExchangeParser(StackExchangeParserBuilder parserBuilder) throws ParserConfigurationException, SAXException, IOException
	{
		//Create a "parser factory" for creating SAX parsers
        SAXParserFactory spfac = SAXParserFactory.newInstance();
        //Now use the parser factory to create a SAXParser object
        SAXParser sp = spfac.newSAXParser();
        //Create an instance of this class; it defines all the handler methods
        StackExchangeParserHandler parserExecutor = new StackExchangeParserHandler(parserBuilder);
        sp.parse(parserBuilder.getXMLPath().toString(), parserExecutor);
        posts = parserExecutor.getPosts();
	}
	
	public List<StackExchangePost> getPosts()
	{
		return posts;
	}
}
