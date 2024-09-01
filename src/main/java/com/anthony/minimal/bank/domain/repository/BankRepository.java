package com.anthony.minimal.bank.domain.repository;

import com.anthony.minimal.bank.domain.Bank;
import com.anthony.minimal.web.repository.DefaultRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BankRepository extends DefaultRepository<Bank> {

    @Override
    @Query("SELECT c FROM Bank c WHERE c.name ILIKE %:search%")
    Page<Bank> search(@Param("search") String search, Pageable pageable);

}
