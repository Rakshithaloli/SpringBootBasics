package com.softeck.valreturn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ReturnListofValues {
    @Autowired
   private TopicService topicService;

    @GetMapping("/values")
    public List<Topics> Hai()
    {
        return topicService.getTopics();
    }

    @RequestMapping("/values/{id}")
    public Topics getTopics(@PathVariable String id)
    {
        return topicService.getTopic(id);
    }

    @RequestMapping(method =RequestMethod.POST, value = "/values")
    public  void addTopics(@RequestBody Topics topic){
        topicService.addTopics(topic);
    }

    @RequestMapping(method =RequestMethod.PUT, value = "/values/{id}")
    public  void updateTopics(@RequestBody Topics topic, @PathVariable String id){
        topicService.updateTopic(id,topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/values/{id}")
    public void deleteTopic(@PathVariable String id)
    {
        topicService.deleteTopic(id);
    }
}
