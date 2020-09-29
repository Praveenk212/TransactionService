package com.cg.ewallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ewallet.dto.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
