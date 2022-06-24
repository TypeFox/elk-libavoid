/*******************************************************************************
 * Copyright (c) 2013, 2022 Kiel University and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
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
