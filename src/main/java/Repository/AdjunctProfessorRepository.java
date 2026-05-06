package Repository;

import Domain.AdjunctProfessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AdjunctProfessorRepository extends JpaRepository<AdjunctProfessor, Integer> {
    List<AdjunctProfessor> findByContractEndDateBefore(LocalDate date);
}