package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraImpl implements Calculadora {
	private double toDouble(double o) {
		return (new BigDecimal(o))
				.setScale(16, RoundingMode.HALF_UP)
				.doubleValue();
	}
	
	@Override
	public double add(double a, double b) {
		return toDouble(a + b);
	}
	
	@Override
	public double divide(int a, int b) {
		return a / b;
	}
	
	@Override
	public double divide(double a, double b) {
		if(b == 0) 
			throw new IllegalArgumentException("El divisor no puede ser 0");
		return a / b;
	}
}
