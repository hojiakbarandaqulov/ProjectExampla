package org.example.dto;


import lombok.Getter;
import lombok.Setter;
import org.example.enums.ProfileStep;

@Getter
@Setter
public class Profile {
    private Long id;
    private String name;  // hw
    private String surname; // hw
    private Integer year;
    private String username;
    private ProfileStep step;
    private String phone;

    public Profile(Long id) {
        this.id = id;
    }


    public String writableString() {
        return id + "#" + name + "#" + surname + "#" + username + "#" + step + "#" + phone;
    }
}
