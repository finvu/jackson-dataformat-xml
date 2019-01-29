package com.fasterxml.jackson.dataformat.xml.stax;

import java.io.InputStream;
import java.io.Reader;

import com.fasterxml.jackson.dataformat.xml.stax.impl.DefaultXMLInputFactory;

public abstract class XMLInputFactory {
	
	/**
	 * The property that requires the parser to resolve external parsed entities
	 */
	public static final String IS_SUPPORTING_EXTERNAL_ENTITIES = "javax.xml.stream.isSupportingExternalEntities";
	
	/**
	 * The property that requires the parser to support DTDs
	 */
	public static final String SUPPORT_DTD = "javax.xml.stream.supportDTD";
	
	/**
	 * The property that requires the parser to coalesce adjacent character data
	 * sections
	 */
	public static final String IS_COALESCING = "javax.xml.stream.isCoalescing";
	
	/**
	 * The property used to turn on/off implementation specific validation
	 */
	public static final String IS_VALIDATING = "javax.xml.stream.isValidating";
	
	/**
	 * The property used to turn on/off namespace support, this is to support XML
	 * 1.0 documents, only the true setting must be supported
	 */
	public static final String IS_NAMESPACE_AWARE = "javax.xml.stream.isNamespaceAware";
	
	public static XMLInputFactory newInstance() {
		return DefaultXMLInputFactory.newInstance();
	}
	
	public abstract void setProperty(String property, Object value);
	
	public abstract XMLStreamReader createXMLStreamReader(InputStream stream) throws XMLStreamException;
	
	public abstract XMLStreamReader createXMLStreamReader(Reader reader) throws XMLStreamException;

}
