package com.dvla.appointment;

import java.time.LocalTime;
import java.util.LinkedList;

import com.dvla.domain.Animal;

public class AppointmentBookerImpl implements AppointmenBooker {
	
	final static LocalTime END_OF_DAY = LocalTime.of(17, 00);
	final static LocalTime START_OF_DAY = LocalTime.of(9, 00);
	private final LinkedList<TimeSlot> diary = new LinkedList<TimeSlot>();
	
	@Override
	public TimeSlot bookAnAppointment(Animal animal) throws IllegalArgumentException {		
		if(isSlotAvailable(animal)) {
			return addAnimalBooking(animal);
		}		
		throw new IllegalArgumentException("No slots available!");
	}
	
	@Override
	public TimeSlot getNextBooking() {		
		return diary.remove();		
	}

	private TimeSlot addAnimalBooking(Animal animal) {
		TimeSlot slot = null;
		if(diary.size() == 0) {
			LocalTime plusMinutes = START_OF_DAY.plusMinutes(animal.getTimeRequired());
			slot = new TimeSlot(animal, START_OF_DAY, plusMinutes);
		} else {			
			LocalTime plusMinutes = diary.getLast().getEnd().plusMinutes(animal.getTimeRequired());
			slot = new TimeSlot(animal, diary.getLast().getEnd(), plusMinutes);	
		}
		
		diary.add(slot);
		return slot;
	}

	private boolean isSlotAvailable(Animal animal) {
		if(diary.size() > 0) {
			TimeSlot last = diary.getLast();		
			LocalTime end = last.getEnd();		
			LocalTime plusMinutes = end.plusMinutes(animal.getTimeRequired());
			
			if(plusMinutes.isAfter(END_OF_DAY)) {
				return false;
			}	
		}
			
		return true;
	}	

}
