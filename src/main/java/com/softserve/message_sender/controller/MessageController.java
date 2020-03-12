package com.softserve.message_sender.controller;

import com.softserve.message_sender.domain.UserReceipt;
import com.softserve.message_sender.repository.UserReceiptRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user-receipt")
public class MessageController {

    @Value("${paging.default-page-size}")
    private int pageSize;

    private final UserReceiptRepo userReceiptRepo;

    @GetMapping("/all")
    public Iterable<UserReceipt> getAllReceipts() {
        return userReceiptRepo.findAll();
    }

    @GetMapping("/{mail}/receipts")
    public Iterable<UserReceipt> getAllByMail(@PathVariable String mail) {
        return userReceiptRepo.findAllByMail(mail);
    }

    @GetMapping("/all/receipts")
    public Page<UserReceipt> getUsersPage(@RequestParam(defaultValue = "0") int page) {
        return userReceiptRepo.findAll(PageRequest.of(page, pageSize));
    }

}
