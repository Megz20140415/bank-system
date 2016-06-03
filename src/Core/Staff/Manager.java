package Core.Staff;

import Core.Users.Account;
import Core.Users.Company;
import Interface.IfileManager;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Manager extends Staff implements IfileManager, Serializable {

    @Override
    public boolean createAccount(Object object) throws Exception {
        Staff staff = (Staff) object;

        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream("Database\\staff.bin"));
            ArrayList<Staff> a = (ArrayList<Staff>) o.readObject();
            String id = "H";
            for (Staff p : a) {
                if (p.getStaffID().charAt(0) == 'H') {
                    id = p.getStaffID();
                }
                if (staff.getUserName().equals(p.getUserName())) {
                    return false;
                }
            }
            staff.setStaffID(id);
            a.add(staff);
            o.close();
            ObjectOutputStream o1;
            o1 = new ObjectOutputStream(new FileOutputStream("Database\\staff.bin"));
            o1.writeObject(a);
        } catch (FileNotFoundException | EOFException e) {
            ArrayList<Staff> a = new ArrayList<>();
            staff.setStaffID("H");
            a.add(staff);
            ObjectOutputStream o1;
            o1 = new ObjectOutputStream(new FileOutputStream("Database\\staff.bin"));
            o1.writeObject(a);
        } finally {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream("Database\\login.bin"));
            ArrayList<String> arrList_log = new ArrayList<String>();
            HashMap<String, ArrayList<String>> hash_log = (HashMap<String, ArrayList<String>>) file.readObject();
            file.close();

            arrList_log.add(staff.getPassword());
            arrList_log.add(staff.getStaffID());
            hash_log.put(staff.getUserName(), arrList_log);

            ObjectOutputStream fileWriter2 = new ObjectOutputStream(new FileOutputStream("Database\\login.bin"));
            fileWriter2.writeObject(hash_log);
            fileWriter2.close();
        }

        return true;
    }

    @Override
    public void deleteAccount(Object object) throws IOException, ClassNotFoundException {
        Staff manager = (Staff) object;
        ///////////////////
        ObjectInputStream file = new ObjectInputStream(new FileInputStream("Database\\login.bin"));
        HashMap<String, ArrayList<String>> hash_log = (HashMap<String, ArrayList<String>>) file.readObject();
        file.close();

        hash_log.remove(manager.getUserName());
        ObjectOutputStream fileWriter2 = new ObjectOutputStream(new FileOutputStream("Database\\login.bin"));
        fileWriter2.writeObject(hash_log);
        fileWriter2.close();

        ///////////////////
        ObjectInputStream fileScanner = new ObjectInputStream(new FileInputStream("Database\\staff.bin"));
        ArrayList<Staff> arrList_staff = (ArrayList<Staff>) fileScanner.readObject();
        fileScanner.close();

        ArrayList<Staff> templist = new ArrayList<>();
        for (Staff Ma : arrList_staff) {
            if (!manager.getUserName().equals(Ma.getUserName())) {
                templist.add(Ma);
            }
        }
        ObjectOutputStream fileWriter1 = new ObjectOutputStream(new FileOutputStream("Database\\staff.bin"));
        fileWriter1.writeObject(templist);
        fileWriter1.close();
    }

    @Override
    public Object searchAccount(Object object) throws IOException, ClassNotFoundException {
        Staff manager = (Staff) object;

        ObjectInputStream fileScanner = new ObjectInputStream(new FileInputStream("Database\\staff.bin"));
        ArrayList<Staff> arrList_staff = (ArrayList<Staff>) fileScanner.readObject();
        fileScanner.close();

        for (Staff Ma : arrList_staff) {
            if (Ma.getUserName().equals(manager.getUserName())) {
                return Ma;
            }
        }
        return manager;
    }

    @Override
    public void updateAccount(Object object) throws IOException, ClassNotFoundException {
        //update in Staff File
        Staff CastStaff = (Staff) object;
        ObjectInputStream Filereader = new ObjectInputStream(new FileInputStream("Database\\staff.bin"));
        ArrayList<Staff> datalist = (ArrayList<Staff>) Filereader.readObject();
        Filereader.close();
        ArrayList<Staff> Templist = new ArrayList<>();
        for (Staff temp : datalist) {
            if (temp.getStaffID().equalsIgnoreCase(CastStaff.getStaffID())) {
                Templist.add(CastStaff);
            } else {
                Templist.add(temp);
            }
        }
        ObjectOutputStream Filewrite;
        Filewrite = new ObjectOutputStream(new FileOutputStream("Database\\staff.bin"));
        Filewrite.writeObject(Templist);
        Filewrite.close();

//update in login File
        ObjectInputStream file = new ObjectInputStream(new FileInputStream("Database\\login.bin"));
        ArrayList<String> arrList_log = new ArrayList<String>();
        HashMap<String, ArrayList<String>> hash_log = (HashMap<String, ArrayList<String>>) file.readObject();
        file.close();

        arrList_log.add(CastStaff.getPassword());
        arrList_log.add(CastStaff.getStaffID());
        hash_log.put(CastStaff.getUserName(), arrList_log);

        ObjectOutputStream fileWriter2 = new ObjectOutputStream(new FileOutputStream("Database\\login.bin"));
        fileWriter2.writeObject(hash_log);
        fileWriter2.close();
    }

    public ArrayList<String> showAllStaffData() throws IOException, ClassNotFoundException {
        ArrayList<Staff> array;
        ArrayList<String> array2 = new ArrayList();
        String sentence;
        int i = 0;
        ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream("Database\\staff.bin"));
        array = (ArrayList<Staff>) fromFile.readObject();
        fromFile.close();

        for (i = 0; i < array.size(); i++) {
            if (array.get(i).getPosition().equalsIgnoreCase("humanResources")) {
                sentence = String.format("%s %s %s %s %s", array.get(i).getStaffID(), array.get(i).getFirstName(), array.get(i).getLastName(), array.get(i).getSalary(), array.get(i).getPosition());
                array2.add(sentence);
            }
        }
        for (i = 0; i < array.size(); i++) {
            if (array.get(i).getPosition().equalsIgnoreCase("loanEmployee")) {
                sentence = String.format("%s %s %s %s %s", array.get(i).getStaffID(), array.get(i).getFirstName(), array.get(i).getLastName(), array.get(i).getSalary(), array.get(i).getPosition());
                array2.add(sentence);
            }
        }
        for (i = 0; i < array.size(); i++) {
            if (array.get(i).getPosition().equalsIgnoreCase("accountManager")) {
                sentence = String.format("%s %s %s %s %s", array.get(i).getStaffID(), array.get(i).getFirstName(), array.get(i).getLastName(), array.get(i).getSalary(), array.get(i).getPosition());
                array2.add(sentence);
            }
        }
        for (i = 0; i < array.size(); i++) {
            if (array.get(i).getPosition().equalsIgnoreCase("Teller")) {
                sentence = String.format("%s %s %s %s %s", array.get(i).getStaffID(), array.get(i).getFirstName(), array.get(i).getLastName(), array.get(i).getSalary(), array.get(i).getPosition());
                array2.add(sentence);
            }
        }

        return array2;
    }

    public String showStatistics() throws IOException, ClassNotFoundException {
        String report = null;
        int staffNumber = 0;
        double totalSalary = 0.0;
        double maxSalary = 0.0;
        double minSalary = 0.0;

        ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream("Database\\staff.bin"));
        ArrayList<Staff> array;
        array = (ArrayList<Staff>) fromFile.readObject();
        fromFile.close();

        maxSalary = array.get(0).getSalary();
        minSalary = array.get(0).getSalary();

        for (int i = 0; i < array.size(); i++) {
            if (maxSalary < array.get(i).getSalary()) {
                maxSalary = array.get(i).getSalary();
            } else if (minSalary > array.get(i).getSalary()) {
                minSalary = array.get(i).getSalary();
            }
            totalSalary += array.get(i).getSalary();
            staffNumber++;
        }
        report = String.format("You have %d employees, total salaries is: %.2f, highest salary: %.2f and lowest salary: %.2f", staffNumber, totalSalary, maxSalary, minSalary);
        return report;
    }

    public double showTotalDeposits() throws IOException, ClassNotFoundException {
        double allMoney = 0.0;
        int i;

        //try {
        ObjectInputStream fromFile1 = new ObjectInputStream(new FileInputStream("Database\\individuals.bin"));
        ArrayList<Account> individualArray;
        individualArray = (ArrayList<Account>) fromFile1.readObject();
        fromFile1.close();
        if (individualArray != null) {
            for (i = 0; i < individualArray.size(); i++) {
                allMoney += individualArray.get(i).getMoneyBalance();
            }
        }

        ObjectInputStream fromFile2 = new ObjectInputStream(new FileInputStream("database\\companies.bin"));
        ArrayList<Company> companyArray;
        companyArray = (ArrayList<Company>) fromFile2.readObject();
        fromFile2.close();
        if (companyArray != null) {
            for (i = 0; i < companyArray.size(); i++) {
                allMoney += companyArray.get(i).getMoneyBalance();
            }
        }
        //} catch (Exception e) {
        //}
        return allMoney;
    }

    public int chart(int choice) throws IOException, ClassNotFoundException {
        
        ObjectInputStream fromFile1 = new ObjectInputStream(new FileInputStream("Database\\individuals.bin"));
        ArrayList<Account> individualArray = (ArrayList<Account>) fromFile1.readObject();
        fromFile1.close();

        int deposits = 0, withdraws = 0, transfares = 0;
        if (choice == 1) {
            for (Account account : individualArray) {
                if (account.getMakeDeposit() == true) {
                    deposits++;
                }
            }
            return deposits;
        }

        if (choice == 2) {
            for (Account account : individualArray) {

                if (account.getMakeWithdraw() == true) {
                    withdraws++;
                }
            }
            return withdraws;
        }
        if (choice == 3) {
            for (Account account : individualArray) {

                if (account.getMaketransfer()== true) {
                    transfares++;
                }
            }
            return transfares;
        }
        
        return 0;

    }
}
