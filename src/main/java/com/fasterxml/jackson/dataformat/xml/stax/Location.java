package com.fasterxml.jackson.dataformat.xml.stax;

public interface Location {
	  
	int getLineNumber();

	int getColumnNumber();

	int getCharacterOffset();
}
