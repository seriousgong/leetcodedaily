package edu;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;

public class EduSign {
    private static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String result = new BigInteger(1, md.digest()).toString(16);
            String tmp = "";
            if (result.length() < 32){
                int offset = 32 - result.length();
                for (int i = 0; i < offset; i++){
                    tmp += "0";
                }
                result = tmp + result;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据ASCII码进行排序
     * @param paramMap
     * @return
     */

    private static List<String> sortKeyByASCII(Map paramMap){
        List<String> strList= new ArrayList<>();
        Iterator it =paramMap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            if(entry.getValue().toString().indexOf("{")!=-1){
                Map childMap=(Map) entry.getValue();
                Iterator childIt =childMap.entrySet().iterator();
                while(childIt.hasNext()){
                    Map.Entry childEntry = (Map.Entry) childIt.next();
                    String str=entry.getKey().toString()+"["+childEntry.getKey().toString()+"]";
                    strList.add(str);
                }
            }else{
                strList.add(entry.getKey().toString());
            }

        }
        strList.sort(((o1, o2) -> (o1.compareTo(o2))));
        System.out.println(strList);
        return  strList;
    }
    /**
     * 组装MD5所需要的字符串
     * @param strList
     * @param paramMap
     * @return
     */
    private static   String assemblyString(List<String> strList,Map paramMap){
        String aimString="";
        for (String str:strList){
            if(str.indexOf("[")!=-1){
                String key= str.substring(0,str.indexOf("["));
                String childKey=str.substring(str.indexOf("[")+1,str.indexOf("]"));
                Map childMap=(Map)paramMap.get(key);
                aimString+=str+"="+childMap.get(childKey).toString()+"&";
            }else{
                aimString+=str+"="+paramMap.get(str).toString()+"&";
            }
        }
//       aimString=aimString+KEY;
//       System.out.println(aimString);

        return aimString;
    }
    public static String getCompleteUrl(Map paramMap,String url){
        String paramString=assemblyString(sortKeyByASCII(paramMap),paramMap);
        String aimString=paramString+paramMap.get("key");
        String sign1=getMD5(aimString).toUpperCase();
        return  url+paramString+"sign="+sign1;

    }
    public static void main(String[] args) {
//        objectid=NjuneRoEaVHU8odone&objType=2&timestamp=1587179010000&sign=33a0cbef0dd43764d40c1e066ad06b3d&
//        devCode=zjwRvRXK44Ge7yZU&devType=2&usertype=1&departid=1&level=1&&page=1&pageSize=10
        Map map = new HashMap();
        map.put("searchtype", 1);
        map.put("keyword", "");
        map.put("timestamp", System.currentTimeMillis() / 1000);
        map.put("objectid","NjuneRoEaVHU8odone");
        map.put("objType",2);
        map.put("devCode","zjwRvRXK44Ge7yZU");
        map.put("devType",2);
        map.put("key","d466ef52daaaa21cd947eb55482d1e22");
        System.out.println(getCompleteUrl(map, "https://open.campus.qq.com/api/common/searchUser?"));
//        System.out.println(getMD5("d466ef52daaaa21cd947eb55482d1e22"));
    }

}
