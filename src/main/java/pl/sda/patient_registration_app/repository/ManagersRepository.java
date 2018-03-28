package pl.sda.patient_registration_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.patient_registration_app.entity.Manager;

@Repository
public interface ManagersRepository extends JpaRepository<Manager, Long>{
    Manager findByEmail(String email);
}
