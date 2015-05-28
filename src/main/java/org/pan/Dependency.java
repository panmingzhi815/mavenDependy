package org.pan;

import java.beans.PropertyChangeSupport;

public class Dependency {

	final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	private String group;
	private String artifaceId;
	private String version;
	private String url;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
		pcs.firePropertyChange("group", null, null);
	}

	public String getArtifaceId() {
		return artifaceId;
	}

	public void setArtifaceId(String artifaceId) {
		this.artifaceId = artifaceId;
		pcs.firePropertyChange("artifaceId", null, null);
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
		pcs.firePropertyChange("version", null, null);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
		pcs.firePropertyChange("url", null, null);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artifaceId == null) ? 0 : artifaceId.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dependency other = (Dependency) obj;
		if (artifaceId == null) {
			if (other.artifaceId != null)
				return false;
		} else if (!artifaceId.equals(other.artifaceId))
			return false;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	
}
