/*
 * JLibs: Common Utilities for Java
 * Copyright (C) 2009  Santhosh Kumar T <santhosh.tekuri@gmail.com>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 */

package jlibs.nio.http.msg;

import jlibs.core.io.IOUtil;
import jlibs.xml.xsl.TransformerUtil;
import org.w3c.dom.Node;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Santhosh Kumar Tekuri
 */
public class DOMPayload extends EncodablePayload{
    public final Node node;
    public final boolean omitXMLDeclaration;
    public final int indentAmount;
    public DOMPayload(String contentType, Node node, boolean omitXMLDeclaration, int indentAmount){
        super(contentType);
        this.node = node;
        this.omitXMLDeclaration = omitXMLDeclaration;
        this.indentAmount = indentAmount;
    }

    @Override
    public void writeTo(OutputStream out) throws IOException{
        try{
            Transformer transformer = TransformerUtil.newTransformer(null, omitXMLDeclaration, indentAmount, IOUtil.UTF_8.name());
            transformer.transform(new DOMSource(node), new StreamResult(out));
        }catch(TransformerException ex){
            throw new IOException(ex);
        }
    }
}
