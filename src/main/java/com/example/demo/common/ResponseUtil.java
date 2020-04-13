package com.example.demo.common;

import com.example.demo.model.EmployeeModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Payload;
import java.util.List;

public interface ResponseUtil {

    static <X extends Payload> ResponseEntity<X> wrapSuccessResponseEnvelope(X x) {
        return new ResponseEntity(new SuccessResponseEnvelope<>(x), HttpStatus.OK);
    }

    static ResponseEntity wrapSuccessResponseEnvelope(List<EmployeeModel> allEmployees) {
        return new ResponseEntity(new SuccessResponseListEnvelope<>(allEmployees), HttpStatus.OK);
    }
}
