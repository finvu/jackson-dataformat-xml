package com.fasterxml.jackson.dataformat.xml.stax.impl;

import java.math.BigDecimal;

public class SimpleRoot {

	private String child;
	
	private BigDecimal decimal;

	/**
	 * @return the child
	 */
	public String getChild() {
		return child;
	}

	/**
	 * @param child the child to set
	 */
	public void setChild(String child) {
		this.child = child;
	}

	/**
	 * @return the decimal
	 */
	public BigDecimal getDecimal() {
		return decimal;
	}

	/**
	 * @param decimal the decimal to set
	 */
	public void setDecimal(BigDecimal decimal) {
		this.decimal = decimal;
	}
	
}
