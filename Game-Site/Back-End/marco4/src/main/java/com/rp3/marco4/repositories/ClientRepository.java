package com.rp3.marco4.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rp3.marco4.models.ClientModel;


@Repository
public interface ClientRepository extends JpaRepository<ClientModel, UUID> {

}
