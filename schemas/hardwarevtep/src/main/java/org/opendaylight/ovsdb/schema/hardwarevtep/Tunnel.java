/*
 * Copyright (C) 2014 Red Hat, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Authors : Madhu Venugopal
 */
package org.opendaylight.ovsdb.schema.hardwarevtep;

import java.util.Map;

import org.opendaylight.ovsdb.lib.notation.Column;
import org.opendaylight.ovsdb.lib.notation.UUID;
import org.opendaylight.ovsdb.lib.schema.GenericTableSchema;
import org.opendaylight.ovsdb.lib.schema.typed.MethodType;
import org.opendaylight.ovsdb.lib.schema.typed.TypedBaseTable;
import org.opendaylight.ovsdb.lib.schema.typed.TypedColumn;
import org.opendaylight.ovsdb.lib.schema.typed.TypedTable;

@TypedTable(name="Tunnel", database="hardware_vtep", fromVersion="1.3.0")
public interface Tunnel extends TypedBaseTable<GenericTableSchema> {
    @TypedColumn(name="local", method=MethodType.GETCOLUMN, fromVersion="1.3.0")
    public Column<GenericTableSchema, UUID> getLocalColumn();

    @TypedColumn(name="local", method=MethodType.SETDATA, fromVersion="1.3.0")
    public void setLocal(UUID local);

    @TypedColumn(name="remote", method=MethodType.GETCOLUMN, fromVersion="1.3.0")
    public Column<GenericTableSchema, UUID> getRemoteColumn();

    @TypedColumn(name="remote", method=MethodType.SETDATA, fromVersion="1.3.0")
    public void setRemote(UUID remote);

    @TypedColumn(name="bfd_config_local", method=MethodType.GETCOLUMN, fromVersion="1.3.0")
    public Column<GenericTableSchema, Map<String, String>> getBfdConfigLocalColumn();

    @TypedColumn(name="bfd_config_local", method=MethodType.SETDATA, fromVersion="1.3.0")
    public void setBfdConfigLocal(Map<String, String> bfdConfigLocal);

    @TypedColumn(name="bfd_config_remote", method=MethodType.GETCOLUMN, fromVersion="1.3.0")
    public Column<GenericTableSchema, Map<String, String>> getBfdConfigRemoteColumn();

    @TypedColumn(name="bfd_config_remote", method=MethodType.SETDATA, fromVersion="1.3.0")
    public void setBfdConfigRemote(Map<String, String> bfdConfigRemote);

    @TypedColumn(name="bfd_params", method=MethodType.GETCOLUMN, fromVersion="1.3.0")
    public Column<GenericTableSchema, Map<String, String>> getBfdParamsColumn();

    @TypedColumn(name="bfd_params", method=MethodType.SETDATA, fromVersion="1.3.0")
    public void setBfdParams(Map<String, String> bfdParams);

    @TypedColumn(name="bfd_status", method=MethodType.GETCOLUMN, fromVersion="1.3.0")
    public Column<GenericTableSchema, Map<String, String>> getBfdStatusColumn();

    @TypedColumn(name="bfd_status", method=MethodType.SETDATA, fromVersion="1.3.0")
    public void setBfdStatus(Map<String, String> bfdStatus);
}
