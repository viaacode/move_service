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
	 * The name of the file
	 */
	@SerializedName("file_name")
	private String filename;
	
	/**
	 * The directory the file is located in
	 */
	@SerializedName("file_source_path")
	private String sourcePath;
	
	/**
	 * The directory the file is located in
	 */
	@SerializedName("file_destination_path")
	private String destinationPath;

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
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
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
		return sourcePath;
	}

	/**
	 * @param sourcePath the sourcePath to set
	 */
	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}

	/**
	 * @return the destinationPath
	 */
	public String getDestinationPath() {
		return destinationPath;
	}

	/**
	 * @param destinationPath the destinationPath to set
	 */
	public void setDestinationPath(String destinationPath) {
		this.destinationPath = destinationPath;
	}

}
