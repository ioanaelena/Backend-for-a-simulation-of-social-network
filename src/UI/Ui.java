package UI;

import Domain.Friendship;
import Domain.User;
import ServicePackage.Service;
import ServicePackage.ServiceClass;

import java.util.List;
import java.util.Scanner;

public class Ui {
    public Ui(ServiceClass service) {
        this.service = service;
    }

    ServiceClass service;
    Scanner scanner = new Scanner(System.in);
    private void printMenu(){
        System.out.println("1.Add an user.");
        System.out.println("2.Delete an user.");
        System.out.println("3.Add a friendship.");
        System.out.println("4.Delete a friendship.");
        System.out.println("5.Show all users");
        System.out.println("6.Show all friendships");
        System.out.println("x.Exit");
    }
    private void addUser(){
        System.out.println("Give the id of the user:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Give the age of the user:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Give the first name of the user :");
        String firstname = scanner.nextLine();
        System.out.println("Give the last name of the user:");
        String lastname = scanner.nextLine();
        User user= new User(id,age,firstname,lastname);
        try{
            service.addUser(user);
            System.out.println("User added");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    private void deleteUser(){
        System.out.println("Give the id of the user you want to delete:");
        int id = scanner.nextInt();
        try{
            service.removeUser(id);
            System.out.println("User deleted");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void addFriendship(){
        System.out.println("Give the id of the friendship:");
        int id = scanner.nextInt();
        System.out.println("Give the id of the first user:");
        int id1 = scanner.nextInt();
        System.out.println("Give the id of the second user:");
        int id2 = scanner.nextInt();
        Friendship friendship = new Friendship(id,id1,id2);
        try{
            service.addFriendship(friendship);
            System.out.println("Friendship created");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void deleteFriendship(){
        System.out.println("Give the id of the friendship you want to delete:");
        int id = scanner.nextInt();
        try{
            service.removeFriendship(id);
            System.out.println("Friendship deleted");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void main1() {
        printMenu();
        String options = null;
        Scanner scan = new Scanner(System.in); // Capturing the input
        do {

            options = scan.nextLine();
            switch (options) {
                case "1":
                    addUser();
                    break;
                case "2":
                    deleteUser();
                    break;
                case "3":
                    addFriendship();
                    break;
                case "4":
                    deleteFriendship();
                    break;
                case "5":
                    showUsers();
                    break;
                case "6":
                    showFriendship();
                    break;
            }
            printMenu();
        } while (!options.equals("x")); // quitting the program
    }
    public void showFriendship() {
        service.showallF();
    }

    public void showUsers() {
        service.showallU();

    }
}
