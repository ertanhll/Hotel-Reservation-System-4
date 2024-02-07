
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Single singleRoom = new Single();
		Double doubleRoom = new Double();
		Club clubRoom = new Club();
		Family familyRoom = new Family();
		FamilyView familyViewRoom = new FamilyView();
		Suite suiteRoom = new Suite();

		Room[] rooms = new Room[] { singleRoom, doubleRoom, clubRoom, familyRoom, familyViewRoom, suiteRoom };

		String[] hotelName = new String[20];
		Reservation[] reservations = new Reservation[20];

		int reservationCount = 0;
		int option;

		while (true) {
			int order = 0;
			for (MenuOptions select : MenuOptions.values()) {
				System.out.println((++order) + ". " + select.getSelection());
			}

			option = input.nextInt();
			input.nextLine();
			int selectedIndex = option - 1;
			if (selectedIndex < 0 || selectedIndex >= MenuOptions.values().length) {
				System.out.println("Invalid input");
				System.out.println("\n");
				continue;
			}
			System.out.println("\n");

			MenuOptions menuOptions = MenuOptions.values()[selectedIndex];

			switch (menuOptions) {
			case A:
				System.out.print("Hotel Name: ");
				hotelName[reservationCount] = input.nextLine();
				reservationCount++;

				String reservationMonth = null;
				boolean isValidMonth = false;

				while (!isValidMonth) {
					System.out.print("Reservation Month: ");
					reservationMonth = input.nextLine();

					for (Month month : Month.values()) {
						if (month.getSelection().equals(reservationMonth)) {
							isValidMonth = true;
							break;
						}
					}
					if (!isValidMonth) {
						System.out.println("Invalid input");
					}
				}
				int reservationStart = 0;
				while (reservationStart <= 0 || reservationStart > 30) {
					System.out.print("Reservation Start (1-30): ");
					reservationStart = input.nextInt();
					if (reservationStart <= 0 || reservationStart > 30) {
						System.out.println("Invalid start day. Please enter a day between 1-30.");
					}
				}
				int reservationEnd = 0;
				while (reservationEnd <= 0 || reservationEnd > 30 || reservationEnd < reservationStart) {
					System.out.print("Reservation End (" + reservationStart + "-30): ");
					reservationEnd = input.nextInt();
					if (reservationEnd <= 0 || reservationEnd > 30) {
						System.out.println("Invalid end day. Please enter a day between " + reservationStart + "-30.");
					} else if (reservationEnd < reservationStart) {
						System.out.println("Invalid end day. End day must be greater than or equal to the start day.");
					}
				}
				reservations[Reservation.getTotalNumOfReservations()] = new Reservation(singleRoom, reservationMonth,
						reservationStart, reservationEnd);

				System.out.println("\n\nReservation created! \n\n");
				break;

			case B:
				System.out.println("ROOM INFOS:\n\n");
				for (Room room : rooms) {
					System.out.println(room.toString());
				}
				System.out.println("\n");
				System.out.print("Hotel Name: ");

				hotelName[reservationCount] = input.nextLine();
				reservationCount++;

				boolean validRoomType = false;
				String roomTypeOption = null;
				String[] roomTypes = { "Single", "Double", "Club", "Family", "Family with View", "Suite" };

				while (!validRoomType) {
					System.out.print("Room Type: ");
					roomTypeOption = input.nextLine();

					for (String roomType : roomTypes) {
						if (roomTypeOption.equalsIgnoreCase(roomType)) {
							validRoomType = true;
							break;
						}
					}
					if (!validRoomType) {
						System.out.println("Invalid Input");
					}
				}
				isValidMonth = false;
				reservationMonth = null;

				while (!isValidMonth) {
					System.out.print("Reservation Month: ");
					reservationMonth = input.nextLine();

					for (Month month : Month.values()) {
						if (month.getSelection().equals(reservationMonth)) {
							isValidMonth = true;
							break;
						}
					}
					if (!isValidMonth) {
						System.out.println("Invalid input");
					}
				}
				reservationStart = 0;
				while (reservationStart <= 0 || reservationStart > 30) {
					System.out.print("Reservation Start (1-30): ");
					reservationStart = input.nextInt();
					if (reservationStart <= 0 || reservationStart > 30) {
						System.out.println("Invalid start day. Please enter a day between 1-30.");
					}
				}
				reservationEnd = 0;
				while (reservationEnd <= 0 || reservationEnd > 30 || reservationEnd < reservationStart) {
					System.out.print("Reservation End (" + reservationStart + "-30): ");
					reservationEnd = input.nextInt();
					if (reservationEnd <= 0 || reservationEnd > 30) {
						System.out.println("Invalid end day. Please enter a day between " + reservationStart + "-30.");
					} else if (reservationEnd < reservationStart) {
						System.out.println("Invalid end day. End day must be greater than or equal to the start day.");
					}
				}
				if (roomTypeOption.equalsIgnoreCase("Single"))
					reservations[Reservation.getTotalNumOfReservations()] = new Reservation(singleRoom,
							reservationMonth, reservationStart, reservationEnd);

				else if (roomTypeOption.equalsIgnoreCase("Double"))
					reservations[Reservation.getTotalNumOfReservations()] = new Reservation(doubleRoom,
							reservationMonth, reservationStart, reservationEnd);

				else if (roomTypeOption.equalsIgnoreCase("Club"))
					reservations[Reservation.getTotalNumOfReservations()] = new Reservation(clubRoom, reservationMonth,
							reservationStart, reservationEnd);

				else if (roomTypeOption.equalsIgnoreCase("Family"))
					reservations[Reservation.getTotalNumOfReservations()] = new Reservation(familyRoom,
							reservationMonth, reservationStart, reservationEnd);

				else if (roomTypeOption.equalsIgnoreCase("Family With View"))
					reservations[Reservation.getTotalNumOfReservations()] = new Reservation(familyViewRoom,
							reservationMonth, reservationStart, reservationEnd);

				else if (roomTypeOption.equalsIgnoreCase("Suite"))
					reservations[Reservation.getTotalNumOfReservations()] = new Reservation(suiteRoom, reservationMonth,
							reservationStart, reservationEnd);

				System.out.println("\nReservation created!\n");
				break;

			case C:
				for (int i = 0; i < Reservation.getTotalNumOfReservations(); i++) {
					System.out.println("Reservation for a " + reservations[i].getRoom().getType() + " room in "
							+ hotelName[i] + " starts on " + reservations[i].getReservationMonth() + " "
							+ reservations[i].getReservationStart() + " and ends on "
							+ reservations[i].getReservationMonth() + " " + reservations[i].getReservationEnd() + ".");
					System.out.println("Reservation has a total cost of $" + reservations[i].calculateTotalPrice());
					System.out.println("\n");
				}
				break;

			case D:
				System.out.println(Reservation.getTotalNumOfReservations()
						+ (Reservation.getTotalNumOfReservations() < 2 ? " reservation " : " reservations ")
						+ "created so far.");

				System.out.println("\n");
				break;

			case E:
				System.out.println("Goodbye");
				input.close();
				return;

			default:
				System.out.println("Invalid input");
				System.out.println("\n");
				break;
			}
		}
	}
}
