package ir.amin.mavenbased.jta.samples;

import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
//import javax.transaction.Transactional;
//import javax.transaction.Transactional.TxType;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import ir.amin.mavenbased.jpa.samples.JTAParent;

@RequestScoped
@Path("/jta")
@Produces("application/json")
@Consumes("application/json")
public class JTAController {

	@Inject
	JTAParent jtaParent;


	@POST
	@Path("/jtaMethods")
	public Response jtaMethods(@QueryParam("type") final String transactionType) {
		TransactionAttributeType transactionAttributeType = TransactionAttributeType.valueOf(transactionType);
		switch (transactionAttributeType) {
		case MANDATORY:
			jtaParent.sendMessagesByMANDATORY(TransactionAttributeType.MANDATORY);
			break;
		case REQUIRED:
			jtaParent.sendMessagesByREQUIRED(TransactionAttributeType.REQUIRED);
			break;
		case REQUIRES_NEW:
			jtaParent.sendMessagesByREQUIRESNEW(TransactionAttributeType.REQUIRES_NEW);
			break;
		case NEVER:
			jtaParent.sendMessagesByNEVER(TransactionAttributeType.NEVER);
			break;
		case NOT_SUPPORTED:
			jtaParent.sendMessagesByNOTSUPPORTED(TransactionAttributeType.NOT_SUPPORTED);
			break;
		case SUPPORTS:
			jtaParent.sendMessagesBySUPPORTS(TransactionAttributeType.SUPPORTS);
			break;
		default:
			break;
		}

		return Response.noContent().build();
	}

}
