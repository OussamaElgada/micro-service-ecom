package org.example.bullingservice.repository;

import org.example.bullingservice.entites.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
