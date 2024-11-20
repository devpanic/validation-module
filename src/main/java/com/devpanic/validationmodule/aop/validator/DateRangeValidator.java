package com.devpanic.validationmodule.aop.validator;

import com.devpanic.validationmodule.aop.annotations.CheckDateRange;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.time.LocalDate;

public class DateRangeValidator implements ConstraintValidator<CheckDateRange, Object> {
    private String startDate;
    private String endDate;

    @Override
    public void initialize(CheckDateRange constraintAnnotation) {
        startDate = constraintAnnotation.startDate();
        endDate = constraintAnnotation.endDate();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Class<?> clazz = o.getClass();

            Field startField = clazz.getDeclaredField(startDate);
            Field endField = clazz.getDeclaredField(endDate);

            startField.setAccessible(true);
            endField.setAccessible(true);

            LocalDate startDate = (LocalDate) startField.get(o);
            LocalDate endDate = (LocalDate) endField.get(o);

            if (startDate == null || endDate == null) {
                return true;
            }

            return !endDate.isBefore(startDate);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            return false;
        }
    }
}
