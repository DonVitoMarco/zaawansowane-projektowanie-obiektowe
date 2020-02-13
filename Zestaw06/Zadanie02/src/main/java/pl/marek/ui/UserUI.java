package pl.marek.ui;

import pl.marek.model.Address;
import pl.marek.model.User;
import pl.marek.service.IAccountService;
import pl.marek.util.ResultPrinter;

import java.util.Scanner;

public class UserUI {

    private IAccountService accountService;
    private Scanner scanner;

    public UserUI(Scanner scanner, IAccountService accountService) {
        this.scanner = scanner;
        this.accountService = accountService;
    }

    public void showAllUsers() {
        accountService.getUsers().forEach(u -> {
            System.out.println("----------------");
            System.out.printf("Id : %s %n", u.getId());
            System.out.printf("Login : %s %n", u.getLogin());
            System.out.printf("First Name : %s %n", u.getFirstName());
            System.out.printf("Second Name : %s %n", u.getSecondName());
            System.out.printf("Email : %s %n", u.getEmail());
            System.out.printf("Register Date : %1$td.%1$tm.%1$ty %n", u.getRegisterDate());
            System.out.printf("Phone : %s %n", u.getPhone());

            Address address = accountService.getAddressForUser(u.getId());
            if (address != null) {
                System.out.printf("City : %s %n", address.getCity());
                System.out.printf("Street : %s %n", address.getStreet());
                System.out.printf("House Number : %s %n", address.getHouseNumber());
                System.out.printf("Post Code : %s %n", address.getPostCode());
            }
            System.out.println("----------------");
        });
    }

    public void createUser() {
        System.out.println("----------------");
        System.out.println("Login: ");
        String login = scanner.nextLine();
        System.out.println("First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Second Name: ");
        String secondName = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        System.out.println("Phone: ");
        String phone = scanner.nextLine();
        System.out.println("City: ");
        String city = scanner.nextLine();
        System.out.println("Street: ");
        String street = scanner.nextLine();
        System.out.println("House Number: ");
        String houseNumber = scanner.nextLine();
        System.out.println("Post Code: ");
        String postCode = scanner.nextLine();

        User user = new User(login, firstName, secondName, password, email, phone);
        Address address = new Address(city, street, houseNumber, postCode, user.getId());

        int result = accountService.createUserWithAddress(user, address);

        ResultPrinter.printQueryResult(result);
        System.out.println("----------------");
    }

    public void deleteUser() {
        System.out.println("----------------");
        System.out.println("Id: ");
        String id = scanner.nextLine();

        int result = accountService.deleteUser(id);

        ResultPrinter.printQueryResult(result);
        System.out.println("----------------");
    }

    public void updatePassword() {
        System.out.println("----------------");
        System.out.println("Id: ");
        String id = scanner.nextLine();
        System.out.println("New Password: ");
        String newPassword = scanner.nextLine();

        int result = accountService.updatePassword(id, newPassword);

        ResultPrinter.printQueryResult(result);
        System.out.println("----------------");
    }

    public void updateAddress() {
        System.out.println("----------------");
        System.out.println("User Id: ");
        String userId = scanner.nextLine();
        System.out.println("City: ");
        String city = scanner.nextLine();
        System.out.println("Street: ");
        String street = scanner.nextLine();
        System.out.println("House Number: ");
        String houseNumber = scanner.nextLine();
        System.out.println("Post Code: ");
        String postCode = scanner.nextLine();

        Address address = accountService.getAddressForUser(userId);
        int result = 0;
        if (address != null) {
            Address updatedAddress = new Address(address.getId(), city, street, houseNumber, postCode, userId);
            result = accountService.updateAddress(userId, updatedAddress);
        }

        ResultPrinter.printQueryResult(result);
        System.out.println("----------------");
    }
}
