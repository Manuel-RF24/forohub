package dto;

import javax.validation.constraints.NotEmpty;

public class UsernamePasswordDTO {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    // Getters y setters
}
