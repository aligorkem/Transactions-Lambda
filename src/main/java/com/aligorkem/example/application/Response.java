/**
 * The clean architecture and SOLID design principles applied to separate domain objects from external dependencies.
 *
 * @project aligorkem - Transactions List
 * @author  Ali Gorkem Ozturk
 * @date   21 Mar 22
 */

package com.aligorkem.example.application;

import java.util.Map;

/**
 * This class represents a response object.
 */
public class Response {

	private final boolean success;
	private final String message;
	private final Map<String, Object> data;

	public Response(String message, boolean success, Map<String, Object> input) {
		this.success = success;
		this.message = message;
		this.data = input;
	}

	public boolean getSuccess() {
		return this.success;
	}

	public String getMessage() {
		return this.message;
	}

	public Map<String, Object> getInput() {
		return this.data;
	}
}
