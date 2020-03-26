package ru.leonchenko.springbilling.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.leonchenko.springbilling.entity.FinancialTransaction;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Controller
//@RestController
@RequestMapping(value = "/test", method = {RequestMethod.POST, RequestMethod.GET})
public class TransactionController {
    @GetMapping("/transactionlist")
    public String readJsonArray(Model model) throws IOException {
        File file = new File("/Users/leokooper/git/spring-billing-system/json/sample.json");
        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();


        List<FinancialTransaction> financialtransactionList = objectMapper.readValue(file, typeFactory.constructCollectionType(List.class, FinancialTransaction.class));
        model.addAttribute("financialtransactionList",financialtransactionList);

        return "transaction-list";
    }

}
