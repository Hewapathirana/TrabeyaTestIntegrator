package noetic.example.codetest.serviceInterfaces;

import noetic.example.codetest.dto.TransactionDto;
import noetic.example.codetest.exceptions.BankException;

/**
 * Created by DS hewapathirana.
 * Date: 23/02/2021
 * Time: 2055h
 */
public interface BankService {
    String findBalanceByAccountId(String accountId) ;
    String findAllAccountBalance() throws BankException;
    String fundTransfer(TransactionDto transactionDto) throws BankException;
}
