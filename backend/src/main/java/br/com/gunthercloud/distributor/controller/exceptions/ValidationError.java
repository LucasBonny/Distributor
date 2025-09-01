package br.com.gunthercloud.distributor.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> field = new ArrayList<>();

    public List<FieldMessage> getField() {
        return field;
    }

    public void addError(String fieldName, String message) {
        field.add(new FieldMessage(fieldName,message));
    }
}
