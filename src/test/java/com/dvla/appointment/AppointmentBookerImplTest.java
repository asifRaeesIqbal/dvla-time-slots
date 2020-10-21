package com.dvla.appointment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.dvla.domain.Animal;
import com.dvla.domain.Cat;
import com.dvla.domain.Dog;
import com.dvla.domain.Rabbit;

public class AppointmentBookerImplTest {
	
	private AppointmenBooker booker = new AppointmentBookerImpl();
	
	@Test
	public void test_add_dog_appointment_successfully() {
		Animal dog = new Dog("dog", "022222222", 12);		
		
		booker.bookAnAppointment(dog);
		TimeSlot nextBooking = booker.getNextBooking();
				
		assertTrue(nextBooking.getAnimal().equals(dog));
		assertTrue(nextBooking.getStart().equals(AppointmentBookerImpl.START_OF_DAY));

		// test the end time
		LocalTime plusMinutes = AppointmentBookerImpl.START_OF_DAY.plusMinutes(dog.getTimeRequired());

		assertTrue(nextBooking.getEnd().equals(plusMinutes));
		assertEquals(10, nextBooking.getEnd().getHour());
		assertEquals(0, nextBooking.getEnd().getMinute());
	}
	
	@Test
	public void test_add_cat_appointment_successfully() {
		Animal cat = new Cat("cat", "00000000", 15);		
		
		booker.bookAnAppointment(cat);
		TimeSlot nextBooking = booker.getNextBooking();
				
		assertTrue(nextBooking.getAnimal().equals(cat));
		assertTrue(nextBooking.getStart().equals(AppointmentBookerImpl.START_OF_DAY));

		// test the end time
		LocalTime plusMinutes = AppointmentBookerImpl.START_OF_DAY.plusMinutes(cat.getTimeRequired());
		
		assertTrue(nextBooking.getEnd().equals(plusMinutes));
		assertEquals(9, nextBooking.getEnd().getHour());
		assertEquals(45, nextBooking.getEnd().getMinute());
	}
	
	
	@Test
	public void test_add_rabbit_appointment_successfully() {
		Animal rabbit = new Rabbit("rabbit", "11111111", 10);		
		
		booker.bookAnAppointment(rabbit);
		TimeSlot nextBooking = booker.getNextBooking();
				
		assertTrue(nextBooking.getAnimal().equals(rabbit));
		assertTrue(nextBooking.getStart().equals(AppointmentBookerImpl.START_OF_DAY));

		// test the end time
		LocalTime plusMinutes = AppointmentBookerImpl.START_OF_DAY.plusMinutes(rabbit.getTimeRequired());
		
		assertTrue(nextBooking.getEnd().equals(plusMinutes));
		assertEquals(9, nextBooking.getEnd().getHour());
		assertEquals(30, nextBooking.getEnd().getMinute());
	}	
	
	
	@Test
	public void test_add_multiple_appointments_successfully() {
		Animal rabbit = new Rabbit("rabbit", "11111111", 10);		
		Animal cat = new Cat("cat", "00000000", 15);
		Animal dog = new Dog("dog", "022222222", 12);		
		
		
		booker.bookAnAppointment(rabbit);
		booker.bookAnAppointment(cat);
		booker.bookAnAppointment(dog);
		
		TimeSlot nextBooking = booker.getNextBooking();				
		assertTrue(nextBooking.getAnimal().equals(rabbit));
		
		nextBooking = booker.getNextBooking();				
		assertTrue(nextBooking.getAnimal().equals(cat));
		
		nextBooking = booker.getNextBooking();				
		assertTrue(nextBooking.getAnimal().equals(dog));
	}
	
	@Test
	public void test_add_multiple_dog_appointments_from_9_to_5_successfully() {
		Animal dog = new Dog("dog", "022222222", 12);		
		
		// 9-5 = 8 hours
		for(int i=0; i<8; i++) {
			booker.bookAnAppointment(dog);
		}
		
		for(int i=0; i<8; i++) {
			TimeSlot nextBooking = booker.getNextBooking();				
			assertTrue(nextBooking.getAnimal().equals(dog));
		}		
	}
	
	@Test
	public void test_unable_to_add_appointment_after_diary_full_throw_error() {
		Animal dog = new Dog("dog", "022222222", 12);		
		
	    Exception exception = assertThrows(RuntimeException.class, () -> {
			// 9-5 = 8 hours
			for(int i=0; i<=8; i++) {
				booker.bookAnAppointment(dog);
			}
	    });

	    String expectedMessage = "No slots available!";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
}
