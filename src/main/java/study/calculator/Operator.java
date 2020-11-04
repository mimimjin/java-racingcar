package study.calculator;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum Operator {

    ADD("+",(left, right) -> left + right),
    SUBTRACT("-",(left, right) -> left - right),
    MULTIPLY("*",(left, right) -> left * right),
    DIVIDE("/",(left, right) -> {
        if(right == 0){
            throw new IllegalArgumentException(CustomErrorMessage.DIVISION_BY_ZERO.getErrorMessage());
        }

        return  left / right;
        }
    );

    private String operatorValue;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operatorValue, BiFunction<Integer, Integer, Integer> expression){
        this.operatorValue = operatorValue;
        this.expression = expression;
    }

    public static Operator findFieldByOperatorCharacter(String operatorCharacter){
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.operatorValue.equals(operatorCharacter))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(CustomErrorMessage.ILLEGAL_OPERATOR.getErrorMessage()));
    }


    public static int calculate(String operatorCharacter, CalculateSet calculateSet){
        return findFieldByOperatorCharacter(operatorCharacter).expression.apply(calculateSet.left, calculateSet.right);
    }

}
