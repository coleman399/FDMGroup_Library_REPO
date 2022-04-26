package com.fdmgroup;

import java.util.Date;

public class Account {
    private int accountNumber;
    private Date openedDate;
    
    public Account(int accountNumber, Date openedDate) {
        this.accountNumber = accountNumber;
        this.openedDate = openedDate;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(Date openedDate) {
        this.openedDate = openedDate;
    }

    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", openedDate=" + openedDate + "]";
    }


    
}
