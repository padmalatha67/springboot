package com.zemoso.springboot.springbootassignment.service.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProcedureCodeConstraintValidator implements ConstraintValidator<ProcedureCode,String> {

    private String procedureCodePrefix;

    @Override
    public void initialize(ProcedureCode theProcedureCode) {
        procedureCodePrefix = theProcedureCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;

        if (theCode != null) {
            result = theCode.startsWith(procedureCodePrefix);
        }
        else {
            result = true;
        }

        return result;
    }


}
