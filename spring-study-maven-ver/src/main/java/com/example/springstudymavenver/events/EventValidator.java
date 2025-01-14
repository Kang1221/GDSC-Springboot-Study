package com.example.springstudymavenver.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

@Component
public class EventValidator {

    public void validate(EventDto eventDto, Errors errors){
        if(eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() > 0 ){
            errors.rejectValue("basePrice", "wrongValue", "BasePrice is wrong"); //field 에러, 그냥 reject하면 글로벌 에러
            errors.rejectValue("maxPrice", "wrongValue", "MaxPrice is wrong");

        }

        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();
        if (endEventDateTime.isBefore(eventDto.getBeginEventDateTime()) ||
        endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime())||
        endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime())){
            errors.rejectValue("endEventDateTime","wrongValue", "EndEventDateTime is wrong");
        }

        //TODO : BeginEventDateTime
        //TODO : CloseEnrollmentDateTim

    }
}
