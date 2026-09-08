package acitvity_2;

class Studio_Type extends HousingUnit{
    enum Unit_Type{
        Studio_Type("Studio Type", 65892.00),
        Two_Bedroom("2 Bedroom", 58807.00),
        Three_Bedroom("3 Bedroom", 53380.00);

        private String unit;
        private double pricePerSQM;

        Unit_Type(String unit, double pricePerSQM){
            this.unit = unit;
            this.pricePerSQM = pricePerSQM;
        }

        public String getUnit(){
            return unit;
        }
        public double getPricePerSQM(){
            return pricePerSQM;
        }
    }

    Unit_Type U_type;
    double area;
    double downPaymentInPercentage, downPayment;

    public Studio_Type(double area, double downPaymentInPercentage, double downPayment){
        //unit = "Studio Type";
        //pricePerSQM = 65892.00;
        this.area = area;
        this.downPaymentInPercentage = downPaymentInPercentage;
        this.downPayment = downPayment;
    }

    @Override
    public double TotalUnitPrice(double area){return  area * U_type.getPricePerSQM();}

    @Override
    public double DownpaymentInPercentage(double downPayment){return downPayment / TotalUnitPrice(area);}

    @Override
    public double Balance(double downPayment){ return TotalUnitPrice(area) - downPayment; }

    @Override
    public double Discount(double downPaymentInPercentage){
        double rounded = Math.round(downPaymentInPercentage * 100);

        if (rounded < 20 ) {return 0.00;}
        else if(rounded >= 20 && rounded<30) {return 0.03;}
        else if(rounded >= 30 && rounded<40) {return 0.04;}
        else {return 0.05;}
    }
    @Override
    public double Discount_Amount(double discount, double downPayment){ return Balance(downPayment) * discount; }

    @Override
    public double Interest(int year){
        switch(year){
            case 5 -> {
                return 0.04;
            }
            case 10 -> {
                return 0.06;
            }
            case 15 ->{
                return 0.08;
            }
            default -> {
                return 0.10;
            }
        }
    }
    @Override
    public double Interest_Amount(double Balance_less_amount, int year){ return Balance_less_amount * Interest(year); }
}