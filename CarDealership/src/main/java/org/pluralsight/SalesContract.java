package org.pluralsight;

public class SalesContract extends Contract{
    private double tax = 0.05;
    private double recordingFee = 100;

    private double processingFee;
    private boolean isFinanced;
    private double loanInterestRate;
    private int loanTermInMonths;

    public SalesContract(String date, String name, String email, Vehicle vehicle, boolean isFinanced) {
        super(date, name, email, vehicle);
        this.isFinanced = isFinanced;

        if(vehicle.getPrice() >= 10000) {
            processingFee = 495;
            loanInterestRate = 0.0425;
            loanTermInMonths = 48;
        } else {
            processingFee = 295;
            loanInterestRate = 0.0524;
            loanTermInMonths = 24;
        }
    }

    @Override
    public double getTotalPrice() {
        double fees = (getVehicle().getPrice() * (1 + tax)) + recordingFee + processingFee;

        return isFinanced ? (getMonthlyPayment() * loanTermInMonths) + fees :
                getVehicle().getPrice() + fees;
    }

    @Override
    public double getMonthlyPayment() {
        if(!isFinanced) return 0;
        //p = a(r / 12);
        return getVehicle().getPrice() * (loanInterestRate / 12);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SALE|");
        stringBuilder.append(getDate()).append("|");
        stringBuilder.append(getName()).append("|");
        stringBuilder.append(getEmail()).append("|");
        stringBuilder.append(getVehicle().toString());
        return stringBuilder.toString();
    }
}
