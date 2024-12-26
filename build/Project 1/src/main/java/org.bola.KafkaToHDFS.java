package org.bola;

import org.apache.hadoop.fs.*;
import org.apache.hadoop.conf.Configuration;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KafkaToHDFS {
    public static void sendDataToHDFS(String message) {
        Configuration conf = new Configuration();
        FileSystem fs = null;

        try {
            fs = FileSystem.get(conf);

            // Sử dụng một tên file động để ghi dữ liệu vào HDFS, ví dụ: theo thời gian
            String fileName = "zooky_revenue_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".log";
            Path path = new Path("/user/hadoop/revenue_data/" + fileName); // Lưu vào thư mục HDFS "revenue_data"

            // Tạo hoặc ghi vào file trên HDFS
            try (FSDataOutputStream outputStream = fs.create(path, true)) {  // 'true' để thêm dữ liệu vào cuối file nếu file đã tồn tại
                outputStream.writeBytes(message + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fs != null) {
                    fs.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
