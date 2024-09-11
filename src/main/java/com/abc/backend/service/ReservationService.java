package com.abc.backend.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import com.abc.backend.model.Payment;
import com.abc.backend.model.Reservation;

public interface ReservationService {

    public List<Reservation> allReservations();
    public Reservation addReservation(Reservation reservation);

    public Optional<Reservation> singleReservation(ObjectId id);
    public Optional<Reservation> singleReservationByCusromerId(String customerId);
    public Reservation updateReservation(ObjectId id, Reservation reservationDetails);

    public void deleteReservation(ObjectId id);

    public List<Payment> allPayments();

    public Payment addPayment(Payment payment);

    public Optional<Payment> singlePayment(ObjectId id);

}
