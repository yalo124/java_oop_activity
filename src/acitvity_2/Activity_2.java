package acitvity_2;
import java.util.Scanner;

public class Activity_2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double Area, DownPayment_A=0, DownPaymentInpercent = 0, discount, Balance_less_discount, Contract_Price;
        int year;
        System.out.print("Input area: ");
        Area = scan.nextDouble();

        Rent.Unit_Type Utype;
        if(Area >= 28.5 && Area < 52.0){
            Utype = Rent.Unit_Type.Studio_Type;
        } else if(Area >= 52.0 && Area < 86.5){
            Utype = Rent.Unit_Type.Two_Bedroom;
        } else if (Area >= 86.5){
            Utype = Rent.Unit_Type.Three_Bedroom;
        } else{
            System.out.println("Wrong");
            return;
        }

        HousingUnit studio_type = new Rent(Area, DownPaymentInpercent, DownPayment_A, Utype);

        System.out.printf("%-19s : %s%n", "Unit Type", Utype.getUnit());
        System.out.printf("%-19s : %.2f%n","Total Unit Price", studio_type.TotalUnitPrice(Area));
        System.out.print("\nInput downpayment : ");
        DownPayment_A = scan.nextDouble();
        System.out.printf("\n%-20s: %.2f%n","Balance", studio_type.Balance(DownPayment_A));
        DownPaymentInpercent = studio_type.DownpaymentInPercentage(DownPayment_A);
        discount = studio_type.Discount(DownPaymentInpercent);
        System.out.print("\nYears to pay : ");
        year = scan.nextByte();
        Balance_less_discount = studio_type.Balance(DownPayment_A)-studio_type.Discount_Amount(discount, DownPayment_A);
        Contract_Price = Balance_less_discount + studio_type.Interest_Amount(Balance_less_discount, year);

        System.out.println("\n");
        System.out.println("==========================================");
        System.out.printf("%-28s | %.2f%n", "Area (in square meter)", Area);
        System.out.println("------------------------------------------");
        System.out.printf("%-28s | %s%n ", "Unit Type", Utype.getUnit());
        System.out.println("------------------------------------------");
        System.out.printf("%-28s | %.2f%n ","Price Per Square Meter", Utype.getPricePerSQM());
        System.out.println("------------------------------------------");
        System.out.printf("%-28s | %.2f%n", "Total Unit Price", studio_type.TotalUnitPrice(Area));
        System.out.println("==========================================");
        System.out.printf("%-28s | %.2f%n", "Downpayment Amount", DownPayment_A);
        System.out.println("------------------------------------------");
        System.out.printf("%-28s | %.0f%%%n", "Downpayment in Percentage", studio_type.DownpaymentInPercentage(DownPayment_A) *100);
        System.out.println("------------------------------------------");
        System.out.printf("%-28s | %.2f%n","Balance", studio_type.Balance(DownPayment_A));
        System.out.println("------------------------------------------");
        System.out.printf("%-28s | %.0f%%%n" ,"Discount", studio_type.Discount(DownPaymentInpercent)*100);
        System.out.println("------------------------------------------");
        System.out.printf("%-28s | %.2f%n","Less: Discount Amount", studio_type.Discount_Amount(discount, DownPayment_A));
        System.out.println("==========================================");
        System.out.printf("%-28s | %d%n","Years to Pay", year);
        System.out.println("------------------------------------------");
        System.out.printf("%-28s | %.0f%%%n","Interest", studio_type.Interest(year) * 100);
        System.out.println("------------------------------------------");
        System.out.printf("%-28s | %.2f%n","Interest Amount",  studio_type.Interest_Amount(Balance_less_discount, year));
        System.out.println("------------------------------------------");
        System.out.printf("%-28s | %.2f%n","Contract Price ", Contract_Price);
        System.out.println("------------------------------------------");
        System.out.printf("%-28s | %.2f%n","Monthly Amortization", Contract_Price / (year * 12));
    }
}
