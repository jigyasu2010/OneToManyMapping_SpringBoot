package com.example.demo.common;
import com.example.demo.common.meta.SuccessMeta;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.Payload;


/**
 * created by Jigyasu on 01/04/20.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponseEnvelope<T extends Payload> {

    private T data;
    private SuccessMeta meta;

    //build success response
    public SuccessResponseEnvelope(T data) {
        this.data = data;
        this.meta = new SuccessMeta(200);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SuccessMeta getMeta() {
        return meta;
    }

    public void setMeta(SuccessMeta meta) {
        this.meta = meta;
    }
}
