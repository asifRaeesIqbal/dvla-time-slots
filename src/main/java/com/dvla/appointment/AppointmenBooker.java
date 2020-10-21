package com.dvla.appointment;

import com.dvla.domain.Animal;

/**
 * 
 * An appointment booker that uses the {@link TimeSlot} to add bookings into a diary for the day.
 * 
 * @author Asif
 *
 */
public interface AppointmenBooker {

	/**
	 * 
	 * Books an animal for the day and throws {@link IllegalArgumentException} if no slots available.
	 * 
	 * @param animal
	 * @return
	 * @throws IllegalArgumentException
	 */
	TimeSlot bookAnAppointment(Animal animal) throws IllegalArgumentException;

	/**
	 * 
	 * gets the next booking an also removes it from the diary.
	 * 
	 * @return
	 */
	TimeSlot getNextBooking();

}