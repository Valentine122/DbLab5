package ua.lviv.iot.view;

import ua.lviv.iot.controller.*;
import ua.lviv.iot.model.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    private final ChildController childController = new ChildController();
    private final ChildGroupController childGroupController = new ChildGroupController();
    private final KindergartenController kindergartenController = new KindergartenController();
    private final ParentInfoController parentInfoController = new ParentInfoController();
    private final PaymentController paymentController = new PaymentController();
    private final VaccinationController vaccinationController = new VaccinationController();
    private final WorkerController workerController = new WorkerController();

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private static final Scanner INPUT = new Scanner(System.in);

    public View() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();

        menu.put("Q", "Q - exit program");
        menu.put("S", "S - show menu");

        menu.put("1", "1 - Get all children");
        menu.put("2", "2 - Get a child by ID");
        menu.put("3", "3 - Create a child");
        menu.put("4", "4 - Delete a child by ID");
        menu.put("5", "5 - Update a child \n");

        menu.put("6", "6 - Get all children groups");
        menu.put("7", "7 - Get a group by ID");
        menu.put("8", "8 - Create a child group");
        menu.put("9", "9 - Delete a child group");
        menu.put("0", "0 - Update a child group \n");

        menu.put("11", "11 - Get all kindergartens");
        menu.put("12", "12 - Get a kindergarten by ID");
        menu.put("13", "13 - Create a kindergarten");
        menu.put("14", "14 - Delete a kindergarten");
        menu.put("15", "15 - Update a kindergarten \n");

        menu.put("21", "21 - Get all parents info");
        menu.put("22", "22 - Get parents info by child ID");
        menu.put("23", "23 - Create parents info for child");
        menu.put("24", "24 - Delete parents info by child ID");
        menu.put("25", "25 - Update parents info \n");

        menu.put("31", "31 - Get all payment info");
        menu.put("32", "32 - Get payment info by worker ID");
        menu.put("33", "33 - Create payment info for worker");
        menu.put("34", "34 - Delete payment info by worker ID");
        menu.put("35", "35 - Update payment info \n");

        menu.put("41", "41 - Get all vaccination info");
        menu.put("42", "42 - Get vaccination info by child ID");
        menu.put("43", "43 - Create vaccination info for child");
        menu.put("44", "44 - Delete vaccination info by child ID");
        menu.put("45", "45 - Update vaccination info \n");

        menu.put("51", "51 - Get all workers");
        menu.put("52", "52 - Get a worker by ID");
        menu.put("53", "53 - Create a worker");
        menu.put("54", "54 - Delete a worker by ID");
        menu.put("55", "55 - Update a worker \n");

        methodsMenu.put("S", this::outputMenu);

        methodsMenu.put("1", this::getAllChildren);
        methodsMenu.put("2", this::getChildById);
        methodsMenu.put("3", this::createChild);
        methodsMenu.put("4", this::deleteChild);
        methodsMenu.put("5", this::updateChildren);

        methodsMenu.put("6", this::getAllGroups);
        methodsMenu.put("7", this::getGroupById);
        methodsMenu.put("8", this::createGroup);
        methodsMenu.put("9", this::deleteGroup);
        methodsMenu.put("0", this::updateGroups);

        methodsMenu.put("11", this::getAllKindergartens);
        methodsMenu.put("12", this::getKindergartenById);
        methodsMenu.put("13", this::createKindergarten);
        methodsMenu.put("14", this::deleteKindergarten);
        methodsMenu.put("15", this::updateKindergartens);

        methodsMenu.put("21", this::getAllParentsInfo);
        methodsMenu.put("22", this::getParentsInfoByChildId);
        methodsMenu.put("23", this::createParentsInfoByChildId);
        methodsMenu.put("24", this::deleteParentsInfoByChildId);
        methodsMenu.put("25", this::updateParentsInfo);

        methodsMenu.put("31", this::getAllPaymentInfo);
        methodsMenu.put("32", this::getPaymentInfoByWorkerId);
        methodsMenu.put("33", this::createPaymentInfoByWorkerId);
        methodsMenu.put("34", this::deletePaymentInfoByWorkerId);
        methodsMenu.put("35", this::updatePaymentInfo);

        methodsMenu.put("41", this::getAllVaccinationInfo);
        methodsMenu.put("42", this::getVaccinationInfoByChildId);
        methodsMenu.put("43", this::createVaccinationInfoByChildId);
        methodsMenu.put("44", this::deleteVaccinationInfoByChildId);
        methodsMenu.put("45", this::updateVaccinationInfo);

        methodsMenu.put("51", this::getAllWorkers);
        methodsMenu.put("52", this::getWorkerById);
        methodsMenu.put("53", this::createWorker);
        methodsMenu.put("54", this::deleteWorker);
        methodsMenu.put("55", this::updateWorker);
    }

    private void getAllChildren() throws SQLException {
        System.out.println("\nChildren:");
        System.out.println(childController.findAll());
    }

    private void getChildById() throws SQLException {
        System.out.println("\nEnter ID for a child you want to find");
        int id = INPUT.nextInt();
        System.out.println(childController.findBy(id));
    }

    private void createChild() throws SQLException {
        System.out.println("\nEnter child name");
        String name = INPUT.next();
        System.out.println("\nEnter child surname");
        String surname = INPUT.next();
        System.out.println("\nEnter certificate of birth numbers");
        int certificateOfBirth = INPUT.nextInt();
        System.out.println("\nEnter date of entry (yyyy-mm-dd)");
        String dateOfEntry = INPUT.next();
        System.out.println("\nEnter child group ID");
        int childGroupId = INPUT.nextInt();
        System.out.println("\nEnter kindergarten ID");
        int childGroupKindergartenId = INPUT.nextInt();
        System.out.println("\nEnter child status");
        String status = INPUT.next();
        Child child = new Child(name, surname, certificateOfBirth, Date.valueOf(dateOfEntry), childGroupId, childGroupKindergartenId, status);
        childController.create(child);
    }

    private void updateChildren() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter child name");
        String name = INPUT.next();
        System.out.println("\nEnter child surname");
        String surname = INPUT.next();
        System.out.println("\nEnter certificate of birth numbers");
        int certificateOfBirth = INPUT.nextInt();
        System.out.println("\nEnter date of entry (yyyy-mm-dd)");
        String dateOfEntry = INPUT.next();
        System.out.println("\nEnter child group ID");
        int childGroupId = INPUT.nextInt();
        System.out.println("\nEnter kindergarten ID");
        int childGroupKindergartenId = INPUT.nextInt();
        System.out.println("\nEnter child status");
        String status = INPUT.next();
        Child child = new Child(id, name, surname, certificateOfBirth, Date.valueOf(dateOfEntry), childGroupId, childGroupKindergartenId, status);
        childController.update(child);
    }

    private void deleteChild() throws SQLException {
        System.out.println("\nEnter ID for child you want to delete");
        int id = INPUT.nextInt();
        childController.deleteBy(id);
    }

    private void getAllGroups() throws SQLException {
        System.out.println("\nGroups:");
        System.out.println(childGroupController.findAll());
    }

    private void getGroupById() throws SQLException {
        System.out.println("\nEnter ID for a group you want to find");
        int id = INPUT.nextInt();
        System.out.println(childGroupController.findBy(id));
    }

    private void createGroup() throws SQLException {
        System.out.println("\nEnter kindergarten ID");
        int kindergartenId = INPUT.nextInt();
        System.out.println("\nEnter group name");
        String name = INPUT.next();
        System.out.println("\nEnter count of children");
        int countOfChildren = INPUT.nextInt();
        ChildGroup childGroup = new ChildGroup(kindergartenId, name, countOfChildren);
        childGroupController.create(childGroup);
    }

    private void updateGroups() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter kindergarten ID");
        int kindergartenId = INPUT.nextInt();
        System.out.println("\nEnter group name");
        String name = INPUT.next();
        System.out.println("\nEnter count of children");
        int countOfChildren = INPUT.nextInt();
        ChildGroup childGroup = new ChildGroup(id, kindergartenId, name, countOfChildren);
        childGroupController.update(childGroup);
    }

    private void deleteGroup() throws SQLException {
        System.out.println("\nEnter ID for group you want to delete");
        int id = INPUT.nextInt();
        childGroupController.deleteBy(id);
    }

    private void getAllKindergartens() throws SQLException {
        System.out.println("\nKindergartens:");
        System.out.println(kindergartenController.findAll());
    }

    private void getKindergartenById() throws SQLException {
        System.out.println("\nEnter ID for a kindergarten you want to find");
        int id = INPUT.nextInt();
        System.out.println(kindergartenController.findBy(id));
    }

    private void createKindergarten() throws SQLException {
        System.out.println("\nEnter kindergarten name");
        String name = INPUT.next();
        System.out.println("\nEnter kindergarten street");
        String street = INPUT.next();
        System.out.println("\nEnter kindergarten building number");
        int buildingNumber = INPUT.nextInt();
        System.out.println("\nEnter count of groups");
        int countOfGroup = INPUT.nextInt();
        Kindergarten kindergarten = new Kindergarten(name, street, buildingNumber, countOfGroup);
        kindergartenController.create(kindergarten);
    }

    private void updateKindergartens() throws SQLException {
        System.out.println("\nEnter kindergarten ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter kindergarten name");
        String name = INPUT.next();
        System.out.println("\nEnter kindergarten street");
        String street = INPUT.next();
        System.out.println("\nEnter kindergarten building number");
        int buildingNumber = INPUT.nextInt();
        System.out.println("\nEnter count of groups");
        int countOfGroup = INPUT.nextInt();
        Kindergarten kindergarten = new Kindergarten(id, name, street, buildingNumber, countOfGroup);
        kindergartenController.update(kindergarten);
    }

    private void deleteKindergarten() throws SQLException {
        System.out.println("\nEnter ID for kindergarten you want to delete");
        int id = INPUT.nextInt();
        kindergartenController.deleteBy(id);
    }

    private void getAllParentsInfo() throws SQLException {
        System.out.println("\nParents info:");
        System.out.println(parentInfoController.findAll());
    }

    private void getParentsInfoByChildId() throws SQLException {
        System.out.println("\nEnter ID to get information about parents");
        int id = INPUT.nextInt();
        System.out.println(parentInfoController.findBy(id));
    }

    private void createParentsInfoByChildId() throws SQLException {
        System.out.println("\nEnter child ID");
        int childId = INPUT.nextInt();
        System.out.println("\nEnter father surname");
        String fatherSurname = INPUT.next();
        System.out.println("\nEnter father name");
        String fatherName = INPUT.next();
        System.out.println("\nEnter father patronymic");
        String fatherPatronymic = INPUT.next();
        System.out.println("\nEnter father phone number");
        String fatherPhoneNumber = INPUT.next();
        System.out.println("\nEnter mother surname");
        String motherSurname = INPUT.next();
        System.out.println("\nEnter mother name");
        String motherName = INPUT.next();
        System.out.println("\nEnter mother patronymic");
        String motherPatronymic = INPUT.next();
        System.out.println("\nEnter mother phone number");
        String motherPhoneNumber = INPUT.next();
        ParentInfo parentInfo = new ParentInfo(childId, fatherSurname, fatherName, fatherPatronymic, fatherPhoneNumber, motherSurname, motherName, motherPatronymic, motherPhoneNumber);
        parentInfoController.create(parentInfo);
    }

    private void updateParentsInfo() throws SQLException {
        System.out.println("\nEnter child ID");
        int childId = INPUT.nextInt();
        System.out.println("\nEnter father surname");
        String fatherSurname = INPUT.next();
        System.out.println("\nEnter father name");
        String fatherName = INPUT.next();
        System.out.println("\nEnter father patronymic");
        String fatherPatronymic = INPUT.next();
        System.out.println("\nEnter father phone number");
        String fatherPhoneNumber = INPUT.next();
        System.out.println("\nEnter mother surname");
        String motherSurname = INPUT.next();
        System.out.println("\nEnter mother name");
        String motherName = INPUT.next();
        System.out.println("\nEnter mother patronymic");
        String motherPatronymic = INPUT.next();
        System.out.println("\nEnter mother phone number");
        String motherPhoneNumber = INPUT.next();
        ParentInfo parentInfo = new ParentInfo(childId, fatherSurname, fatherName, fatherPatronymic, fatherPhoneNumber, motherSurname, motherName, motherPatronymic, motherPhoneNumber);
        parentInfoController.update(parentInfo);
    }

    private void deleteParentsInfoByChildId() throws SQLException {
        System.out.println("\nEnter ID to delete information about parents");
        int id = INPUT.nextInt();
        parentInfoController.deleteBy(id);
    }

    private void getAllPaymentInfo() throws SQLException {
        System.out.println("\nPayment info:");
        System.out.println(paymentController.findAll());
    }

    private void getPaymentInfoByWorkerId() throws SQLException {
        System.out.println("\nEnter ID to get information about payment");
        int id = INPUT.nextInt();
        System.out.println(paymentController.findBy(id));
    }

    private void createPaymentInfoByWorkerId() throws SQLException {
        System.out.println("\nEnter worker ID");
        int workerId = INPUT.nextInt();
        System.out.println("\nEnter salary");
        int salary = INPUT.nextInt();
        System.out.println("\nEnter amount of remuneration");
        int amountOfRemuneration = INPUT.nextInt();
        System.out.println("\nEnter date of pay (yyyy-mm-dd)");
        String dateOfPay = INPUT.next();
        Payment payment = new Payment(workerId, salary, amountOfRemuneration, Date.valueOf(dateOfPay));
        paymentController.create(payment);
    }

    private void updatePaymentInfo() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter worker ID");
        int workerId = INPUT.nextInt();
        System.out.println("\nEnter salary");
        int salary = INPUT.nextInt();
        System.out.println("\nEnter amount of remuneration");
        int amountOfRemuneration = INPUT.nextInt();
        System.out.println("\nEnter date of pay (yyyy-mm-dd)");
        String dateOfPay = INPUT.next();
        Payment payment = new Payment(id, workerId, salary, amountOfRemuneration, Date.valueOf(dateOfPay));
        paymentController.update(payment);
    }

    private void deletePaymentInfoByWorkerId() throws SQLException {
        System.out.println("\nEnter ID to delete information about payment");
        int id = INPUT.nextInt();
        paymentController.deleteBy(id);
    }

    private void getAllVaccinationInfo() throws SQLException {
        System.out.println("\nVaccination info:");
        System.out.println(vaccinationController.findAll());
    }

    private void getVaccinationInfoByChildId() throws SQLException {
        System.out.println("\nEnter ID to get information about vaccination");
        int id = INPUT.nextInt();
        System.out.println(vaccinationController.findBy(id));
    }

    private void createVaccinationInfoByChildId() throws SQLException {
        System.out.println("\nEnter child ID");
        int childId = INPUT.nextInt();
        System.out.println("\nEnter vaccine name");
        String name = INPUT.next();
        System.out.println("\nEnter date of vaccination (yyyy-mm-dd)");
        String dateOfVaccination = INPUT.next();
        Vaccination vaccination = new Vaccination(childId, name, Date.valueOf(dateOfVaccination));
        vaccinationController.create(vaccination);
    }

    private void updateVaccinationInfo() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter child ID");
        int childId = INPUT.nextInt();
        System.out.println("\nEnter vaccine name");
        String name = INPUT.next();
        System.out.println("\nEnter date of vaccination (yyyy-mm-dd)");
        String dateOfVaccination = INPUT.next();
        Vaccination vaccination = new Vaccination(id, childId, name, Date.valueOf(dateOfVaccination));
        vaccinationController.update(vaccination);
    }

    private void deleteVaccinationInfoByChildId() throws SQLException {
        System.out.println("\nEnter ID to delete information about vaccination");
        int id = INPUT.nextInt();
        vaccinationController.deleteBy(id);
    }

    private void getAllWorkers() throws SQLException {
        System.out.println("\nWorkers:");
        System.out.println(workerController.findAll());
    }

    private void getWorkerById() throws SQLException {
        System.out.println("\nEnter ID for a worker you want to find");
        int id = INPUT.nextInt();
        System.out.println(workerController.findBy(id));
    }

    private void createWorker() throws SQLException {
        System.out.println("\nEnter worker name");
        String name = INPUT.next();
        System.out.println("\nEnter worker surname");
        String surname = INPUT.next();
        System.out.println("\nEnter date of employment (yyyy-mm-dd)");
        String dateOfEmployment = INPUT.next();
        System.out.println("\nEnter child group ID");
        int childGroupId = INPUT.nextInt();
        System.out.println("\nEnter kindergarten ID");
        int childGroupKindergartenId = INPUT.nextInt();
        System.out.println("\nEnter worker status");
        String status = INPUT.next();
        Worker worker = new Worker(name, surname, Date.valueOf(dateOfEmployment), childGroupId, childGroupKindergartenId, status);
        workerController.create(worker);
    }

    private void updateWorker() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter worker name");
        String name = INPUT.next();
        System.out.println("\nEnter worker surname");
        String surname = INPUT.next();
        System.out.println("\nEnter date of employment (yyyy-mm-dd)");
        String dateOfEmployment = INPUT.next();
        System.out.println("\nEnter child group ID");
        int childGroupId = INPUT.nextInt();
        System.out.println("\nEnter kindergarten ID");
        int childGroupKindergartenId = INPUT.nextInt();
        System.out.println("\nEnter worker status");
        String status = INPUT.next();
        Worker worker = new Worker(id, name, surname, Date.valueOf(dateOfEmployment), childGroupId, childGroupKindergartenId, status);
        workerController.update(worker);
    }

    private void deleteWorker() throws SQLException {
        System.out.println("\nEnter ID for worker you want to delete");
        int id = INPUT.nextInt();
        workerController.deleteBy(id);
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    private void outputSubMenu() {
        System.out.println(menu.get("S"));
        System.out.println(menu.get("Q"));
        System.out.println("Please, select menu point.");
    }

    public void show() {
        String keyMenu;
        outputSubMenu();
        do {
            keyMenu = INPUT.next().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            }
            catch (Exception ignored) {
            }
            outputSubMenu();
        } while (!keyMenu.equals("Q"));
    }
}
