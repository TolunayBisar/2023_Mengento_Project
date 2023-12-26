package com.seleniummaster.ecommercetest.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author : tolunaybisar
 * @created : 16.12.2023,16:27
 * @Email :tolunay.bisar@gmail.com
 **/
public class CustomerGroupPayloadObject {
    /*{
[
  {
    "customerGroupCode": "string",
    "id": 0,
    "taxClassId": 0
  }
]
}*/
    @JsonProperty("customerGroupCode")
    private  String customerGroupCode;
    @JsonProperty("taxClassId")
    private  int taxClassId;

    @JsonProperty("id")
    private  int id;

    public CustomerGroupPayloadObject(String customerGroupCode, int taxClassId, int id) {
        this.customerGroupCode = customerGroupCode;
        this.taxClassId = taxClassId;
        this.id = id;
    }


}
