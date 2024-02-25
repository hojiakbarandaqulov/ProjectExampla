package com.company;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Card {
    private String cardNumber;
    private Long balance;
    private String accessToken;
    private String id;


}
