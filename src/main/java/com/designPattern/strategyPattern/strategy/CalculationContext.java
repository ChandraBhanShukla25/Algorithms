package com.designPattern.strategyPattern.strategy;

public class CalculationContext {

    CalculationStrategy strategy;

    public CalculationContext(CalculationStrategy strategy){
        this.strategy = strategy;
    }

    public float calculate(float a, float b){
        return strategy.calculate(a, b);
    }
}
