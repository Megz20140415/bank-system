package Core.Users;

import java.io.Serializable;

public class Account implements Serializable{

        creditCard CreditCard;

    private String accountID;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;

    private String SSN; //Social Security Number
    private String phoneNumber;
    private String address;
    private int age;
    private String gender;
    private double moneyBalance;
    private float interestRate;
    private boolean offerStatus;
    private boolean loanStatus;
    private String profilePicture;
    private boolean makeDeposit;
    private boolean makeWithdraw;
    private boolean maketransfer;

    
    

    public boolean getMakeDeposit() {
        return makeDeposit;
    }

    public void setMakeDeposit(boolean makeDeposit) {
        this.makeDeposit = makeDeposit;
    }

    public boolean getMakeWithdraw() {
        return makeWithdraw;
    }

    public void setMakeWithdraw(boolean makeWithdraw) {
        this.makeWithdraw = makeWithdraw;
    }

    public boolean getMaketransfer() {
        return maketransfer;
    }

    public void setMaketransfer(boolean maketransfer) {
        this.maketransfer = maketransfer;
    }
   
    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID)
    {
        int z = 0;
        for (int i = 1; i < accountID.length(); i++)
        {
            z = z * 10;
            z = z + Integer.parseInt("" + accountID.charAt(i));
        }
        z++;
        accountID = "" + accountID.charAt(0) + z;

        this.accountID = accountID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passsword) {
        this.password = passsword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getMoneyBalance() {
        return moneyBalance;
    }

    public void setMoneyBalance(double moneyBalance) {
        this.moneyBalance = moneyBalance;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public boolean getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(boolean offerStatus) {
        this.offerStatus = offerStatus;
    }

    public boolean getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(boolean loanStatus) {
        this.loanStatus = loanStatus;
    }

    public creditCard getCreditCard() {
        return CreditCard;
    }

    public void setCreditCard(creditCard creditCard) {
        this.CreditCard = creditCard;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
