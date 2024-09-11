package com.abc.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.backend.model.Payment;
import com.abc.backend.model.Reservation;
import com.abc.backend.repository.PaymentRepository;
import com.abc.backend.repository.ReservationRepository;
import com.abc.backend.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> allReservations() {
        return reservationRepository.findAll();
    }

    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> singleReservation(ObjectId id) {
        return reservationRepository.findById(id);
    }

    public Optional<Reservation> singleReservationByCusromerId(String customerId) {
        return reservationRepository.findByCustomerId(customerId);
    }

    public Reservation updateReservation(ObjectId id, Reservation reservationDetails) {
        Optional<Reservation> optionalreservation = reservationRepository.findById(id);
        if (optionalreservation.isPresent()) {
            Reservation reservation = optionalreservation.get();
            reservation.setCustomerId(reservationDetails.getCustomerId());
            reservation.setReservationProducts(reservationDetails.getReservationProducts());
            reservation.setReservationType(reservationDetails.getReservationType());
            reservation.setReservationDate(reservationDetails.getReservationDate());
            reservation.setReservationTime(reservationDetails.getReservationTime());
            reservation.setReservationNote(reservationDetails.getReservationNote());
            reservation.setReservationLocation(reservationDetails.getReservationLocation());
            reservation.setReservationPlacedTime(reservationDetails.getReservationPlacedTime());
            reservation.setReservtionTotal(reservationDetails.getReservtionTotal());
            reservation.setReservationStatus(reservationDetails.getReservationStatus());
            return reservationRepository.save(reservation);
        }
        return null;
    }

    public void deleteReservation(ObjectId id) {
            reservationRepository.deleteById(id);
    }

    // --------------------------------------------------------------------------------------

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> allPayments() {
        return paymentRepository.findAll();
    }

    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Optional<Payment> singlePayment(ObjectId id) {
        return paymentRepository.findById(id);
    }

}
