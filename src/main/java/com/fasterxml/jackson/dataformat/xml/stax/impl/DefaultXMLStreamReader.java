package com.fasterxml.jackson.dataformat.xml.stax.impl;

import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.ri.Stax2ReaderAdapter;

import com.fasterxml.jackson.dataformat.xml.stax.Location;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamException;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamReader;

public class DefaultXMLStreamReader implements XMLStreamReader {
	
	XMLStreamReader2 _xmlReader;
	
	public DefaultXMLStreamReader(javax.xml.stream.XMLStreamReader reader) {
		this._xmlReader = Stax2ReaderAdapter.wrapIfNecessary(reader);
	}

	@Override
	public int getEventType() {
		return _xmlReader.getEventType();
	}

	@Override
	public String getLocalName() {
		return _xmlReader.getLocalName();
	}

	@Override
	public String getNamespaceURI() {
		return _xmlReader.getNamespaceURI();
	}

	@Override
	public int getAttributeCount() {
		return _xmlReader.getAttributeCount();
	}

	@Override
	public void closeCompletely() throws XMLStreamException {
		try {
			_xmlReader.closeCompletely();			
		} catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void close() throws XMLStreamException {
		try {
			_xmlReader.close();			
		} catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public String getAttributeLocalName(int index) {
		return _xmlReader.getAttributeLocalName(index);
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
		return _xmlReader.next();
	}

	@Override
	public int nextTag() throws Exception {
		return _xmlReader.nextTag();
	}

	@Override
	public boolean isEmptyElement() throws Exception {
		return _xmlReader.isEmptyElement();
	}

	@Override
	public String getText() {
		return _xmlReader.getText();
	}

	@Override
	public boolean hasNext() throws Exception {
		return _xmlReader.hasNext();
	}

	@Override
	public Location getLocation() {
		final javax.xml.stream.Location location = _xmlReader.getLocation();
		if(location != null) {
			return new Location() {
				
				@Override
				public int getLineNumber() {
					return location.getLineNumber();
				}
				
				@Override
				public int getColumnNumber() {
					return location.getColumnNumber();
				}
				
				@Override
				public int getCharacterOffset() {
					return location.getCharacterOffset();
				}
			};
		}
		return null;
	}
}