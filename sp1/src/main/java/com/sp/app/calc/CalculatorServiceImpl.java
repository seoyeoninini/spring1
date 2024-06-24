package com.sp.app.calc;

public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public int result(Calculator dto) {
		int s = 0;
		
		switch(dto.getOperator()) {
			case "+" : s = dto.getNum1() + dto.getNum2(); break;
			case "-" : s = dto.getNum1() - dto.getNum2(); break;
			case "*" : s = dto.getNum1() * dto.getNum2(); break;
			case "/" : s = dto.getNum1() / dto.getNum2(); break;
		}
		
		return s;
	}
	
}
