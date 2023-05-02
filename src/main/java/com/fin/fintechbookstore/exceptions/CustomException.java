package com.fin.fintechbookstore.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String message;

}