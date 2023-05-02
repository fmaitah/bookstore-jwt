package com.fin.fintechbookstore.model.responses;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class ErrorResponse {

    public ErrorResponse(String message) {
        super();
        this.message = message;
    }

    private String message;

    private List<String> errors = new ArrayList<String>();


}
