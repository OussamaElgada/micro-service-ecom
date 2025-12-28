package org.example.bullingservice.web;

import org.example.bullingservice.entites.Bill;
import org.example.bullingservice.entites.ProductItem;
import org.example.bullingservice.feign.CustomerRestClient;
import org.example.bullingservice.feign.ProductRestClient;
import org.example.bullingservice.repository.BillRepository;
import org.example.bullingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient  productRestClient;
    @GetMapping("/bills/{id}")
    public Bill getBill(Long id){
        Bill bill  = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        return bill;
    }
}
