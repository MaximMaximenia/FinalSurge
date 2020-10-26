package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Account {
    String firsName;
    String lastName;
    String email;
    String password;
    String reTypePassword;
    String timeZone;


}
