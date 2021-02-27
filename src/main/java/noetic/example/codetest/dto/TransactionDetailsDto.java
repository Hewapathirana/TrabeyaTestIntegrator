package noetic.example.codetest.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * Created by DS hewapathirana.
 * Date: 23/02/2021
 * Time: 2050h
 */
@Getter
@Setter
public class TransactionDetailsDto {
    private Long id;
    private String requestType;
    private String statusCode;
    private String statusMessage;
    @NotBlank(message = "amount is required")
    private String transactionId;
    private String amount;
}
