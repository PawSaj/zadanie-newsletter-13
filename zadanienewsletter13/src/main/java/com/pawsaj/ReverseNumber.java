package com.pawsaj;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ReverseNumber {

    public Number reverse(Number toReverse) {

        BigDecimal received = new BigDecimal(toReverse.toString());
        int receivedAmountOfNumber = amountOfNumbers(received);

        BigDecimal temp;
        BigDecimal divisor = BigDecimal.ONE.divide(BigDecimal.TEN.pow(received.scale() - 1, MathContext.DECIMAL32));

        BigDecimal result = BigDecimal.ZERO;

        do {
            temp = received.remainder(divisor)
                    .setScale(divisor.scale() + 1, RoundingMode.DOWN);
            BigDecimal shift = BigDecimal.TEN.pow(receivedAmountOfNumber - 1 - (received.scale() - temp.scale()) * 2, MathContext.DECIMAL32);
            result = result.add(temp.multiply(shift));
            divisor = divisor.multiply(BigDecimal.TEN).setScale(divisor.scale() - 1);
        } while (!received.remainder(divisor.divide(BigDecimal.TEN)).equals(received));

        return specifyReturnType(toReverse, result);
    }

    private Number specifyReturnType(Number toReverse, BigDecimal result) {
        if (toReverse instanceof Double) {
            return result.doubleValue();
        } else if (toReverse instanceof Float) {
            return result.floatValue();
        } else if (toReverse instanceof Long) {
            return result.longValue();
        } else if (toReverse instanceof Integer) {
            return result.intValue();
        } else if (toReverse instanceof Short) {
            return result.shortValue();
        } else if (toReverse instanceof Byte) {
            return result.byteValue();
        } else {
            throw new IllegalArgumentException("Incorrect value");
        }
    }

    private int amountOfNumbers(BigDecimal received) {
        long workingReceived = received.setScale(0, RoundingMode.DOWN)
                .longValueExact();

        int receivedAmountOfNumber = 0;
        do {
            receivedAmountOfNumber++;
            workingReceived /= 10;
        } while (workingReceived % 10 != 0);

        receivedAmountOfNumber += received.scale();

        return receivedAmountOfNumber;
    }
}
