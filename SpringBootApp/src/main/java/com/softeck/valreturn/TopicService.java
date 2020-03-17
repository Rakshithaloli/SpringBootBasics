package com.softeck.valreturn;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

   private List<Topics> topics=new ArrayList<>( Arrays.asList(new Topics("Spring", "SpringFramework", "SpringFrameworkDescription"),
                            new Topics("101","JAva","Basic language for framework"),
                            new Topics("102","Spring","framework")));

   public List<Topics> getTopics()
   {
       return topics;
   }

   public Topics getTopic(String id)
   {
       return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
   }

   public void addTopics(Topics topic)
   {
      topics.add(topic);
   }

   public void updateTopic(String id, Topics topic)
   {

      for(int i=0;i<topics.size();i++)
      {
         Topics t=topics.get(i);
         if(t.getId().equals(id))
         {
            topics.set(i,topic);
            return;
         }
      }
   }

   public void deleteTopic(String id) {
      topics.removeIf(t -> t.getId().equals(id));
   }
}
