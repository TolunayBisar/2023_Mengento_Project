package com.seleniummaster.ecommercetest.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author : tolunaybisar
 * @created : 16.12.2023,16:26
 * @Email :tolunay.bisar@gmail.com
 **/
public class CategoryPayloadObject {
/*      {
            "id": 1,
            "entityTypeId": 3, - int
            "attributeId": 41,  - int
            "storeId": 0,      -   int
            "valueId": 1,      - int
            "value": "cbus"     - text
        }, */
    @JsonProperty("value")
    private String value;
    @JsonProperty("valueId")
    private int valueId;
    @JsonProperty("storeId")
    private int storeId;
    @JsonProperty("attributeId")
    private int attributeId;
    @JsonProperty("entityTypeId")
    private int entityTypeId;

    public CategoryPayloadObject(String value, int valueId, int storeId, int
            attributeId, int entityTypeId) {
        this.value = value;
        this.valueId = valueId;
        this.storeId = storeId;
        this.attributeId = attributeId;
        this.entityTypeId = entityTypeId;
    }
}
