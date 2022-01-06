package org.api.util;

public class ApiConfig {
	
	private String basePath;
	private String port;
	private String host;
	
	public String getPath() {
		return basePath;
	}
	
	public String getPort() {
		return port;
	}
	
	public String getHost() {
		return host;
	}

	public ApiConfig(String basePath, String port, String host) {
		super();
		this.basePath = basePath;
		this.port = port;
		this.host = host;
	}
	
	@Override
	public String toString() {
		return String.format("ApiConfig [basePath=%s, port=%s, host=%s]", basePath, port, host);
	}
	

}
