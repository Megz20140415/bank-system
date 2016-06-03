package Core.Users;

import java.io.Serializable;

public class Borrower implements Serializable
{
    private String borrowerID;
    private String phoneNumber;
    private String address;
    private double loanBalance;

    public void setBorrowerID(String borrowerID) {
        int z = 0;
       for (int i = 2; i < borrowerID.length(); i++) {
           z = z * 10;
           z = z + Integer.parseInt("" + borrowerID.charAt(i));
       }
       z++;
       borrowerID = "" + borrowerID.charAt(0) + borrowerID.charAt(1) + z;

       this.borrowerID = borrowerID;
    }
    private int repaymentPeriod; //In months
    private boolean accountStatus;

    public String getBorrowerID()
    {
        return borrowerID;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public double getLoanBalance()
    {
        return loanBalance;
    }

    public void setLoanBalance(double loanBalance)
    {
        this.loanBalance = loanBalance;
    }

    public int getRepatmentPeriod()
    {
        return repaymentPeriod;
    }

    public void setRepatmentPeriod(int repatmentPeriod)
    {
        this.repaymentPeriod = repatmentPeriod;
    }

    public boolean getAccountStatus()
    {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus)
    {
        this.accountStatus = accountStatus;
    }
    
}
