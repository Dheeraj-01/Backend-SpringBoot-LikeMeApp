package com.backend.likeme.payloads;

import com.backend.likeme.entities.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username must be min of 4 characters !!")
    private String name;

    @Email(message = "Email address is not valid !!")
    @NotEmpty(message = "Email is required !!")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be min of 3 chars and max of 10 chars !!")

    @NotEmpty
    private String password;

    @NotEmpty
    private String about;

    private Set<RoleDto> roles = new HashSet<>();

    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password=password;
    }
}
