package magentoapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author : tolunaybisar
 * @created : 16.12.2023,16:28
 * @Email :tolunay.bisar@gmail.com
 **/
public class CustomerPayloadObject {
    /*    {
            "id": 4098,
            "entity_type_id": 1,
            "attribute_id": 6,
            "entity_id": 320,
            "value": "hhh"
        },,*/
    @JsonProperty("id")
    private int id;
    @JsonProperty("attribute_id")
    private int attributeId;
    @JsonProperty("entity_id")
    private int entityId;
    @JsonProperty("entity_type_id")
    private  int entityTypeId;

    @JsonProperty("value")
    private String value;

    public CustomerPayloadObject(int id,int attributeId, int entityId,
                                 int entityTypeId, String value) {
        this.id = id;
        this.attributeId = attributeId;
        this.entityId = entityId;
        this.entityTypeId = entityTypeId;
        this.value = value;
    }
}
