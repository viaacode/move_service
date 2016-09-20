package be.viaa.move.model;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Response when the FXP transfer has been carried out
 * 
 * @author Hannes Lowette
 *
 */
public class MoveResponse {
	
	/**
	 * The filename of the deleted source file
	 */
	@SerializedName("source_filename")
	private String source_filename;
	
        /**
	 * The filename of the destination file
	 */
	@SerializedName("destination_filename")
	private String destination_filename;
        
	/**
	 * The directory of the file
	 */
	@SerializedName("source_path")
	private String sourceDirectory;
	
	/**
	 * The directory of the file
	 */
	@SerializedName("destination_path")
	private String destinationDirectory;
	
	/**
	 * The correlation ID of the file
	 */
	@SerializedName("correlation_id")
	private String correlationId;
	
	/**
	 * The status of the deletion (OK/NOK)
	 */
	private String status;
	
	/**
	 * Collection of exceptions
	 */
	private List<String> messages;

	/**
	 * 
	 * @param messages
	 */
	public void setMessages(List<Exception> messages) {
		for (Exception exception : messages) {
			addMessage(exception);
		}
	}
	
	/**
	 * 
	 * @param exception
	 */
	public void addMessage(Exception exception) {
		if (messages == null) {
			messages = new ArrayList<>();
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		exception.printStackTrace(new PrintStream(baos));
		messages.add(new String(baos.toByteArray(), StandardCharsets.UTF_8));
	}

	/**
	 * @return the source filename
	 */
	public String getSourceFilename() {
		return source_filename;
	}

	/**
	 * @param filename the source filename to set
	 */
	public void setSourceFilename(String filename) {
		this.source_filename = filename;
	}
        
        /**
	 * @return the source filename
	 */
	public String getDestinationFilename() {
		return destination_filename;
	}

	/**
	 * @param filename the destination filename to set
	 */
	public void setDestinationFilename(String filename) {
		this.destination_filename = filename;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the sourceDirectory
	 */
	public String getSourceDirectory() {
		return sourceDirectory;
	}

	/**
	 * @param sourceDirectory the sourceDirectory to set
	 */
	public void setSourceDirectory(String sourceDirectory) {
		this.sourceDirectory = sourceDirectory;
	}

	/**
	 * @return the destinationDirectory
	 */
	public String getDestinationDirectory() {
		return destinationDirectory;
	}

	/**
	 * @param destinationDirectory the destinationDirectory to set
	 */
	public void setDestinationDirectory(String destinationDirectory) {
		this.destinationDirectory = destinationDirectory;
	}

	/**
	 * @return
	 */
	public List<String> getMessages() {
		return messages;
	}

}
