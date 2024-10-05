package com.designPattern.strategyPattern;

import com.designPattern.strategyPattern.strategy.AdditionStrategy;
import com.designPattern.strategyPattern.strategy.CalculationContext;
import com.designPattern.strategyPattern.strategy.CalculationStrategy;
import com.designPattern.strategyPattern.strategy.MutiplicationStrategy;

public class Main {

    public static void main(String[] args) {
        float a = 20.5f;
        float b = 30.5f;

        CalculationStrategy calculationStrategy = new MutiplicationStrategy();

        CalculationContext calculationContext = new CalculationContext(calculationStrategy);

        float mulRes = calculationContext.calculate(a,b);
        System.out.println(mulRes);

        AdditionStrategy additionStrategy = new AdditionStrategy();
        CalculationContext calculationContext1  = new CalculationContext(additionStrategy);
        System.out.println(calculationContext1.calculate(a,b));
    }
}
