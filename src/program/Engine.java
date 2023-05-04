package program;

import entities.CarRental;
import entities.Vehicle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Engine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm");

        System.out.println("--------PILILIU CAR RENTAL LTDA-----------");
        System.out.print("Enter car model data:  ");
        String carModel =sc.nextLine();

        System.out.println("Retirada (dd/MM/yyyy   hh:mm):  ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(),fmt);

        System.out.println("Return (dd/MM/yyyy   hh:mm):  ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(),fmt);


        CarRental cr = new CarRental( start, finish, new Vehicle(carModel));












        sc.close();

    }
}
