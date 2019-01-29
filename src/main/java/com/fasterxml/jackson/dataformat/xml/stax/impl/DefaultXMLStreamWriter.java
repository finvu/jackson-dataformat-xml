package com.fasterxml.jackson.dataformat.xml.stax.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;

import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamException;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamWriter;

public class DefaultXMLStreamWriter implements XMLStreamWriter {
	
	private XMLStreamWriter2 _xmlWriter;
	
	public DefaultXMLStreamWriter(javax.xml.stream.XMLStreamWriter writer) {
		this._xmlWriter = Stax2WriterAdapter.wrapIfNecessary(writer);
	}

	@Override
	public void writeStartDocument(String encoding, String version) throws XMLStreamException {
		try {
			_xmlWriter.writeStartDocument(encoding, version);	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeStartElement(String namespaceURI, String localName) throws XMLStreamException {
		try {
			_xmlWriter.writeStartElement(namespaceURI, localName);	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeEndElement() throws XMLStreamException {
		try {
			_xmlWriter.writeEndElement();	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeAttribute(String namespaceURI, String localName, String value) throws XMLStreamException {
		try {
			_xmlWriter.writeAttribute(namespaceURI, localName, value);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeCData(String data) throws XMLStreamException {
		try {
			_xmlWriter.writeCData(data);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeCData(char[] text, int start, int len) throws XMLStreamException {
		try {
			_xmlWriter.writeCData(text, start, len);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeCharacters(String text) throws XMLStreamException {
		try {
			_xmlWriter.writeCharacters(text);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeCharacters(char[] text, int start, int len) throws XMLStreamException {
		try {
			_xmlWriter.writeCharacters(text, start, len);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeRaw(String data) throws XMLStreamException {
		try {
			_xmlWriter.writeRaw(data);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeRaw(char[] text, int start, int len) throws XMLStreamException {
		try {
			_xmlWriter.writeRaw(text, start, len);	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeRaw(String text, int start, int len) throws XMLStreamException {
		try {
			_xmlWriter.writeRaw(text, start, len);	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void closeCompletely() throws XMLStreamException {
		try {
			_xmlWriter.closeCompletely();	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void close() throws XMLStreamException {
		try {
			_xmlWriter.close();	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeAttribute(String prefix, String namespaceURI, String localName, String value)
			throws XMLStreamException {
		try {
			_xmlWriter.writeAttribute(prefix, namespaceURI, localName, value);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void flush() throws XMLStreamException {
		try {
			_xmlWriter.flush();	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void setDefaultNamespace(String uri) throws XMLStreamException {
		try {
			_xmlWriter.setDefaultNamespace(uri);	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeBoolean(boolean value) throws XMLStreamException {
		try {
			_xmlWriter.writeBoolean(value);	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeInt(int value) throws XMLStreamException {
		try {
			_xmlWriter.writeInt(value);	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeLong(long value) throws XMLStreamException {
		try {
			_xmlWriter.writeLong(value);	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeDouble(double value) throws XMLStreamException {
		try {
			_xmlWriter.writeDouble(value);	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeFloat(float value) throws XMLStreamException {
		try {
			_xmlWriter.writeFloat(value);	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeInteger(BigInteger value) throws XMLStreamException {
		try {
			_xmlWriter.writeInteger(value);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeDecimal(BigDecimal value) throws XMLStreamException {
		try {
			_xmlWriter.writeDecimal(value);	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeBinary(byte[] data, int offset, int len) throws XMLStreamException {
		try {
			_xmlWriter.writeBinary(data, offset, len);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}	}

	@Override
	public void writeEmptyElement(String nsURI, String localName) throws XMLStreamException {
		try {
			_xmlWriter.writeEmptyElement(nsURI, localName);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeBinaryAttribute(String prefix, String namespaceURI, String localName, byte[] value)
			throws XMLStreamException {
		try {
			_xmlWriter.writeBinaryAttribute(prefix, namespaceURI, localName, value);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeBooleanAttribute(String prefix, String namespaceURI, String localName, boolean value)
			throws XMLStreamException {
		try {
			_xmlWriter.writeBooleanAttribute(prefix, namespaceURI, localName, value);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeIntAttribute(String prefix, String namespaceURI, String localName, int value)
			throws XMLStreamException {
		try {
			_xmlWriter.writeIntAttribute(prefix, namespaceURI, localName, value);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeLongAttribute(String prefix, String namespaceURI, String localName, long value)
			throws XMLStreamException {
		try {
			_xmlWriter.writeLongAttribute(prefix, namespaceURI, localName, value);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeDoubleAttribute(String prefix, String namespaceURI, String localName, double value)
			throws XMLStreamException {
		try {
			_xmlWriter.writeDoubleAttribute(prefix, namespaceURI, localName, value);	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeFloatAttribute(String prefix, String namespaceURI, String localName, float value)
			throws XMLStreamException {
		try {
			_xmlWriter.writeFloatAttribute(prefix, namespaceURI, localName, value);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeDecimalAttribute(String prefix, String namespaceURI, String localName, BigDecimal value)
			throws XMLStreamException {
		try {
			_xmlWriter.writeDecimalAttribute(prefix, namespaceURI, localName, value);	
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeIntegerAttribute(String prefix, String namespaceURI, String localName, BigInteger value)
			throws XMLStreamException {
		try {
			_xmlWriter.writeIntegerAttribute(prefix, namespaceURI, localName, value);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeEndDocument() throws XMLStreamException {
		try {
			_xmlWriter.writeEndDocument();
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeStartElement(String localName) throws XMLStreamException {
		try {
			_xmlWriter.writeStartElement(localName);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

	@Override
	public void writeDefaultNamespace(String uri) throws XMLStreamException {
		try {
			_xmlWriter.writeDefaultNamespace(uri);
		}catch(javax.xml.stream.XMLStreamException e) {
			throw new XMLStreamException(e);
		}
	}

}
