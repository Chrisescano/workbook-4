package org.pluralsight;

public class LeaseContract extends Contract{
    private double expectedEndingValue;
    private final double leaseFee = 0.07;
    private final double interestRate = 0.04;
    private final int leaseTermInMonths = 36;

    public LeaseContract(String date, String name, String email, Vehicle vehicle) {
        super(date, name, email, vehicle);

        expectedEndingValue = vehicle.getPrice() * 0.5;
    }

    @Override
    public double getTotalPrice() {
        return (getVehicle().getPrice() - expectedEndingValue) + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        double interestRate = this.interestRate / 12;
        double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, leaseTermInMonths)) /
                (Math.pow(1 + interestRate, leaseTermInMonths) - 1);
        monthlyPayment = Math.round(monthlyPayment * 100);
        monthlyPayment /= 100;
        return monthlyPayment;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LEASE|");
        stringBuilder.append(getDate()).append("|");
        stringBuilder.append(getName()).append("|");
        stringBuilder.append(getEmail()).append("|");
        stringBuilder.append(getVehicle().toString());
        return stringBuilder.toString();
    }
}
