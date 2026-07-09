package org.shop;

import java.util.Date;

public class CardPayment {
    private String cardNumber;
    private String cvv;
    private Date expirationDate;
    private String bankCompany;

    public boolean isExpired() {
        if (expirationDate == null) {
            return true;
        }
        return expirationDate.before(new Date());
    }
}
