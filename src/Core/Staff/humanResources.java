package Core.Staff;

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

public class humanResources extends Staff implements IfileManager,Serializable {

    @Override
    public boolean createAccount(Object object) throws IOException, ClassNotFoundException {
        Staff staff = (Staff) object;
        String Type = "";
        System.out.println(staff.Position);
        if (staff.Position.equalsIgnoreCase("Teller")) {
            Type = "T";
        } else if (staff.Position.equalsIgnoreCase("accountManager")) {
            Type = "A";
        } else if (staff.Position.equalsIgnoreCase("loanemployee")) {
            Type = "L";
        }
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream("Database\\staff.bin"));
            ArrayList<Staff> a = (ArrayList<Staff>) o.readObject();
            String id = "";
            for (Staff p : a) {
                if (Type.equalsIgnoreCase("" + p.getStaffID().charAt(0))) {
                    id = p.getStaffID();
                }
                if (staff.getUserName().equals(p.getUserName())) {
                    return false;
                }
            }
            if (id.equals("")) {
                id = Type;
            }
            staff.setStaffID(id);
            a.add(staff);
            o.close();
            ObjectOutputStream o1;
            o1 = new ObjectOutputStream(new FileOutputStream("Database\\staff.bin"));
            o1.writeObject(a);
        } catch (FileNotFoundException | EOFException e) {
            ArrayList<Staff> a = new ArrayList<>();
            staff.setStaffID(Type);
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
        String pos;
        ObjectInputStream Filereader = new ObjectInputStream(new FileInputStream("Database\\staff.bin"));
        ArrayList<Staff> datalist = (ArrayList<Staff>) Filereader.readObject();
        Filereader.close();
        ArrayList<Staff> Templist = new ArrayList<>();
        for (Staff temp : datalist) {
            pos = temp.Position;
            if (temp.getStaffID().equalsIgnoreCase(CastStaff.getStaffID()) && (pos.equalsIgnoreCase("Teller") || pos.equalsIgnoreCase("accountManager") || pos.equalsIgnoreCase("loanemployee"))) {
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
        ArrayList<String> arrList_log = new ArrayList<>();
        HashMap<String, ArrayList<String>> hash_log = (HashMap<String, ArrayList<String>>) file.readObject();
        file.close();

        arrList_log.add(CastStaff.getPassword());
        pos = CastStaff.getPosition();
        if (pos.equalsIgnoreCase("Teller") || pos.equalsIgnoreCase("accountManager") || pos.equalsIgnoreCase("loanemployee")) {
            arrList_log.add(CastStaff.getStaffID());
            hash_log.put(CastStaff.getUserName(), arrList_log);
        }

        ObjectOutputStream fileWriter2 = new ObjectOutputStream(new FileOutputStream("Database\\login.bin"));
        fileWriter2.writeObject(hash_log);
        fileWriter2.close();
    }

    public ArrayList<String> showStaffData() throws IOException, ClassNotFoundException {
        ArrayList<Staff> array;
        ArrayList<String> array2 = new ArrayList();
        String sentence;
        int i = 0;
        ObjectInputStream fromFile = new ObjectInputStream(new FileInputStream("Database\\staff.bin"));
        array = (ArrayList<Staff>) fromFile.readObject();
        fromFile.close();

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
}
