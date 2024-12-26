package ZookyProducer;

import org.apache.kafka.clients.producer.*;
import java.util.Properties;

public class ZookyProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "kafkahost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        String topic = "zooky_revenue";
        String[] records = {
                "1,Shoes,5,50,New York,2024-12-01",
                "2,Jersey,2,30,Los Angeles,2024-12-02",
                "3,Shorts,3,20,Chicago,2024-12-03",
                "4,Socks,10,5,San Francisco,2024-12-04",
                "5,Hats,7,15,Miami,2024-12-05",
                "6,Gloves,4,10,Boston,2024-12-06",
                "7,Shoes,8,45,Dallas,2024-12-07",
                "8,Jersey,6,25,Houston,2024-12-08",
                "9,Shorts,9,18,Philadelphia,2024-12-09",
                "10,Socks,12,4,Seattle,2024-12-10",
                "11,Hats,5,20,Atlanta,2024-12-11",
                "12,Gloves,3,12,Denver,2024-12-12",
                "13,Shoes,7,55,Phoenix,2024-12-13",
                "14,Jersey,4,28,San Diego,2024-12-14",
                "15,Shorts,8,22,Portland,2024-12-15",
                "16,Socks,15,6,Las Vegas,2024-12-16",
                "17,Hats,10,17,San Jose,2024-12-17",
                "18,Gloves,2,9,Austin,2024-12-18",
                "19,Shoes,3,60,Detroit,2024-12-19",
                "20,Jersey,5,35,Memphis,2024-12-20",
                "21,Shorts,6,23,Charlotte,2024-12-21",
                "22,Socks,20,3,Orlando,2024-12-22",
                "23,Hats,4,25,Nashville,2024-12-23",
                "24,Gloves,6,15,Baltimore,2024-12-24",
                "25,Shoes,7,50,Sacramento,2024-12-25",
                "26,Jersey,3,32,Indianapolis,2024-12-26",
                "27,Shorts,9,21,Milwaukee,2024-12-27",
                "28,Socks,10,5,Columbus,2024-12-28",
                "29,Hats,8,18,Fort Worth,2024-12-29",
                "30,Gloves,5,13,El Paso,2024-12-30",
                "31,Shoes,6,40,San Antonio,2024-12-31",
                "32,Jersey,7,37,Pittsburgh,2024-12-01",
                "33,Shorts,10,19,Jacksonville,2024-12-02",
                "34,Socks,8,6,Cincinnati,2024-12-03",
                "35,Hats,12,14,Oakland,2024-12-04",
                "36,Gloves,3,8,Cleveland,2024-12-05",
                "37,Shoes,11,48,Minneapolis,2024-12-06",
                "38,Jersey,9,30,Honolulu,2024-12-07",
                "39,Shorts,4,17,Anchorage,2024-12-08",
                "40,Socks,14,7,St. Louis,2024-12-09",
                "41,Hats,6,22,Tampa,2024-12-10",
                "42,Gloves,2,11,Richmond,2024-12-11",
                "43,Shoes,9,52,Boise,2024-12-12",
                "44,Jersey,5,27,Cheyenne,2024-12-13",
                "45,Shorts,3,24,Albany,2024-12-14",
                "46,Socks,7,8,Charleston,2024-12-15",
                "47,Hats,11,19,Juneau,2024-12-16",
                "48,Gloves,4,10,Madison,2024-12-17",
                "49,Shoes,2,53,Lincoln,2024-12-18",
                "50,Jersey,8,33,Helena,2024-12-19",
                "51,Shorts,5,20,Montpelier,2024-12-20",
                "52,Socks,13,5,Salem,2024-12-21",
                "53,Hats,3,26,Concord,2024-12-22",
                "54,Gloves,7,14,Columbia,2024-12-23",
                "55,Shoes,4,47,Little Rock,2024-12-24",
                "56,Jersey,6,36,Dover,2024-12-25",
                "57,Shorts,8,16,Frankfort,2024-12-26",
                "58,Socks,11,9,Trenton,2024-12-27",
                "59,Hats,10,18,Augusta,2024-12-28",
                "60,Gloves,5,12,Topeka,2024-12-29",
                "61,Shoes,6,43,Olympia,2024-12-30",
                "62,Jersey,4,31,Santa Fe,2024-12-31",
                "63,Shorts,7,25,Bismarck,2024-12-01",
                "64,Socks,9,4,Tallahassee,2024-12-02",
                "65,Hats,2,21,Hartford,2024-12-03",
                "66,Gloves,3,13,Springfield,2024-12-04",
                "67,Shoes,8,42,Atlanta,2024-12-05",
                "68,Jersey,5,28,Denver,2024-12-06",
                "69,Shorts,4,18,Boston,2024-12-07",
                "70,Socks,12,3,Chicago,2024-12-08",
                "71,Hats,6,17,Dallas,2024-12-09",
                "72,Gloves,4,11,Houston,2024-12-10",
                "73,Shoes,9,50,Phoenix,2024-12-11",
                "74,Jersey,6,34,San Francisco,2024-12-12",
                "75,Shorts,3,22,Seattle,2024-12-13",
                "76,Socks,14,6,Portland,2024-12-14",
                "77,Hats,7,20,Miami,2024-12-15",
                "78,Gloves,8,12,Nashville,2024-12-16",
                "79,Shoes,5,60,Memphis,2024-12-17",
                "80,Jersey,3,29,Los Angeles,2024-12-18",
                "81,Shorts,9,21,San Diego,2024-12-19",
                "82,Socks,10,7,Las Vegas,2024-12-20",
                "83,Hats,6,16,San Jose,2024-12-21",
                "84,Gloves,5,9,Austin,2024-12-22",
                "85,Shoes,7,58,Detroit,2024-12-23",
                "86,Jersey,4,38,Pittsburgh,2024-12-24",
                "87,Shorts,10,24,Jacksonville,2024-12-25",
                "88,Socks,11,4,Orlando,2024-12-26",
                "89,Hats,2,26,Charlotte,2024-12-27",
                "90,Gloves,6,15,Milwaukee,2024-12-28",
                "91,Shoes,3,45,Philadelphia,2024-12-29",
                "92,Jersey,9,31,Columbus,2024-12-30",
                "93,Shorts,5,23,Indianapolis,2024-12-31",
                "94,Socks,13,5,Fort Worth,2024-12-01",
                "95,Hats,8,19,Sacramento,2024-12-02",
                "96,Gloves,2,14,El Paso,2024-12-03",
                "97,Shoes,11,53,Richmond,2024-12-04",
                "98,Jersey,7,30,Anchorage,2024-12-05",
                "99,Shorts,6,20,Honolulu,2024-12-06",
                "100,Socks,10,6,Juneau,2024-12-07"
        };
        try {
            for (int i = 0; i < records.length; i++) {
                String message = records[i];  // Use records array
                producer.send(new ProducerRecord<>(topic, "key-" + i, message));
                System.out.println("Sent: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}
