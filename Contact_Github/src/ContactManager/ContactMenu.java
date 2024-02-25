package ContactManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class ContactMenu {
    static List<ContactVariables> contactVariablesList = new ArrayList<>();

    public static void main(String[] args) {
        boolean b = true;
        while (b) {
            menu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter action: ");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    addContact();
                    break;
                case 2:
                    contactList();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 0:
                    b = false;
                    System.out.println("program finished!!");
                    break;
            }
        }
    }

    public static void deleteContact() {

        System.out.println(contactVariablesList.removeAll(contactVariablesList));

    }

    public static void searchContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter query: ");
        String query = scanner.next();
        for (ContactVariables contactVariables : contactVariablesList) {
            if (contactVariables != null && contactVariables.getName().toLowerCase().startsWith(query.toLowerCase()) ||
                    contactVariables.getSurname().toLowerCase().startsWith(query.toLowerCase()) ||
                    contactVariables.getPhone().toLowerCase().startsWith(query.toLowerCase())) {
                System.out.println(contactVariables.getName() + " " + contactVariables.getSurname() + " " + contactVariables.getPhone());
            }
        }
    }

    public static void contactList() {
        for (ContactVariables contactVariables : contactVariablesList) {
            System.out.println(contactVariables.getName() + " " + contactVariables.getSurname() + " " + contactVariables.getPhone());
        }
    }

    public static ContactVariables addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter surname: ");
        String surname = scanner.next();
        System.out.print("Enter phone: ");
        String phone = scanner.next();

        ContactVariables contactVariables = new ContactVariables();
        contactVariables.setName(name);
        contactVariables.setSurname(surname);
        contactVariables.setPhone(phone);
        contactVariablesList.add(contactVariables);
        return contactVariables;
    }


    public static void menu() {
        System.out.println("** Menu **");
        System.out.println("1. addContact");
        System.out.println("2. ContactList");
        System.out.println("3. searchContact");
        System.out.println("4. deleteContact");
        System.out.println("0. Ext");
    }
}
