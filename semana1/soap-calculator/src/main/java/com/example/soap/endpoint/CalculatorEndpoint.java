package com.example.soap.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.soap.calculator.CalculatorRequest;
import com.example.soap.calculator.CalculatorResponse;

@Endpoint
public class CalculatorEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/soap/calculator";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "calculatorRequest")
    @ResponsePayload
    public CalculatorResponse calculate(@RequestPayload CalculatorRequest request) {
        CalculatorResponse response = new CalculatorResponse();
        double result = 0;

        switch (request.getOperation()) {
            case ADD:
                result = request.getNumber1() + request.getNumber2();
                break;
            case SUBTRACT:
                result = request.getNumber1() - request.getNumber2();
                break;
            case MULTIPLY:
                result = request.getNumber1() * request.getNumber2();
                break;
            case DIVIDE:
                if (request.getNumber2() != 0) {
                    result = request.getNumber1() / request.getNumber2();
                } else {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                break;
        }

        response.setResult(result);
        return response;
    }
}