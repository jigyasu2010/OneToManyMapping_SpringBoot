package com.example.demo.common;

import com.example.demo.common.meta.SuccessMeta;
import com.example.demo.entity.Employee;
import com.example.demo.model.EmployeeModel;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.Payload;
import java.util.List;


/**
 * created by Jigyasu on 01/04/20.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponseListEnvelope<T extends Payload> {

    private List<EmployeeModel> data;
    private SuccessMeta meta;


    public SuccessResponseListEnvelope(List<EmployeeModel> data) {
        this.data = data;
        this.meta = new SuccessMeta(200);
    }

    public List<EmployeeModel> getData() {
        return data;
    }

    public void setData(List<EmployeeModel> data) {
        this.data = data;
    }

    public SuccessMeta getMeta() {
        return meta;
    }

    public void setMeta(SuccessMeta meta) {
        this.meta = meta;
    }


}
