package com.designPattern.strategyPattern.strategy;

public class AdditionStrategy implements CalculationStrategy{
    @Override
    public float calculate(float a, float b) {
        return a+b;
    }
}
