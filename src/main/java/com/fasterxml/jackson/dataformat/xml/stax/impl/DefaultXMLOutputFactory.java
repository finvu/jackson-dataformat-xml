package com.fasterxml.jackson.dataformat.xml.stax.impl;

import java.io.OutputStream;
import java.io.Writer;

import com.fasterxml.jackson.dataformat.xml.stax.XMLOutputFactory;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamException;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamWriter;

public class DefaultXMLOutputFactory extends XMLOutputFactory {
	
	private javax.xml.stream.XMLOutputFactory _outputFactory;
	
	public DefaultXMLOutputFactory() {
		_outputFactory = javax.xml.stream.XMLOutputFactory.newFactory();
	}

	@Override
	public void setProperty(String property, Object value) {
		_outputFactory.setProperty(property, value);
	}

	@Override
	public XMLStreamWriter createXMLStreamWriter(OutputStream out, String encoding) throws XMLStreamException {
		try {
			return new DefaultXMLStreamWriter(_outputFactory.createXMLStreamWriter(out, encoding));			
		} catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}
	
	@Override
	public XMLStreamWriter createXMLStreamWriter(OutputStream out) throws XMLStreamException {
		return createXMLStreamWriter(out, "UTF-8");
	}

	@Override
	public XMLStreamWriter createXMLStreamWriter(Writer w) throws XMLStreamException {
		try {
			return new DefaultXMLStreamWriter(_outputFactory.createXMLStreamWriter(w));			
		} catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}
	
	public static XMLOutputFactory newInstance() {
		return new DefaultXMLOutputFactory();
	}

}
