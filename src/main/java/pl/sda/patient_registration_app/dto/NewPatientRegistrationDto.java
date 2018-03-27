package pl.sda.patient_registration_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.patient_registration_app.annotations.PasswordMatches;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@PasswordMatches
public class NewPatientRegistrationDto {

    @NotNull
    @Size(min=1)
    private String firstName;

    @NotNull
    @Size(min=1)
    private String lastName;

    @NotNull
    @Size(min=1)
    private String login;

    @NotNull
    @Size(min=7)
    private String password;

    @NotNull
    @Size(min=7)
    private String matchingPassword;

    @NotNull
    @Size(min=1)
    private String email;
}
