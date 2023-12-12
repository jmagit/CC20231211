package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculadora {
	private double toDouble(double o) {
		return (new BigDecimal(o))
				.setScale(16, RoundingMode.HALF_UP)
				.doubleValue();
	}
	
	public double add(double a, double b) {
		return toDouble(a + b);
	}
	
	public double divide(int a, int b) {
		return a / b;
	}
	
	public double divide(double a, double b) {
//		if(b == 0) 
//			throw new IllegalArgumentException("El divisor no puede ser 0");
		return a / b;
	}
}
