package acitvity_2;
import java.util.Scanner;

public class Activity_2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double Area, DownPayment_A=0, DownPaymentInpercent = 0, discount, Balance_less_discount, Contract_Price;
        int year;
        System.out.print("Input area: ");
        Area = scan.nextDouble();

        if(Area >= 28.5 && Area < 52.0){
            HousingUnit studio_type = new Studio_Type(Area, DownPaymentInpercent, DownPayment_A);

            System.out.println("Unit Type: " + studio_type.unit);
            System.out.printf("Total Unit Price: %.2f%n", studio_type.TotalUnitPrice(Area));
            System.out.print("Input downpament: ");
            DownPayment_A = scan.nextDouble();
            System.out.printf("Balance: %.2f%n", studio_type.Balance(DownPayment_A));
            DownPaymentInpercent = studio_type.DownpaymentInPercentage(DownPayment_A);
            discount = studio_type.Discount(DownPaymentInpercent);
            System.out.print("Years to pay: ");
            year = scan.nextByte();
            Balance_less_discount = studio_type.Balance(DownPayment_A)-studio_type.Discount_Amount(discount, DownPayment_A);
            Contract_Price = Balance_less_discount + studio_type.Interest_Amount(Balance_less_discount, year);

            System.out.println("\n");
            System.out.println("==========================================");
            System.out.println("Area (in square meter): " + Area);
            System.out.println("------------------------------------------");
            System.out.println("Unit Type: " + studio_type.unit);
            System.out.println("------------------------------------------");
            System.out.println("Price Per Square Meter: "+ studio_type.pricePerSQM);
            System.out.println("------------------------------------------");
            System.out.printf("Total Unit Price: %.2f%n", studio_type.TotalUnitPrice(Area));
            System.out.println("==========================================");
            System.out.println("Downpayment Amount: " + DownPayment_A);
            System.out.println("------------------------------------------");
            System.out.printf("Downpayment in Percentage: %.0f%%%n", studio_type.DownpaymentInPercentage(DownPayment_A) *100);
            System.out.println("------------------------------------------");
            System.out.printf("Balance: %.2f%n", studio_type.Balance(DownPayment_A));
            System.out.println("------------------------------------------");
            System.out.printf("Discount: %.0f%%%n" ,studio_type.Discount(DownPaymentInpercent)*100);
            System.out.println("------------------------------------------");
            System.out.printf("Less: Discount Amount: %.2f%n", studio_type.Discount_Amount(discount, DownPayment_A));
            System.out.println("==========================================");
            System.out.println("Years to Pay: " + year);
            System.out.println("------------------------------------------");
            System.out.printf("Interest: %.0f%%%n", studio_type.Interest(year) * 100);
            System.out.println("------------------------------------------");
            System.out.printf("Interest Amount: %.2f%n",  studio_type.Interest_Amount(Balance_less_discount, year));
            System.out.println("------------------------------------------");
            System.out.printf("Contract Price : %.2f%n", Contract_Price);
            System.out.println("------------------------------------------");
            System.out.printf("Monthly Amortization : %.2f%n", Contract_Price / (year * 12));

        } else if(Area >= 52.0 || Area < 86.5){


        } else if (Area >= 86.5){

        }
    }
}
