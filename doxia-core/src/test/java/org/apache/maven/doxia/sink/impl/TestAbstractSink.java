/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.maven.doxia.sink.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAbstractSink {
    @Test
    public void testUnifiedEOL() {
        String eol = AbstractSink.EOL;
        String eolMacos9 = "\r";
        String eolUnix = "\n";
        String eolWin = "\r\n";

        assertEquals("Hello " + eol + " world", AbstractSink.unifyEOLs("Hello " + eolMacos9 + " world"));
        assertEquals("Hello " + eol + " world", AbstractSink.unifyEOLs("Hello " + eolUnix + " world"));
        assertEquals("Hello " + eol + " world", AbstractSink.unifyEOLs("Hello " + eolWin + " world"));

        assertEquals("Hello world" + eol, AbstractSink.unifyEOLs("Hello world" + eolMacos9));
        assertEquals("Hello world" + eol, AbstractSink.unifyEOLs("Hello world" + eolUnix));
        assertEquals("Hello world" + eol, AbstractSink.unifyEOLs("Hello world" + eolWin));

        assertEquals(eol + "Hello world", AbstractSink.unifyEOLs(eolMacos9 + "Hello world"));
        assertEquals(eol + "Hello world", AbstractSink.unifyEOLs(eolUnix + "Hello world"));
        assertEquals(eol + "Hello world", AbstractSink.unifyEOLs(eolWin + "Hello world"));
    }
}
