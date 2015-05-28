package org.pan;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class APPUIModel {
	
	final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	private String localMavenFloder;
	
	private Dependency dependency = new Dependency();
	
	private List<Dependency> dependencies = new ArrayList<Dependency>();

	public String getLocalMavenFloder() {
		return localMavenFloder;
	}

	public void setLocalMavenFloder(String localMavenFloder) {
		this.localMavenFloder = localMavenFloder;
		pcs.firePropertyChange("localMavenFloder", null, null);
	}

	public Dependency getDependency() {
		return dependency;
	}

	public void setDependency(Dependency dependency) {
		this.dependency = dependency;
		pcs.firePropertyChange("dependency", null, null);
	}

	public List<Dependency> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<Dependency> dependencies) {
		this.dependencies = dependencies;
		pcs.firePropertyChange("dependencies", null, null);
	}
	
	
}
