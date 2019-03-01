package com.fasterxml.jackson.dataformat.xml.stax;

public class QName {

	String localPart;
	String prefix;
	String namespaceURI;
	
	public QName(String localPart) {
		this("", localPart, "");
	}
	
	public QName(String namespaceURI, String localPart) {
		this(namespaceURI, localPart, "");
	}
	
	public QName(String namespaceURI, String localPart, String prefix) {
		this.namespaceURI = namespaceURI;
        
		if (localPart == null) {
            throw new IllegalArgumentException(
                    "local part cannot be \"null\" when creating a QName");
        }
		this.localPart = localPart;
		
        // prefix is required
        if (prefix == null) {
            throw new IllegalArgumentException(
                    "prefix cannot be \"null\" when creating a QName");
        }
		this.prefix = prefix;
	}

	/**
	 * @return the localPart
	 */
	public String getLocalPart() {
		return localPart;
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @return the namespaceURI
	 */
	public String getNamespaceURI() {
		return namespaceURI;
	}
}
