package Repository;

import Domain.GraduateStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GraduateStudentRepository extends JpaRepository<GraduateStudent, Integer> {
    List<GraduateStudent> findBySupervisorId(int professorId);
    List<GraduateStudent> findByThesisTitleContaining(String keyword);
}