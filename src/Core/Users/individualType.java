package Core.Users;

public class individualType extends Borrower
{
    private String firstName;
    private String lastName;
    private  String accountID;
    private  float loanInterestRate;
    private double salary;
    private String SSN;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getAccountID()
    {
        return accountID;
    }

    public void setAccountID(String accountID)
    {
        this.accountID = accountID;
    }

    public float getLoanInterestRate()
    {
        return loanInterestRate;
    }

    public void setLoanInterestRate(float loanInterestRate)
    {
        this.loanInterestRate = loanInterestRate;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }
    
    public String getSSN()
    {
        return SSN;
    }

    public void setSSN(String SSN)
    {
        this.SSN = SSN;
    }
}
