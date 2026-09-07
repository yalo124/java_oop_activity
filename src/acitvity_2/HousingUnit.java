package acitvity_2;

abstract class HousingUnit{
    protected  String unit;
    protected double pricePerSQM;

    public abstract double TotalUnitPrice(double area);
    public abstract double DownpaymentInPercentage(double downPayment);
    public abstract double Balance(double downPayment);
    public abstract double Discount(double downPaymentInPercentage);
    public abstract double Discount_Amount(double discount, double downPayment);
    public abstract double Interest(int year);
    public abstract double Interest_Amount(double Balance_less_amount, int year);
}
