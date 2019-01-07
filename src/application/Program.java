package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		Scanner  sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy):");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			Date checkOut = sdf.parse(sc.next());
			
			
		
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: "+reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy):");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			checkOut = sdf.parse(sc.next());
			
			
			reservation.updateDates(checkIn, checkOut);//chamando o metodo da classe Reservation
			System.out.println("Reservation: "+reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
			e.printStackTrace();
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: "+ e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid information");
		}
		catch (Exception e) {
			System.out.println("Unexpect error");
		}
		sc.close();
		
		
	}

}
