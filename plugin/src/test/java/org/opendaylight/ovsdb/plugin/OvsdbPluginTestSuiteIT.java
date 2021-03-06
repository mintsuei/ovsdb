/*
 * Copyright (C) 2014 Red Hat, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Authors : Madhu Venugopal, Dave Tucker
 */
package org.opendaylight.ovsdb.plugin;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.opendaylight.ovsdb.plugin.PluginTestBase.TestObjects;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    BridgeDomainConfigBridgeTestCases.class,
    BridgeDomainConfigPortTestCases.class,
    BridgeDomainConfigManagerTestCases.class,
    TearDown.class})

public class OvsdbPluginTestSuiteIT {
    static TestObjects testObjects;

    public static TestObjects getTestObjects() {
        return testObjects;
    }

    public static void setTestObjects(TestObjects testObjects) {
        OvsdbPluginTestSuiteIT.testObjects = testObjects;
    }

}
