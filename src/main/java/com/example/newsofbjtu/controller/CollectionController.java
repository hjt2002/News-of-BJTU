package com.example.newsofbjtu.controller;

import com.example.newsofbjtu.bean.Collection;
import com.example.newsofbjtu.service.CollectionService;
import com.example.newsofbjtu.util.JsonResult;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/collection")
public class CollectionController {
    final
    CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }
    @PostMapping("/createCollection")
    public JsonResult createCollection(@RequestBody Map<String,String> map){
        String uid = map.get("uid");
        String nid = map.get("nid");
        return collectionService.createCollection(uid,nid);
    }
    @PostMapping("/deleteCollection")
    public JsonResult deleteCollection(@RequestBody Map<String,String>map){
        String uid = map.get("uid");
        String nid = map.get("nid");
        return collectionService.deleteCollection(uid,nid);
    }
    @GetMapping("/getCollection")
    public JsonResult<Collection>getCollection(@RequestParam String uid){
        return collectionService.getCollection(uid);
    }
}
