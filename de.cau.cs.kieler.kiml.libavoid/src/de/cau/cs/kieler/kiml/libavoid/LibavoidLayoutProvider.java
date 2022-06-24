/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2013 by
 * + Kiel University
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.libavoid;

import org.eclipse.elk.alg.common.nodespacing.NodeDimensionCalculation;
import org.eclipse.elk.core.AbstractLayoutProvider;
import org.eclipse.elk.core.util.IElkProgressMonitor;
import org.eclipse.elk.core.util.adapters.ElkGraphAdapters;
import org.eclipse.elk.core.util.adapters.ElkGraphAdapters.ElkGraphAdapter;
import org.eclipse.elk.graph.ElkNode;

import de.cau.cs.kieler.kiml.libavoid.options.LibavoidOptions;
import de.cau.cs.kieler.kiml.libavoid.server.LibavoidServer;
import de.cau.cs.kieler.kiml.libavoid.server.LibavoidServerPool;

/**
 * A layout provider for KIML that performs layout using the Libavoid connector routing library. See
 * http://www.adaptagrams.org/documentation/ for further information on the library.
 * 
 * @author uru
 */
public class LibavoidLayoutProvider extends AbstractLayoutProvider {

    private LibavoidServerCommunicator comm = new LibavoidServerCommunicator();

    /**
     * {@inheritDoc}
     */
    @Override
    public void layout(final ElkNode parentNode, final IElkProgressMonitor progressMonitor) {

        // TODO
        // at this point the 'DIRECTION' should be set to a reasonable value ... 
        // parentNode.setProperty(LibavoidOptions.DIRECTION, Direction.DOWN);
        
        // TODO check if we should set this to 0 by default
        parentNode.setProperty(LibavoidOptions.IDEAL_NUDGING_DISTANCE, 0d);
        
        // calculate node margins
        ElkGraphAdapter adapter = ElkGraphAdapters.adapt(parentNode);

        NodeDimensionCalculation.sortPortLists(adapter);
        
        // TODO this behaves strangely (creates different node sizes for the layered alg)
        // NodeDimensionCalculation.calculateLabelAndNodeSizes(adapter);
        
        NodeDimensionCalculation.calculateNodeMargins(adapter);
        
        // create an Libavoid server process instance or use an existing one
        LibavoidServer lvServer = LibavoidServerPool.INSTANCE.fetch();
        // send a layout request to the server process and apply the layout
        comm.requestLayout(parentNode, progressMonitor, lvServer);
        // if everything worked well, release the used process instance
        LibavoidServerPool.INSTANCE.release(lvServer);

    }

}
