package com.example.demo.service;

import com.example.demo.entity.Finance;
import com.example.demo.entity.FinanceDto;
import com.example.demo.repository.FinancialDataRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FinancialDataService{

    public List<FinanceDto> getAllFinancial(Connection conn, String ticker, String columns, String period) throws SQLException {
        List<FinanceDto> financeList = new ArrayList<>();
        String[] columnArray = columns.split(",");
        LocalDate startDate = LocalDate.now().minusYears(5);
        String startDateString = startDate.toString();
        String query = "SELECT id, " + columns + " FROM FinancialData WHERE ticker = ? AND date > ?";

        //Statement stmt = conn.createStatement();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1,ticker);
        stmt.setString(2, startDateString);
        //ResultSet rs = stmt.executeQuery("SELECT id,ticker,revenue,date,gp from FinancialData where ticker= 'AAPL' ");
        ResultSet rs = stmt.executeQuery();
         while (rs.next())
         {
             FinanceDto finance = new FinanceDto();
             finance.setId(rs.getLong("id"));
             //finance.setTicker(rs.getString("ticker"));
             finance.setRevenue(rs.getDouble("revenue"));
             //finance.setDate(rs.getDate("date"));
             finance.setGp((int) rs.getDouble("gp"));

             financeList.add(finance);
         }
         return financeList;
    }
}



