package noetic.example.codetest.serviceImpl;
import noetic.example.codetest.dto.TransactionDto;
import noetic.example.codetest.exceptions.BankException;
import noetic.example.codetest.model.TransactionDetails;
import noetic.example.codetest.repository.TransactionDetailsRepo;
import noetic.example.codetest.serviceInterfaces.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
/**
 * Created by DS hewapathirana.
 * Date:24/02/2020
 * Time: 9:45 PM
 */
@Service
public class BankServiceImple implements BankService {
    @Autowired
    private TransactionDetailsRepo transactionDetailsRepo;

    private static final String BASE_URL = "";

    @Override
    public String findBalanceByAccountId(String accountId) {
        RestTemplate restTemplate = new RestTemplate();
        TransactionDetails transactionDetails = new TransactionDetails();

        String baseUrl
                = "http://localhost:8089/bank/accountBalance";
        ResponseEntity<String> response
                = restTemplate.getForEntity(baseUrl + "/" +accountId, String.class);

        String[] codeNmessage = response.getStatusCode().toString().split(" ");

        transactionDetails.setRequestType("getAccountBalance");
        transactionDetails.setStatusCode(codeNmessage[0]);
        transactionDetails.setStatusMessage(codeNmessage[1]);
        transactionDetails.setAmount(response.getBody());
        transactionDetails.setSenderAccount(accountId);
        transactionDetailsRepo.save(transactionDetails);

        return response.getBody();
    }

    @Override
    public String findAllAccountBalance() throws BankException {
        RestTemplate restTemplate = new RestTemplate();
        TransactionDetails transactionDetails = new TransactionDetails();

        String baseUrl
                = "http://localhost:8089/bank/allAccountBalance";
        ResponseEntity<String> response
                = restTemplate.getForEntity(baseUrl , String.class);

        String[] codeNmessage = response.getStatusCode().toString().split(" ");
        transactionDetails.setRequestType("allAccountBalance");
        transactionDetails.setStatusCode(codeNmessage[0]);
        transactionDetails.setStatusMessage(codeNmessage[1]);
        transactionDetails.setAmount(response.getBody());
        transactionDetailsRepo.save(transactionDetails);

        return response.getBody();
    }

    @Override
    public String fundTransfer(TransactionDto transactionDto) throws BankException {

        RestTemplate restTemplate = new RestTemplate();
        TransactionDetails transactionDetails = new TransactionDetails();

        String baseUrl
                = "http://localhost:8089/bank/transaction";
        ResponseEntity<String> response
                = restTemplate.postForEntity(baseUrl, transactionDto, String.class);

        if(transactionDto.getIsOwnAccount()){
            transactionDetails.setRequestType("OwnFundTransfer");
        }
        else {
            transactionDetails.setRequestType("FundTransferOtherAccounts");
        }
        transactionDetails.setStatusCode(response.getStatusCode().toString());
        transactionDetails.setAmount(transactionDto.getAmount());
        transactionDetails.setStatusMessage(response.getBody());
        transactionDetails.setSenderAccount(transactionDto.getSenderAccount());
        transactionDetails.setReceiverAccount(transactionDto.getReceiverAccount());
        transactionDetails.setOwnFundtransfer(transactionDto.getIsOwnAccount());
        transactionDetails.setTransactionId(String.valueOf(ZonedDateTime.now().toInstant().toEpochMilli()));
        transactionDetailsRepo.save(transactionDetails);

        return response.getBody();

    }


}
