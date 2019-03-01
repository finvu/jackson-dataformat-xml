package com.fasterxml.jackson.dataformat.xml.stax;

public interface XMLStreamReader extends XMLStreamConstants {

	/**
	 * Returns an integer code that indicates the type of the event the cursor is
	 * pointing to.
	 */
	public int getEventType();
	
	/**
	 * Returns the (local) name of the current event. For START_ELEMENT or
	 * END_ELEMENT returns the (local) name of the current element. For
	 * ENTITY_REFERENCE it returns entity name. The current event must be
	 * START_ELEMENT or END_ELEMENT, or ENTITY_REFERENCE
	 * 
	 * @return the localName
	 * @throws IllegalStateException
	 *             if this not a START_ELEMENT, END_ELEMENT or ENTITY_REFERENCE
	 */
	public String getLocalName();
	
	/**
	 * If the current event is a START_ELEMENT or END_ELEMENT this method returns
	 * the URI of the prefix or the default namespace. Returns null if the event
	 * does not have a prefix.
	 * 
	 * @return the URI bound to this elements prefix, the default namespace, or null
	 */
	public String getNamespaceURI();
	
	/**
	 * Returns the count of attributes on this START_ELEMENT, this method is only
	 * valid on a START_ELEMENT or ATTRIBUTE. This count excludes namespace
	 * definitions. Attribute indices are zero-based.
	 * 
	 * @return returns the number of attributes
	 * @throws IllegalStateException
	 *             if this is not a START_ELEMENT or ATTRIBUTE
	 */
	public int getAttributeCount();
	
	/**
	 * Method similar to {@link javax.xml.stream.XMLStreamReader#close}, except that
	 * this method also does close the underlying input source if it has not yet
	 * been closed. It is generally preferable to call this method if the parsing
	 * ends in an exception; and for some input sources (when passing a
	 * {@link java.io.File} or {@link java.net.URL} for factory method) it has to be
	 * called as the application does not have access to the actually input source
	 * ({@link java.io.InputStream} opened from a {@link java.net.URL} and so on).
	 */
	public void closeCompletely() throws XMLStreamException;
	
	/**
	 * Frees any resources associated with this Reader. This method does not close
	 * the underlying input source.
	 * 
	 * @throws XMLStreamException
	 *             if there are errors freeing associated resources
	 */
	public void close() throws XMLStreamException;
	
	/**
	 * Returns the localName of the attribute at the provided index
	 * 
	 * @param index
	 *            the position of the attribute
	 * @return the localName of the attribute
	 * @throws IllegalStateException
	 *             if this is not a START_ELEMENT or ATTRIBUTE
	 */
	public String getAttributeLocalName(int index);
	
	/**
	 * Returns the namespace of the attribute at the provided index
	 * 
	 * @param index
	 *            the position of the attribute
	 * @return the namespace URI (can be null)
	 * @throws IllegalStateException
	 *             if this is not a START_ELEMENT or ATTRIBUTE
	 */
	public String getAttributeNamespace(int index);
	
	/**
	 * Returns the value of the attribute at the index
	 * 
	 * @param index
	 *            the position of the attribute
	 * @return the attribute value
	 * @throws IllegalStateException
	 *             if this is not a START_ELEMENT or ATTRIBUTE
	 */
	public String getAttributeValue(int index);
	
	public int nextTag() throws Exception;

	public int next() throws Exception;
	
    public boolean isEmptyElement() throws Exception;
    
    public String getText();
    
    public boolean hasNext() throws Exception;
    
    public Location getLocation();
}
