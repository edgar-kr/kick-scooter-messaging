package com.softserve.message_sender.service;

import com.softserve.message_sender.domain.UserReceipt;

public interface MailService {

    void sendReceiptMessage(UserReceipt userReceipt);

    //TODO email verification
}
