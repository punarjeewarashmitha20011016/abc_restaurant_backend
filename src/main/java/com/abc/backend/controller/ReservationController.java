package com.abc.backend.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.backend.model.Payment;
import com.abc.backend.model.Reservation;
import com.abc.backend.service.ReservationService;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin(origins = "*") 
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/allReservations")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return new ResponseEntity<>(reservationService.allReservations(), HttpStatus.OK);
    }

    @PostMapping("/addReservation")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        Reservation newReservation = reservationService.addReservation(reservation);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Reservation>> singleReservation(@PathVariable ObjectId id){
        Optional<Reservation> reservation = reservationService.singleReservation(id);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @GetMapping("/byCustomer/{customerId}")
    public ResponseEntity<Optional<Reservation>> singleReservationByCustomer(@PathVariable String customerId){
        Optional<Reservation> reservation = reservationService.singleReservationByCusromerId(customerId);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable ObjectId id, @RequestBody Reservation reservationDetails) {
        Reservation updatedReservation = reservationService.updateReservation(id, reservationDetails);
        if (updatedReservation != null) {
            return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable ObjectId id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // -------------------------------------------------------------------------------------------

    @GetMapping("/allPayments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        return new ResponseEntity<>(reservationService.allPayments(), HttpStatus.OK);
    }

    @PostMapping("/addPayment")
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
        Payment newPayment = reservationService.addPayment(payment);
        return new ResponseEntity<>(newPayment, HttpStatus.CREATED);
    }

}