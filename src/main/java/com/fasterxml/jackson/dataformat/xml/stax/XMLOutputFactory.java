package com.fasterxml.jackson.dataformat.xml.stax;

import java.io.OutputStream;
import java.io.Writer;

import com.fasterxml.jackson.dataformat.xml.stax.impl.DefaultXMLOutputFactory;

public abstract class XMLOutputFactory {
	
	/**
	 * Property used to set prefix defaulting on the output side
	 */
	public static final String IS_REPAIRING_NAMESPACES = "javax.xml.stream.isRepairingNamespaces";
	
	public static XMLOutputFactory newInstance() {
		return DefaultXMLOutputFactory.newInstance();
	}
	
	public abstract void setProperty(String property, Object value);
	
	public abstract XMLStreamWriter createXMLStreamWriter(OutputStream out) throws XMLStreamException;
	
	public abstract XMLStreamWriter createXMLStreamWriter(OutputStream out, String encoding) throws XMLStreamException;
	
	public abstract XMLStreamWriter createXMLStreamWriter(Writer w) throws XMLStreamException;

}
