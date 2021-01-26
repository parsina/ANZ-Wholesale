package com.anz.sample.wholesale.repository;

import com.anz.sample.wholesale.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
