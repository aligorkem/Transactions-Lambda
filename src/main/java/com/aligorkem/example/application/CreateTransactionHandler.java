/**
 * The clean architecture and SOLID design principles applied to separate domain objects from external dependencies.
 *
 * @project aligorkem - Transactions List
 * @author  Ali Gorkem Ozturk
 * @date   21 Mar 22
 */

package com.aligorkem.example.application;

import com.aligorkem.example.core.domain.exceptions.TransactionNullException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.aligorkem.example.core.domain.entities.Transaction;
import java.util.Map;

/**
 * This handler class is responsible for creating a new transaction object.
 */
public class CreateTransactionHandler extends BaseHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {

        try {
            // convert body params to map
            Map<String, Object> params = getParameters(input);

            // create a transaction object
            Transaction transaction = slsConfig.createTransaction(params);

            // convert transaction to a map object
            Map<String, Object> convertValue = convertObjectToMap(transaction);

            Response responseBody = new Response("Transaction created successfully.", true, convertValue);
            return response(200, responseBody);

        }
        catch (TransactionNullException nullException) {

            Response responseBody = new Response("Error in creating transaction.", false, null);
            return response(422, responseBody);
        }
        catch (Exception ex) {

            // send the error response back
            Response responseBody = new Response("Error in creating transaction: " + ex.getMessage(), false, input);
            return response(500, responseBody);
        }
    }
}