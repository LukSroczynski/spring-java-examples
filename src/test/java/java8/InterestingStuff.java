package java8;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InterestingStuff {

    @Test
    public void summaryStatistics_and_numberFormatter() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        double digit = 3.1234;

        //when
        IntSummaryStatistics statistics = numbers.stream()
                .mapToInt(x -> x)
                .summaryStatistics(); //IntSummaryStatistics{count=6, sum=21, min=1, average=3.500000, max=6}

        NumberFormat numberFormatter = NumberFormat.getNumberInstance();
        numberFormatter.setMinimumFractionDigits(1);
        numberFormatter.setMaximumFractionDigits(1);

        // then
        assertEquals(Double.parseDouble(numberFormatter.format(digit)), 3.1, 0);

    }


}

