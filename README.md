# Graph Cache

Graph Cache is a Java based caching system that makes use of Caffeine and JGrapht libraries to create caching mechanisms for JGraphT graphe structures.

Features at a glance:
  - High performance Caching using Caffeine
  - Ability to save data in JGraphT multigraph structures and Cache in memory using Caffeine
  - Maintain data in Source Node and Child node objects and Edges that maintain relationships between Nodes.

# Some use cases

  - Save snapshots of single page sites in parent child div relationships
  - Save relational data using Node to Node relationships and use edges to specify the relation

### Installation

Graph Cache can be built using Maven comman line into a Jar that can be included as a dependency into your java project.

Using Maven command line, use the following commands:

1. mvn clean
2. mvn install

To create the jar artifact. Include as dependency in your Java project or extend and customize to your liking.


