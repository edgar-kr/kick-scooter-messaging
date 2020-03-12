package com.softserve.message_sender.repository;

import com.softserve.message_sender.domain.UserReceipt;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserReceiptRepo extends PagingAndSortingRepository<UserReceipt, Long> {
    Iterable<UserReceipt> findAllByMail(String mail);

    //todo add sortByDate
}
