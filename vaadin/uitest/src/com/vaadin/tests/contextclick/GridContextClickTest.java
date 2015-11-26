/*
 * Copyright 2000-2014 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.tests.contextclick;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.GridElement;

public class GridContextClickTest extends AbstractContextClickTest {

    @Test
    public void testBodyContextClickWithTypedListener() {
        addOrRemoveTypedListener();

        contextClick($(GridElement.class).first().getCell(0, 0));

        assertEquals(
                "1. ContextClickEvent value: Lisa Schneider, propertyId: address, section: BODY",
                getLogRow(0));

        contextClick($(GridElement.class).first().getCell(0, 3));

        assertEquals(
                "2. ContextClickEvent value: Lisa Schneider, propertyId: lastName, section: BODY",
                getLogRow(0));
    }

    @Test
    public void testHeaderContextClickWithTypedListener() {
        addOrRemoveTypedListener();

        contextClick($(GridElement.class).first().getHeaderCell(0, 0));

        assertEquals(
                "1. ContextClickEvent value: Address, propertyId: address, section: HEADER",
                getLogRow(0));

        contextClick($(GridElement.class).first().getHeaderCell(0, 3));

        assertEquals(
                "2. ContextClickEvent value: Last Name, propertyId: lastName, section: HEADER",
                getLogRow(0));
    }

    @Test
    public void testFooterContextClickWithTypedListener() {
        addOrRemoveTypedListener();

        contextClick($(GridElement.class).first().getFooterCell(0, 0));

        assertEquals(
                "1. ContextClickEvent value: , propertyId: address, section: FOOTER",
                getLogRow(0));

        contextClick($(GridElement.class).first().getFooterCell(0, 3));

        assertEquals(
                "2. ContextClickEvent value: , propertyId: lastName, section: FOOTER",
                getLogRow(0));
    }

    @Test
    public void testContextClickInEmptyGrid() {
        addOrRemoveTypedListener();

        $(ButtonElement.class).caption("Remove all content").first().click();

        contextClick($(GridElement.class).first(), 100, 100);

        assertEquals(
                "1. ContextClickEvent value: , propertyId: null, section: BODY",
                getLogRow(0));

    }

}
