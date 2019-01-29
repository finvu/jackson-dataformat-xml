package com.fasterxml.jackson.dataformat.xml.stax.impl.xmlpull;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Base64;
import java.util.Stack;

import org.xmlpull.v1.XmlSerializer;

import com.fasterxml.jackson.dataformat.xml.stax.QName;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamException;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamWriter;

public class XMLSerializerWriter implements XMLStreamWriter {
	
	private XmlSerializer _xmlWriter;
	private Stack<QName> _elementStack;
	
	public XMLSerializerWriter(XmlSerializer xmlWriter) {
		this._xmlWriter = xmlWriter;
		_elementStack = new Stack<>();
	}

	@Override
	public void writeStartDocument(String encoding, String version) throws XMLStreamException {
		try {
			_xmlWriter.startDocument(encoding, version != null? true : false);
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeStartElement(String namespaceURI, String localName) throws XMLStreamException {
		try {
			// we need the details when closing the tag.
			_elementStack.push(new QName(namespaceURI, localName, null));
			_xmlWriter.startTag(namespaceURI, localName);
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeEndElement() throws XMLStreamException {
		try {
			QName name = _elementStack.pop();
			_xmlWriter.endTag(name.getNamespaceURI(), name.getLocalPart());
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeAttribute(String namespaceURI, String localName, String value) throws XMLStreamException {
		try {
			_xmlWriter.attribute(namespaceURI, localName, value);
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeCData(String data) throws XMLStreamException {
		try {
			_xmlWriter.cdsect(data);
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeCData(char[] text, int start, int len) throws XMLStreamException {
		try {
			_xmlWriter.cdsect(new String(text, start, len));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeCharacters(String text) throws XMLStreamException {
		try {
			_xmlWriter.text(text);
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeCharacters(char[] text, int start, int len) throws XMLStreamException {
		try {
			_xmlWriter.text(text, start, len);
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeRaw(String data) throws XMLStreamException {
		try {
			// xml pull does not have raw, we will write escaped.
			_xmlWriter.text(data);
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeRaw(char[] text, int start, int len) throws XMLStreamException {
		try {
			// xml pull does not have raw, we will write escaped.
			_xmlWriter.text(text, start, len);
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeRaw(String text, int start, int len) throws XMLStreamException {
		try {
			// xml pull does not have raw, we will write escaped.
			char[] chars = text.toCharArray();
			_xmlWriter.text(chars, start, len);
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void closeCompletely() throws XMLStreamException {
		try {
			// no close in xml pull. so we just flush.
			_xmlWriter.flush();
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void close() throws XMLStreamException {
		closeCompletely();
	}

	@Override
	public void writeAttribute(String prefix, String namespaceURI, String localName, String value)
			throws XMLStreamException {
		try {
			
			// TODO: need to find a way to set prefix.
			_xmlWriter.attribute(namespaceURI, localName, value);
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void flush() throws XMLStreamException {
		try {
			_xmlWriter.flush();
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void setDefaultNamespace(String uri) throws XMLStreamException {
		try {
			_xmlWriter.setPrefix("", uri);
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeBoolean(boolean value) throws XMLStreamException {
		try {
			_xmlWriter.text(String.valueOf(value));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeInt(int value) throws XMLStreamException {
		try {
			_xmlWriter.text(String.valueOf(value));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeLong(long value) throws XMLStreamException {
		try {
			_xmlWriter.text(String.valueOf(value));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeDouble(double value) throws XMLStreamException {
		try {
			_xmlWriter.text(String.valueOf(value));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeFloat(float value) throws XMLStreamException {
		try {
			_xmlWriter.text(String.valueOf(value));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeInteger(BigInteger value) throws XMLStreamException {
		try {
			_xmlWriter.text(String.valueOf(value));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeDecimal(BigDecimal value) throws XMLStreamException {
		try {
			_xmlWriter.text(String.valueOf(value));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeBinary(byte[] data, int offset, int len) throws XMLStreamException {
		try {
			if(len < data.length) {
				byte[] destData = new byte[len];
				System.arraycopy(data, offset, destData, 0, len);
				data = destData;
			}
			_xmlWriter.text(Base64.getEncoder().encodeToString(data));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeEmptyElement(String nsURI, String localName) throws XMLStreamException {
		try {
			_xmlWriter.startTag(nsURI, localName);
			_xmlWriter.endTag(nsURI, localName);
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeBinaryAttribute(String prefix, String namespaceURI, String localName, byte[] value)
			throws XMLStreamException {		
		try {
			_xmlWriter.attribute(namespaceURI, localName, Base64.getEncoder().encodeToString(value));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeBooleanAttribute(String prefix, String namespaceURI, String localName, boolean value)
			throws XMLStreamException {
		try {
			_xmlWriter.attribute(namespaceURI, localName, String.valueOf(value));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeIntAttribute(String prefix, String namespaceURI, String localName, int value)
			throws XMLStreamException {
		try {
			_xmlWriter.attribute(namespaceURI, localName, String.valueOf(value));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeLongAttribute(String prefix, String namespaceURI, String localName, long value)
			throws XMLStreamException {
		try {
			_xmlWriter.attribute(namespaceURI, localName, String.valueOf(value));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeDoubleAttribute(String prefix, String namespaceURI, String localName, double value)
			throws XMLStreamException {
		try {
			_xmlWriter.attribute(namespaceURI, localName, String.valueOf(value));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeFloatAttribute(String prefix, String namespaceURI, String localName, float value)
			throws XMLStreamException {
		try {
			_xmlWriter.attribute(namespaceURI, localName, String.valueOf(value));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeDecimalAttribute(String prefix, String namespaceURI, String localName, BigDecimal value)
			throws XMLStreamException {
		try {
			_xmlWriter.attribute(namespaceURI, localName, String.valueOf(value));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeIntegerAttribute(String prefix, String namespaceURI, String localName, BigInteger value)
			throws XMLStreamException {
		try {
			_xmlWriter.attribute(namespaceURI, localName, String.valueOf(value));
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeEndDocument() throws XMLStreamException {
		try {
			_xmlWriter.endDocument();
		}catch(IOException ioe) {
			throw new XMLStreamException(ioe);
		}
	}

	@Override
	public void writeStartElement(String localName) throws XMLStreamException {
		writeStartElement(null, localName);
	}

	@Override
	public void writeDefaultNamespace(String uri) throws XMLStreamException {
		setDefaultNamespace(uri);
	}

}
