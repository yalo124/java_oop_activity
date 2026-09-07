package acitvity_2;

import java.util.Scanner;

abstract class HousingUnit{
    String unit;
    double pricePerSQM;

    public abstract double TotalUnitPrice(double area);
    public abstract double DownpaymentInPercentage(double downPayment);
    public abstract double Balance(double downPayment);
    public abstract double Discount(double dpPercentage);

}

class Studio_Type extends  HousingUnit{
    String unit = "Studio Type";
    double pricePerSQM = 65892.00;
    double area;
    double downPaymentInPercentage;

    public Studio_Type(double area, double downPaymentInPercentage){
        this.area = area;
        this.downPaymentInPercentage = downPaymentInPercentage;
    }
    @Override
    public double TotalUnitPrice(double area){
        return  area * pricePerSQM;
    }

    @Override
    public double DownpaymentInPercentage(double downPayment){
        return downPayment / TotalUnitPrice(area);
    }

    @Override
    public double Balance(double downPayment){
        return TotalUnitPrice(area) - downPayment;
    }

    @Override
    public double Discount(double downPaymentInPercentage){
        double rounded = Math.round(downPaymentInPercentage * 100);

        if (rounded < 20 ){
            return 0.00;
        } else if(rounded >= 20 && rounded<30){
            return 0.03;
        } else if(rounded >= 30 && rounded<40){
            return 0.04;
        } else {
            return 0.05;
        }

    }


}



public class Activity_2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double Area, DownPayment_A, DownPaymentInpercent = 0;

        System.out.print("Input area: ");
        Area = scan.nextDouble();
        if(Area >= 28.5 && Area < 52.0){
            Studio_Type ST = new Studio_Type(Area, DownPaymentInpercent);


            System.out.printf("Total Unit Price: %.2f%n", ST.TotalUnitPrice(Area));

            System.out.print("Input downpament: ");
            DownPayment_A = scan.nextDouble();
            System.out.printf("Downpayment in Percentage: %.0f%%%n", ST.DownpaymentInPercentage(DownPayment_A) *100);

            System.out.printf("Balance: %.2f%n", ST.Balance(DownPayment_A));
            DownPaymentInpercent = ST.DownpaymentInPercentage(DownPayment_A);
            System.out.printf("Discount: %.0f%%%n" ,ST.Discount(DownPaymentInpercent)*100);
        } else if(Area >= 52.0 || Area < 86.5){

        } else if (Area >= 86.5){

        }
    }
}
