package noetic.example.codetest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by DS hewapathirana.
 * Date:24/02/2020
 * Time: 9:45 PM
 */

@Getter
@Setter
@Entity
public class TransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String requestType;
    private String statusCode;
    private String statusMessage;
    private String transactionId;
    private String amount;
    private String senderAccount;
    private String receiverAccount;
    private boolean isOwnFundtransfer;
}
