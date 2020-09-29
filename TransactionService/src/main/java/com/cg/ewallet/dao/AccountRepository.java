package com.cg.ewallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ewallet.dto.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
