package com.fasterxml.jackson.dataformat.xml.stax.impl.xmlpull;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.fasterxml.jackson.dataformat.xml.stax.XMLInputFactory;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamException;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamReader;

public class XMLPullInputFactory extends XMLInputFactory {
	
	private XmlPullParserFactory _inputFactory;
	
	public XMLPullInputFactory() {
		try {
			this._inputFactory = XmlPullParserFactory.newInstance();			
		}catch(XmlPullParserException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void setProperty(String property, Object value) {
		if(IS_VALIDATING.equals(property)) {
			_inputFactory.setValidating(((Boolean)value).booleanValue());
		} else if(IS_NAMESPACE_AWARE.equals(property)) {
			_inputFactory.setNamespaceAware(((Boolean)value).booleanValue());
		}
	}

	@Override
	public XMLStreamReader createXMLStreamReader(InputStream stream) throws XMLStreamException {
		return createXMLStreamReader(new InputStreamReader(stream));
	}

	@Override
	public XMLStreamReader createXMLStreamReader(Reader reader) throws XMLStreamException {
		try {
			XmlPullParser parser = _inputFactory.newPullParser();
			parser.setInput(reader);
			
			XMLPullStreamReader xmlReader = new XMLPullStreamReader(parser);
			return xmlReader;
		}catch(XmlPullParserException e) {
			throw new XMLStreamException(e);
		}
	}
}