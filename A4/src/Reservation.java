
public class Reservation {
	private int reservationID;
	private Room room;
	private String hotelName;
	private String reservationMonth;
	private int reservationStart;
	private int reservationEnd;
	private int dailyCost;
	private static int totalNumOfReservations = 0;

	public Reservation(Room room, String reservationMonth, int reservationStart, int reservationEnd) {

		this.room = room;
		this.reservationMonth = reservationMonth;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.dailyCost = calculateDailyCost();
		totalNumOfReservations++;
		this.reservationID = totalNumOfReservations;

	}

	public static int getTotalNumOfReservations() {
		return totalNumOfReservations;
	}

	public static void setTotalNumOfReservations(int totalNumOfReservations) {
		Reservation.totalNumOfReservations = totalNumOfReservations;
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getReservationMonth() {
		return reservationMonth;
	}

	public void setReservationMonth(String reservationMonth) {
		this.reservationMonth = reservationMonth;
	}

	public int getReservationStart() {
		return reservationStart;
	}

	public void setReservationStart(int reservationStart) {
		this.reservationStart = reservationStart;
	}

	public int getReservationEnd() {
		return reservationEnd;
	}

	public void setReservationEnd(int reservationEnd) {
		this.reservationEnd = reservationEnd;
	}

	public int getDailyCost() {
		return dailyCost;
	}

	public void setDailyCost(int dailyCost) {
		this.dailyCost = dailyCost;
	}

	private int calculateDailyCost() {
		int multiplier = 1;
		if (reservationMonth.equals("June") || reservationMonth.equals("July") || reservationMonth.equals("August")) {
			multiplier = 2;
		}
		return room.getCost() * multiplier;
	}

	public int calculateTotalPrice() {
		return calculateDailyCost() * (reservationEnd - reservationStart);
	}

}
