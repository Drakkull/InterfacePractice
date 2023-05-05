package program;

import entities.CarRental;
import entities.Vehicle;
import services.BrazilTaxService;
import services.RentalService;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Engine {
    public static void main(String[] args)  {
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

        System.out.print("Enter the price per hour:  ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Enter the price per day:  ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay,new BrazilTaxService());
        rentalService.processInvoice(cr);

        System.out.println("BILL: ");
        System.out.println("Basic Payment:  " + cr.getInvoice().getBasicPayment());
        System.out.println("Tax:  " + cr.getInvoice().getTax());
        System.out.println("Total Payment:  " + cr.getInvoice().getTotalPayment());












        sc.close();

    }
}
