/**
 * The clean architecture and SOLID design principles applied to separate domain objects from external dependencies.
 *
 * @project aligorkem - Transactions List
 * @author  Ali Gorkem Ozturk
 * @date   21 Mar 22
 */

package com.aligorkem.example.application;

import java.util.List;
import java.util.Map;
import com.aligorkem.example.config.SlsConfig;
import com.aligorkem.example.core.domain.exceptions.TransactionNullException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.aligorkem.example.core.domain.entities.TransactionDetail;

public class ListTransactionsHandler extends BaseHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		SlsConfig slsConfig = new SlsConfig();

		try {
			// get transactions
			List<TransactionDetail> transactions = slsConfig.getTransactions();
			return response(200, transactions);
		}
		catch (TransactionNullException nullException) {

			Response responseBody = new Response("Error in getting transactions.", false, null);
			return response(422, responseBody);
		}
		catch (Exception ex) {

			// send the error response back
			Response responseBody = new Response("Error in getting transactions: " + ex.getMessage(), false, input);
			return response(500, responseBody);
		}
	}
}
