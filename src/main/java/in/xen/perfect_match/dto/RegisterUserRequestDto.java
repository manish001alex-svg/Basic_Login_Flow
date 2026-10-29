package in.xen.perfect_match.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequestDto {
    @NotNull(message = "Name is required.")
    @Size(min = 2, max = 50, message = "name must be between 2 - 50 character long.")
    private String name;

    @NotNull(message = "Email is required.")
    @Email(message = "Please provide a valid email.")
    @Size(max = 150, message = "Email must not exceed above 150 characters.")
    private String email;

    @NotNull(message = "Password is required.")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).+$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character"
    )
    private String password;

}
