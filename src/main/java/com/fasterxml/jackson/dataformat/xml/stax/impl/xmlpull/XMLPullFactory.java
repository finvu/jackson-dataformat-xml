package com.fasterxml.jackson.dataformat.xml.stax.impl.xmlpull;

import com.fasterxml.jackson.dataformat.xml.XmlFactory;

public class XMLPullFactory extends XmlFactory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4038776493313899999L;

	public XMLPullFactory() {
		super(new XMLPullInputFactory(), new XMLSerializerOutputFactory());
	}
}
