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
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
