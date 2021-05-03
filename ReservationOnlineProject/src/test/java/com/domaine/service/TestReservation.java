package com.domaine.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.domaine.model.Reservation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:WEB-INF/dispatcher-config.xml" })
public class TestReservation {
	
	
	@Autowired
	ReservationService reservationService;
	
	
	@Test
	public void getAllReservationsTest() {
		List<Reservation> list = reservationService.getAllReservations();
		assertNotNull(list);
		//assertEquals("1", list.get(1));
	}

}
