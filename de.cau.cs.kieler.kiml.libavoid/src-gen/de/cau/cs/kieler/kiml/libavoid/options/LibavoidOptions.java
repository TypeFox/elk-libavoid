/**
 * Copyright (c) 2016 Kiel University and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package de.cau.cs.kieler.kiml.libavoid.options;

import de.cau.cs.kieler.kiml.libavoid.LibavoidLayoutProvider;
import org.eclipse.elk.core.AbstractLayoutProvider;
import org.eclipse.elk.core.data.ILayoutMetaDataProvider;
import org.eclipse.elk.core.data.LayoutAlgorithmData;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.Direction;
import org.eclipse.elk.core.options.EdgeRouting;
import org.eclipse.elk.core.options.PortConstraints;
import org.eclipse.elk.core.options.PortSide;
import org.eclipse.elk.graph.properties.IProperty;
import org.eclipse.elk.graph.properties.Property;

@SuppressWarnings("all")
public class LibavoidOptions implements ILayoutMetaDataProvider {
  /**
   * The id of the Libavoid algorithm.
   */
  public static final String ALGORITHM_ID = "de.cau.cs.kieler.kiml.libavoid";
  
  /**
   * Default value for {@link #DEBUG_MODE} with algorithm "Libavoid".
   */
  private static final boolean DEBUG_MODE_DEFAULT = false;
  
  /**
   * Whether additional debug information shall be generated.
   */
  public static final IProperty<Boolean> DEBUG_MODE = new Property<Boolean>(
                                CoreOptions.DEBUG_MODE,
                                DEBUG_MODE_DEFAULT);
  
  /**
   * The side of a node on which a port is situated. This option must be set if 'Port
   * Constraints' is set to FIXED_SIDE or FIXED_ORDER and no specific positions are given
   * for the ports.
   */
  public static final IProperty<PortSide> PORT_SIDE = CoreOptions.PORT_SIDE;
  
  /**
   * Overall direction of edges: horizontal (right / left) or
   * vertical (down / up).
   */
  public static final IProperty<Direction> DIRECTION = CoreOptions.DIRECTION;
  
  /**
   * Default value for {@link #EDGE_ROUTING} with algorithm "Libavoid".
   */
  private static final EdgeRouting EDGE_ROUTING_DEFAULT = EdgeRouting.ORTHOGONAL;
  
  /**
   * What kind of edge routing style should be applied for the content of a parent node.
   * Algorithms may also set this option to single edges in order to mark them as splines.
   * The bend point list of edges with this option set to SPLINES must be interpreted as control
   * points for a piecewise cubic spline.
   */
  public static final IProperty<EdgeRouting> EDGE_ROUTING = new Property<EdgeRouting>(
                                CoreOptions.EDGE_ROUTING,
                                EDGE_ROUTING_DEFAULT);
  
  /**
   * Default value for {@link #PORT_CONSTRAINTS} with algorithm "Libavoid".
   */
  private static final PortConstraints PORT_CONSTRAINTS_DEFAULT = PortConstraints.FREE;
  
  /**
   * Defines constraints of the position of the ports of a node.
   */
  public static final IProperty<PortConstraints> PORT_CONSTRAINTS = new Property<PortConstraints>(
                                CoreOptions.PORT_CONSTRAINTS,
                                PORT_CONSTRAINTS_DEFAULT);
  
  /**
   * This penalty is applied for each segment in the connector path beyond the first.
   * This should always normally be set when doing orthogonal routing to prevent
   * step-like connector paths.
   */
  public static final IProperty<Double> SEGMENT_PENALTY = LibavoidMetaDataProvider.SEGMENT_PENALTY;
  
  /**
   * This penalty is applied in its full amount to tight acute bends in the connector path.
   * A smaller portion of the penalty is applied for slight bends, i.e., where the bend is close
   * to 180 degrees. This is useful for polyline routing where there is some evidence that tighter
   * corners are worse for readability, but that slight bends might not be so bad,
   * especially when smoothed by curves.
   */
  public static final IProperty<Double> ANGLE_PENALTY = LibavoidMetaDataProvider.ANGLE_PENALTY;
  
  /**
   * This penalty is applied whenever a connector path crosses another connector path.
   * It takes shared paths into consideration and the penalty is only applied
   * if there is an actual crossing.
   */
  public static final IProperty<Double> CROSSING_PENALTY = LibavoidMetaDataProvider.CROSSING_PENALTY;
  
  /**
   * This penalty is applied whenever a connector path crosses a cluster boundary.
   */
  public static final IProperty<Double> CLUSTER_CROSSING_PENALTY = LibavoidMetaDataProvider.CLUSTER_CROSSING_PENALTY;
  
  /**
   * This penalty is applied whenever a connector path shares some segments with an immovable
   * portion of an existing connector route (such as the first or last segment of a connector).
   */
  public static final IProperty<Double> FIXED_SHARED_PATH_PENALTY = LibavoidMetaDataProvider.FIXED_SHARED_PATH_PENALTY;
  
  /**
   * This penalty is applied to port selection choice when the other end of the connector
   * being routed does not appear in any of the 90 degree visibility cones centered on the
   * visibility directions for the port.
   */
  public static final IProperty<Double> PORT_DIRECTION_PENALTY = LibavoidMetaDataProvider.PORT_DIRECTION_PENALTY;
  
  /**
   * This parameter defines the spacing distance that will be added to the sides of each
   * shape when determining obstacle sizes for routing. This controls how closely connectors
   * pass shapes, and can be used to prevent connectors overlapping with shape boundaries.
   * By default, this distance is set to a value of 4.
   */
  public static final IProperty<Double> SHAPE_BUFFER_DISTANCE = LibavoidMetaDataProvider.SHAPE_BUFFER_DISTANCE;
  
  /**
   * This parameter defines the spacing distance that will be used for nudging apart
   * overlapping corners and line segments of connectors. By default,
   * this distance is set to a value of 4.
   */
  public static final IProperty<Double> IDEAL_NUDGING_DISTANCE = LibavoidMetaDataProvider.IDEAL_NUDGING_DISTANCE;
  
  /**
   * This option causes the final segments of connectors, which are attached to shapes,
   * to be nudged apart. Usually these segments are fixed, since they are considered to be
   * attached to ports. This option is not set by default.
   */
  public static final IProperty<Boolean> NUDGE_ORTHOGONAL_SEGMENTS_CONNECTED_TO_SHAPES = LibavoidMetaDataProvider.NUDGE_ORTHOGONAL_SEGMENTS_CONNECTED_TO_SHAPES;
  
  /**
   * This option causes hyperedge routes to be locally improved fixing obviously bad paths.
   * As part of this process libavoid will effectively move junctions, setting new ideal positions
   * ( JunctionRef::recommendedPosition() ) for each junction.
   */
  public static final IProperty<Boolean> IMPROVE_HYPEREDGE_ROUTES_MOVING_JUNCTIONS = LibavoidMetaDataProvider.IMPROVE_HYPEREDGE_ROUTES_MOVING_JUNCTIONS;
  
  /**
   * This option penalises and attempts to reroute orthogonal shared connector paths terminating
   * at a common junction or shape connection pin. When multiple connector paths enter or leave
   * the same side of a junction (or shape pin), the router will attempt to reroute these to
   * different sides of the junction or different shape pins. This option depends on the
   * fixedSharedPathPenalty penalty having been set.
   */
  public static final IProperty<Boolean> PENALISE_ORTHOGONAL_SHARED_PATHS_AT_CONN_ENDS = LibavoidMetaDataProvider.PENALISE_ORTHOGONAL_SHARED_PATHS_AT_CONN_ENDS;
  
  /**
   * This option can be used to control whether colinear line segments that touch just at
   * their ends will be nudged apart. The overlap will usually be resolved in the other dimension,
   * so this is not usually required and is not set by default.
   */
  public static final IProperty<Boolean> NUDGE_ORTHOGONAL_TOUCHING_COLINEAR_SEGMENTS = LibavoidMetaDataProvider.NUDGE_ORTHOGONAL_TOUCHING_COLINEAR_SEGMENTS;
  
  /**
   * This option can be used to control whether the router performs a preprocessing step before
   * orthogonal nudging where is tries to unify segments and centre them in free space.
   * This generally results in better quality ordering and nudging.
   */
  public static final IProperty<Boolean> PERFORM_UNIFYING_NUDGING_PREPROCESSING_STEP = LibavoidMetaDataProvider.PERFORM_UNIFYING_NUDGING_PREPROCESSING_STEP;
  
  /**
   * This option causes hyperedge routes to be locally improved fixing obviously bad paths.
   */
  public static final IProperty<Boolean> IMPROVE_HYPEREDGE_ROUTES_MOVING_ADDING_AND_DELETING_JUNCTIONS = LibavoidMetaDataProvider.IMPROVE_HYPEREDGE_ROUTES_MOVING_ADDING_AND_DELETING_JUNCTIONS;
  
  /**
   * Layouter-specific algorithm factory.
   */
  public static class LibavoidFactory implements org.eclipse.elk.core.util.IFactory<AbstractLayoutProvider> {
    public AbstractLayoutProvider create() {
      AbstractLayoutProvider provider = new LibavoidLayoutProvider();
      provider.initialize("");
      return provider;
    }
    
    public void destroy(final AbstractLayoutProvider obj) {
      obj.dispose();
    }
  }
  
  public void apply(final org.eclipse.elk.core.data.ILayoutMetaDataProvider.Registry registry) {
    registry.register(new LayoutAlgorithmData.Builder()
        .id("de.cau.cs.kieler.kiml.libavoid")
        .name("Libavoid")
        .description("libavoid is a cross-platform C++ library providing fast, object-avoiding orthogonal and polyline connector routing for use in interactive diagram editors.")
        .providerFactory(new LibavoidFactory())
        .category("de.cau.cs.kieler.kiml.libavoid.edge")
        .melkBundleName("Libavoid Connector Routing")
        .definingBundleId("de.cau.cs.kieler.kiml.libavoid")
        .create()
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "org.eclipse.elk.debugMode",
        DEBUG_MODE_DEFAULT
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "org.eclipse.elk.port.side",
        PORT_SIDE.getDefault()
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "org.eclipse.elk.direction",
        DIRECTION.getDefault()
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "org.eclipse.elk.edgeRouting",
        EDGE_ROUTING_DEFAULT
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "org.eclipse.elk.portConstraints",
        PORT_CONSTRAINTS_DEFAULT
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "de.cau.cs.kieler.kiml.libavoid.segmentPenalty",
        SEGMENT_PENALTY.getDefault()
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "de.cau.cs.kieler.kiml.libavoid.anglePenalty",
        ANGLE_PENALTY.getDefault()
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "de.cau.cs.kieler.kiml.libavoid.crossingPenalty",
        CROSSING_PENALTY.getDefault()
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "de.cau.cs.kieler.kiml.libavoid.clusterCrossingPenalty",
        CLUSTER_CROSSING_PENALTY.getDefault()
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "de.cau.cs.kieler.kiml.libavoid.fixedSharedPathPenalty",
        FIXED_SHARED_PATH_PENALTY.getDefault()
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "de.cau.cs.kieler.kiml.libavoid.portDirectionPenalty",
        PORT_DIRECTION_PENALTY.getDefault()
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "de.cau.cs.kieler.kiml.libavoid.shapeBufferDistance",
        SHAPE_BUFFER_DISTANCE.getDefault()
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "de.cau.cs.kieler.kiml.libavoid.idealNudgingDistance",
        IDEAL_NUDGING_DISTANCE.getDefault()
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "de.cau.cs.kieler.kiml.libavoid.nudgeOrthogonalSegmentsConnectedToShapes",
        NUDGE_ORTHOGONAL_SEGMENTS_CONNECTED_TO_SHAPES.getDefault()
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "de.cau.cs.kieler.kiml.libavoid.improveHyperedgeRoutesMovingJunctions",
        IMPROVE_HYPEREDGE_ROUTES_MOVING_JUNCTIONS.getDefault()
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "de.cau.cs.kieler.kiml.libavoid.penaliseOrthogonalSharedPathsAtConnEnds",
        PENALISE_ORTHOGONAL_SHARED_PATHS_AT_CONN_ENDS.getDefault()
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "de.cau.cs.kieler.kiml.libavoid.nudgeOrthogonalTouchingColinearSegments",
        NUDGE_ORTHOGONAL_TOUCHING_COLINEAR_SEGMENTS.getDefault()
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "de.cau.cs.kieler.kiml.libavoid.performUnifyingNudgingPreprocessingStep",
        PERFORM_UNIFYING_NUDGING_PREPROCESSING_STEP.getDefault()
    );
    registry.addOptionSupport(
        "de.cau.cs.kieler.kiml.libavoid",
        "de.cau.cs.kieler.kiml.libavoid.improveHyperedgeRoutesMovingAddingAndDeletingJunctions",
        IMPROVE_HYPEREDGE_ROUTES_MOVING_ADDING_AND_DELETING_JUNCTIONS.getDefault()
    );
  }
}
