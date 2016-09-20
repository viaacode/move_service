package be.viaa.move.model;

import com.google.gson.annotations.SerializedName;

/**
 * An FXP request
 * 
 * @author Hannes Lowette
 *
 */
public class MoveRequest {

	/**
	 * The name of the source file
	 */
	@SerializedName("source_name")
	private String source_name;
        
        /**
	 * The name of the destination file
	 */
	@SerializedName("destination_name")
	private String destination_name;
	
	/**
	 * The directory the source file is located in
	 */
	@SerializedName("source_path")
	private String source_path;
	
	/**
	 * The destination directory
	 */
	@SerializedName("destination_path")
	private String destination_path;

	/**
	 * The remote location of the FTP server
	 */
	private String host;

	/**
	 * The username used to access the FTP server
	 */
	private String username;

	/**
	 * The password to authenticate on the server
	 */
	private String password;
	
	/**
	 * The correlation ID of the file
	 */
	@SerializedName("correlation_id")
	private String correlationId;

	/**
	 * @return the source filename
	 */
	public String getSourceFilename() {
		return source_name;
	}

	/**
	 * @param filename the source filename to set
	 */
	public void setSourceFilename(String filename) {
		this.source_name = filename;
	}
        
        /**
	 * @return the destination filename
	 */
	public String getDestinationName() {
		return destination_name;
	}

	/**
	 * @param filename the destination filename to set
	 */
	public void setDestinationName(String filename) {
		this.destination_name = filename;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the correlationId
	 */
	public String getCorrelationId() {
		return correlationId;
	}

	/**
	 * @param correlationId the correlationId to set
	 */
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	/**
	 * @return the sourcePath
	 */
	public String getSourcePath() {
		return source_path;
	}

	/**
	 * @param sourcePath the sourcePath to set
	 */
	public void setSourcePath(String sourcePath) {
		this.source_path = sourcePath;
	}

	/**
	 * @return the destinationPath
	 */
	public String getDestinationPath() {
		return destination_path;
	}

	/**
	 * @param destinationPath the destinationPath to set
	 */
	public void setDestinationPath(String destinationPath) {
		this.destination_path = destinationPath;
	}

}
