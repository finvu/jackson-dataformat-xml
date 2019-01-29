package com.fasterxml.jackson.dataformat.xml.failing;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.XmlTestBase;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.stax.XMLOutputFactory;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamException;
import com.fasterxml.jackson.dataformat.xml.stax.XMLStreamWriter;
import com.fasterxml.jackson.dataformat.xml.stax.impl.DefaultXMLInputFactory;
import com.fasterxml.jackson.dataformat.xml.stax.impl.DefaultXMLOutputFactory;

// for [dataformat-xml#311]
public class FailingNamespace311Test extends XmlTestBase
{
    @JacksonXmlRootElement(localName = "new")
    static class Bean {
        @JacksonXmlProperty(isAttribute = true)
        public String source="ECOM";
        public Member member;

        public Bean(int id, String name) {
            this.member=new Member(id, name);
        }

        public Member getMember() {
            return member;
        }
    }

    static class Member {
        private final int id;
        private final String name;

        public Member(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public void testIssue311() throws Exception {
        XMLOutputFactory xmlOutputFactory = DefaultXMLOutputFactory.newInstance();
        
        /* Setting this to true makes the application run but does not write namespace */
        xmlOutputFactory.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, false);
        
        XmlMapper mapper = XmlMapper.builder(
                XmlFactory.builder()
                    .inputFactory(DefaultXMLInputFactory.newInstance())
                    .outputFactory(xmlOutputFactory)
                    .build()
                    )
            .enable(SerializationFeature.INDENT_OUTPUT)
            .build();

        XMLStreamWriter writer = xmlOutputFactory.createXMLStreamWriter(System.out);

        startDocument(writer);
        Bean bean=new Bean(1, "Dude");
        mapper.writeValue(writer, bean);
        endDocument(writer);        
    }

    protected void startDocument(XMLStreamWriter writer) throws XMLStreamException {
        writer.writeStartDocument("utf-8", "1.0");
        writer.writeCharacters("\n");
        writer.setDefaultNamespace("http://eClub.Schemas.ImportContact");
        writer.writeStartElement("contacts");
        writer.writeDefaultNamespace( "http://eClub.Schemas.ImportContact");
        writer.writeCharacters("\n");
    }

    protected void endDocument(XMLStreamWriter writer) throws XMLStreamException {
        writer.writeCharacters("\n");
        writer.writeEndDocument();
    }
}
