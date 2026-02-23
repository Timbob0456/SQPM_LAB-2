package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

	@GetMapping("/add")
	public String addString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  Binary.add(number1,number2).getValue();
		// http://localhost:8080/add?operand1=111&operand2=1010
	}

	@GetMapping("/multiply")
public String multiply(
        @RequestParam String operand1,
        @RequestParam String operand2) {

    Binary op1 = new Binary(operand1);
    Binary op2 = new Binary(operand2);
    return op1.multiply(op2).toString();
}

@GetMapping("/and")
public String and(
        @RequestParam String operand1,
        @RequestParam String operand2) {

    Binary op1 = new Binary(operand1);
    Binary op2 = new Binary(operand2);
    return op1.and(op2).toString();
}

@GetMapping("/or")
public String or(
        @RequestParam String operand1,
        @RequestParam String operand2) {

    Binary op1 = new Binary(operand1);
    Binary op2 = new Binary(operand2);
    return op1.or(op2).toString();
}
	
	@GetMapping("/add_json")
	public BinaryAPIResult addJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  new BinaryAPIResult(number1,"add",number2,Binary.add(number1,number2));
		// http://localhost:8080/add?operand1=111&operand2=1010
	}

	@GetMapping("/multiply_json")
public BinaryAPIResult multiply_json(
        @RequestParam String operand1,
        @RequestParam String operand2) {

    Binary op1 = new Binary(operand1);
    Binary op2 = new Binary(operand2);
    Binary result = op1.multiply(op2);

    return new BinaryAPIResult(operand1, operand2, "*", result.toString());
}

@GetMapping("/and_json")
public BinaryAPIResult and_json(
        @RequestParam String operand1,
        @RequestParam String operand2) {

    Binary op1 = new Binary(operand1);
    Binary op2 = new Binary(operand2);
    Binary result = op1.and(op2);

    return new BinaryAPIResult(operand1, operand2, "&", result.toString());
}

@GetMapping("/or_json")
public BinaryAPIResult or_json(
        @RequestParam String operand1,
        @RequestParam String operand2) {

    Binary op1 = new Binary(operand1);
    Binary op2 = new Binary(operand2);
    Binary result = op1.or(op2);

    return new BinaryAPIResult(operand1, operand2, "|", result.toString());
}

}