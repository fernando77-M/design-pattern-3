package com.example.patterns_banking.models.decorator;

import com.example.patterns_banking.models.Account;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class LimitedAccountWhithdrawDecorator extends AccountDecorator{
    private final Double LIMIT = 20000.0;
    private final Double TOTAL= getBalance() + LIMIT;

    public LimitedAccountWhithdrawDecorator(Account account) {
        super(account);
    }

    @Override
    public void withdraw(Double amount) {

        if (amount > (TOTAL)) {
            System.out.println("Su retiro: " + (amount - TOTAL) + " excedio el monto maximo de: " + TOTAL);
            setBalance(0.0);
        }

        if (amount < TOTAL) {
            System.out.println("Se hizo el retiro de: " + amount + " se excedio en: " + (amount - getBalance()));
            setBalance(TOTAL - amount);
        }

        System.out.println("Se hizo el retiro de: " + amount + " y quedo en la cuenta: "
                + (getBalance() - amount));
        setBalance(getBalance() - amount);
    }
}
