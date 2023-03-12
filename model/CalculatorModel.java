package model;

public class CalculatorModel extends Updater
{
    private double result = 0;

    public CalculatorModel() {}

    public void add(double number1, double number2)
    {
        result = number1 + number2;
        updateViews();
    }

    public void subtract(double number1, double number2)
    {
        result = number1 - number2;
        updateViews();
    }

    public void multiply(double number1, double number2)
    {
        result = number1 * number2;
        updateViews();
    }

    public void divide(double number1, double number2)
    {
        result = number1 / number2;
        updateViews();
    }
    
    public double getResult()
    {
        return result;
    }
}
