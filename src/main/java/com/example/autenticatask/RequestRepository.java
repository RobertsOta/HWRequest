package com.example.autenticatask;

import org.springframework.data.jpa.repository.JpaRepository;

//Izveido RequestRepository interface, kas iekļauj sevī JpaRepository funkcionalitāti.
//JpaRepository sevī ietver standarta metodes ar kurām veikt darbības ar datubāzēm.
public interface RequestRepository extends JpaRepository<HardwareRequest, Integer> {
}
