
nexus-snapshot:
	mvn install deploy -DaltDeploymentRepository=nexus::default::http://teletraan:8081/repository/maven-snapshots/

nexus-release:
	mvn install deploy -DaltDeploymentRepository=nexus::default::http://teletraan:8081/repository/maven-releases/


