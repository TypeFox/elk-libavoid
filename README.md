# ELK Libavoid

[![Build](https://github.com/TypeFox/elk-libavoid/actions/workflows/main.yml/badge.svg)](https://github.com/TypeFox/elk-libavoid/actions/workflows/main.yml)

This project wraps [libavoid-server](https://github.com/TypeFox/libavoid-server) into [ELK](https://www.eclipse.org/elk/) to make it available in Java applications. The edge routing algorithm is accessed through a [layout provider](https://github.com/TypeFox/elk-libavoid/blob/main/de.cau.cs.kieler.kiml.libavoid/src/de/cau/cs/kieler/kiml/libavoid/LibavoidLayoutProvider.java) and its [layout options](https://github.com/TypeFox/elk-libavoid/blob/main/de.cau.cs.kieler.kiml.libavoid/src-gen/de/cau/cs/kieler/kiml/libavoid/options/LibavoidOptions.java) reflect the [configuration options](https://github.com/TypeFox/libavoid-server/blob/main/README.md#configuration) of libavoid.

The libavoid edge router can be used in the same way as [other ELK layouts](https://www.eclipse.org/elk/documentation/tooldevelopers.html). The specialty of this layout provider is that it does not modify positions of nodes and ports, but it only computes edge routes. This enables to automatically adjust connections when the user moves a node or port.

_Important:_ All nodes and ports must be assigned proper positions before this algorithm is invoked. In addition, all ports need a value for the [Port Side](https://www.eclipse.org/elk/reference/options/org-eclipse-elk-port-side.html) option.

Examples are available in the [elk-libavoid-examples](https://github.com/TypeFox/elk-libavoid-examples) repository.

## CI and Releasing

You can download a zipped p2 repository (p2-update-site.zip) from the [GH Action](https://github.com/TypeFox/elk-libavoid/actions/workflows/main.yml?query=is%3Asuccess+branch%3Amain) assets.
### Nightly Build

On each commit to the `main` branch, the [main](https://github.com/TypeFox/elk-libavoid/blob/main/.github/workflows/main.yml) GH Action will be triggered:

 - Download configured version (see main.yaml) of [libavoid-server](https://github.com/TypeFox/libavoid-server)
 - Build P2 Repository
 - Publish the repository to the [nighty update site](https://typefox.github.io/elk-libavoid/download/updates/main): `https://typefox.github.io/elk-libavoid/download/updates/main/`

### Release Build

On each tag push, the [main](https://github.com/TypeFox/elk-libavoid/blob/main/.github/workflows/main.yml) GH Action will be triggered:

 - Download configured version (see main.yaml) of [libavoid-server](https://github.com/TypeFox/libavoid-server)
 - Build P2 Repository
 - Publish the repository to the corresponding update site. For tag `v0.1.0` the repository will be published under following URL: `https://typefox.github.io/elk-libavoid/download/updates/v0.1.0/`

**Note:** The published repository location will be completely replaced. Pushing the same tag twice will replace the existing p2 repository with the new version.
