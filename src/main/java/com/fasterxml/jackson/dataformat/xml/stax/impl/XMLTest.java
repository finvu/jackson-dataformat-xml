package com.fasterxml.jackson.dataformat.xml.stax.impl;

import java.math.BigDecimal;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.stax.impl.xmlpull.XMLPullFactory;

public class XMLTest {

	public static void main(String[] args) throws Exception {
		
		/**
		
		SimpleRoot root = new SimpleRoot();
		root.setChild("hello");
		
		XmlMapper mapper = new XmlMapper();
		System.out.println(mapper.writeValueAsString(root));
		*/
		
		
		XMLPullFactory pullFactory = new XMLPullFactory();
		XmlMapper mapper = new XmlMapper(pullFactory);
		
		/*
		SimpleRoot root = mapper.readValue("<SimpleRoot><child>hello</child></SimpleRoot>", SimpleRoot.class);
		
		System.out.println(root);
		System.out.println(root.getChild());
		
		System.out.println(mapper.writeValueAsString(root));*/
		
		SimpleRoot root = new SimpleRoot();
		root.setChild("hello");
		root.setDecimal(new BigDecimal("1234343434343"));
		
		System.out.println(mapper.writeValueAsString(root));

	}

}
