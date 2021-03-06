/*
 * Copyright (C) 2014 Red Hat, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Authors : Madhu Venugopal
 */
package org.opendaylight.ovs.nx.sal.convertor.match;

import java.util.HashSet;
import java.util.Set;

import org.opendaylight.openflowjava.nx.api.NiciraConstants;
import org.opendaylight.openflowplugin.extension.api.GroupingResolver;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.augments.rev131002.ExperimenterIdMatchEntry;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.augments.rev131002.ExperimenterIdMatchEntryBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.common.types.rev130731.ExperimenterId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.oxm.rev130731.MatchField;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.oxm.rev130731.OxmClassBase;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.oxm.rev130731.oxm.fields.grouping.MatchEntries;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.oxm.rev130731.oxm.fields.grouping.MatchEntriesBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.ovs.nx.match.rev140421.OfjAugNxMatch;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflowplugin.extension.general.rev140714.general.extension.grouping.Extension;
import org.opendaylight.yang.gen.v1.urn.opendaylight.ovs.nx.sal.match.rev140714.NxAugMatchNodesNodeTableFlow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.ovs.nx.sal.match.rev140714.NxAugMatchNotifPacketIn;
import org.opendaylight.yang.gen.v1.urn.opendaylight.ovs.nx.sal.match.rev140714.NxAugMatchNotifSwitchFlowRemoved;
import org.opendaylight.yang.gen.v1.urn.opendaylight.ovs.nx.sal.match.rev140714.NxAugMatchNotifUpdateFlowStats;
import org.opendaylight.yang.gen.v1.urn.opendaylight.ovs.nx.sal.match.rev140714.NxAugMatchRpcAddFlow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.ovs.nx.sal.match.rev140714.NxAugMatchRpcRemoveFlow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.ovs.nx.sal.match.rev140714.NxAugMatchRpcUpdateFlowOriginal;
import org.opendaylight.yang.gen.v1.urn.opendaylight.ovs.nx.sal.match.rev140714.NxAugMatchRpcUpdateFlowUpdated;
import org.opendaylight.yang.gen.v1.urn.opendaylight.ovs.nx.sal.match.rev140714.NxmNxNspGrouping;
import org.opendaylight.yang.gen.v1.urn.opendaylight.ovs.nx.sal.match.rev140714.NxmNxNsiGrouping;
import org.opendaylight.yangtools.yang.binding.Augmentation;

public class MatchUtil {

    private final static Set<Class<? extends Augmentation<Extension>>> augmentationsOfExtension = new HashSet<>();
    public final static GroupingResolver<NxmNxNspGrouping, Extension> nspResolver = new GroupingResolver<>(
            NxmNxNspGrouping.class);
    public final static GroupingResolver<NxmNxNsiGrouping, Extension> nsiResolver = new GroupingResolver<>(
            NxmNxNsiGrouping.class);
    public final static ExperimenterIdMatchEntry EXPERIMENTER_ID_MATCH_ENTRY;

    static {
        augmentationsOfExtension.add(NxAugMatchRpcAddFlow.class);
        augmentationsOfExtension.add(NxAugMatchRpcRemoveFlow.class);
        augmentationsOfExtension.add(NxAugMatchRpcUpdateFlowOriginal.class);
        augmentationsOfExtension.add(NxAugMatchRpcUpdateFlowUpdated.class);
        augmentationsOfExtension.add(NxAugMatchNodesNodeTableFlow.class);
        augmentationsOfExtension.add(NxAugMatchNotifSwitchFlowRemoved.class);
        augmentationsOfExtension.add(NxAugMatchNotifPacketIn.class);
        augmentationsOfExtension.add(NxAugMatchNotifUpdateFlowStats.class);
        nspResolver.setAugmentations(augmentationsOfExtension);
        nsiResolver.setAugmentations(augmentationsOfExtension);
        ExperimenterIdMatchEntryBuilder experimenterIdMatchEntryBuilder = new ExperimenterIdMatchEntryBuilder();
        experimenterIdMatchEntryBuilder.setExperimenter(new ExperimenterId(NiciraConstants.NX_VENDOR_ID));
        EXPERIMENTER_ID_MATCH_ENTRY = experimenterIdMatchEntryBuilder.build();
    }

    public static MatchEntries createNiciraMatchEntries(Class<? extends OxmClassBase> oxmClass,
            Class<? extends MatchField> oxmMatchField, boolean hasMask, OfjAugNxMatch augNxMatch) {
        MatchEntriesBuilder matchEntriesBuilder = new MatchEntriesBuilder();
        matchEntriesBuilder.setOxmClass(oxmClass).setOxmMatchField(oxmMatchField).setHasMask(hasMask);
        matchEntriesBuilder.addAugmentation(ExperimenterIdMatchEntry.class, EXPERIMENTER_ID_MATCH_ENTRY);
        matchEntriesBuilder.addAugmentation(OfjAugNxMatch.class, augNxMatch);
        return matchEntriesBuilder.build();
    }

}
