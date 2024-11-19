package com.pitang.desafio.repository;

import com.pitang.desafio.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICarroRepository extends JpaRepository<Carro, Long> {

    Optional<Carro> findByLicensePlate(String licensePlate);

}
