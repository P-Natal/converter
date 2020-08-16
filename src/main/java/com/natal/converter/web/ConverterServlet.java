package com.natal.converter.web;

import com.natal.converter.ejb.ConverterLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ConverterServlet", urlPatterns = {"/ConverterServlet"})
public class ConverterServlet extends HttpServlet {

    @EJB
    private ConverterLocal converter;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("teste");
        
        try{
            
            String amount = request.getParameter("value");
            out.println("Valor em dólar: " + amount);
                   
            if (amount != null && amount.length()> 0) {
                BigDecimal d = new BigDecimal(amount);
                BigDecimal yenAmount = converter.dollarToYen(d);
                BigDecimal euroAmount = converter.yenToEuro(yenAmount);
                
                out.println("<h2>Valor em Yen: " + yenAmount + "<h2>");
                out.println("<h2>Valor em Euro: " + euroAmount + "<h2>");
            }
        }catch(Exception e){
            out.println("Erro: " + e.getLocalizedMessage());
        }
        
        
    }

}
