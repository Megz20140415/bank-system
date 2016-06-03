/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankSystem;

import Core.Human;
import Core.Staff.*;
import Core.Users.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author mohamed
 */
public class main {

    public static void main(String[] args) throws Exception {
        //Manager Create Human Resource
//        Manager M = new Manager();
//        humanResources Hr = new humanResources();
//        Hr.setFirstName("Muhammed3");
//        Hr.setLastName("Tarek3");
//       Hr.setUserName("tarek12341");
//        Hr.setPassword("tarek123411");
//        Hr.setPosition("humanResources");
//        Hr.setSalary(20002.1);
////    create account
//       System.out.println(M.createAccount(Hr));
//        Hr = (humanResources)M.searchAccount(Hr);
//        System.out.println(Hr.getFirstName() + " " + Hr.getLastName() + " " + Hr.getPassword() + " " + Hr.getPosition() + " " + Hr.getStaffID() );
//    //delete account
//        /*M.deleteAccount(Hr);
//        Hr = (humanResources)M.searchAccount(Hr);
//        System.out.println(Hr.getFirstName() + " " + Hr.getLastName() + " " + Hr.getPassword() + " " + Hr.getPosition() + " " + Hr.getStaffID() );*/
//    //update account
//        Hr.setFirstName("ahmed");
//        Hr.setPassword("12345");
//        Hr.setLastName("ahmed");
//        M.updateAccount(Hr);
//        Hr = (humanResources)M.searchAccount(Hr);
//        System.out.println(Hr.getFirstName() + " " + Hr.getLastName() + " " + Hr.getPassword() + " " + Hr.getPosition() + " " + Hr.getStaffID() );
        
        
        
        
  //HumanResources create Teller
//        humanResources HR=new humanResources();
//        Staff teller=new Staff();
//       teller.setFirstName("mohamed");
//       teller.setLastName("khairala");
//        teller.setUserName("khairala1");
//      teller.setPassword("12345678");
//       teller.setSalary(1326.5);
//       teller.setPosition("Teller");
//  //Create account
//        System.out.println(HR.createAccount(teller));
//        teller=(Staff)HR.searchAccount(teller);
//        System.out.println(teller.getFirstName()+" "+teller.getLastName()+" "+teller.getUserName()+" "+teller.getPassword());
      
     //delete account
       //HR.deleteAccount(teller);
        
     //update account
//        teller.setFirstName("khairala");
//        teller.setLastName("mohamed");
//        HR.updateAccount(teller);
//        teller=(Staff)HR.searchAccount(teller);
//        System.out.println(teller.getFirstName()+" "+teller.getLastName()+" "+teller.getUserName()+" "+teller.getPassword());
        
        
//   //HumanResources create loan  
//        humanResources HR=new humanResources();
//       Staff loan=new Staff();
//       loan.setFirstName("mohamed");
//       loan.setLastName("khairala");
//        loan.setUserName("amin2");
//      loan.setPassword("12345678");
//       loan.setSalary(1326.5);
//       loan.setPosition("loanemployee");
//  //Create account
//        System.out.println(HR.createAccount(loan));
//        loan=(Staff)HR.searchAccount(loan);
//        System.out.println(loan.getFirstName()+" "+loan.getLastName()+" "+loan.getUserName()+" "+loan.getPassword());
        
        
//   //HumanResources create loan  
//        humanResources HR=new humanResources();
//         Staff accountmanger=new Staff();
//         accountmanger.setFirstName("mohamed");
//       accountmanger.setLastName("khairala");
//        accountmanger.setUserName("kamal2");
//      accountmanger.setPassword("12345678");
//       accountmanger.setSalary(1326.5);
//       accountmanger.setPosition("loanemployee");
//  //Create account
//        System.out.println(HR.createAccount(accountmanger));
//        accountmanger=(Staff)HR.searchAccount(accountmanger);
//        System.out.println(accountmanger.getFirstName()+" "+accountmanger.getLastName()+" "+accountmanger.getUserName()+" "+accountmanger.getPassword());
        
        
    //accountManager create individual
//        accountManager accountmanager=new accountManager();
//        Account user = new Account();
//        
//        
//         user.setFirstName("Muhammad");
//         user.setLastName("Tarek");
//         user.setUserName("ahmed1");
//         user.setPassword("1234567856");
//         user.setSSN("2 96 01 21 01 02735");
//         user.setPhoneNumber("0100 44 02 609");
//         user.setAddress("7, Othman Basha Ghaleb, Heliopolis");
//         user.setAge(18);
//         user.setGender("Male");
//         user.setMoneyBalance(5000);
//         user.setInterestRate(5000);
//         user.setOfferStatus(false);
//         user.setLoanStatus(false);
//        
//         creditCard card = new creditCard();
//         card.setCVC(9696);
//         card.setCreditCardNumber(312343242);
//         //Set Date
//         DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
//         Date date = formatter.parse("01/29/02");
//         card.setExpirationDate(date);
//         user.setCreditCard(card);
//         System.out.println(accountmanager.createAccount(user));
//         
//         user=(Account)accountmanager.searchAccount(user);
//         System.out.println(user.getFirstName()+" "+user.getLastName()+" "+user.getUserName()+" "+user.getPassword()+" "+user.getCreditCard().getExpirationDate().toString());
//         
        
//        Company company=new Company();
//          company.setUserName("Team_M");
//          company.setPassword("123546789");
//          company.setAddress("7, Othman Basha Ghaleb, Heliopolis");
//          company.setEmail("Team@yahoo.com");
//          company.setEmployeeNumber(100);
//          company.setInterestRate((float) 12.5);
//          company.setLoanStatus(false);
//          company.setMoneyBalance(13265.26);
//          company.setName("Name_Team");
//          company.setPhoneNumber("012345678954");
//          company.setWebsite("www.asdsad.com");
//          
//          System.out.println(accountmanager.createAccount(company));
//          
//          company=(Company)accountmanager.searchAccount(company);
//          System.out.println(company.getName()+" "+company.getUserName()+" "+company.getPassword()+" "+company.getEmail()+" "+ company.getPhoneNumber()+" "+company.getLoanStatus());
//         
        
    //Loan create individualType 
//      loanEmployee loan=new loanEmployee();
//      individualType individualtype=new individualType();
//      
//      individualtype.setFirstName("mohamed");
//      individualtype.setLastName("kamal");
//      individualtype.setAccountStatus(false);
//      individualtype.setAddress("3basia,giza");
//      individualtype.setLoanBalance(1500.0);
//      individualtype.setLoanInterestRate((float) 2.5);
//      individualtype.setPhoneNumber("01325647985");
//      individualtype.setRepatmentPeriod(5);
//      individualtype.setSSN("13246579812345");
//      individualtype.setSalary(14000.0);
//      
//       System.out.println(loan.createAccount(individualtype));
//        
//          individualtype=(individualType) loan.searchAccount(individualtype);
//          
//         System.out.println(loan.repayLoan(individualtype, 500));
//         
//          System.out.println(individualtype.getSSN()+" "+individualtype.getFirstName()+" "+individualtype.getLastName()+" "+individualtype.getLoanBalance()+" "+individualtype.getAddress());
//  
//      
//    companyType companytype=new companyType();
////       companytype.setAccountStatus(false);
////       companytype.setAddress("asd,asd56");
////       companytype.setCapital(1000000);
////       companytype.setLoanBalance(1325);
//       companytype.setName("Mostafico");
////       companytype.setPhoneNumber("01235468956");
////       companytype.setRepatmentPeriod(5);
////       
////        System.out.println(loan.createAccount(companytype));
//        
//       companytype=(companyType) loan.searchAccount(companytype);
//        System.out.println(companytype.getName()+" "+companytype.getPhoneNumber()+" "+companytype.getCapital());
        /*System.out.println(Human.Login("ahmed1", "1234567856")); 
        Manager x = new Manager();
        Account s = new Account();
        Individual a = new Individual();
        s.setUserName("ahmed1");
        s= (Account)a.searchAccount(s);
        System.out.println(s.getUserName() +" "+ s.getFirstName() +" "+ s.getCreditCard().getCreditCardNumber()+ " " + s.getCreditCard().getExpirationDate());*/
        /*humanResources h = new humanResources();
        Staff x = new Staff();
        x.setFirstName("Ahmed");
        x.setLastName("Ali");
        x.setPassword("123456");
        x.setUserName("m.ahmed");
        x.setPosition("accountManager");
        x.setSalary(5000.0);
        System.out.println(h.createAccount(x));*/
//        Company x = new Company();
//        accountManager z = new accountManager();
//        x.setAddress("abbasia cairo");
//        x.setEmail("medo_forever277@yahoo.com");
//        x.setEmployeeNumber(1000);
//        x.setInterestRate((float) 22.0);
//        x.setLoanStatus(false);
//        x.setMoneyBalance(2);
//        x.setName("egyptair");
//        x.setPassword("123456");
//        x.setPhoneNumber("01147960889");
//        x.setUserName("c_egypt");
//        x.setWebsite("www.facebook.com");
//        x.setIndustryType("Tecnology");
//        System.out.println(z.createAccount(x));
//        x = (Company)x.searchAccount(x);
//        System.out.println(x.getIndustryType());

/*ObjectInputStream file = new ObjectInputStream(new FileInputStream("Database\\login.bin"));
       ArrayList<String> arrList_log = new ArrayList<>();
       HashMap<String, ArrayList<String>> hash_log = (HashMap<String, ArrayList<String>>) file.readObject();
       file.close();
       arrList_log.add("Admin");
       arrList_log.add("M");
       hash_log.put("Admin", arrList_log);
       ObjectOutputStream fileWriter2 = new ObjectOutputStream(new FileOutputStream("Database\\login.bin"));
       fileWriter2.writeObject(hash_log);
       fileWriter2.close();*/
        /*Teller x = new Teller();
        Account z = new Account();
        z.setUserName("m.kamal275");
        z = (Account)x.searchAccount(z);
        System.out.println(z.getMoneyBalance());
        x.withDraw(z, 20);
        z = (Account)x.searchAccount(z);
        System.out.println(z.getMoneyBalance());*/
        /*
        Account x = new Account();
        x.setUserName("m.kamal275");
        
        Individual z = new Individual();
        System.out.println(z.displayTransactions(x));*/
    }
}
