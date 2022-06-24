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
 */
package de.cau.cs.kieler.kiml.libavoid;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import de.cau.cs.kieler.kiml.libavoid.server.LibavoidServerPool;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author uru
 */
public class LibavoidPlugin extends Plugin {

    /** the plug-in ID. */
    public static final String PLUGIN_ID = "org.adaptagrams.cola.libavoid"; //$NON-NLS-1$

    /** the shared instance. */
    private static LibavoidPlugin plugin;
    
    /**
     * The constructor.
     */
    public LibavoidPlugin() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop(final BundleContext context) throws Exception {
        plugin = null;
        LibavoidServerPool.INSTANCE.dispose();
        super.stop(context);
    }

    /**
     * Returns the shared instance.
     *
     * @return the shared instance
     */
    public static LibavoidPlugin getDefault() {
        return plugin;
    }

}
