package noetic.example.codetest.repository;
import noetic.example.codetest.model.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DS hewapathirana.
 * Date:24/02/2020
 * Time: 9:45 PM
 */

@Repository
public interface TransactionDetailsRepo extends JpaRepository<TransactionDetails,Long> {
}
