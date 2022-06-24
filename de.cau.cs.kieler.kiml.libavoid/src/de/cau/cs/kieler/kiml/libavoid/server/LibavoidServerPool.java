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
package de.cau.cs.kieler.kiml.libavoid.server;

import java.util.LinkedList;

import de.cau.cs.kieler.kiml.libavoid.server.LibavoidServer.Cleanup;


/**
 * A pool for Libavoid server process instances.
 *
 * @author msp
 */
public final class LibavoidServerPool {
    
    /** the singleton instance of the server pool. */
    public static final LibavoidServerPool INSTANCE = new LibavoidServerPool();
    
    /**
     * Hide constructor to avoid instantiation from outside.
     */
    private LibavoidServerPool() {
    }
    
    /** the list of currently available servers. */
    private LinkedList<LibavoidServer> servers = new LinkedList<LibavoidServer>();
    
    /**
     * Fetch an Libavoid server process from the pool, creating one if necessary.
     * 
     * @return an Libavoid server process
     */
    public LibavoidServer fetch() {
        synchronized (servers) {
            if (servers.isEmpty()) {
                return new LibavoidServer();
            }
            return servers.removeFirst();
        }
    }
    
    /**
     * Release a previously created server process into the pool. Only instances that
     * are still usable may be released. Process instances that lead to errors must be closed
     * without releasing them.
     * 
     * @param server an Libavoid server process
     */
    public void release(final LibavoidServer server) {
        synchronized (servers) {
            servers.add(server);
        }
    }
    
    /**
     * Dispose all created server instances.
     */
    public void dispose() {
        synchronized (servers) {
            for (LibavoidServer server : servers) {
                server.cleanup(Cleanup.STOP);
            }
            servers.clear();
        }
    }

}
