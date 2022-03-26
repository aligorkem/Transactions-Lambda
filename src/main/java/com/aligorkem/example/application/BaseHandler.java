/**
 * The clean architecture and SOLID design principles applied to separate domain objects from external dependencies.
 *
 * @project aligorkem - Transactions List
 * @author  Ali Gorkem Ozturk
 * @date   21 Mar 22
 */

package com.aligorkem.example.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.aligorkem.example.config.SlsConfig;

import java.util.Map;

/**
 * The base handler class provides commonly used functionality to transaction handlers
 */
public class BaseHandler {

    protected SlsConfig slsConfig;

    public BaseHandler(){
        this.slsConfig = new SlsConfig();
    }

    /**
     * It returns params from an input object.
     * @param input
     * @return
     * @throws JsonProcessingException
     */
    protected Map<String, Object> getParameters(Map<String, Object> input) throws JsonProcessingException {
        JsonNode jsonNode = new ObjectMapper().readTree((String) input.get("body"));
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> params = mapper.convertValue(jsonNode, new TypeReference<Map<String, Object>>(){});
        return params;
    }

    /**
     * It converts object to a map object.
     * @param object
     * @return
     * @throws JsonProcessingException
     */
    protected Map<String, Object> convertObjectToMap(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> convertValue = mapper.convertValue(object, Map.class);
        return convertValue;
    }

    /**
     * Responsible for returning a gateaway object.
     * @param statusCode
     * @param responseBody
     * @return ApiGatewayResponse.
     */
    protected ApiGatewayResponse response(int statusCode, Response responseBody){
        return ApiGatewayResponse.builder()
                .setStatusCode(statusCode)
                .setObjectBody(responseBody)
                .build();
    }

    /**
     * Overloaded method that is responsible for returning a gateaway object.
     * @param statusCode
     * @param responseBody
     * @return ApiGatewayResponse.
     */
    protected ApiGatewayResponse response(int statusCode, Object responseBody){
        return ApiGatewayResponse.builder()
                .setStatusCode(statusCode)
                .setObjectBody(responseBody)
                .build();
    }
}
