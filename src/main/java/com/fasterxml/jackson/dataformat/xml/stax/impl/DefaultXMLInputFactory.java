package com.fasterxml.jackson.dataformat.xml.stax.impl;

import java.io.InputStream;
import java.io.Reader;

import com.fasterxml.jackson.dataformat.xml.stax.XMLInputFactory;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamException;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamReader;

public class DefaultXMLInputFactory extends XMLInputFactory {
	
	private javax.xml.stream.XMLInputFactory _inputFactory;
	
	public DefaultXMLInputFactory() {
		_inputFactory = javax.xml.stream.XMLInputFactory.newInstance();
	}

	@Override
	public XMLStreamReader createXMLStreamReader(InputStream stream) throws XMLStreamException {
		try {
			return new DefaultXMLStreamReader(_inputFactory.createXMLStreamReader(stream));			
		} catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public XMLStreamReader createXMLStreamReader(Reader reader) throws XMLStreamException {
		try {
			return new DefaultXMLStreamReader(_inputFactory.createXMLStreamReader(reader));
		} catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}
	
	@Override
	public void setProperty(String property, Object value) {
		_inputFactory.setProperty(property, value);
	}

	public static XMLInputFactory newInstance() {
		return new DefaultXMLInputFactory();
	}
}
