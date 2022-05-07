package com.example.autenticatask;

import org.springframework.data.jpa.repository.JpaRepository;

//Pārbaudīt ko likt iekš <> iekavām
public interface RequestRepository extends JpaRepository<HardwareRequest, Integer> {

     //HardwareRequest findHardwareRequestById(Integer id);
}
