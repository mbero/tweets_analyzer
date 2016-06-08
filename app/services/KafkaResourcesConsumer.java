package services;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import models.Tweet;


/**
 * Created by user on 8/4/14.
 */
@Singleton
public class KafkaResourcesConsumer extends  Thread {
    final static String clientId = "SimpleConsumerDemoClient";
    final static String TOPIC = "test";
    ConsumerConnector consumerConnector;
    @Inject
    TweetsManager tweetsManager;

    public static void main(String[] argv) throws UnsupportedEncodingException {
        KafkaResourcesConsumer helloKafkaConsumer = new KafkaResourcesConsumer();
        helloKafkaConsumer.start();
    }

    public KafkaResourcesConsumer(){
        Properties properties	 = new Properties();
        properties.put("zookeeper.connect","localhost:2181");
        properties.put("group.id","test-group");
        properties.put("zookeeper.session.timeout.ms", "400");
        properties.put("zookeeper.sync.time.ms", "200");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("auto.offset.reset", "smallest");
        ConsumerConfig consumerConfig = new ConsumerConfig(properties);
        consumerConnector = Consumer.createJavaConsumerConnector(consumerConfig);
        
    }

    @Override
    public void run() {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(TOPIC, new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumerConnector.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream =  consumerMap.get(TOPIC).get(0);
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        int counter=0;
        while(it.hasNext())
        {
        	List<Tweet> arrayOfMessagesToReadFromDB = new ArrayList<Tweet>();
        	if(counter<10)
        	{
        		Tweet currentTweet = new Tweet(new String(it.next().message()), "2015-05-04", 1);
        		//arrayOfMessagesToReadFromDB.add(new String(it.next().message()));
        		counter+=1;
        	}
        	else
        	{
        		//save to db package of ten messages
        		tweetsManager.saveTweetsToDB(arrayOfMessagesToReadFromDB);
        		counter=0;
        	}
        }
    }

}
