/**
 * Copyright 2015 Santhosh Kumar Tekuri
 *
 * The JLibs authors license this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package jlibs.xml.sax.binding.impl;

import jlibs.xml.sax.binding.SAXContext;
import org.xml.sax.SAXException;

/**
 * Establishes relation between parent and child objects
 *
 * @author Santhosh Kumar T
 */
public interface Relation{
    public void startRelation(int state, SAXContext parent, SAXContext current) throws SAXException;
    public void endRelation(int state, SAXContext parent, SAXContext current)throws SAXException;

    /*-------------------------------------------------[ DO NOTHING ]---------------------------------------------------*/

    static final Relation DO_NOTHING = new Relation(){
        @Override
        public void startRelation(int state, SAXContext parent, SAXContext current) throws SAXException{}
        @Override
        public void endRelation(int state, SAXContext parent, SAXContext current) throws SAXException{}
    };
}