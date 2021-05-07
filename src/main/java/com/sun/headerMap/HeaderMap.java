package com.sun.headerMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by qiulisun on 2019/1/6.<br>
 */
public class HeaderMap {

    public static void main(String[] args){

    }

    public  List<Map<String, Object>> doHeaderMap(List<PersonVO> params) {
        List<Map<String, Object>> queryList = new ArrayList<>();
        Map<Long, Map<String, Object>> headerMap = new HashMap<>();
        for (PersonVO vo : params) {
            if (!headerMap.containsKey(vo.getHeaderId())) {
                Map<String, Object> tempMap = new HashMap<>();
                tempMap.put("headerId", vo.getHeaderId());
                tempMap.put("name", vo.getName());
                tempMap.put("sex", vo.getSex());
                tempMap.put("age", vo.getSex());

                List<Map<String, Object>> lineList = new ArrayList<>();
                Map<String, Object> lineMap = new HashMap<>();
                lineMap.put("headerId", vo.getHeaderId());
                lineMap.put("lineId", vo.getLineId());
                lineMap.put("lineName", vo.getLineName());
                
                lineList.add(lineMap);
                tempMap.put("items", lineList);
                headerMap.put(vo.getHeaderId(), tempMap);
            } else {
                Map<String, Object> tempMap = headerMap.get(vo.getHeaderId());

                List<Map<String, Object>> lineList = (List<Map<String, Object>>) tempMap.get("items");

                Map<String, Object> lineMap = new HashMap<>();
                lineMap.put("headerId", vo.getHeaderId());
                lineMap.put("lineId", vo.getLineId());
                lineMap.put("lineName", vo.getLineName());
                
                lineList.add(lineMap);
                tempMap.put("items", lineList);
                headerMap.put(vo.getHeaderId(), tempMap);
            }
        }
        
        for (Map.Entry<Long, Map<String, Object>> entry : headerMap.entrySet()) {

            queryList.add(entry.getValue());
        }
        return queryList;
    }
}
