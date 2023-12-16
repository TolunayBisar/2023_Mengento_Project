package magentoapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author : tolunaybisar
 * @created : 16.12.2023,16:29
 * @Email :tolunay.bisar@gmail.com
 **/
public class Payloads {
    public static String CategoryPayload(){
        String payload = null;
        CategoryPayloadObject categoryPayloadObject = new CategoryPayloadObject(randomText("Team3"),0,0,0,0);
        ObjectMapper objectMapper= new ObjectMapper();
        try {
            payload = objectMapper.writeValueAsString(categoryPayloadObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payload;
    }
    public static String randomText(String a){
        String randomText = RandomStringUtils.randomAlphabetic(5);
        return a+randomText;

    }

    public static String customerGroupPayload(String groupName){
        String payload = null;
        CustomerGroupPayloadObject cgPayload = new CustomerGroupPayloadObject(groupName,0,0);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            payload =objectMapper.writeValueAsString(cgPayload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payload;
    }

    public static String customerPayload(int id,int attributeId,int entityID,String customerName){
        String payload = null;
        CustomerPayloadObject customerPayloadObject =
                new CustomerPayloadObject(id,attributeId,entityID,
                        1,customerName);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            payload =objectMapper.writeValueAsString(customerPayloadObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payload;
    }

    public static String productPayload(String sku){
        String payload = null;
        ProductPayloadObject productPayloadObject = new ProductPayloadObject(4,18,"simple",
                sku,0,0,"2013-03-04 22:48:17","2014-03-08 01:46:16");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            payload =objectMapper.writeValueAsString(productPayloadObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payload;
    }


}
