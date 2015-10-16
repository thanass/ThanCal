package edu.thanassis.thancal;

/**
 * Created by Thanassis on 28/9/2015.
 */
public class Operations
{
    private static double add(double a, double b)
    {
        return a + b;
    }

    public static double operate(double a, double b, EnumOperators.Operator opType)
    {
        double result = 0;

        switch (opType)
        {
            case PLUS:
                result = add(a,b);
                break;
        }
        return result;
    }
}
