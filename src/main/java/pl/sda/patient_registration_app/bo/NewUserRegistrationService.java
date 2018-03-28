package pl.sda.patient_registration_app.bo;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.patient_registration_app.annotations.EmailExistsException;
import pl.sda.patient_registration_app.dto.NewUserRegistrationDto;
import pl.sda.patient_registration_app.entity.Admin;
import pl.sda.patient_registration_app.entity.Manager;
import pl.sda.patient_registration_app.entity.Patient;
import pl.sda.patient_registration_app.entity.User;
import pl.sda.patient_registration_app.repository.AdminsRepository;
import pl.sda.patient_registration_app.repository.ManagersRepository;
import pl.sda.patient_registration_app.repository.PatientsRepository;
import pl.sda.patient_registration_app.repository.UserRepository;
import pl.sda.patient_registration_app.type.RoleType;

@Service
public class NewUserRegistrationService {

    private final UtilsService utilsService;
    private final PatientsRepository patientsRepository;
    private ManagersRepository managersRepository;
    private AdminsRepository adminsRepository;
    private UserRepository userRepository;

    public NewUserRegistrationService(UtilsService utilsService, PatientsRepository patientsRepository, ManagersRepository managersRepository, AdminsRepository adminsRepository) {
        this.utilsService = utilsService;
        this.patientsRepository = patientsRepository;
        this.managersRepository = managersRepository;
        this.adminsRepository = adminsRepository;
    }


    @Transactional
    public Patient saveNewPatientToDB(NewUserRegistrationDto newUserRegistrationDto) throws EmailExistsException {

        if (patientEmailExist(newUserRegistrationDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            + newUserRegistrationDto.getEmail());
        }

        Patient patient = utilsService.mapNewUserRegistrationDtoToPatient(newUserRegistrationDto);

        patient.setRole(RoleType.PATIENT);
        return patientsRepository.save(patient);

    }


    private boolean patientEmailExist(String email) {

        Patient patient = patientsRepository.findByEmail(email);
        if (patient != null) {
            return true;
        }
        return false;
    }

    private boolean managerEmailExist(String email) {

        Manager manager = managersRepository.findByEmail(email);
        if (manager != null) {
            return true;
        }
        return false;
    }
    private boolean adminEmailExist(String email) {

        Admin admin = adminsRepository.findByEmail(email);
        if (admin != null) {
            return true;
        }
        return false;
    }

    @Transactional
    public Manager saveNewManagerToDB(NewUserRegistrationDto newUserRegistrationDto) throws EmailExistsException {


        if (managerEmailExist(newUserRegistrationDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            + newUserRegistrationDto.getEmail());
        }

        Manager manager = utilsService.mapNewUserRegistrationDtoToManager(newUserRegistrationDto);

        manager.setRole(RoleType.MANAGER);


        return managersRepository.save(manager);
    }

    @Transactional
    public Admin saveNewAdminToDB(NewUserRegistrationDto newUserRegistrationDto) throws EmailExistsException {

        if (adminEmailExist(newUserRegistrationDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            + newUserRegistrationDto.getEmail());
        }

        Admin admin = utilsService.mapNewUserRegistrationDtoToAdmin(newUserRegistrationDto);

        admin.setRole(RoleType.ADMIN);
        return adminsRepository.save(admin);
    }
}
