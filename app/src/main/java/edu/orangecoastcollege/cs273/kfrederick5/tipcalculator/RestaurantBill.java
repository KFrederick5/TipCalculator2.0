package edu.orangecoastcollege.cs273.kfrederick5.tipcalculator;

/**
 * Takes the amount of a restaurant bill input by the user and,
 * along with a slider that a user moves around to select
 * a tip percent, calculates the total bill.
 * Created by kfrederick5 on 9/8/2016.
 */
public class RestaurantBill {

    /**
     * Amount the user inputs, the amount shown for tip percent
     * selected, the tip amount calculated by the user inputs,
     * and the total amount of the bill.
     */
    private double mAmount;
    private double mTipPercent;
    private double mTipAmount;
    private double mTotalAmount;
    private double mTaxAmount;

    /**
     * Creates a new restaurant bill with default values.
     * No inputs are needed.
     */
    public RestaurantBill() {
        mAmount = 0.0;
        mTipPercent = 0.0;
        mTipAmount = 0.0;
        mTotalAmount = 0.0;
        mTaxAmount = 0.0;
    }

    /**
     * Creates a new restaurant bill with user input values.
     * The amount should be a number value.
     *
     * @param mAmount The amount of the bill
     * @param mTipPercent The tip percentage the user wishes to give.
     */
    public RestaurantBill(double mAmount, double mTipPercent) {
        this.mAmount = mAmount;
        this.mTipPercent = mTipPercent;
        recalcAmounts();
    }

    /**
     * Gets the users inputted amount.
     * @return the amount given
     */
    public double getAmount() {
        return mAmount;
    }

    /**
     * Gets the percent of the tip the user wishes to give
     * @return tip percent amount
     */
    public double getTipPercent() {
        return mTipPercent;
    }

    /**
     * Gets the tip amount in dollars from the calculation
     * of the tip percent and user amoount.
     * @return dollar amount of the tip
     */
    public double getTipAmount() {
        return mTipAmount;
    }

    /**
     * Gets the total amount of user amount plus tip.
     * @return dollar amount of the total bill
     */
    public double getTotalAmount() {
        return mTotalAmount;
    }

    /**
     * Gets the tax value and returns it for calculation
     * @return the total tax
     */
    public double getTaxAmount() {
        return mTaxAmount;
    }

    /**
     * Sets the amount given by the user and
     * recalculates all the dependent values
     * @param mAmount sets the amount the user entered
     */
    public void setAmount(double mAmount) {
        this.mAmount = mAmount;
        recalcAmounts();
    }

    /**
     * Sets the tip percent given by the percentage
     * bar and recalculates all the dependent values
     * @param mTipPercent sets the amount of the percent selected
     */
    public void setTipPercent(double mTipPercent) {
        this.mTipPercent = mTipPercent;
        recalcAmounts();
    }

    /**
     * Will set the tax amount based on the users
     * location, in the future.
     * @param mTaxAmount sets tax amount based on users gps locale
     */
    public void setTaxAmount(double mTaxAmount) {
        this.mTaxAmount = mTaxAmount;
        recalcAmounts();
    }

    /**
     * Recalculates the amounts of total and percent values using
     * the user entered amount and tip percent seek bar.
     */
    private void recalcAmounts()
    {
        mTaxAmount = mAmount*(.08);
        mTipAmount = mAmount*mTipPercent;
        mTotalAmount = mAmount + mTipAmount + mTaxAmount;
    }
}
