package com.example.patterns_banking.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
public class CheckingAccount extends Account{
  private static final Double MANAGEMENT_FEE = 10.0; // Monthly management fee
  private static final Double TRANSFER_FEE_RATE = 0.023; // 2.3% of the amount
  private static final Double DEPOSIT_FEE_RATE = 0.01; // 1% of the amount
  private static final Double WITHDRAWAL_FEE_RATE = 0.002; // 0.2% of the amount

  @Override
  public Double calculateDepositFee(Double amount) {
    return amount * DEPOSIT_FEE_RATE;
  }

  @Override
  public Double calculateWithdrawalFee(Double amount) {
    return amount * WITHDRAWAL_FEE_RATE;
  }
}
