package noetic.example.codetest.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by DS hewapathirana.
 * Date:24/02/2020
 * Time: 9:45 PM
 */
@Getter
@Setter
public class ValidationError {
    private String path;
    private String message;
}
