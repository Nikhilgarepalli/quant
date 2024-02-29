package com.example.demo.controller;

import com.example.demo.entity.Finance;
import com.example.demo.entity.FinanceDto;
import com.example.demo.service.DBConnection;
import com.example.demo.service.FinancialDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api")
class FinancialDataController1 {


    FinancialDataService financialDataService;
    private String ticker;
    private Connection connection;


    public FinancialDataController1(FinancialDataService financialDataService) {
        this.financialDataService = financialDataService;
        this.connection = DBConnection.getConnection();
    }

    @GetMapping("/")
    public List<FinanceDto> getAllFinancial(@RequestParam(name = "ticker") String ticker,
                                            @RequestParam(name = "columns") String columns,
                                            @RequestParam(name = "period") String period) throws SQLException {
        return financialDataService.getAllFinancial(connection, ticker, columns, period);
    }

}


