package com.devpanic.validationmodule.record;

import com.devpanic.validationmodule.aop.annotations.CheckDateRange;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@CheckDateRange(startDate = "startDate", endDate = "endDate")
public record TestRecord(
        @DateTimeFormat(iso = ISO.DATE)
        LocalDate startDate,

        @DateTimeFormat(iso = ISO.DATE)
        LocalDate endDate) {
}
