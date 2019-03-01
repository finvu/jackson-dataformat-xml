package com.fasterxml.jackson.dataformat.xml.stax.impl.xmlpull;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import com.fasterxml.jackson.dataformat.xml.stax.XMLOutputFactory;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamException;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamWriter;

public class XMLSerializerOutputFactory extends XMLOutputFactory {
	
	private XmlPullParserFactory _outputFactory;
	
	public XMLSerializerOutputFactory() {
		try {
			this._outputFactory = XmlPullParserFactory.newInstance();			
		}catch(XmlPullParserException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void setProperty(String property, Object value) {
		// xml pull factory does not offer any useful property for serialization.
	}

	@Override
	public XMLStreamWriter createXMLStreamWriter(OutputStream out, String encoding) throws XMLStreamException {
		try {
			
			XmlSerializer serializer = _outputFactory.newSerializer();
			serializer.setOutput(out, encoding);
			
			XMLSerializerWriter xmlWriter = new XMLSerializerWriter(serializer);
			return xmlWriter;
		}catch(XmlPullParserException | IOException e) {
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
			
			XmlSerializer serializer = _outputFactory.newSerializer();
			serializer.setOutput(w);
			
			XMLSerializerWriter xmlWriter = new XMLSerializerWriter(serializer);
			return xmlWriter;
		}catch(XmlPullParserException | IOException e) {
			throw new XMLStreamException(e);
		}
	}
}
