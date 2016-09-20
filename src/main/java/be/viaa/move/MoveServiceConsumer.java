package be.viaa.move;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import be.viaa.amqp.AmqpJsonConsumer;
import be.viaa.amqp.AmqpService;
import be.viaa.fxp.File;
import be.viaa.fxp.FxpFileTransporter;
import be.viaa.fxp.Host;
import be.viaa.move.model.MoveRequest;
import be.viaa.move.model.MoveResponse;
import be.viaa.util.GsonUtil;

/**
 * AMQP consumer for Move messages
 * 
 * @author Hannes Lowette
 *
 */
public class MoveServiceConsumer extends AmqpJsonConsumer<MoveRequest> {

	/**
	 * The logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(MoveServiceConsumer.class);

	/**
	 * The file transporter
	 */
	private final FxpFileTransporter transporter = new FxpFileTransporter();

	/**
	 * Constructor to identify the class used in the JSON parser
	 */
	public MoveServiceConsumer() {
		super(MoveRequest.class);
	}

	@Override
	public void accept(AmqpService service, MoveRequest message) throws Exception {
		File sourceFile = new File(message.getSourcePath(), message.getSourceFilename());
		File destinationFile = new File(message.getDestinationPath(), message.getDestinationName());
		Host host = new Host(message.getHost(), message.getUsername(), message.getPassword());
		
		
		transporter.move(sourceFile, destinationFile, host);
	}

	@Override
	public void success(AmqpService service, MoveRequest request) throws Exception {
		MoveResponse response = new MoveResponse();
		
		response.setSourceFilename(request.getSourceFilename());
                response.setDestinationFilename(request.getDestinationName());
		response.setSourceDirectory(request.getSourcePath());
		response.setDestinationDirectory(request.getDestinationPath());
		response.setStatus("OK");
		response.setCorrelationId(request.getCorrelationId());
		
		service.write("move_responses", GsonUtil.convert(response));
	}

	@Override
	public void exception(AmqpService service, Exception exception, MoveRequest request) {
		MoveResponse response = new MoveResponse();

		response.setSourceFilename(request.getSourceFilename());
                response.setDestinationFilename(request.getDestinationName());
		response.setSourceDirectory(request.getSourcePath());
		response.setDestinationDirectory(request.getDestinationPath());
		response.setStatus("NOK");
		response.addMessage(exception);
		response.setCorrelationId(request.getCorrelationId());
		
		try {
			service.write("move_responses", GsonUtil.convert(response));
		} catch (Exception ex) {
			logger.warn("Could not write to the response queue");
			logger.catching(ex);
		}
		
		logger.catching(exception);
	}	

}
