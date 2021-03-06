/*
 * Copyright (C) 2013 Red Hat, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Authors : Madhu Venugopal, Brent Salisbury
 */
package org.opendaylight.ovsdb.northbound;

import java.util.Map;

import org.opendaylight.ovsdb.lib.notation.Row;

@Deprecated
public class OvsdbRows {
    Map<String, Row> rows;

    public OvsdbRows(Map<String, Row> rows) {
        super();
        this.rows = rows;
    }

    public Map<String, Row> getRows() {
        return rows;
    }

    public void setRows(Map<String, Row> rows) {
        this.rows = rows;
    }
}
