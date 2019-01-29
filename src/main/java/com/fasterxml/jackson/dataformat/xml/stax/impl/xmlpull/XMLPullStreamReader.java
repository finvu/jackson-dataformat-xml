package com.fasterxml.jackson.dataformat.xml.stax.impl.xmlpull;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.fasterxml.jackson.dataformat.xml.stax.Location;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamConstants;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamException;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamReader;

public class XMLPullStreamReader implements XMLStreamReader {
	
	XmlPullParser _xmlReader;
	
	public XMLPullStreamReader(XmlPullParser reader) {
		this._xmlReader = reader;
	}

	@Override
	public int getEventType() {
		try {
			return convertAndReturn(_xmlReader.getEventType());
		}catch(XmlPullParserException e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public String getLocalName() {
		return _xmlReader.getName();
	}

	@Override
	public String getNamespaceURI() {
		return _xmlReader.getNamespace();
	}

	@Override
	public int getAttributeCount() {
		return _xmlReader.getAttributeCount();
	}

	@Override
	public void closeCompletely() throws XMLStreamException {
		// no close() feature in xml pull parser.
	}

	@Override
	public void close() throws XMLStreamException {
		// no close() feature in xml pull parser.
	}

	@Override
	public String getAttributeLocalName(int index) {
		return _xmlReader.getAttributeName(index);
	}

	@Override
	public String getAttributeNamespace(int index) {
		return _xmlReader.getAttributeNamespace(index);
	}

	@Override
	public String getAttributeValue(int index) {
		return _xmlReader.getAttributeValue(index);
	}

	@Override
	public int next() throws Exception {
		return convertAndReturn(_xmlReader.next());
	}

	@Override
	public int nextTag() throws Exception {
		return convertAndReturn(_xmlReader.nextTag());
	}

	@Override
	public boolean isEmptyElement() throws Exception {
		if(_xmlReader.getEventType() != XmlPullParser.END_DOCUMENT)
			return _xmlReader.isEmptyElementTag();
		return false;
	}

	@Override
	public String getText() {
		return _xmlReader.getText();
	}

	@Override
	public boolean hasNext() throws Exception {
		return _xmlReader.getEventType() != XmlPullParser.END_DOCUMENT;
	}

	@Override
	public Location getLocation() {
		return new Location() {
			
			@Override
			public int getLineNumber() {
				return _xmlReader.getLineNumber();
			}
			
			@Override
			public int getColumnNumber() {
				return _xmlReader.getColumnNumber();
			}
			
			@Override
			public int getCharacterOffset() {
				return _xmlReader.getColumnNumber();
			}
		};
	}
	
	private int convertAndReturn(int i) {
		// convert the pull parser event type to the javax.xml event type.
		switch(i) {
			case XmlPullParser.START_TAG : return XMLStreamConstants.START_ELEMENT;
			case XmlPullParser.END_TAG: return XMLStreamConstants.END_ELEMENT;
			case XmlPullParser.TEXT: return XMLStreamConstants.CHARACTERS;
			case XmlPullParser.CDSECT: return XMLStreamConstants.CDATA;
			case XmlPullParser.START_DOCUMENT : return XMLStreamConstants.START_DOCUMENT;
			case XmlPullParser.END_DOCUMENT: return XMLStreamConstants.END_DOCUMENT;
		}
		throw new IllegalStateException("Unsupported event type from the underlying pull parser: " + i);
	}

}
