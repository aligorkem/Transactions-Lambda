/**
 * The clean architecture and SOLID design principles applied to separate domain objects from external dependencies.
 *
 * @project aligorkem - Transactions List
 * @author Ali Gorkem Ozturk
 * @date 21 Mar 22
 */

package com.aligorkem.example.application;

import com.aligorkem.example.core.domain.exceptions.TransactionNullException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.aligorkem.example.core.domain.entities.TransactionDetail;

import java.util.Map;

public class GetTransactionHandler extends BaseHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        try {
            // get the 'pathParameters' from input
            Map<String, String> pathParameters = (Map<String, String>) input.get("pathParameters");

            // get the transaction object
            TransactionDetail transactionDetail = slsConfig.getTransaction(pathParameters);

            return response(200, transactionDetail);

        } catch (TransactionNullException nullException) {

            //if the transaction not found
            Response responseBody = new Response("Transaction doesn't exist.", false, null);
            return response(422, responseBody);

        } catch (Exception ex) {

            // send the error response back
            Response responseBody = new Response("Error in getting transaction: " + ex.getMessage(), false, input);
            return response(500, responseBody);
        }
    }
}
