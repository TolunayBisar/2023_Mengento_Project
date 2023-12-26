package com.seleniummaster.ecommercetest.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author : tolunaybisar
 * @created : 16.12.2023,16:28
 * @Email :tolunay.bisar@gmail.com
 **/
public class ProductPayloadObject {
    /*  {
   "id": 352,
        "entityTypeId": 4,
        "attributeSetId": 18,
        "typeId": "simple",
        "sku": "aws012",
        "hasOptions": 0,
        "requiredOptions": 0,
        "createdAt": "2013-03-04 22:48:17",
        "updatedAt": "2014-03-08 01:46:16"
}*/
@JsonProperty("entityTypeId")
    private int entityTypeId;
    @JsonProperty("attributeSetId")
    private int attributeSetId;
    @JsonProperty("typeId")
    private  String typeId;
    @JsonProperty("sku")
    private  String sku;
    @JsonProperty("hasOptions")
    private int hasOptions;
    @JsonProperty("requiredOptions")
    private  int requiredOptions;
    @JsonProperty("createdAt")
    private  String createdAt;
    @JsonProperty("updatedAt")
    private  String updatedAt;

    public ProductPayloadObject(int entityTypeId, int attributeSetId, String typeId,
                                String sku, int hasOptions, int requiredOptions,
                                String createdAt, String updatedAt) {
        this.entityTypeId = entityTypeId;
        this.attributeSetId = attributeSetId;
        this.typeId = typeId;
        this.sku = sku;
        this.hasOptions = hasOptions;
        this.requiredOptions = requiredOptions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
