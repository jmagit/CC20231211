package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        var calc = new CalculadoraImpl();
        System.out.println(calc.add(1, 2));
        System.out.println(calc.add(0.1, 0.2));
        System.out.println(calc.add(1, -0.9));
    }
}
