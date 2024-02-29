package com.example.demo.repository;

import com.example.demo.entity.Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface FinancialDataRepository extends JpaRepository<Finance, Long> {

         @Query("Select f  from Finance f where f.ticker = :ticker")
         List<Finance> findAllByTicker(@Param("ticker") String string);

}
