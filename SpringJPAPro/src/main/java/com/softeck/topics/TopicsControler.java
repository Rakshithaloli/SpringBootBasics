package com.softeck.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicsControler {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topics> Hai()
    {
        return topicService.getTopics();
    }

    @RequestMapping("/topics/{id}")
    public void getTopics(@PathVariable String id)
    {
        topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public  void addTopics(@RequestBody Topics topic){
        topicService.addTopics(topic);
    }

    @RequestMapping(method =RequestMethod.PUT, value = "/topics/{id}")
    public  void updateTopics(@RequestBody Topics topic, @PathVariable String id){
        topicService.updateTopic(id,topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id)
    {
        topicService.deleteTopic(id);
    }
}
