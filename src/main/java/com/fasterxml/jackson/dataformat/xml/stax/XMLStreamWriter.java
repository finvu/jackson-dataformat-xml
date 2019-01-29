package com.fasterxml.jackson.dataformat.xml.stax;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface XMLStreamWriter {

	/**
	 * Write the XML Declaration. Defaults the XML version to 1.0, and the encoding
	 * to utf-8
	 * 
	 * @throws XMLStreamException
	 */
	public void writeStartDocument(String encoding, String version) throws XMLStreamException;
	
	public void writeEndDocument() throws XMLStreamException;

	public void writeStartElement(String namespaceURI, String localName) throws XMLStreamException;
	
	public void writeStartElement(String localName) throws XMLStreamException;

	public void writeEndElement() throws XMLStreamException;

	public void writeAttribute(String namespaceURI, String localName, String value) throws XMLStreamException;

	public void writeCData(String data) throws XMLStreamException;

	public void writeCData(char[] text, int start, int len) throws XMLStreamException;

	public void writeCharacters(String text) throws XMLStreamException;

	public void writeCharacters(char[] text, int start, int len) throws XMLStreamException;

	public void writeRaw(String data) throws XMLStreamException;

	public void writeRaw(char[] text, int start, int len) throws XMLStreamException;

	public void writeRaw(String text, int start, int len) throws XMLStreamException;

	public void closeCompletely() throws XMLStreamException;

	public void close() throws XMLStreamException;

	public void writeAttribute(String prefix, String namespaceURI, String localName, String value)
			throws XMLStreamException;
	
	/**
	 * Write any cached data to the underlying output mechanism.
	 * 
	 * @throws XMLStreamException
	 */
	public void flush() throws XMLStreamException;

	public void setDefaultNamespace(String uri) throws XMLStreamException;
	
	public void writeDefaultNamespace(String uri) throws XMLStreamException;

	public void writeBoolean(boolean value) throws XMLStreamException;

	public void writeInt(int value) throws XMLStreamException;

	public void writeLong(long value) throws XMLStreamException;

	public void writeDouble(double value) throws XMLStreamException;

	public void writeFloat(float value) throws XMLStreamException;

	public void writeInteger(BigInteger value) throws XMLStreamException;

	public void writeDecimal(BigDecimal value) throws XMLStreamException;

	public void writeBinary(byte[] data, int offset, int len) throws XMLStreamException;

	public void writeEmptyElement(String nsURI, String localName) throws XMLStreamException;

	void writeBinaryAttribute(String prefix, String namespaceURI, String localName, byte[] value)
			throws XMLStreamException;

	void writeBooleanAttribute(String prefix, String namespaceURI, String localName, boolean value)
			throws XMLStreamException;

	void writeIntAttribute(String prefix, String namespaceURI, String localName, int value) throws XMLStreamException;

	void writeLongAttribute(String prefix, String namespaceURI, String localName, long value) throws XMLStreamException;

	void writeDoubleAttribute(String prefix, String namespaceURI, String localName, double value)
			throws XMLStreamException;

	void writeFloatAttribute(String prefix, String namespaceURI, String localName, float value)
			throws XMLStreamException;

	void writeDecimalAttribute(String prefix, String namespaceURI, String localName, BigDecimal value)
			throws XMLStreamException;

	void writeIntegerAttribute(String prefix, String namespaceURI, String localName, BigInteger value)
			throws XMLStreamException;
}