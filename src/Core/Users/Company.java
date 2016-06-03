package Core.Users;

import Interface.IuserFunctions;
import Core.Human;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Company extends Human implements IuserFunctions,Serializable {

    private String companyID;
    private String name;
    private String phoneNumber;
    private String address;
    private String industryType;

    public void setCompanyID(String companyID) {
         int z = 0;
       for (int i = 1; i < companyID.length(); i++) {
           z = z * 10;
           z = z + Integer.parseInt("" + companyID.charAt(i));
       }
       z++;
       companyID = "" + companyID.charAt(0) + z;

       this.companyID = companyID;
    }
    private String email;
    private String website;
    private int employeeNumber;
    private double moneyBalance;

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }
    private float interestRate;
    private boolean loanStatus;

    Transaction record;

    public Company() {
        record = new Transaction();
    }
    
    
    public Transaction getRecord() {
        return record;
    }

    public void setRecord(Transaction record) {
        this.record = record;
    }

    public String getCompanyID() {
        return companyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
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

    public boolean getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(boolean loanStatus) {
        this.loanStatus = loanStatus;
    }

    @Override
    public ArrayList<String> displayTransactions(Object object) throws IOException, ClassNotFoundException {
        return record.showRecords(object);
    }

    @Override
    public Object searchAccount(Object object) throws IOException, ClassNotFoundException {
        Company obj = (Company) object;
        ArrayList<Company> array;
        ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream("Database\\companies.bin"));
        array = (ArrayList<Company>) fromFile.readObject();
        fromFile.close();

        for (Company comp : array) {
            if (comp.getUserName().equals(obj.getUserName())) {
                return comp;
            }
        }
        return obj;
    }
}
