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

/**
 * An exception that is thrown when execution of the Libavoid server process fails.
 *
 * @author uru
 */
public class LibavoidServerException extends RuntimeException {

    /** the serial version UID. */
    private static final long serialVersionUID = 8631325948240011630L;
    
    /**
     * Constructs a new server exception.
     */
    public LibavoidServerException() {
        super();
    }
    
    /**
     * Constructs a new server exception with a detail message.
     * 
     * @param message a detail message
     */
    public LibavoidServerException(final String message) {
        super(message);
    }
    
    /**
     * Constructs a new server exception with a detail message and a cause.
     * 
     * @param message a detail message
     * @param cause the cause for this exception
     */
    public LibavoidServerException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
