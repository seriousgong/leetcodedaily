package edu;


import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ChangeCode {

    public static void main(String[] args) {
        String msg  = "\u3010OpenAPI\u3011\u53c2\u6570\u4e0d\u5168\uff0c\u8bf7\u68c0\u67e5\u662f\u5426\u5305\u62ecopenAppID\uff08\u6216devCode\u3001devType\u3001keyId\uff09\u3001timestamp\u3001sign\u3001objectid\u3001objType\u53c2\u6570";
//        String  msg = "\u3010OpenAPI\u3011\u7b7e\u540d\u9519\u8bef\uff0c\u8bf7\u68c0\u67e5sign\u7b7e\u540d\u7b97\u6cd5\u662f\u5426\u6b63\u786e";
        String  newMsg = new String(msg.getBytes(), StandardCharsets.UTF_8);
        System.out.println(newMsg);


    }
}
