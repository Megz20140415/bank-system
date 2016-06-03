package Core.Users;

import java.io.Serializable;

public class companyType extends Borrower implements Serializable
{
    private String Name;
    private String companyID;
    private float loanInterestRate;
    private double capital;

    public String getName()
    {
        return Name;
    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    public String getCompanyID()
    {
        return companyID;
    }

    public void setCompanyID(String companyID)
    {
        this.companyID = companyID;
    }

    public float getLoanInterestRate()
    {
        return loanInterestRate;
    }

    public void setLoanInterestRate(float loanInterestRate)
    {
        this.loanInterestRate = loanInterestRate;
    }

    public double getCapital()
    {
        return capital;
    }

    public void setCapital(double capital)
    {
        this.capital = capital;
    }
}
