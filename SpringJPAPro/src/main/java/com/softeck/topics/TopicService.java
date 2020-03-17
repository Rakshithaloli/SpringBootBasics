package com.softeck.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

   @Autowired
   private TopiceRepository topiceRepository;
/*
   //This is hardcoding like (we are adding values)
   private List<Topics> topics=new ArrayList<>( Arrays.asList(new Topics("Spring", "SpringFramework", "SpringFrameworkDescription"),
                            new Topics("101","JAva","Basic language for framework"),
                            new Topics("102","Spring","framework")));
*/

   public List<Topics> getTopics()
   {
      List<Topics> list=new ArrayList<>();
      topiceRepository.findAll().forEach(list::add);
      return list;

   }

   public void getTopic(String id)
   {
      // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();// insted of hardcoding connect to database and do its easy
      topiceRepository.findById(id);
   }

   public void addTopics(Topics topic)
   {
      topiceRepository.save(topic);
   }

   public void updateTopic(String id, Topics topic)
   {

     /* for(int i=0;i<topics.size();i++)
      {
         Topics t=topics.get(i);
         if(t.getId().equals(id))                     //Hardcoding is to difficult to do so just connect top database and start doing
         {
            topics.set(i,topic);
            return;
         }
      }*/

     topiceRepository.save(topic);
   }

   public void deleteTopic(String id) {
     // topics.removeIf(t -> t.getId().equals(id));

      topiceRepository.deleteById(id);
   }
}
