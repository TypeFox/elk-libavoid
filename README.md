# elk-libavoid

[![Build Elk libavoid repository](https://github.com/TypeFox/elk-libavoid/actions/workflows/main.yml/badge.svg)](https://github.com/TypeFox/elk-libavoid/actions/workflows/main.yml)




## CI and Releasing

You can download a zipped p2 repository (p2-update-site.zip) from the [GH Action](https://github.com/TypeFox/elk-libavoid/actions/workflows/main.yml?query=is%3Asuccess+branch%3Amain) assets  
### Nightly Build
On each commit to the `main` branch the [main](https://github.com/TypeFox/elk-libavoid/blob/main/.github/workflows/main.yml) GH Action will be triggered:
- Downloads configured version (see main.yaml) of [TypeFox/libavoid-server](https://github.com/TypeFox/libavoid-server)
- Builds P2 Repository
- Publish the repository to [nighty update site](https://typefox.github.io/elk-libavoid/download/updates/main) `https://typefox.github.io/elk-libavoid/download/updates/main/`


### Release Build
On each tag push the [main](https://github.com/TypeFox/elk-libavoid/blob/main/.github/workflows/main.yml) GH Action will be triggered:
- Downloads configured version (see main.yaml) of [TypeFox/libavoid-server](https://github.com/TypeFox/libavoid-server)
- Builds P2 Repository
- Publish the repository to the corresponding update site. For tag `v0.1.0` the repository will be published under following URL `https://typefox.github.io/elk-libavoid/download/updates/v0.1.0/`

**Note:** The published repository location will be completely replaced. Pushing the same tag twice will replace the existing p2 repository with the new version.

