# Apache--Kafka

What is event streaming?
Event streaming is the digital equivalent of the human body's central nervous system. It is the technological foundation for the 'always-on' world where businesses are increasingly software-defined and automated, and where the user of software is more software.

Technically speaking, event streaming is the practice of capturing data in real-time from event sources like databases, sensors, mobile devices, cloud services, and software applications in the form of streams of events; storing these event streams durably for later retrieval; manipulating, processing, and reacting to the event streams in real-time as well as retrospectively; and routing the event streams to different destination technologies as needed. Event streaming thus ensures a continuous flow and interpretation of data so that the right information is at the right place, at the right time.

What can I use event streaming for?
Event streaming is applied to a wide variety of use cases across a plethora of industries and organizations. Its many examples include:

To process payments and financial transactions in real-time, such as in stock exchanges, banks, and insurances.
To track and monitor cars, trucks, fleets, and shipments in real-time, such as in logistics and the automotive industry.
To continuously capture and analyze sensor data from IoT devices or other equipment, such as in factories and wind parks.
To collect and immediately react to customer interactions and orders, such as in retail, the hotel and travel industry, and mobile applications.
To monitor patients in hospital care and predict changes in condition to ensure timely treatment in emergencies.
To connect, store, and make available data produced by different divisions of a company.
To serve as the foundation for data platforms, event-driven architectures, and microservices.
Apache Kafka® is an event streaming platform. What does that mean?
Kafka combines three key capabilities so you can implement your use cases for event streaming end-to-end with a single battle-tested solution:

To publish (write) and subscribe to (read) streams of events, including continuous import/export of your data from other systems.
To store streams of events durably and reliably for as long as you want.
To process streams of events as they occur or retrospectively.
And all this functionality is provided in a distributed, highly scalable, elastic, fault-tolerant, and secure manner. Kafka can be deployed on bare-metal hardware, virtual machines, and containers, and on-premises as well as in the cloud. You can choose between self-managing your Kafka environments and using fully managed services offered by a variety of vendors.

How does Kafka work in a nutshell?
Kafka is a distributed system consisting of servers and clients that communicate via a high-performance TCP network protocol. It can be deployed on bare-metal hardware, virtual machines, and containers in on-premise as well as cloud environments.

Servers: Kafka is run as a cluster of one or more servers that can span multiple datacenters or cloud regions. Some of these servers form the storage layer, called the brokers. Other servers run Kafka Connect to continuously import and export data as event streams to integrate Kafka with your existing systems such as relational databases as well as other Kafka clusters. To let you implement mission-critical use cases, a Kafka cluster is highly scalable and fault-tolerant: if any of its servers fails, the other servers will take over their work to ensure continuous operations without any data loss.

Clients: They allow you to write distributed applications and microservices that read, write, and process streams of events in parallel, at scale, and in a fault-tolerant manner even in the case of network problems or machine failures. Kafka ships with some such clients included, which are augmented by dozens of clients provided by the Kafka community: clients are available for Java and Scala including the higher-level Kafka Streams library, for Go, Python, C/C++, and many other programming languages as well as REST APIs.

Main Concepts and Terminology
An event records the fact that "something happened" in the world or in your business. It is also called record or message in the documentation. When you read or write data to Kafka, you do this in the form of events. Conceptually, an event has a key, value, timestamp, and optional metadata headers. Here's an example event:

Event key: "Alice"
Event value: "Made a payment of $200 to Bob"
Event timestamp: "Jun. 25, 2020 at 2:06 p.m."
Producers are those client applications that publish (write) events to Kafka, and consumers are those that subscribe to (read and process) these events. In Kafka, producers and consumers are fully decoupled and agnostic of each other, which is a key design element to achieve the high scalability that Kafka is known for. For example, producers never need to wait for consumers. Kafka provides various guarantees such as the ability to process events exactly-once.

Events are organized and durably stored in topics. Very simplified, a topic is similar to a folder in a filesystem, and the events are the files in that folder. An example topic name could be "payments". Topics in Kafka are always multi-producer and multi-subscriber: a topic can have zero, one, or many producers that write events to it, as well as zero, one, or many consumers that subscribe to these events. Events in a topic can be read as often as needed—unlike traditional messaging systems, events are not deleted after consumption. Instead, you define for how long Kafka should retain your events through a per-topic configuration setting, after which old events will be discarded. Kafka's performance is effectively constant with respect to data size, so storing data for a long time is perfectly fine.

Topics are partitioned, meaning a topic is spread over a number of "buckets" located on different Kafka brokers. This distributed placement of your data is very important for scalability because it allows client applications to both read and write the data from/to many brokers at the same time. When a new event is published to a topic, it is actually appended to one of the topic's partitions. Events with the same event key (e.g., a customer or vehicle ID) are written to the same partition, and Kafka guarantees that any consumer of a given topic-partition will always read that partition's events in exactly the same order as they were written.

![image](https://github.com/user-attachments/assets/aa1bf98a-93c5-4906-be03-239cf3dc9fa8)

Figure: This example topic has four partitions P1–P4. Two different producer clients are publishing, independently from each other, new events to the topic by writing events over the network to the topic's partitions. Events with the same key (denoted by their color in the figure) are written to the same partition. Note that both producers can write to the same partition if appropriate.
To make your data fault-tolerant and highly-available, every topic can be replicated, even across geo-regions or datacenters, so that there are always multiple brokers that have a copy of the data just in case things go wrong, you want to do maintenance on the brokers, and so on. A common production setting is a replication factor of 3, i.e., there will always be three copies of your data. This replication is performed at the level of topic-partitions.

This primer should be sufficient for an introduction. The Design section of the documentation explains Kafka's various concepts in full detail, if you are interested.

Kafka APIs
In addition to command line tooling for management and administration tasks, Kafka has five core APIs for Java and Scala:

The Admin API to manage and inspect topics, brokers, and other Kafka objects.
The Producer API to publish (write) a stream of events to one or more Kafka topics.
The Consumer API to subscribe to (read) one or more topics and to process the stream of events produced to them.
The Kafka Streams API to implement stream processing applications and microservices. It provides higher-level functions to process event streams, including transformations, stateful operations like aggregations and joins, windowing, processing based on event-time, and more. Input is read from one or more topics in order to generate output to one or more topics, effectively transforming the input streams to output streams.
The Kafka Connect API to build and run reusable data import/export connectors that consume (read) or produce (write) streams of events from and to external systems and applications so they can integrate with Kafka. For example, a connector to a relational database like PostgreSQL might capture every change to a set of tables. However, in practice, you typically don't need to implement your own connectors because the Kafka community already provides hundreds of ready-to-use connectors.
Where to go from here
To get hands-on experience with Kafka, follow the Quickstart.
To understand Kafka in more detail, read the Documentation. You also have your choice of Kafka books and academic papers.
Browse through the Use Cases to learn how other users in our world-wide community are getting value out of Kafka.
Join a local Kafka meetup group and watch talks from Kafka Summit, the main conference of the Kafka community.

# SETUP
Step 1: Get Kafka
Download the latest Kafka release and extract it:

$ tar -xzf kafka_2.13-3.9.0.tgz
$ cd kafka_2.13-3.9.0
Step 2: Start the Kafka environment
NOTE: Your local environment must have Java 8+ installed.

Apache Kafka can be started using KRaft or ZooKeeper. To get started with either configuration follow one of the sections below but not both.

Kafka with KRaft
Kafka can be run using KRaft mode using local scripts and downloaded files or the docker image. Follow one of the sections below but not both to start the kafka server.

Using downloaded files
Generate a Cluster UUID

$ KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"
Format Log Directories

$ bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c config/kraft/reconfig-server.properties
Start the Kafka Server

$ bin/kafka-server-start.sh config/kraft/reconfig-server.properties
Once the Kafka server has successfully launched, you will have a basic Kafka environment running and ready to use.

Using JVM Based Apache Kafka Docker Image
Get the Docker image:

$ docker pull apache/kafka:3.9.0
Start the Kafka Docker container:

$ docker run -p 9092:9092 apache/kafka:3.9.0
Using GraalVM Based Native Apache Kafka Docker Image
Get the Docker image:

$ docker pull apache/kafka-native:3.9.0
Start the Kafka Docker container:

$ docker run -p 9092:9092 apache/kafka-native:3.9.0
Kafka with ZooKeeper
Run the following commands in order to start all services in the correct order:

# Start the ZooKeeper service
$ bin/zookeeper-server-start.sh config/zookeeper.properties
Open another terminal session and run:

# Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties
Once all services have successfully launched, you will have a basic Kafka environment running and ready to use.

Step 3: Create a topic to store your events
Kafka is a distributed event streaming platform that lets you read, write, store, and process events (also called records or messages in the documentation) across many machines.

Example events are payment transactions, geolocation updates from mobile phones, shipping orders, sensor measurements from IoT devices or medical equipment, and much more. These events are organized and stored in topics. Very simplified, a topic is similar to a folder in a filesystem, and the events are the files in that folder.

So before you can write your first events, you must create a topic. Open another terminal session and run:

$ bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092
All of Kafka's command line tools have additional options: run the kafka-topics.sh command without any arguments to display usage information. For example, it can also show you details such as the partition count of the new topic:

$ bin/kafka-topics.sh --describe --topic quickstart-events --bootstrap-server localhost:9092
Topic: quickstart-events        TopicId: NPmZHyhbR9y00wMglMH2sg PartitionCount: 1       ReplicationFactor: 1	Configs:
Topic: quickstart-events Partition: 0    Leader: 0   Replicas: 0 Isr: 0
Step 4: Write some events into the topic
A Kafka client communicates with the Kafka brokers via the network for writing (or reading) events. Once received, the brokers will store the events in a durable and fault-tolerant manner for as long as you need—even forever.

Run the console producer client to write a few events into your topic. By default, each line you enter will result in a separate event being written to the topic.

$ bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092
>This is my first event
>This is my second event
You can stop the producer client with Ctrl-C at any time.

Step 5: Read the events
Open another terminal session and run the console consumer client to read the events you just created:

$ bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
This is my first event
This is my second event
You can stop the consumer client with Ctrl-C at any time.

Feel free to experiment: for example, switch back to your producer terminal (previous step) to write additional events, and see how the events immediately show up in your consumer terminal.

Because events are durably stored in Kafka, they can be read as many times and by as many consumers as you want. You can easily verify this by opening yet another terminal session and re-running the previous command again.

Step 6: Import/export your data as streams of events with Kafka Connect
You probably have lots of data in existing systems like relational databases or traditional messaging systems, along with many applications that already use these systems. Kafka Connect allows you to continuously ingest data from external systems into Kafka, and vice versa. It is an extensible tool that runs connectors, which implement the custom logic for interacting with an external system. It is thus very easy to integrate existing systems with Kafka. To make this process even easier, there are hundreds of such connectors readily available.

In this quickstart we'll see how to run Kafka Connect with simple connectors that import data from a file to a Kafka topic and export data from a Kafka topic to a file.

First, make sure to add connect-file-3.9.0.jar to the plugin.path property in the Connect worker's configuration. For the purpose of this quickstart we'll use a relative path and consider the connectors' package as an uber jar, which works when the quickstart commands are run from the installation directory. However, it's worth noting that for production deployments using absolute paths is always preferable. See plugin.path for a detailed description of how to set this config.

Edit the config/connect-standalone.properties file, add or change the plugin.path configuration property match the following, and save the file:

$ echo "plugin.path=libs/connect-file-3.9.0.jar" >> config/connect-standalone.properties
Then, start by creating some seed data to test with:

$ echo -e "foo\nbar" > test.txt
Or on Windows:
$ echo foo > test.txt
$ echo bar >> test.txt
Next, we'll start two connectors running in standalone mode, which means they run in a single, local, dedicated process. We provide three configuration files as parameters. The first is always the configuration for the Kafka Connect process, containing common configuration such as the Kafka brokers to connect to and the serialization format for data. The remaining configuration files each specify a connector to create. These files include a unique connector name, the connector class to instantiate, and any other configuration required by the connector.

$ bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties
These sample configuration files, included with Kafka, use the default local cluster configuration you started earlier and create two connectors: the first is a source connector that reads lines from an input file and produces each to a Kafka topic and the second is a sink connector that reads messages from a Kafka topic and produces each as a line in an output file.

During startup you'll see a number of log messages, including some indicating that the connectors are being instantiated. Once the Kafka Connect process has started, the source connector should start reading lines from test.txt and producing them to the topic connect-test, and the sink connector should start reading messages from the topic connect-test and write them to the file test.sink.txt. We can verify the data has been delivered through the entire pipeline by examining the contents of the output file:

$ more test.sink.txt
foo
bar
Note that the data is being stored in the Kafka topic connect-test, so we can also run a console consumer to see the data in the topic (or use custom consumer code to process it):

$ bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic connect-test --from-beginning
{"schema":{"type":"string","optional":false},"payload":"foo"}
{"schema":{"type":"string","optional":false},"payload":"bar"}
…
The connectors continue to process data, so we can add data to the file and see it move through the pipeline:

$ echo "Another line" >> test.txt
You should see the line appear in the console consumer output and in the sink file.

Step 7: Process your events with Kafka Streams
Once your data is stored in Kafka as events, you can process the data with the Kafka Streams client library for Java/Scala. It allows you to implement mission-critical real-time applications and microservices, where the input and/or output data is stored in Kafka topics. Kafka Streams combines the simplicity of writing and deploying standard Java and Scala applications on the client side with the benefits of Kafka's server-side cluster technology to make these applications highly scalable, elastic, fault-tolerant, and distributed. The library supports exactly-once processing, stateful operations and aggregations, windowing, joins, processing based on event-time, and much more.

To give you a first taste, here's how one would implement the popular WordCount algorithm:

KStream<String, String> textLines = builder.stream("quickstart-events");

KTable<String, Long> wordCounts = textLines
            .flatMapValues(line -> Arrays.asList(line.toLowerCase().split(" ")))
            .groupBy((keyIgnored, word) -> word)
            .count();

wordCounts.toStream().to("output-topic", Produced.with(Serdes.String(), Serdes.Long()));
The Kafka Streams demo and the app development tutorial demonstrate how to code and run such a streaming application from start to finish.

Step 8: Terminate the Kafka environment
Now that you reached the end of the quickstart, feel free to tear down the Kafka environment—or continue playing around.

Stop the producer and consumer clients with Ctrl-C, if you haven't done so already.
Stop the Kafka broker with Ctrl-C.
Lastly, if the Kafka with ZooKeeper section was followed, stop the ZooKeeper server with Ctrl-C.
If you also want to delete any data of your local Kafka environment including any events you have created along the way, run the command:

$ rm -rf /tmp/kafka-logs /tmp/zookeeper /tmp/kraft-combined-logs
# USE CASES
Use cases
Here is a description of a few of the popular use cases for Apache Kafka®. For an overview of a number of these areas in action, see this blog post.

Messaging
Kafka works well as a replacement for a more traditional message broker. Message brokers are used for a variety of reasons (to decouple processing from data producers, to buffer unprocessed messages, etc). In comparison to most messaging systems Kafka has better throughput, built-in partitioning, replication, and fault-tolerance which makes it a good solution for large scale message processing applications.
In our experience messaging uses are often comparatively low-throughput, but may require low end-to-end latency and often depend on the strong durability guarantees Kafka provides.

In this domain Kafka is comparable to traditional messaging systems such as ActiveMQ or RabbitMQ.

Website Activity Tracking
The original use case for Kafka was to be able to rebuild a user activity tracking pipeline as a set of real-time publish-subscribe feeds. This means site activity (page views, searches, or other actions users may take) is published to central topics with one topic per activity type. These feeds are available for subscription for a range of use cases including real-time processing, real-time monitoring, and loading into Hadoop or offline data warehousing systems for offline processing and reporting.
Activity tracking is often very high volume as many activity messages are generated for each user page view.

Metrics
Kafka is often used for operational monitoring data. This involves aggregating statistics from distributed applications to produce centralized feeds of operational data.
Log Aggregation
Many people use Kafka as a replacement for a log aggregation solution. Log aggregation typically collects physical log files off servers and puts them in a central place (a file server or HDFS perhaps) for processing. Kafka abstracts away the details of files and gives a cleaner abstraction of log or event data as a stream of messages. This allows for lower-latency processing and easier support for multiple data sources and distributed data consumption. In comparison to log-centric systems like Scribe or Flume, Kafka offers equally good performance, stronger durability guarantees due to replication, and much lower end-to-end latency.
Stream Processing
Many users of Kafka process data in processing pipelines consisting of multiple stages, where raw input data is consumed from Kafka topics and then aggregated, enriched, or otherwise transformed into new topics for further consumption or follow-up processing. For example, a processing pipeline for recommending news articles might crawl article content from RSS feeds and publish it to an "articles" topic; further processing might normalize or deduplicate this content and publish the cleansed article content to a new topic; a final processing stage might attempt to recommend this content to users. Such processing pipelines create graphs of real-time data flows based on the individual topics. Starting in 0.10.0.0, a light-weight but powerful stream processing library called Kafka Streams is available in Apache Kafka to perform such data processing as described above. Apart from Kafka Streams, alternative open source stream processing tools include Apache Storm and Apache Samza.
Event Sourcing
Event sourcing is a style of application design where state changes are logged as a time-ordered sequence of records. Kafka's support for very large stored log data makes it an excellent backend for an application built in this style.

3.11 Configuration Providers
Use configuration providers to load configuration data from external sources. This might include sensitive information, such as passwords, API keys, or other credentials.

You have the following options:

Use a custom provider by creating a class implementing the ConfigProvider interface and packaging it into a JAR file.
Use a built-in provider:
DirectoryConfigProvider
EnvVarConfigProvider
FileConfigProvider
To use a configuration provider, specify it in your configuration using the config.providers property.

Using Configuration Providers
Configuration providers allow you to pass parameters and retrieve configuration data from various sources.

To specify configuration providers, you use a comma-separated list of aliases and the fully-qualified class names that implement the configuration providers:

config.providers=provider1,provider2
config.providers.provider1.class=com.example.Provider1
config.providers.provider2.class=com.example.Provider2
Each provider can have its own set of parameters, which are passed in a specific format:

config.providers.<provider_alias>.param.<name>=<value>
The ConfigProvider interface serves as a base for all configuration providers. Custom implementations of this interface can be created to retrieve configuration data from various sources. You can package the implementation as a JAR file, add the JAR to your classpath, and reference the provider's class in your configuration.

Example custom provider configuration

config.providers=customProvider
config.providers.customProvider.class=com.example.customProvider
config.providers.customProvider.param.param1=value1
config.providers.customProvider.param.param2=value2
DirectoryConfigProvider
The DirectoryConfigProvider retrieves configuration data from files stored in a specified directory.

Each file represents a key, and its content is the value. This provider is useful for loading multiple configuration files and for organizing configuration data into separate files.

To restrict the files that the DirectoryConfigProvider can access, use the allowed.paths parameter. This parameter accepts a comma-separated list of paths that the provider is allowed to access. If not set, all paths are allowed.

Example DirectoryConfigProvider configuration

config.providers=dirProvider
config.providers.dirProvider.class=org.apache.kafka.common.config.provider.DirectoryConfigProvider
config.providers.dirProvider.param.allowed.paths=/path/to/dir1,/path/to/dir2
To reference a value supplied by the DirectoryConfigProvider, use the correct placeholder syntax:

${dirProvider:<path_to_file>:<file_name>}
EnvVarConfigProvider
The EnvVarConfigProvider retrieves configuration data from environment variables.

No specific parameters are required, as it reads directly from the specified environment variables.

This provider is useful for configuring applications running in containers, for example, to load certificates or JAAS configuration from environment variables mapped from secrets.

To restrict which environment variables the EnvVarConfigProvider can access, use the allowlist.pattern parameter. This parameter accepts a regular expression that environment variable names must match to be used by the provider.

Example EnvVarConfigProvider configuration

config.providers=envVarProvider
config.providers.envVarProvider.class=org.apache.kafka.common.config.provider.EnvVarConfigProvider
config.providers.envVarProvider.param.allowlist.pattern=^MY_ENVAR1_.*
To reference a value supplied by the EnvVarConfigProvider, use the correct placeholder syntax:

${envVarProvider:<enVar_name>}
FileConfigProvider
The FileConfigProvider retrieves configuration data from a single properties file.

This provider is useful for loading configuration data from mounted files.

To restrict the file paths that the FileConfigProvider can access, use the allowed.paths parameter. This parameter accepts a comma-separated list of paths that the provider is allowed to access. If not set, all paths are allowed.

Example FileConfigProvider configuration

config.providers=fileProvider
config.providers.fileProvider.class=org.apache.kafka.common.config.provider.FileConfigProvider
config.providers.fileProvider.param.allowed.paths=/path/to/config1,/path/to/config2
To reference a value supplied by the FileConfigProvider, use the correct placeholder syntax:

${fileProvider:<path_and_filename>:<property>}
Example: Referencing files
Here’s an example that uses a file configuration provider with Kafka Connect to provide authentication credentials to a database for a connector.

First, create a connector-credentials.properties configuration file with the following credentials:

dbUsername=my-username
dbPassword=my-password
Specify a FileConfigProvider in the Kafka Connect configuration:

Example Kafka Connect configuration with a FileConfigProvider

config.providers=fileProvider
config.providers.fileProvider.class=org.apache.kafka.common.config.provider.FileConfigProvider
Next, reference the properties from the file in the connector configuration.

Example connector configuration referencing file properties

database.user=${fileProvider:/path/to/connector-credentials.properties:dbUsername}
database.password=${fileProvider:/path/to/connector-credentials.properties:dbPassword}
At runtime, the configuration provider reads and extracts the values from the properties file.

4. Design
4.1 Motivation
We designed Kafka to be able to act as a unified platform for handling all the real-time data feeds a large company might have. To do this we had to think through a fairly broad set of use cases.

It would have to have high-throughput to support high volume event streams such as real-time log aggregation.

It would need to deal gracefully with large data backlogs to be able to support periodic data loads from offline systems.

It also meant the system would have to handle low-latency delivery to handle more traditional messaging use-cases.

We wanted to support partitioned, distributed, real-time processing of these feeds to create new, derived feeds. This motivated our partitioning and consumer model.

Finally in cases where the stream is fed into other data systems for serving, we knew the system would have to be able to guarantee fault-tolerance in the presence of machine failures.

Supporting these uses led us to a design with a number of unique elements, more akin to a database log than a traditional messaging system. We will outline some elements of the design in the following sections.

4.2 Persistence
Don't fear the filesystem!
Kafka relies heavily on the filesystem for storing and caching messages. There is a general perception that "disks are slow" which makes people skeptical that a persistent structure can offer competitive performance. In fact disks are both much slower and much faster than people expect depending on how they are used; and a properly designed disk structure can often be as fast as the network.

The key fact about disk performance is that the throughput of hard drives has been diverging from the latency of a disk seek for the last decade. As a result the performance of linear writes on a JBOD configuration with six 7200rpm SATA RAID-5 array is about 600MB/sec but the performance of random writes is only about 100k/sec—a difference of over 6000X. These linear reads and writes are the most predictable of all usage patterns, and are heavily optimized by the operating system. A modern operating system provides read-ahead and write-behind techniques that prefetch data in large block multiples and group smaller logical writes into large physical writes. A further discussion of this issue can be found in this ACM Queue article; they actually find that sequential disk access can in some cases be faster than random memory access!

To compensate for this performance divergence, modern operating systems have become increasingly aggressive in their use of main memory for disk caching. A modern OS will happily divert all free memory to disk caching with little performance penalty when the memory is reclaimed. All disk reads and writes will go through this unified cache. This feature cannot easily be turned off without using direct I/O, so even if a process maintains an in-process cache of the data, this data will likely be duplicated in OS pagecache, effectively storing everything twice.

Furthermore, we are building on top of the JVM, and anyone who has spent any time with Java memory usage knows two things:

The memory overhead of objects is very high, often doubling the size of the data stored (or worse).
Java garbage collection becomes increasingly fiddly and slow as the in-heap data increases.
As a result of these factors using the filesystem and relying on pagecache is superior to maintaining an in-memory cache or other structure—we at least double the available cache by having automatic access to all free memory, and likely double again by storing a compact byte structure rather than individual objects. Doing so will result in a cache of up to 28-30GB on a 32GB machine without GC penalties. Furthermore, this cache will stay warm even if the service is restarted, whereas the in-process cache will need to be rebuilt in memory (which for a 10GB cache may take 10 minutes) or else it will need to start with a completely cold cache (which likely means terrible initial performance). This also greatly simplifies the code as all logic for maintaining coherency between the cache and filesystem is now in the OS, which tends to do so more efficiently and more correctly than one-off in-process attempts. If your disk usage favors linear reads then read-ahead is effectively pre-populating this cache with useful data on each disk read.

This suggests a design which is very simple: rather than maintain as much as possible in-memory and flush it all out to the filesystem in a panic when we run out of space, we invert that. All data is immediately written to a persistent log on the filesystem without necessarily flushing to disk. In effect this just means that it is transferred into the kernel's pagecache.

This style of pagecache-centric design is described in an article on the design of Varnish here (along with a healthy dose of arrogance).

Constant Time Suffices
The persistent data structure used in messaging systems are often a per-consumer queue with an associated BTree or other general-purpose random access data structures to maintain metadata about messages. BTrees are the most versatile data structure available, and make it possible to support a wide variety of transactional and non-transactional semantics in the messaging system. They do come with a fairly high cost, though: Btree operations are O(log N). Normally O(log N) is considered essentially equivalent to constant time, but this is not true for disk operations. Disk seeks come at 10 ms a pop, and each disk can do only one seek at a time so parallelism is limited. Hence even a handful of disk seeks leads to very high overhead. Since storage systems mix very fast cached operations with very slow physical disk operations, the observed performance of tree structures is often superlinear as data increases with fixed cache--i.e. doubling your data makes things much worse than twice as slow.

Intuitively a persistent queue could be built on simple reads and appends to files as is commonly the case with logging solutions. This structure has the advantage that all operations are O(1) and reads do not block writes or each other. This has obvious performance advantages since the performance is completely decoupled from the data size—one server can now take full advantage of a number of cheap, low-rotational speed 1+TB SATA drives. Though they have poor seek performance, these drives have acceptable performance for large reads and writes and come at 1/3 the price and 3x the capacity.

Having access to virtually unlimited disk space without any performance penalty means that we can provide some features not usually found in a messaging system. For example, in Kafka, instead of attempting to delete messages as soon as they are consumed, we can retain messages for a relatively long period (say a week). This leads to a great deal of flexibility for consumers, as we will describe.

4.3 Efficiency
We have put significant effort into efficiency. One of our primary use cases is handling web activity data, which is very high volume: each page view may generate dozens of writes. Furthermore, we assume each message published is read by at least one consumer (often many), hence we strive to make consumption as cheap as possible.

We have also found, from experience building and running a number of similar systems, that efficiency is a key to effective multi-tenant operations. If the downstream infrastructure service can easily become a bottleneck due to a small bump in usage by the application, such small changes will often create problems. By being very fast we help ensure that the application will tip-over under load before the infrastructure. This is particularly important when trying to run a centralized service that supports dozens or hundreds of applications on a centralized cluster as changes in usage patterns are a near-daily occurrence.

We discussed disk efficiency in the previous section. Once poor disk access patterns have been eliminated, there are two common causes of inefficiency in this type of system: too many small I/O operations, and excessive byte copying.

The small I/O problem happens both between the client and the server and in the server's own persistent operations.

To avoid this, our protocol is built around a "message set" abstraction that naturally groups messages together. This allows network requests to group messages together and amortize the overhead of the network roundtrip rather than sending a single message at a time. The server in turn appends chunks of messages to its log in one go, and the consumer fetches large linear chunks at a time.

This simple optimization produces orders of magnitude speed up. Batching leads to larger network packets, larger sequential disk operations, contiguous memory blocks, and so on, all of which allows Kafka to turn a bursty stream of random message writes into linear writes that flow to the consumers.

The other inefficiency is in byte copying. At low message rates this is not an issue, but under load the impact is significant. To avoid this we employ a standardized binary message format that is shared by the producer, the broker, and the consumer (so data chunks can be transferred without modification between them).

The message log maintained by the broker is itself just a directory of files, each populated by a sequence of message sets that have been written to disk in the same format used by the producer and consumer. Maintaining this common format allows optimization of the most important operation: network transfer of persistent log chunks. Modern unix operating systems offer a highly optimized code path for transferring data out of pagecache to a socket; in Linux this is done with the sendfile system call.

To understand the impact of sendfile, it is important to understand the common data path for transfer of data from file to socket:

The operating system reads data from the disk into pagecache in kernel space
The application reads the data from kernel space into a user-space buffer
The application writes the data back into kernel space into a socket buffer
The operating system copies the data from the socket buffer to the NIC buffer where it is sent over the network
This is clearly inefficient, there are four copies and two system calls. Using sendfile, this re-copying is avoided by allowing the OS to send the data from pagecache to the network directly. So in this optimized path, only the final copy to the NIC buffer is needed.

We expect a common use case to be multiple consumers on a topic. Using the zero-copy optimization above, data is copied into pagecache exactly once and reused on each consumption instead of being stored in memory and copied out to user-space every time it is read. This allows messages to be consumed at a rate that approaches the limit of the network connection.

This combination of pagecache and sendfile means that on a Kafka cluster where the consumers are mostly caught up you will see no read activity on the disks whatsoever as they will be serving data entirely from cache.

TLS/SSL libraries operate at the user space (in-kernel SSL_sendfile is currently not supported by Kafka). Due to this restriction, sendfile is not used when SSL is enabled. For enabling SSL configuration, refer to security.protocol and security.inter.broker.protocol

For more background on the sendfile and zero-copy support in Java, see this article.

End-to-end Batch Compression
In some cases the bottleneck is actually not CPU or disk but network bandwidth. This is particularly true for a data pipeline that needs to send messages between data centers over a wide-area network. Of course, the user can always compress its messages one at a time without any support needed from Kafka, but this can lead to very poor compression ratios as much of the redundancy is due to repetition between messages of the same type (e.g. field names in JSON or user agents in web logs or common string values). Efficient compression requires compressing multiple messages together rather than compressing each message individually.

Kafka supports this with an efficient batching format. A batch of messages can be grouped together, compressed, and sent to the server in this form. The broker decompresses the batch in order to validate it. For example, it validates that the number of records in the batch is same as what batch header states. This batch of messages is then written to disk in compressed form. The batch will remain compressed in the log and it will also be transmitted to the consumer in compressed form. The consumer decompresses any compressed data that it receives.

Kafka supports GZIP, Snappy, LZ4 and ZStandard compression protocols. More details on compression can be found here.

4.4 The Producer
Load balancing
The producer sends data directly to the broker that is the leader for the partition without any intervening routing tier. To help the producer do this all Kafka nodes can answer a request for metadata about which servers are alive and where the leaders for the partitions of a topic are at any given time to allow the producer to appropriately direct its requests.

The client controls which partition it publishes messages to. This can be done at random, implementing a kind of random load balancing, or it can be done by some semantic partitioning function. We expose the interface for semantic partitioning by allowing the user to specify a key to partition by and using this to hash to a partition (there is also an option to override the partition function if need be). For example if the key chosen was a user id then all data for a given user would be sent to the same partition. This in turn will allow consumers to make locality assumptions about their consumption. This style of partitioning is explicitly designed to allow locality-sensitive processing in consumers.

Asynchronous send
Batching is one of the big drivers of efficiency, and to enable batching the Kafka producer will attempt to accumulate data in memory and to send out larger batches in a single request. The batching can be configured to accumulate no more than a fixed number of messages and to wait no longer than some fixed latency bound (say 64k or 10 ms). This allows the accumulation of more bytes to send, and few larger I/O operations on the servers. This buffering is configurable and gives a mechanism to trade off a small amount of additional latency for better throughput.

Details on configuration and the api for the producer can be found elsewhere in the documentation.

4.5 The Consumer
The Kafka consumer works by issuing "fetch" requests to the brokers leading the partitions it wants to consume. The consumer specifies its offset in the log with each request and receives back a chunk of log beginning from that position. The consumer thus has significant control over this position and can rewind it to re-consume data if need be.
Push vs. pull
An initial question we considered is whether consumers should pull data from brokers or brokers should push data to the consumer. In this respect Kafka follows a more traditional design, shared by most messaging systems, where data is pushed to the broker from the producer and pulled from the broker by the consumer. Some logging-centric systems, such as Scribe and Apache Flume, follow a very different push-based path where data is pushed downstream. There are pros and cons to both approaches. However, a push-based system has difficulty dealing with diverse consumers as the broker controls the rate at which data is transferred. The goal is generally for the consumer to be able to consume at the maximum possible rate; unfortunately, in a push system this means the consumer tends to be overwhelmed when its rate of consumption falls below the rate of production (a denial of service attack, in essence). A pull-based system has the nicer property that the consumer simply falls behind and catches up when it can. This can be mitigated with some kind of backoff protocol by which the consumer can indicate it is overwhelmed, but getting the rate of transfer to fully utilize (but never over-utilize) the consumer is trickier than it seems. Previous attempts at building systems in this fashion led us to go with a more traditional pull model.

Another advantage of a pull-based system is that it lends itself to aggressive batching of data sent to the consumer. A push-based system must choose to either send a request immediately or accumulate more data and then send it later without knowledge of whether the downstream consumer will be able to immediately process it. If tuned for low latency, this will result in sending a single message at a time only for the transfer to end up being buffered anyway, which is wasteful. A pull-based design fixes this as the consumer always pulls all available messages after its current position in the log (or up to some configurable max size). So one gets optimal batching without introducing unnecessary latency.

The deficiency of a naive pull-based system is that if the broker has no data the consumer may end up polling in a tight loop, effectively busy-waiting for data to arrive. To avoid this we have parameters in our pull request that allow the consumer request to block in a "long poll" waiting until data arrives (and optionally waiting until a given number of bytes is available to ensure large transfer sizes).

You could imagine other possible designs which would be only pull, end-to-end. The producer would locally write to a local log, and brokers would pull from that with consumers pulling from them. A similar type of "store-and-forward" producer is often proposed. This is intriguing but we felt not very suitable for our target use cases which have thousands of producers. Our experience running persistent data systems at scale led us to feel that involving thousands of disks in the system across many applications would not actually make things more reliable and would be a nightmare to operate. And in practice we have found that we can run a pipeline with strong SLAs at large scale without a need for producer persistence.

Consumer Position
Keeping track of what has been consumed is, surprisingly, one of the key performance points of a messaging system.
Most messaging systems keep metadata about what messages have been consumed on the broker. That is, as a message is handed out to a consumer, the broker either records that fact locally immediately or it may wait for acknowledgement from the consumer. This is a fairly intuitive choice, and indeed for a single machine server it is not clear where else this state could go. Since the data structures used for storage in many messaging systems scale poorly, this is also a pragmatic choice--since the broker knows what is consumed it can immediately delete it, keeping the data size small.

What is perhaps not obvious is that getting the broker and consumer to come into agreement about what has been consumed is not a trivial problem. If the broker records a message as consumed immediately every time it is handed out over the network, then if the consumer fails to process the message (say because it crashes or the request times out or whatever) that message will be lost. To solve this problem, many messaging systems add an acknowledgement feature which means that messages are only marked as sent not consumed when they are sent; the broker waits for a specific acknowledgement from the consumer to record the message as consumed. This strategy fixes the problem of losing messages, but creates new problems. First of all, if the consumer processes the message but fails before it can send an acknowledgement then the message will be consumed twice. The second problem is around performance, now the broker must keep multiple states about every single message (first to lock it so it is not given out a second time, and then to mark it as permanently consumed so that it can be removed). Tricky problems must be dealt with, like what to do with messages that are sent but never acknowledged.

Kafka handles this differently. Our topic is divided into a set of totally ordered partitions, each of which is consumed by exactly one consumer within each subscribing consumer group at any given time. This means that the position of a consumer in each partition is just a single integer, the offset of the next message to consume. This makes the state about what has been consumed very small, just one number for each partition. This state can be periodically checkpointed. This makes the equivalent of message acknowledgements very cheap.

There is a side benefit of this decision. A consumer can deliberately rewind back to an old offset and re-consume data. This violates the common contract of a queue, but turns out to be an essential feature for many consumers. For example, if the consumer code has a bug and is discovered after some messages are consumed, the consumer can re-consume those messages once the bug is fixed.

Offline Data Load
Scalable persistence allows for the possibility of consumers that only periodically consume such as batch data loads that periodically bulk-load data into an offline system such as Hadoop or a relational data warehouse.
In the case of Hadoop we parallelize the data load by splitting the load over individual map tasks, one for each node/topic/partition combination, allowing full parallelism in the loading. Hadoop provides the task management, and tasks which fail can restart without danger of duplicate data—they simply restart from their original position.

Static Membership
Static membership aims to improve the availability of stream applications, consumer groups and other applications built on top of the group rebalance protocol. The rebalance protocol relies on the group coordinator to allocate entity ids to group members. These generated ids are ephemeral and will change when members restart and rejoin. For consumer based apps, this "dynamic membership" can cause a large percentage of tasks re-assigned to different instances during administrative operations such as code deploys, configuration updates and periodic restarts. For large state applications, shuffled tasks need a long time to recover their local states before processing and cause applications to be partially or entirely unavailable. Motivated by this observation, Kafka’s group management protocol allows group members to provide persistent entity ids. Group membership remains unchanged based on those ids, thus no rebalance will be triggered.
If you want to use static membership,

Upgrade both broker cluster and client apps to 2.3 or beyond, and also make sure the upgraded brokers are using inter.broker.protocol.version of 2.3 or beyond as well.
Set the config ConsumerConfig#GROUP_INSTANCE_ID_CONFIG to a unique value for each consumer instance under one group.
For Kafka Streams applications, it is sufficient to set a unique ConsumerConfig#GROUP_INSTANCE_ID_CONFIG per KafkaStreams instance, independent of the number of used threads for an instance.
If your broker is on an older version than 2.3, but you choose to set ConsumerConfig#GROUP_INSTANCE_ID_CONFIG on the client side, the application will detect the broker version and then throws an UnsupportedException. If you accidentally configure duplicate ids for different instances, a fencing mechanism on broker side will inform your duplicate client to shutdown immediately by triggering a org.apache.kafka.common.errors.FencedInstanceIdException. For more details, see KIP-345
4.6 Message Delivery Semantics
Now that we understand a little about how producers and consumers work, let's discuss the semantic guarantees Kafka provides between producer and consumer. Clearly there are multiple possible message delivery guarantees that could be provided:

At most once—Messages may be lost but are never redelivered.
At least once—Messages are never lost but may be redelivered.
Exactly once—this is what people actually want, each message is delivered once and only once.
It's worth noting that this breaks down into two problems: the durability guarantees for publishing a message and the guarantees when consuming a message.
Many systems claim to provide "exactly once" delivery semantics, but it is important to read the fine print, most of these claims are misleading (i.e. they don't translate to the case where consumers or producers can fail, cases where there are multiple consumer processes, or cases where data written to disk can be lost).

Kafka's semantics are straight-forward. When publishing a message we have a notion of the message being "committed" to the log. Once a published message is committed it will not be lost as long as one broker that replicates the partition to which this message was written remains "alive". The definition of committed message, alive partition as well as a description of which types of failures we attempt to handle will be described in more detail in the next section. For now let's assume a perfect, lossless broker and try to understand the guarantees to the producer and consumer. If a producer attempts to publish a message and experiences a network error it cannot be sure if this error happened before or after the message was committed. This is similar to the semantics of inserting into a database table with an autogenerated key.

Prior to 0.11.0.0, if a producer failed to receive a response indicating that a message was committed, it had little choice but to resend the message. This provides at-least-once delivery semantics since the message may be written to the log again during resending if the original request had in fact succeeded. Since 0.11.0.0, the Kafka producer also supports an idempotent delivery option which guarantees that resending will not result in duplicate entries in the log. To achieve this, the broker assigns each producer an ID and deduplicates messages using a sequence number that is sent by the producer along with every message. Also beginning with 0.11.0.0, the producer supports the ability to send messages to multiple topic partitions using transaction-like semantics: i.e. either all messages are successfully written or none of them are. The main use case for this is exactly-once processing between Kafka topics (described below).

Not all use cases require such strong guarantees. For uses which are latency sensitive we allow the producer to specify the durability level it desires. If the producer specifies that it wants to wait on the message being committed this can take on the order of 10 ms. However the producer can also specify that it wants to perform the send completely asynchronously or that it wants to wait only until the leader (but not necessarily the followers) have the message.

Now let's describe the semantics from the point-of-view of the consumer. All replicas have the exact same log with the same offsets. The consumer controls its position in this log. If the consumer never crashed it could just store this position in memory, but if the consumer fails and we want this topic partition to be taken over by another process the new process will need to choose an appropriate position from which to start processing. Let's say the consumer reads some messages -- it has several options for processing the messages and updating its position.

It can read the messages, then save its position in the log, and finally process the messages. In this case there is a possibility that the consumer process crashes after saving its position but before saving the output of its message processing. In this case the process that took over processing would start at the saved position even though a few messages prior to that position had not been processed. This corresponds to "at-most-once" semantics as in the case of a consumer failure messages may not be processed.
It can read the messages, process the messages, and finally save its position. In this case there is a possibility that the consumer process crashes after processing messages but before saving its position. In this case when the new process takes over the first few messages it receives will already have been processed. This corresponds to the "at-least-once" semantics in the case of consumer failure. In many cases messages have a primary key and so the updates are idempotent (receiving the same message twice just overwrites a record with another copy of itself).
So what about exactly once semantics (i.e. the thing you actually want)? When consuming from a Kafka topic and producing to another topic (as in a Kafka Streams application), we can leverage the new transactional producer capabilities in 0.11.0.0 that were mentioned above. The consumer's position is stored as a message in a topic, so we can write the offset to Kafka in the same transaction as the output topics receiving the processed data. If the transaction is aborted, the consumer's position will revert to its old value and the produced data on the output topics will not be visible to other consumers, depending on their "isolation level." In the default "read_uncommitted" isolation level, all messages are visible to consumers even if they were part of an aborted transaction, but in "read_committed," the consumer will only return messages from transactions which were committed (and any messages which were not part of a transaction).

When writing to an external system, the limitation is in the need to coordinate the consumer's position with what is actually stored as output. The classic way of achieving this would be to introduce a two-phase commit between the storage of the consumer position and the storage of the consumers output. But this can be handled more simply and generally by letting the consumer store its offset in the same place as its output. This is better because many of the output systems a consumer might want to write to will not support a two-phase commit. As an example of this, consider a Kafka Connect connector which populates data in HDFS along with the offsets of the data it reads so that it is guaranteed that either data and offsets are both updated or neither is. We follow similar patterns for many other data systems which require these stronger semantics and for which the messages do not have a primary key to allow for deduplication.

So effectively Kafka supports exactly-once delivery in Kafka Streams, and the transactional producer/consumer can be used generally to provide exactly-once delivery when transferring and processing data between Kafka topics. Exactly-once delivery for other destination systems generally requires cooperation with such systems, but Kafka provides the offset which makes implementing this feasible (see also Kafka Connect). Otherwise, Kafka guarantees at-least-once delivery by default, and allows the user to implement at-most-once delivery by disabling retries on the producer and committing offsets in the consumer prior to processing a batch of messages.

4.7 Replication
Kafka replicates the log for each topic's partitions across a configurable number of servers (you can set this replication factor on a topic-by-topic basis). This allows automatic failover to these replicas when a server in the cluster fails so messages remain available in the presence of failures.

Other messaging systems provide some replication-related features, but, in our (totally biased) opinion, this appears to be a tacked-on thing, not heavily used, and with large downsides: replicas are inactive, throughput is heavily impacted, it requires fiddly manual configuration, etc. Kafka is meant to be used with replication by default—in fact we implement un-replicated topics as replicated topics where the replication factor is one.

The unit of replication is the topic partition. Under non-failure conditions, each partition in Kafka has a single leader and zero or more followers. The total number of replicas including the leader constitute the replication factor. All writes go to the leader of the partition, and reads can go to the leader or the followers of the partition. Typically, there are many more partitions than brokers and the leaders are evenly distributed among brokers. The logs on the followers are identical to the leader's log—all have the same offsets and messages in the same order (though, of course, at any given time the leader may have a few as-yet unreplicated messages at the end of its log).

Followers consume messages from the leader just as a normal Kafka consumer would and apply them to their own log. Having the followers pull from the leader has the nice property of allowing the follower to naturally batch together log entries they are applying to their log.

As with most distributed systems, automatically handling failures requires a precise definition of what it means for a node to be "alive." In Kafka, a special node known as the "controller" is responsible for managing the registration of brokers in the cluster. Broker liveness has two conditions:

Brokers must maintain an active session with the controller in order to receive regular metadata updates.
Brokers acting as followers must replicate the writes from the leader and not fall "too far" behind.
What is meant by an "active session" depends on the cluster configuration. For KRaft clusters, an active session is maintained by sending periodic heartbeats to the controller. If the controller fails to receive a heartbeat before the timeout configured by broker.session.timeout.ms expires, then the node is considered offline.

For clusters using Zookeeper, liveness is determined indirectly through the existence of an ephemeral node which is created by the broker on initialization of its Zookeeper session. If the broker loses its session after failing to send heartbeats to Zookeeper before expiration of zookeeper.session.timeout.ms, then the node gets deleted. The controller would then notice the node deletion through a Zookeeper watch and mark the broker offline.

We refer to nodes satisfying these two conditions as being "in sync" to avoid the vagueness of "alive" or "failed". The leader keeps track of the set of "in sync" replicas, which is known as the ISR. If either of these conditions fail to be satisfied, then the broker will be removed from the ISR. For example, if a follower dies, then the controller will notice the failure through the loss of its session, and will remove the broker from the ISR. On the other hand, if the follower lags too far behind the leader but still has an active session, then the leader can also remove it from the ISR. The determination of lagging replicas is controlled through the replica.lag.time.max.ms configuration. Replicas that cannot catch up to the end of the log on the leader within the max time set by this configuration are removed from the ISR.

In distributed systems terminology we only attempt to handle a "fail/recover" model of failures where nodes suddenly cease working and then later recover (perhaps without knowing that they have died). Kafka does not handle so-called "Byzantine" failures in which nodes produce arbitrary or malicious responses (perhaps due to bugs or foul play).

We can now more precisely define that a message is considered committed when all replicas in the ISR for that partition have applied it to their log. Only committed messages are ever given out to the consumer. This means that the consumer need not worry about potentially seeing a message that could be lost if the leader fails. Producers, on the other hand, have the option of either waiting for the message to be committed or not, depending on their preference for tradeoff between latency and durability. This preference is controlled by the acks setting that the producer uses. Note that topics have a setting for the "minimum number" of in-sync replicas that is checked when the producer requests acknowledgment that a message has been written to the full set of in-sync replicas. If a less stringent acknowledgement is requested by the producer, then the message can be committed, and consumed, even if the number of in-sync replicas is lower than the minimum (e.g. it can be as low as just the leader).

The guarantee that Kafka offers is that a committed message will not be lost, as long as there is at least one in sync replica alive, at all times.

Kafka will remain available in the presence of node failures after a short fail-over period, but may not remain available in the presence of network partitions.

Replicated Logs: Quorums, ISRs, and State Machines (Oh my!)
At its heart a Kafka partition is a replicated log. The replicated log is one of the most basic primitives in distributed data systems, and there are many approaches for implementing one. A replicated log can be used by other systems as a primitive for implementing other distributed systems in the state-machine style.
A replicated log models the process of coming into consensus on the order of a series of values (generally numbering the log entries 0, 1, 2, ...). There are many ways to implement this, but the simplest and fastest is with a leader who chooses the ordering of values provided to it. As long as the leader remains alive, all followers need to only copy the values and ordering the leader chooses.

Of course if leaders didn't fail we wouldn't need followers! When the leader does die we need to choose a new leader from among the followers. But followers themselves may fall behind or crash so we must ensure we choose an up-to-date follower. The fundamental guarantee a log replication algorithm must provide is that if we tell the client a message is committed, and the leader fails, the new leader we elect must also have that message. This yields a tradeoff: if the leader waits for more followers to acknowledge a message before declaring it committed then there will be more potentially electable leaders.

If you choose the number of acknowledgements required and the number of logs that must be compared to elect a leader such that there is guaranteed to be an overlap, then this is called a Quorum.

A common approach to this tradeoff is to use a majority vote for both the commit decision and the leader election. This is not what Kafka does, but let's explore it anyway to understand the tradeoffs. Let's say we have 2f+1 replicas. If f+1 replicas must receive a message prior to a commit being declared by the leader, and if we elect a new leader by electing the follower with the most complete log from at least f+1 replicas, then, with no more than f failures, the leader is guaranteed to have all committed messages. This is because among any f+1 replicas, there must be at least one replica that contains all committed messages. That replica's log will be the most complete and therefore will be selected as the new leader. There are many remaining details that each algorithm must handle (such as precisely defined what makes a log more complete, ensuring log consistency during leader failure or changing the set of servers in the replica set) but we will ignore these for now.

This majority vote approach has a very nice property: the latency is dependent on only the fastest servers. That is, if the replication factor is three, the latency is determined by the faster follower not the slower one.

There are a rich variety of algorithms in this family including ZooKeeper's Zab, Raft, and Viewstamped Replication. The most similar academic publication we are aware of to Kafka's actual implementation is PacificA from Microsoft.

The downside of majority vote is that it doesn't take many failures to leave you with no electable leaders. To tolerate one failure requires three copies of the data, and to tolerate two failures requires five copies of the data. In our experience having only enough redundancy to tolerate a single failure is not enough for a practical system, but doing every write five times, with 5x the disk space requirements and 1/5th the throughput, is not very practical for large volume data problems. This is likely why quorum algorithms more commonly appear for shared cluster configuration such as ZooKeeper but are less common for primary data storage. For example in HDFS the namenode's high-availability feature is built on a majority-vote-based journal, but this more expensive approach is not used for the data itself.

Kafka takes a slightly different approach to choosing its quorum set. Instead of majority vote, Kafka dynamically maintains a set of in-sync replicas (ISR) that are caught-up to the leader. Only members of this set are eligible for election as leader. A write to a Kafka partition is not considered committed until all in-sync replicas have received the write. This ISR set is persisted in the cluster metadata whenever it changes. Because of this, any replica in the ISR is eligible to be elected leader. This is an important factor for Kafka's usage model where there are many partitions and ensuring leadership balance is important. With this ISR model and f+1 replicas, a Kafka topic can tolerate f failures without losing committed messages.

For most use cases we hope to handle, we think this tradeoff is a reasonable one. In practice, to tolerate f failures, both the majority vote and the ISR approach will wait for the same number of replicas to acknowledge before committing a message (e.g. to survive one failure a majority quorum needs three replicas and one acknowledgement and the ISR approach requires two replicas and one acknowledgement). The ability to commit without the slowest servers is an advantage of the majority vote approach. However, we think it is ameliorated by allowing the client to choose whether they block on the message commit or not, and the additional throughput and disk space due to the lower required replication factor is worth it.

Another important design distinction is that Kafka does not require that crashed nodes recover with all their data intact. It is not uncommon for replication algorithms in this space to depend on the existence of "stable storage" that cannot be lost in any failure-recovery scenario without potential consistency violations. There are two primary problems with this assumption. First, disk errors are the most common problem we observe in real operation of persistent data systems and they often do not leave data intact. Secondly, even if this were not a problem, we do not want to require the use of fsync on every write for our consistency guarantees as this can reduce performance by two to three orders of magnitude. Our protocol for allowing a replica to rejoin the ISR ensures that before rejoining, it must fully re-sync again even if it lost unflushed data in its crash.

Unclean leader election: What if they all die?
Note that Kafka's guarantee with respect to data loss is predicated on at least one replica remaining in sync. If all the nodes replicating a partition die, this guarantee no longer holds.
However a practical system needs to do something reasonable when all the replicas die. If you are unlucky enough to have this occur, it is important to consider what will happen. There are two behaviors that could be implemented:

Wait for a replica in the ISR to come back to life and choose this replica as the leader (hopefully it still has all its data).
Choose the first replica (not necessarily in the ISR) that comes back to life as the leader.
This is a simple tradeoff between availability and consistency. If we wait for replicas in the ISR, then we will remain unavailable as long as those replicas are down. If such replicas were destroyed or their data was lost, then we are permanently down. If, on the other hand, a non-in-sync replica comes back to life and we allow it to become leader, then its log becomes the source of truth even though it is not guaranteed to have every committed message. By default from version 0.11.0.0, Kafka chooses the first strategy and favor waiting for a consistent replica. This behavior can be changed using configuration property unclean.leader.election.enable, to support use cases where uptime is preferable to consistency.

This dilemma is not specific to Kafka. It exists in any quorum-based scheme. For example in a majority voting scheme, if a majority of servers suffer a permanent failure, then you must either choose to lose 100% of your data or violate consistency by taking what remains on an existing server as your new source of truth.

Availability and Durability Guarantees
When writing to Kafka, producers can choose whether they wait for the message to be acknowledged by 0,1 or all (-1) replicas. Note that "acknowledgement by all replicas" does not guarantee that the full set of assigned replicas have received the message. By default, when acks=all, acknowledgement happens as soon as all the current in-sync replicas have received the message. For example, if a topic is configured with only two replicas and one fails (i.e., only one in sync replica remains), then writes that specify acks=all will succeed. However, these writes could be lost if the remaining replica also fails. Although this ensures maximum availability of the partition, this behavior may be undesirable to some users who prefer durability over availability. Therefore, we provide two topic-level configurations that can be used to prefer message durability over availability:
Disable unclean leader election - if all replicas become unavailable, then the partition will remain unavailable until the most recent leader becomes available again. This effectively prefers unavailability over the risk of message loss. See the previous section on Unclean Leader Election for clarification.
Specify a minimum ISR size - the partition will only accept writes if the size of the ISR is above a certain minimum, in order to prevent the loss of messages that were written to just a single replica, which subsequently becomes unavailable. This setting only takes effect if the producer uses acks=all and guarantees that the message will be acknowledged by at least this many in-sync replicas. This setting offers a trade-off between consistency and availability. A higher setting for minimum ISR size guarantees better consistency since the message is guaranteed to be written to more replicas which reduces the probability that it will be lost. However, it reduces availability since the partition will be unavailable for writes if the number of in-sync replicas drops below the minimum threshold.
Replica Management
The above discussion on replicated logs really covers only a single log, i.e. one topic partition. However a Kafka cluster will manage hundreds or thousands of these partitions. We attempt to balance partitions within a cluster in a round-robin fashion to avoid clustering all partitions for high-volume topics on a small number of nodes. Likewise we try to balance leadership so that each node is the leader for a proportional share of its partitions.
It is also important to optimize the leadership election process as that is the critical window of unavailability. A naive implementation of leader election would end up running an election per partition for all partitions a node hosted when that node failed. As discussed above in the section on replication, Kafka clusters have a special role known as the "controller" which is responsible for managing the registration of brokers. If the controller detects the failure of a broker, it is responsible for electing one of the remaining members of the ISR to serve as the new leader. The result is that we are able to batch together many of the required leadership change notifications which makes the election process far cheaper and faster for a large number of partitions. If the controller itself fails, then another controller will be elected.

4.8 Log Compaction
Log compaction ensures that Kafka will always retain at least the last known value for each message key within the log of data for a single topic partition. It addresses use cases and scenarios such as restoring state after application crashes or system failure, or reloading caches after application restarts during operational maintenance. Let's dive into these use cases in more detail and then describe how compaction works.
So far we have described only the simpler approach to data retention where old log data is discarded after a fixed period of time or when the log reaches some predetermined size. This works well for temporal event data such as logging where each record stands alone. However an important class of data streams are the log of changes to keyed, mutable data (for example, the changes to a database table).

Let's discuss a concrete example of such a stream. Say we have a topic containing user email addresses; every time a user updates their email address we send a message to this topic using their user id as the primary key. Now say we send the following messages over some time period for a user with id 123, each message corresponding to a change in email address (messages for other ids are omitted):

123 => bill@microsoft.com
        .
        .
        .
123 => bill@gatesfoundation.org
        .
        .
        .
123 => bill@gmail.com
Log compaction gives us a more granular retention mechanism so that we are guaranteed to retain at least the last update for each primary key (e.g. bill@gmail.com). By doing this we guarantee that the log contains a full snapshot of the final value for every key not just keys that changed recently. This means downstream consumers can restore their own state off this topic without us having to retain a complete log of all changes.
Let's start by looking at a few use cases where this is useful, then we'll see how it can be used.

Database change subscription. It is often necessary to have a data set in multiple data systems, and often one of these systems is a database of some kind (either a RDBMS or perhaps a new-fangled key-value store). For example you might have a database, a cache, a search cluster, and a Hadoop cluster. Each change to the database will need to be reflected in the cache, the search cluster, and eventually in Hadoop. In the case that one is only handling the real-time updates you only need recent log. But if you want to be able to reload the cache or restore a failed search node you may need a complete data set.
Event sourcing. This is a style of application design which co-locates query processing with application design and uses a log of changes as the primary store for the application.
Journaling for high-availability. A process that does local computation can be made fault-tolerant by logging out changes that it makes to its local state so another process can reload these changes and carry on if it should fail. A concrete example of this is handling counts, aggregations, and other "group by"-like processing in a stream query system. Samza, a real-time stream-processing framework, uses this feature for exactly this purpose.
In each of these cases one needs primarily to handle the real-time feed of changes, but occasionally, when a machine crashes or data needs to be re-loaded or re-processed, one needs to do a full load. Log compaction allows feeding both of these use cases off the same backing topic. This style of usage of a log is described in more detail in this blog post.
The general idea is quite simple. If we had infinite log retention, and we logged each change in the above cases, then we would have captured the state of the system at each time from when it first began. Using this complete log, we could restore to any point in time by replaying the first N records in the log. This hypothetical complete log is not very practical for systems that update a single record many times as the log will grow without bound even for a stable dataset. The simple log retention mechanism which throws away old updates will bound space but the log is no longer a way to restore the current state—now restoring from the beginning of the log no longer recreates the current state as old updates may not be captured at all.

Log compaction is a mechanism to give finer-grained per-record retention, rather than the coarser-grained time-based retention. The idea is to selectively remove records where we have a more recent update with the same primary key. This way the log is guaranteed to have at least the last state for each key.

This retention policy can be set per-topic, so a single cluster can have some topics where retention is enforced by size or time and other topics where retention is enforced by compaction.

This functionality is inspired by one of LinkedIn's oldest and most successful pieces of infrastructure—a database changelog caching service called Databus. Unlike most log-structured storage systems Kafka is built for subscription and organizes data for fast linear reads and writes. Unlike Databus, Kafka acts as a source-of-truth store so it is useful even in situations where the upstream data source would not otherwise be replayable.

Log Compaction Basics
Here is a high-level picture that shows the logical structure of a Kafka log with the offset for each message.


The head of the log is identical to a traditional Kafka log. It has dense, sequential offsets and retains all messages. Log compaction adds an option for handling the tail of the log. The picture above shows a log with a compacted tail. Note that the messages in the tail of the log retain the original offset assigned when they were first written—that never changes. Note also that all offsets remain valid positions in the log, even if the message with that offset has been compacted away; in this case this position is indistinguishable from the next highest offset that does appear in the log. For example, in the picture above the offsets 36, 37, and 38 are all equivalent positions and a read beginning at any of these offsets would return a message set beginning with 38.

Compaction also allows for deletes. A message with a key and a null payload will be treated as a delete from the log. Such a record is sometimes referred to as a tombstone. This delete marker will cause any prior message with that key to be removed (as would any new message with that key), but delete markers are special in that they will themselves be cleaned out of the log after a period of time to free up space. The point in time at which deletes are no longer retained is marked as the "delete retention point" in the above diagram.

The compaction is done in the background by periodically recopying log segments. Cleaning does not block reads and can be throttled to use no more than a configurable amount of I/O throughput to avoid impacting producers and consumers. The actual process of compacting a log segment looks something like this:




What guarantees does log compaction provide?
Log compaction guarantees the following:
Any consumer that stays caught-up to within the head of the log will see every message that is written; these messages will have sequential offsets. The topic's min.compaction.lag.ms can be used to guarantee the minimum length of time must pass after a message is written before it could be compacted. I.e. it provides a lower bound on how long each message will remain in the (uncompacted) head. The topic's max.compaction.lag.ms can be used to guarantee the maximum delay between the time a message is written and the time the message becomes eligible for compaction.
Ordering of messages is always maintained. Compaction will never re-order messages, just remove some.
The offset for a message never changes. It is the permanent identifier for a position in the log.
Any consumer progressing from the start of the log will see at least the final state of all records in the order they were written. Additionally, all delete markers for deleted records will be seen, provided the consumer reaches the head of the log in a time period less than the topic's delete.retention.ms setting (the default is 24 hours). In other words: since the removal of delete markers happens concurrently with reads, it is possible for a consumer to miss delete markers if it lags by more than delete.retention.ms.
Log Compaction Details
Log compaction is handled by the log cleaner, a pool of background threads that recopy log segment files, removing records whose key appears in the head of the log. Each compactor thread works as follows:
It chooses the log that has the highest ratio of log head to log tail
It creates a succinct summary of the last offset for each key in the head of the log
It recopies the log from beginning to end removing keys which have a later occurrence in the log. New, clean segments are swapped into the log immediately so the additional disk space required is just one additional log segment (not a fully copy of the log).
The summary of the log head is essentially just a space-compact hash table. It uses exactly 24 bytes per entry. As a result with 8GB of cleaner buffer one cleaner iteration can clean around 366GB of log head (assuming 1k messages).

Configuring The Log Cleaner
The log cleaner is enabled by default. This will start the pool of cleaner threads. To enable log cleaning on a particular topic, add the log-specific property
log.cleanup.policy=compact
The log.cleanup.policy property is a broker configuration setting defined in the broker's server.properties file; it affects all of the topics in the cluster that do not have a configuration override in place as documented here. The log cleaner can be configured to retain a minimum amount of the uncompacted "head" of the log. This is enabled by setting the compaction time lag.
log.cleaner.min.compaction.lag.ms
This can be used to prevent messages newer than a minimum message age from being subject to compaction. If not set, all log segments are eligible for compaction except for the last segment, i.e. the one currently being written to. The active segment will not be compacted even if all of its messages are older than the minimum compaction time lag. The log cleaner can be configured to ensure a maximum delay after which the uncompacted "head" of the log becomes eligible for log compaction.
log.cleaner.max.compaction.lag.ms
This can be used to prevent log with low produce rate from remaining ineligible for compaction for an unbounded duration. If not set, logs that do not exceed min.cleanable.dirty.ratio are not compacted. Note that this compaction deadline is not a hard guarantee since it is still subjected to the availability of log cleaner threads and the actual compaction time. You will want to monitor the uncleanable-partitions-count, max-clean-time-secs and max-compaction-delay-secs metrics.
Further cleaner configurations are described here.

4.9 Quotas
Kafka cluster has the ability to enforce quotas on requests to control the broker resources used by clients. Two types of client quotas can be enforced by Kafka brokers for each group of clients sharing a quota:

Network bandwidth quotas define byte-rate thresholds (since 0.9)
Request rate quotas define CPU utilization thresholds as a percentage of network and I/O threads (since 0.11)
Why are quotas necessary?
It is possible for producers and consumers to produce/consume very high volumes of data or generate requests at a very high rate and thus monopolize broker resources, cause network saturation and generally DOS other clients and the brokers themselves. Having quotas protects against these issues and is all the more important in large multi-tenant clusters where a small set of badly behaved clients can degrade user experience for the well behaved ones. In fact, when running Kafka as a service this even makes it possible to enforce API limits according to an agreed upon contract.

Client groups
The identity of Kafka clients is the user principal which represents an authenticated user in a secure cluster. In a cluster that supports unauthenticated clients, user principal is a grouping of unauthenticated users chosen by the broker using a configurable PrincipalBuilder. Client-id is a logical grouping of clients with a meaningful name chosen by the client application. The tuple (user, client-id) defines a secure logical group of clients that share both user principal and client-id.
Quotas can be applied to (user, client-id), user or client-id groups. For a given connection, the most specific quota matching the connection is applied. All connections of a quota group share the quota configured for the group. For example, if (user="test-user", client-id="test-client") has a produce quota of 10MB/sec, this is shared across all producer instances of user "test-user" with the client-id "test-client".

Quota Configuration
Quota configuration may be defined for (user, client-id), user and client-id groups. It is possible to override the default quota at any of the quota levels that needs a higher (or even lower) quota. The mechanism is similar to the per-topic log config overrides. User and (user, client-id) quota overrides are written to ZooKeeper under /config/users and client-id quota overrides are written under /config/clients. These overrides are read by all brokers and are effective immediately. This lets us change quotas without having to do a rolling restart of the entire cluster. See here for details. Default quotas for each group may also be updated dynamically using the same mechanism.

The order of precedence for quota configuration is:

/config/users/<user>/clients/<client-id>
/config/users/<user>/clients/<default>
/config/users/<user>
/config/users/<default>/clients/<client-id>
/config/users/<default>/clients/<default>
/config/users/<default>
/config/clients/<client-id>
/config/clients/<default>
Network Bandwidth Quotas
Network bandwidth quotas are defined as the byte rate threshold for each group of clients sharing a quota. By default, each unique client group receives a fixed quota in bytes/sec as configured by the cluster. This quota is defined on a per-broker basis. Each group of clients can publish/fetch a maximum of X bytes/sec per broker before clients are throttled.

Request Rate Quotas
Request rate quotas are defined as the percentage of time a client can utilize on request handler I/O threads and network threads of each broker within a quota window. A quota of n% represents n% of one thread, so the quota is out of a total capacity of ((num.io.threads + num.network.threads) * 100)%. Each group of clients may use a total percentage of upto n% across all I/O and network threads in a quota window before being throttled. Since the number of threads allocated for I/O and network threads are typically based on the number of cores available on the broker host, request rate quotas represent the total percentage of CPU that may be used by each group of clients sharing the quota.

Enforcement
By default, each unique client group receives a fixed quota as configured by the cluster. This quota is defined on a per-broker basis. Each client can utilize this quota per broker before it gets throttled. We decided that defining these quotas per broker is much better than having a fixed cluster wide bandwidth per client because that would require a mechanism to share client quota usage among all the brokers. This can be harder to get right than the quota implementation itself!

How does a broker react when it detects a quota violation? In our solution, the broker first computes the amount of delay needed to bring the violating client under its quota and returns a response with the delay immediately. In case of a fetch request, the response will not contain any data. Then, the broker mutes the channel to the client, not to process requests from the client anymore, until the delay is over. Upon receiving a response with a non-zero delay duration, the Kafka client will also refrain from sending further requests to the broker during the delay. Therefore, requests from a throttled client are effectively blocked from both sides. Even with older client implementations that do not respect the delay response from the broker, the back pressure applied by the broker via muting its socket channel can still handle the throttling of badly behaving clients. Those clients who sent further requests to the throttled channel will receive responses only after the delay is over.

Byte-rate and thread utilization are measured over multiple small windows (e.g. 30 windows of 1 second each) in order to detect and correct quota violations quickly. Typically, having large measurement windows (for e.g. 10 windows of 30 seconds each) leads to large bursts of traffic followed by long delays which is not great in terms of user experience.

5. Implementation
5.1 Network Layer
The network layer is a fairly straight-forward NIO server, and will not be described in great detail. The sendfile implementation is done by giving the TransferableRecords interface a writeTo method. This allows the file-backed message set to use the more efficient transferTo implementation instead of an in-process buffered write. The threading model is a single acceptor thread and N processor threads which handle a fixed number of connections each. This design has been pretty thoroughly tested elsewhere and found to be simple to implement and fast. The protocol is kept quite simple to allow for future implementation of clients in other languages.

5.2 Messages
Messages consist of a variable-length header, a variable-length opaque key byte array and a variable-length opaque value byte array. The format of the header is described in the following section. Leaving the key and value opaque is the right decision: there is a great deal of progress being made on serialization libraries right now, and any particular choice is unlikely to be right for all uses. Needless to say a particular application using Kafka would likely mandate a particular serialization type as part of its usage. The RecordBatch interface is simply an iterator over messages with specialized methods for bulk reading and writing to an NIO Channel.

5.3 Message Format
Messages (aka Records) are always written in batches. The technical term for a batch of messages is a record batch, and a record batch contains one or more records. In the degenerate case, we could have a record batch containing a single record. Record batches and records have their own headers. The format of each is described below.

5.3.1 Record Batch
The following is the on-disk format of a RecordBatch.

baseOffset: int64
batchLength: int32
partitionLeaderEpoch: int32
magic: int8 (current magic value is 2)
crc: uint32
attributes: int16
    bit 0~2:
        0: no compression
        1: gzip
        2: snappy
        3: lz4
        4: zstd
    bit 3: timestampType
    bit 4: isTransactional (0 means not transactional)
    bit 5: isControlBatch (0 means not a control batch)
    bit 6: hasDeleteHorizonMs (0 means baseTimestamp is not set as the delete horizon for compaction)
    bit 7~15: unused
lastOffsetDelta: int32
baseTimestamp: int64
maxTimestamp: int64
producerId: int64
producerEpoch: int16
baseSequence: int32
records: [Record]
Note that when compression is enabled, the compressed record data is serialized directly following the count of the number of records.

The CRC covers the data from the attributes to the end of the batch (i.e. all the bytes that follow the CRC). It is located after the magic byte, which means that clients must parse the magic byte before deciding how to interpret the bytes between the batch length and the magic byte. The partition leader epoch field is not included in the CRC computation to avoid the need to recompute the CRC when this field is assigned for every batch that is received by the broker. The CRC-32C (Castagnoli) polynomial is used for the computation.

On compaction: unlike the older message formats, magic v2 and above preserves the first and last offset/sequence numbers from the original batch when the log is cleaned. This is required in order to be able to restore the producer's state when the log is reloaded. If we did not retain the last sequence number, for example, then after a partition leader failure, the producer might see an OutOfSequence error. The base sequence number must be preserved for duplicate checking (the broker checks incoming Produce requests for duplicates by verifying that the first and last sequence numbers of the incoming batch match the last from that producer). As a result, it is possible to have empty batches in the log when all the records in the batch are cleaned but batch is still retained in order to preserve a producer's last sequence number. One oddity here is that the baseTimestamp field is not preserved during compaction, so it will change if the first record in the batch is compacted away.

Compaction may also modify the baseTimestamp if the record batch contains records with a null payload or aborted transaction markers. The baseTimestamp will be set to the timestamp of when those records should be deleted with the delete horizon attribute bit also set.

5.3.1.1 Control Batches
A control batch contains a single record called the control record. Control records should not be passed on to applications. Instead, they are used by consumers to filter out aborted transactional messages.

The key of a control record conforms to the following schema:

version: int16 (current version is 0)
type: int16 (0 indicates an abort marker, 1 indicates a commit)
The schema for the value of a control record is dependent on the type. The value is opaque to clients.

5.3.2 Record
Record level headers were introduced in Kafka 0.11.0. The on-disk format of a record with Headers is delineated below.

length: varint
attributes: int8
    bit 0~7: unused
timestampDelta: varlong
offsetDelta: varint
keyLength: varint
key: byte[]
valueLen: varint
value: byte[]
Headers => [Header]
5.3.2.1 Record Header
headerKeyLength: varint
headerKey: String
headerValueLength: varint
Value: byte[]
We use the same varint encoding as Protobuf. More information on the latter can be found here. The count of headers in a record is also encoded as a varint.

5.3.3 Old Message Format
Prior to Kafka 0.11, messages were transferred and stored in message sets. In a message set, each message has its own metadata. Note that although message sets are represented as an array, they are not preceded by an int32 array size like other array elements in the protocol.

Message Set:
MessageSet (Version: 0) => [offset message_size message]
offset => INT64
message_size => INT32
message => crc magic_byte attributes key value
    crc => INT32
    magic_byte => INT8
    attributes => INT8
        bit 0~2:
            0: no compression
            1: gzip
            2: snappy
        bit 3~7: unused
    key => BYTES
    value => BYTES
MessageSet (Version: 1) => [offset message_size message]
offset => INT64
message_size => INT32
message => crc magic_byte attributes timestamp key value
    crc => INT32
    magic_byte => INT8
    attributes => INT8
        bit 0~2:
            0: no compression
            1: gzip
            2: snappy
            3: lz4
        bit 3: timestampType
            0: create time
            1: log append time
        bit 4~7: unused
    timestamp => INT64
    key => BYTES
    value => BYTES
In versions prior to Kafka 0.10, the only supported message format version (which is indicated in the magic value) was 0. Message format version 1 was introduced with timestamp support in version 0.10.

Similarly to version 2 above, the lowest bits of attributes represent the compression type.
In version 1, the producer should always set the timestamp type bit to 0. If the topic is configured to use log append time, (through either broker level config log.message.timestamp.type = LogAppendTime or topic level config message.timestamp.type = LogAppendTime), the broker will overwrite the timestamp type and the timestamp in the message set.
The highest bits of attributes must be set to 0.
In message format versions 0 and 1 Kafka supports recursive messages to enable compression. In this case the message's attributes must be set to indicate one of the compression types and the value field will contain a message set compressed with that type. We often refer to the nested messages as "inner messages" and the wrapping message as the "outer message." Note that the key should be null for the outer message and its offset will be the offset of the last inner message.

When receiving recursive version 0 messages, the broker decompresses them and each inner message is assigned an offset individually. In version 1, to avoid server side re-compression, only the wrapper message will be assigned an offset. The inner messages will have relative offsets. The absolute offset can be computed using the offset from the outer message, which corresponds to the offset assigned to the last inner message.

The crc field contains the CRC32 (and not CRC-32C) of the subsequent message bytes (i.e. from magic byte to the value).

5.4 Log
A log for a topic named "my-topic" with two partitions consists of two directories (namely my-topic-0 and my-topic-1) populated with data files containing the messages for that topic. The format of the log files is a sequence of "log entries"; each log entry is a 4 byte integer N storing the message length which is followed by the N message bytes. Each message is uniquely identified by a 64-bit integer offset giving the byte position of the start of this message in the stream of all messages ever sent to that topic on that partition. The on-disk format of each message is given below. Each log file is named with the offset of the first message it contains. So the first file created will be 00000000000000000000.log, and each additional file will have an integer name roughly S bytes from the previous file where S is the max log file size given in the configuration.

The exact binary format for records is versioned and maintained as a standard interface so record batches can be transferred between producer, broker, and client without recopying or conversion when desirable. The previous section included details about the on-disk format of records.

The use of the message offset as the message id is unusual. Our original idea was to use a GUID generated by the producer, and maintain a mapping from GUID to offset on each broker. But since a consumer must maintain an ID for each server, the global uniqueness of the GUID provides no value. Furthermore, the complexity of maintaining the mapping from a random id to an offset requires a heavy weight index structure which must be synchronized with disk, essentially requiring a full persistent random-access data structure. Thus to simplify the lookup structure we decided to use a simple per-partition atomic counter which could be coupled with the partition id and node id to uniquely identify a message; this makes the lookup structure simpler, though multiple seeks per consumer request are still likely. However once we settled on a counter, the jump to directly using the offset seemed natural—both after all are monotonically increasing integers unique to a partition. Since the offset is hidden from the consumer API this decision is ultimately an implementation detail and we went with the more efficient approach.


Writes
The log allows serial appends which always go to the last file. This file is rolled over to a fresh file when it reaches a configurable size (say 1GB). The log takes two configuration parameters: M, which gives the number of messages to write before forcing the OS to flush the file to disk, and S, which gives a number of seconds after which a flush is forced. This gives a durability guarantee of losing at most M messages or S seconds of data in the event of a system crash.

Reads
Reads are done by giving the 64-bit logical offset of a message and an S-byte max chunk size. This will return an iterator over the messages contained in the S-byte buffer. S is intended to be larger than any single message, but in the event of an abnormally large message, the read can be retried multiple times, each time doubling the buffer size, until the message is read successfully. A maximum message and buffer size can be specified to make the server reject messages larger than some size, and to give a bound to the client on the maximum it needs to ever read to get a complete message. It is likely that the read buffer ends with a partial message, this is easily detected by the size delimiting.

The actual process of reading from an offset requires first locating the log segment file in which the data is stored, calculating the file-specific offset from the global offset value, and then reading from that file offset. The search is done as a simple binary search variation against an in-memory range maintained for each file.

The log provides the capability of getting the most recently written message to allow clients to start subscribing as of "right now". This is also useful in the case the consumer fails to consume its data within its SLA-specified number of days. In this case when the client attempts to consume a non-existent offset it is given an OutOfRangeException and can either reset itself or fail as appropriate to the use case.

The following is the format of the results sent to the consumer.

MessageSetSend (fetch result)

total length     : 4 bytes
error code       : 2 bytes
message 1        : x bytes
...
message n        : x bytes
MultiMessageSetSend (multiFetch result)

total length       : 4 bytes
error code         : 2 bytes
messageSetSend 1
...
messageSetSend n
Deletes
Data is deleted one log segment at a time. The log manager applies two metrics to identify segments which are eligible for deletion: time and size. For time-based policies, the record timestamps are considered, with the largest timestamp in a segment file (order of records is not relevant) defining the retention time for the entire segment. Size-based retention is disabled by default. When enabled the log manager keeps deleting the oldest segment file until the overall size of the partition is within the configured limit again. If both policies are enabled at the same time, a segment that is eligible for deletion due to either policy will be deleted. To avoid locking reads while still allowing deletes that modify the segment list we use a copy-on-write style segment list implementation that provides consistent views to allow a binary search to proceed on an immutable static snapshot view of the log segments while deletes are progressing.

Guarantees
The log provides a configuration parameter M which controls the maximum number of messages that are written before forcing a flush to disk. On startup a log recovery process is run that iterates over all messages in the newest log segment and verifies that each message entry is valid. A message entry is valid if the sum of its size and offset are less than the length of the file AND the CRC32 of the message payload matches the CRC stored with the message. In the event corruption is detected the log is truncated to the last valid offset.

Note that two kinds of corruption must be handled: truncation in which an unwritten block is lost due to a crash, and corruption in which a nonsense block is ADDED to the file. The reason for this is that in general the OS makes no guarantee of the write order between the file inode and the actual block data so in addition to losing written data the file can gain nonsense data if the inode is updated with a new size but a crash occurs before the block containing that data is written. The CRC detects this corner case, and prevents it from corrupting the log (though the unwritten messages are, of course, lost).

5.5 Distribution
Consumer Offset Tracking
Kafka consumer tracks the maximum offset it has consumed in each partition and has the capability to commit offsets so that it can resume from those offsets in the event of a restart. Kafka provides the option to store all the offsets for a given consumer group in a designated broker (for that group) called the group coordinator. i.e., any consumer instance in that consumer group should send its offset commits and fetches to that group coordinator (broker). Consumer groups are assigned to coordinators based on their group names. A consumer can look up its coordinator by issuing a FindCoordinatorRequest to any Kafka broker and reading the FindCoordinatorResponse which will contain the coordinator details. The consumer can then proceed to commit or fetch offsets from the coordinator broker. In case the coordinator moves, the consumer will need to rediscover the coordinator. Offset commits can be done automatically or manually by consumer instance.

When the group coordinator receives an OffsetCommitRequest, it appends the request to a special compacted Kafka topic named __consumer_offsets. The broker sends a successful offset commit response to the consumer only after all the replicas of the offsets topic receive the offsets. In case the offsets fail to replicate within a configurable timeout, the offset commit will fail and the consumer may retry the commit after backing off. The brokers periodically compact the offsets topic since it only needs to maintain the most recent offset commit per partition. The coordinator also caches the offsets in an in-memory table in order to serve offset fetches quickly.

When the coordinator receives an offset fetch request, it simply returns the last committed offset vector from the offsets cache. In case coordinator was just started or if it just became the coordinator for a new set of consumer groups (by becoming a leader for a partition of the offsets topic), it may need to load the offsets topic partition into the cache. In this case, the offset fetch will fail with an CoordinatorLoadInProgressException and the consumer may retry the OffsetFetchRequest after backing off.

ZooKeeper Directories
The following gives the ZooKeeper structures and algorithms used for co-ordination between consumers and brokers.

Notation
When an element in a path is denoted [xyz], that means that the value of xyz is not fixed and there is in fact a ZooKeeper znode for each possible value of xyz. For example /topics/[topic] would be a directory named /topics containing a sub-directory for each topic name. Numerical ranges are also given such as [0...5] to indicate the subdirectories 0, 1, 2, 3, 4. An arrow -> is used to indicate the contents of a znode. For example /hello -> world would indicate a znode /hello containing the value "world".

Broker Node Registry
/brokers/ids/[0...N] --> {"jmx_port":...,"timestamp":...,"endpoints":[...],"host":...,"version":...,"port":...} (ephemeral node)
This is a list of all present broker nodes, each of which provides a unique logical broker id which identifies it to consumers (which must be given as part of its configuration). On startup, a broker node registers itself by creating a znode with the logical broker id under /brokers/ids. The purpose of the logical broker id is to allow a broker to be moved to a different physical machine without affecting consumers. An attempt to register a broker id that is already in use (say because two servers are configured with the same broker id) results in an error.

Since the broker registers itself in ZooKeeper using ephemeral znodes, this registration is dynamic and will disappear if the broker is shutdown or dies (thus notifying consumers it is no longer available).

Broker Topic Registry
/brokers/topics/[topic]/partitions/[0...N]/state --> {"controller_epoch":...,"leader":...,"version":...,"leader_epoch":...,"isr":[...]} (ephemeral node)
Each broker registers itself under the topics it maintains and stores the number of partitions for that topic.

Cluster Id
The cluster id is a unique and immutable identifier assigned to a Kafka cluster. The cluster id can have a maximum of 22 characters and the allowed characters are defined by the regular expression [a-zA-Z0-9_\-]+, which corresponds to the characters used by the URL-safe Base64 variant with no padding. Conceptually, it is auto-generated when a cluster is started for the first time.

Implementation-wise, it is generated when a broker with version 0.10.1 or later is successfully started for the first time. The broker tries to get the cluster id from the /cluster/id znode during startup. If the znode does not exist, the broker generates a new cluster id and creates the znode with this cluster id.

Broker node registration
The broker nodes are basically independent, so they only publish information about what they have. When a broker joins, it registers itself under the broker node registry directory and writes information about its host name and port. The broker also register the list of existing topics and their logical partitions in the broker topic registry. New topics are registered dynamically when they are created on the broker.

6. Operations
Here is some information on actually running Kafka as a production system. Please send us any additional tips you know of.

6.1 Basic Kafka Operations
This section will review the most common operations you will perform on your Kafka cluster. All of the tools reviewed in this section are available under the bin/ directory of the Kafka distribution and each tool will print details on all possible commandline options if it is run with no arguments.
Adding and removing topics
You have the option of either adding topics manually or having them be created automatically when data is first published to a non-existent topic. If topics are auto-created then you may want to tune the default topic configurations used for auto-created topics.
Topics are added and modified using the topic tool:

$ bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic my_topic_name \
    --partitions 20 --replication-factor 3 --config x=y
The replication factor controls how many servers will replicate each message that is written. If you have a replication factor of 3 then up to 2 servers can fail before you will lose access to your data. We recommend you use a replication factor of 2 or 3 so that you can transparently bounce machines without interrupting data consumption.
The partition count controls how many logs the topic will be sharded into. There are several impacts of the partition count. First each partition must fit entirely on a single server. So if you have 20 partitions the full data set (and read and write load) will be handled by no more than 20 servers (not counting replicas). Finally the partition count impacts the maximum parallelism of your consumers. This is discussed in greater detail in the concepts section.

Each sharded partition log is placed into its own folder under the Kafka log directory. The name of such folders consists of the topic name, appended by a dash (-) and the partition id. Since a typical folder name can not be over 255 characters long, there will be a limitation on the length of topic names. We assume the number of partitions will not ever be above 100,000. Therefore, topic names cannot be longer than 249 characters. This leaves just enough room in the folder name for a dash and a potentially 5 digit long partition id.

The configurations added on the command line override the default settings the server has for things like the length of time data should be retained. The complete set of per-topic configurations is documented here.

Modifying topics
You can change the configuration or partitioning of a topic using the same topic tool.
To add partitions you can do

$ bin/kafka-topics.sh --bootstrap-server localhost:9092 --alter --topic my_topic_name \
    --partitions 40
Be aware that one use case for partitions is to semantically partition data, and adding partitions doesn't change the partitioning of existing data so this may disturb consumers if they rely on that partition. That is if data is partitioned by hash(key) % number_of_partitions then this partitioning will potentially be shuffled by adding partitions but Kafka will not attempt to automatically redistribute data in any way.
To add configs:

$ bin/kafka-configs.sh --bootstrap-server localhost:9092 --entity-type topics --entity-name my_topic_name --alter --add-config x=y
To remove a config:
$ bin/kafka-configs.sh --bootstrap-server localhost:9092 --entity-type topics --entity-name my_topic_name --alter --delete-config x
And finally deleting a topic:
$ bin/kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic my_topic_name
Kafka does not currently support reducing the number of partitions for a topic.

Instructions for changing the replication factor of a topic can be found here.

Graceful shutdown
The Kafka cluster will automatically detect any broker shutdown or failure and elect new leaders for the partitions on that machine. This will occur whether a server fails or it is brought down intentionally for maintenance or configuration changes. For the latter cases Kafka supports a more graceful mechanism for stopping a server than just killing it. When a server is stopped gracefully it has two optimizations it will take advantage of:
It will sync all its logs to disk to avoid needing to do any log recovery when it restarts (i.e. validating the checksum for all messages in the tail of the log). Log recovery takes time so this speeds up intentional restarts.
It will migrate any partitions the server is the leader for to other replicas prior to shutting down. This will make the leadership transfer faster and minimize the time each partition is unavailable to a few milliseconds.
Syncing the logs will happen automatically whenever the server is stopped other than by a hard kill, but the controlled leadership migration requires using a special setting:
controlled.shutdown.enable=true
Note that controlled shutdown will only succeed if all the partitions hosted on the broker have replicas (i.e. the replication factor is greater than 1 and at least one of these replicas is alive). This is generally what you want since shutting down the last replica would make that topic partition unavailable.
Balancing leadership
Whenever a broker stops or crashes, leadership for that broker's partitions transfers to other replicas. When the broker is restarted it will only be a follower for all its partitions, meaning it will not be used for client reads and writes.
To avoid this imbalance, Kafka has a notion of preferred replicas. If the list of replicas for a partition is 1,5,9 then node 1 is preferred as the leader to either node 5 or 9 because it is earlier in the replica list. By default the Kafka cluster will try to restore leadership to the preferred replicas. This behaviour is configured with:

auto.leader.rebalance.enable=true
You can also set this to false, but you will then need to manually restore leadership to the restored replicas by running the command:
$ bin/kafka-leader-election.sh --bootstrap-server localhost:9092 --election-type preferred --all-topic-partitions
Balancing Replicas Across Racks
The rack awareness feature spreads replicas of the same partition across different racks. This extends the guarantees Kafka provides for broker-failure to cover rack-failure, limiting the risk of data loss should all the brokers on a rack fail at once. The feature can also be applied to other broker groupings such as availability zones in EC2.
You can specify that a broker belongs to a particular rack by adding a property to the broker config:
broker.rack=my-rack-id
When a topic is created, modified or replicas are redistributed, the rack constraint will be honoured, ensuring replicas span as many racks as they can (a partition will span min(#racks, replication-factor) different racks).
The algorithm used to assign replicas to brokers ensures that the number of leaders per broker will be constant, regardless of how brokers are distributed across racks. This ensures balanced throughput.
However if racks are assigned different numbers of brokers, the assignment of replicas will not be even. Racks with fewer brokers will get more replicas, meaning they will use more storage and put more resources into replication. Hence it is sensible to configure an equal number of brokers per rack.
Mirroring data between clusters & Geo-replication
Kafka administrators can define data flows that cross the boundaries of individual Kafka clusters, data centers, or geographical regions. Please refer to the section on Geo-Replication for further information.

Checking consumer position
Sometimes it's useful to see the position of your consumers. We have a tool that will show the position of all consumers in a consumer group as well as how far behind the end of the log they are. To run this tool on a consumer group named my-group consuming a topic named my-topic would look like this:
$ bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my-group
TOPIC                          PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG        CONSUMER-ID                                       HOST                           CLIENT-ID
my-topic                       0          2               4               2          consumer-1-029af89c-873c-4751-a720-cefd41a669d6   /127.0.0.1                     consumer-1
my-topic                       1          2               3               1          consumer-1-029af89c-873c-4751-a720-cefd41a669d6   /127.0.0.1                     consumer-1
my-topic                       2          2               3               1          consumer-2-42c1abd4-e3b2-425d-a8bb-e1ea49b29bb2   /127.0.0.1                     consumer-2
Managing Consumer Groups
With the ConsumerGroupCommand tool, we can list, describe, or delete the consumer groups. The consumer group can be deleted manually, or automatically when the last committed offset for that group expires. Manual deletion works only if the group does not have any active members. For example, to list all consumer groups across all topics:
$ bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
test-consumer-group
To view offsets, as mentioned earlier, we "describe" the consumer group like this:
$ bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my-group
TOPIC           PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG             CONSUMER-ID                                    HOST            CLIENT-ID
topic3          0          241019          395308          154289          consumer2-e76ea8c3-5d30-4299-9005-47eb41f3d3c4 /127.0.0.1      consumer2
topic2          1          520678          803288          282610          consumer2-e76ea8c3-5d30-4299-9005-47eb41f3d3c4 /127.0.0.1      consumer2
topic3          1          241018          398817          157799          consumer2-e76ea8c3-5d30-4299-9005-47eb41f3d3c4 /127.0.0.1      consumer2
topic1          0          854144          855809          1665            consumer1-3fc8d6f1-581a-4472-bdf3-3515b4aee8c1 /127.0.0.1      consumer1
topic2          0          460537          803290          342753          consumer1-3fc8d6f1-581a-4472-bdf3-3515b4aee8c1 /127.0.0.1      consumer1
topic3          2          243655          398812          155157          consumer4-117fe4d3-c6c1-4178-8ee9-eb4a3954bee0 /127.0.0.1      consumer4
There are a number of additional "describe" options that can be used to provide more detailed information about a consumer group:
--members: This option provides the list of all active members in the consumer group.
$ bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my-group --members
CONSUMER-ID                                    HOST            CLIENT-ID       #PARTITIONS
consumer1-3fc8d6f1-581a-4472-bdf3-3515b4aee8c1 /127.0.0.1      consumer1       2
consumer4-117fe4d3-c6c1-4178-8ee9-eb4a3954bee0 /127.0.0.1      consumer4       1
consumer2-e76ea8c3-5d30-4299-9005-47eb41f3d3c4 /127.0.0.1      consumer2       3
consumer3-ecea43e4-1f01-479f-8349-f9130b75d8ee /127.0.0.1      consumer3       0
--members --verbose: On top of the information reported by the "--members" options above, this option also provides the partitions assigned to each member.
$ bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my-group --members --verbose
CONSUMER-ID                                    HOST            CLIENT-ID       #PARTITIONS     ASSIGNMENT
consumer1-3fc8d6f1-581a-4472-bdf3-3515b4aee8c1 /127.0.0.1      consumer1       2               topic1(0), topic2(0)
consumer4-117fe4d3-c6c1-4178-8ee9-eb4a3954bee0 /127.0.0.1      consumer4       1               topic3(2)
consumer2-e76ea8c3-5d30-4299-9005-47eb41f3d3c4 /127.0.0.1      consumer2       3               topic2(1), topic3(0,1)
consumer3-ecea43e4-1f01-479f-8349-f9130b75d8ee /127.0.0.1      consumer3       0               -
--offsets: This is the default describe option and provides the same output as the "--describe" option.
--state: This option provides useful group-level information.
$ bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my-group --state
COORDINATOR (ID)          ASSIGNMENT-STRATEGY       STATE                #MEMBERS
localhost:9092 (0)        range                     Stable               4
To manually delete one or multiple consumer groups, the "--delete" option can be used:
$ bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --delete --group my-group --group my-other-group
Deletion of requested consumer groups ('my-group', 'my-other-group') was successful.
To reset offsets of a consumer group, "--reset-offsets" option can be used. This option supports one consumer group at the time. It requires defining following scopes: --all-topics or --topic. One scope must be selected, unless you use '--from-file' scenario. Also, first make sure that the consumer instances are inactive. See KIP-122 for more details.

It has 3 execution options:

(default) to display which offsets to reset.
--execute : to execute --reset-offsets process.
--export : to export the results to a CSV format.
--reset-offsets also has the following scenarios to choose from (at least one scenario must be selected):

--to-datetime <String: datetime> : Reset offsets to offsets from datetime. Format: 'YYYY-MM-DDTHH:mm:SS.sss'
--to-earliest : Reset offsets to earliest offset.
--to-latest : Reset offsets to latest offset.
--shift-by <Long: number-of-offsets> : Reset offsets shifting current offset by 'n', where 'n' can be positive or negative.
--from-file : Reset offsets to values defined in CSV file.
--to-current : Resets offsets to current offset.
--by-duration <String: duration> : Reset offsets to offset by duration from current timestamp. Format: 'PnDTnHnMnS'
--to-offset : Reset offsets to a specific offset.
Please note, that out of range offsets will be adjusted to available offset end. For example, if offset end is at 10 and offset shift request is of 15, then, offset at 10 will actually be selected.
For example, to reset offsets of a consumer group to the latest offset:

$ bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --reset-offsets --group consumergroup1 --topic topic1 --to-latest
TOPIC                          PARTITION  NEW-OFFSET
topic1                         0          0

Expanding your cluster
Adding servers to a Kafka cluster is easy, just assign them a unique broker id and start up Kafka on your new servers. However these new servers will not automatically be assigned any data partitions, so unless partitions are moved to them they won't be doing any work until new topics are created. So usually when you add machines to your cluster you will want to migrate some existing data to these machines.
The process of migrating data is manually initiated but fully automated. Under the covers what happens is that Kafka will add the new server as a follower of the partition it is migrating and allow it to fully replicate the existing data in that partition. When the new server has fully replicated the contents of this partition and joined the in-sync replica one of the existing replicas will delete their partition's data.

The partition reassignment tool can be used to move partitions across brokers. An ideal partition distribution would ensure even data load and partition sizes across all brokers. The partition reassignment tool does not have the capability to automatically study the data distribution in a Kafka cluster and move partitions around to attain an even load distribution. As such, the admin has to figure out which topics or partitions should be moved around.

The partition reassignment tool can run in 3 mutually exclusive modes:

--generate: In this mode, given a list of topics and a list of brokers, the tool generates a candidate reassignment to move all partitions of the specified topics to the new brokers. This option merely provides a convenient way to generate a partition reassignment plan given a list of topics and target brokers.
--execute: In this mode, the tool kicks off the reassignment of partitions based on the user provided reassignment plan. (using the --reassignment-json-file option). This can either be a custom reassignment plan hand crafted by the admin or provided by using the --generate option
--verify: In this mode, the tool verifies the status of the reassignment for all partitions listed during the last --execute. The status can be either of successfully completed, failed or in progress
Automatically migrating data to new machines
The partition reassignment tool can be used to move some topics off of the current set of brokers to the newly added brokers. This is typically useful while expanding an existing cluster since it is easier to move entire topics to the new set of brokers, than moving one partition at a time. When used to do this, the user should provide a list of topics that should be moved to the new set of brokers and a target list of new brokers. The tool then evenly distributes all partitions for the given list of topics across the new set of brokers. During this move, the replication factor of the topic is kept constant. Effectively the replicas for all partitions for the input list of topics are moved from the old set of brokers to the newly added brokers.
For instance, the following example will move all partitions for topics foo1,foo2 to the new set of brokers 5,6. At the end of this move, all partitions for topics foo1 and foo2 will only exist on brokers 5,6.

Since the tool accepts the input list of topics as a json file, you first need to identify the topics you want to move and create the json file as follows:

$ cat topics-to-move.json
{
  "topics": [
    { "topic": "foo1" },
    { "topic": "foo2" }
  ],
  "version": 1
}
Once the json file is ready, use the partition reassignment tool to generate a candidate assignment:
$ bin/kafka-reassign-partitions.sh --bootstrap-server localhost:9092 --topics-to-move-json-file topics-to-move.json --broker-list "5,6" --generate
Current partition replica assignment
{"version":1,
 "partitions":[{"topic":"foo1","partition":0,"replicas":[2,1],"log_dirs":["any"]},
               {"topic":"foo1","partition":1,"replicas":[1,3],"log_dirs":["any"]},
               {"topic":"foo1","partition":2,"replicas":[3,4],"log_dirs":["any"]},
               {"topic":"foo2","partition":0,"replicas":[4,2],"log_dirs":["any"]},
               {"topic":"foo2","partition":1,"replicas":[2,1],"log_dirs":["any"]},
               {"topic":"foo2","partition":2,"replicas":[1,3],"log_dirs":["any"]}]
}

Proposed partition reassignment configuration
{"version":1,
 "partitions":[{"topic":"foo1","partition":0,"replicas":[6,5],"log_dirs":["any"]},
               {"topic":"foo1","partition":1,"replicas":[5,6],"log_dirs":["any"]},
               {"topic":"foo1","partition":2,"replicas":[6,5],"log_dirs":["any"]},
               {"topic":"foo2","partition":0,"replicas":[5,6],"log_dirs":["any"]},
               {"topic":"foo2","partition":1,"replicas":[6,5],"log_dirs":["any"]},
               {"topic":"foo2","partition":2,"replicas":[5,6],"log_dirs":["any"]}]
}
The tool generates a candidate assignment that will move all partitions from topics foo1,foo2 to brokers 5,6. Note, however, that at this point, the partition movement has not started, it merely tells you the current assignment and the proposed new assignment. The current assignment should be saved in case you want to rollback to it. The new assignment should be saved in a json file (e.g. expand-cluster-reassignment.json) to be input to the tool with the --execute option as follows:

$ bin/kafka-reassign-partitions.sh --bootstrap-server localhost:9092 --reassignment-json-file expand-cluster-reassignment.json --execute
Current partition replica assignment

{"version":1,
 "partitions":[{"topic":"foo1","partition":0,"replicas":[2,1],"log_dirs":["any"]},
               {"topic":"foo1","partition":1,"replicas":[1,3],"log_dirs":["any"]},
               {"topic":"foo1","partition":2,"replicas":[3,4],"log_dirs":["any"]},
               {"topic":"foo2","partition":0,"replicas":[4,2],"log_dirs":["any"]},
               {"topic":"foo2","partition":1,"replicas":[2,1],"log_dirs":["any"]},
               {"topic":"foo2","partition":2,"replicas":[1,3],"log_dirs":["any"]}]
}

Save this to use as the --reassignment-json-file option during rollback
Successfully started partition reassignments for foo1-0,foo1-1,foo1-2,foo2-0,foo2-1,foo2-2
Finally, the --verify option can be used with the tool to check the status of the partition reassignment. Note that the same expand-cluster-reassignment.json (used with the --execute option) should be used with the --verify option:

$ bin/kafka-reassign-partitions.sh --bootstrap-server localhost:9092 --reassignment-json-file expand-cluster-reassignment.json --verify
Status of partition reassignment:
Reassignment of partition [foo1,0] is completed
Reassignment of partition [foo1,1] is still in progress
Reassignment of partition [foo1,2] is still in progress
Reassignment of partition [foo2,0] is completed
Reassignment of partition [foo2,1] is completed
Reassignment of partition [foo2,2] is completed
Custom partition assignment and migration
The partition reassignment tool can also be used to selectively move replicas of a partition to a specific set of brokers. When used in this manner, it is assumed that the user knows the reassignment plan and does not require the tool to generate a candidate reassignment, effectively skipping the --generate step and moving straight to the --execute step
For instance, the following example moves partition 0 of topic foo1 to brokers 5,6 and partition 1 of topic foo2 to brokers 2,3:

The first step is to hand craft the custom reassignment plan in a json file:

$ cat custom-reassignment.json
{"version":1,"partitions":[{"topic":"foo1","partition":0,"replicas":[5,6]},{"topic":"foo2","partition":1,"replicas":[2,3]}]}
Then, use the json file with the --execute option to start the reassignment process:
$ bin/kafka-reassign-partitions.sh --bootstrap-server localhost:9092 --reassignment-json-file custom-reassignment.json --execute
Current partition replica assignment

{"version":1,
 "partitions":[{"topic":"foo1","partition":0,"replicas":[1,2],"log_dirs":["any"]},
               {"topic":"foo2","partition":1,"replicas":[3,4],"log_dirs":["any"]}]
}

Save this to use as the --reassignment-json-file option during rollback
Successfully started partition reassignments for foo1-0,foo2-1
The --verify option can be used with the tool to check the status of the partition reassignment. Note that the same custom-reassignment.json (used with the --execute option) should be used with the --verify option:

$ bin/kafka-reassign-partitions.sh --bootstrap-server localhost:9092 --reassignment-json-file custom-reassignment.json --verify
Status of partition reassignment:
Reassignment of partition [foo1,0] is completed
Reassignment of partition [foo2,1] is completed
Decommissioning brokers
The partition reassignment tool does not have the ability to automatically generate a reassignment plan for decommissioning brokers yet. As such, the admin has to come up with a reassignment plan to move the replica for all partitions hosted on the broker to be decommissioned, to the rest of the brokers. This can be relatively tedious as the reassignment needs to ensure that all the replicas are not moved from the decommissioned broker to only one other broker. To make this process effortless, we plan to add tooling support for decommissioning brokers in the future.
Increasing replication factor
Increasing the replication factor of an existing partition is easy. Just specify the extra replicas in the custom reassignment json file and use it with the --execute option to increase the replication factor of the specified partitions.
For instance, the following example increases the replication factor of partition 0 of topic foo from 1 to 3. Before increasing the replication factor, the partition's only replica existed on broker 5. As part of increasing the replication factor, we will add more replicas on brokers 6 and 7.

The first step is to hand craft the custom reassignment plan in a json file:

$ cat increase-replication-factor.json
{"version":1,
 "partitions":[{"topic":"foo","partition":0,"replicas":[5,6,7]}]}
Then, use the json file with the --execute option to start the reassignment process:
$ bin/kafka-reassign-partitions.sh --bootstrap-server localhost:9092 --reassignment-json-file increase-replication-factor.json --execute
Current partition replica assignment

{"version":1,
 "partitions":[{"topic":"foo","partition":0,"replicas":[5],"log_dirs":["any"]}]}

Save this to use as the --reassignment-json-file option during rollback
Successfully started partition reassignment for foo-0
The --verify option can be used with the tool to check the status of the partition reassignment. Note that the same increase-replication-factor.json (used with the --execute option) should be used with the --verify option:

$ bin/kafka-reassign-partitions.sh --bootstrap-server localhost:9092 --reassignment-json-file increase-replication-factor.json --verify
Status of partition reassignment:
Reassignment of partition [foo,0] is completed
You can also verify the increase in replication factor with the kafka-topics tool:
$ bin/kafka-topics.sh --bootstrap-server localhost:9092 --topic foo --describe
Topic:foo	PartitionCount:1	ReplicationFactor:3	Configs:
  Topic: foo	Partition: 0	Leader: 5	Replicas: 5,6,7	Isr: 5,6,7
Limiting Bandwidth Usage during Data Migration
Kafka lets you apply a throttle to replication traffic, setting an upper bound on the bandwidth used to move replicas from machine to machine and from disk to disk. This is useful when rebalancing a cluster, adding or removing brokers or adding or removing disks, as it limits the impact these data-intensive operations will have on users.
There are two interfaces that can be used to engage a throttle. The simplest, and safest, is to apply a throttle when invoking the kafka-reassign-partitions.sh, but kafka-configs.sh can also be used to view and alter the throttle values directly.
So for example, if you were to execute a rebalance, with the below command, it would move partitions at no more than 50MB/s between brokers, and at no more than 100MB/s between disks on a broker.
$ bin/kafka-reassign-partitions.sh --bootstrap-server localhost:9092 --execute --reassignment-json-file bigger-cluster.json --throttle 50000000 --replica-alter-log-dirs-throttle 100000000
When you execute this script you will see the throttle engage:
The inter-broker throttle limit was set to 50000000 B/s
The replica-alter-dir throttle limit was set to 100000000 B/s
Successfully started partition reassignment for foo1-0
Should you wish to alter the throttle, during a rebalance, say to increase the inter-broker throughput so it completes quicker, you can do this by re-running the execute command with the --additional option passing the same reassignment-json-file:

$ bin/kafka-reassign-partitions.sh --bootstrap-server localhost:9092 --additional --execute --reassignment-json-file bigger-cluster.json --throttle 700000000
The inter-broker throttle limit was set to 700000000 B/s
Once the rebalance completes the administrator can check the status of the rebalance using the --verify option. If the rebalance has completed, the throttle will be removed via the --verify command. It is important that administrators remove the throttle in a timely manner once rebalancing completes by running the command with the --verify option. Failure to do so could cause regular replication traffic to be throttled.

When the --verify option is executed, and the reassignment has completed, the script will confirm that the throttle was removed:

$ bin/kafka-reassign-partitions.sh --bootstrap-server localhost:9092 --verify --reassignment-json-file bigger-cluster.json
Status of partition reassignment:
Reassignment of partition [my-topic,1] is completed
Reassignment of partition [my-topic,0] is completed

Clearing broker-level throttles on brokers 1,2,3
Clearing topic-level throttles on topic my-topic
The administrator can also validate the assigned configs using the kafka-configs.sh. There are two sets of throttle configuration used to manage the throttling process. First set refers to the throttle value itself. This is configured, at a broker level, using the dynamic properties:

leader.replication.throttled.rate
follower.replication.throttled.rate
replica.alter.log.dirs.io.max.bytes.per.second
Then there is the configuration pair of enumerated sets of throttled replicas:

leader.replication.throttled.replicas
follower.replication.throttled.replicas
Which are configured per topic.

All five config values are automatically assigned by kafka-reassign-partitions.sh (discussed below).

To view the throttle limit configuration:

$ bin/kafka-configs.sh --describe --bootstrap-server localhost:9092 --entity-type brokers
Configs for brokers '2' are leader.replication.throttled.rate=700000000,follower.replication.throttled.rate=700000000,replica.alter.log.dirs.io.max.bytes.per.second=1000000000
Configs for brokers '1' are leader.replication.throttled.rate=700000000,follower.replication.throttled.rate=700000000,replica.alter.log.dirs.io.max.bytes.per.second=1000000000
This shows the throttle applied to both leader and follower side of the replication protocol (by default both sides are assigned the same throttled throughput value), as well as the disk throttle.

To view the list of throttled replicas:

$ bin/kafka-configs.sh --describe --bootstrap-server localhost:9092 --entity-type topics
Configs for topic 'my-topic' are leader.replication.throttled.replicas=1:102,0:101,
    follower.replication.throttled.replicas=1:101,0:102
Here we see the leader throttle is applied to partition 1 on broker 102 and partition 0 on broker 101. Likewise the follower throttle is applied to partition 1 on broker 101 and partition 0 on broker 102.

By default kafka-reassign-partitions.sh will apply the leader throttle to all replicas that exist before the rebalance, any one of which might be leader. It will apply the follower throttle to all move destinations. So if there is a partition with replicas on brokers 101,102, being reassigned to 102,103, a leader throttle, for that partition, would be applied to 101,102 and a follower throttle would be applied to 103 only.

If required, you can also use the --alter switch on kafka-configs.sh to alter the throttle configurations manually.

Safe usage of throttled replication
Some care should be taken when using throttled replication. In particular:

(1) Throttle Removal:

The throttle should be removed in a timely manner once reassignment completes (by running kafka-reassign-partitions.sh --verify).
(2) Ensuring Progress:

If the throttle is set too low, in comparison to the incoming write rate, it is possible for replication to not make progress. This occurs when:

max(BytesInPerSec) > throttle
Where BytesInPerSec is the metric that monitors the write throughput of producers into each broker.

The administrator can monitor whether replication is making progress, during the rebalance, using the metric:

kafka.server:type=FetcherLagMetrics,name=ConsumerLag,clientId=([-.\w]+),topic=([-.\w]+),partition=([0-9]+)
The lag should constantly decrease during replication. If the metric does not decrease the administrator should increase the throttle throughput as described above.

Setting quotas
Quotas overrides and defaults may be configured at (user, client-id), user or client-id levels as described here. By default, clients receive an unlimited quota. It is possible to set custom quotas for each (user, client-id), user or client-id group.
Configure custom quota for (user=user1, client-id=clientA):

$ bin/kafka-configs.sh --bootstrap-server localhost:9092 --alter --add-config 'producer_byte_rate=1024,consumer_byte_rate=2048,request_percentage=200' --entity-type users --entity-name user1 --entity-type clients --entity-name clientA
Updated config for entity: user-principal 'user1', client-id 'clientA'.
Configure custom quota for user=user1:
$ bin/kafka-configs.sh --bootstrap-server localhost:9092 --alter --add-config 'producer_byte_rate=1024,consumer_byte_rate=2048,request_percentage=200' --entity-type users --entity-name user1
Updated config for entity: user-principal 'user1'.
Configure custom quota for client-id=clientA:
$ bin/kafka-configs.sh --bootstrap-server localhost:9092 --alter --add-config 'producer_byte_rate=1024,consumer_byte_rate=2048,request_percentage=200' --entity-type clients --entity-name clientA
Updated config for entity: client-id 'clientA'.
It is possible to set default quotas for each (user, client-id), user or client-id group by specifying --entity-default option instead of --entity-name.
Configure default client-id quota for user=userA:

$ bin/kafka-configs.sh --bootstrap-server localhost:9092 --alter --add-config 'producer_byte_rate=1024,consumer_byte_rate=2048,request_percentage=200' --entity-type users --entity-name user1 --entity-type clients --entity-default
Updated config for entity: user-principal 'user1', default client-id.
Configure default quota for user:
$ bin/kafka-configs.sh --bootstrap-server localhost:9092 --alter --add-config 'producer_byte_rate=1024,consumer_byte_rate=2048,request_percentage=200' --entity-type users --entity-default
Updated config for entity: default user-principal.
Configure default quota for client-id:
$ bin/kafka-configs.sh --bootstrap-server localhost:9092 --alter --add-config 'producer_byte_rate=1024,consumer_byte_rate=2048,request_percentage=200' --entity-type clients --entity-default
Updated config for entity: default client-id.
Here's how to describe the quota for a given (user, client-id):
$ bin/kafka-configs.sh --bootstrap-server localhost:9092 --describe --entity-type users --entity-name user1 --entity-type clients --entity-name clientA
Configs for user-principal 'user1', client-id 'clientA' are producer_byte_rate=1024,consumer_byte_rate=2048,request_percentage=200
Describe quota for a given user:
$ bin/kafka-configs.sh --bootstrap-server localhost:9092 --describe --entity-type users --entity-name user1
Configs for user-principal 'user1' are producer_byte_rate=1024,consumer_byte_rate=2048,request_percentage=200
Describe quota for a given client-id:
$ bin/kafka-configs.sh --bootstrap-server localhost:9092 --describe --entity-type clients --entity-name clientA
Configs for client-id 'clientA' are producer_byte_rate=1024,consumer_byte_rate=2048,request_percentage=200
If entity name is not specified, all entities of the specified type are described. For example, describe all users:
$ bin/kafka-configs.sh --bootstrap-server localhost:9092 --describe --entity-type users
Configs for user-principal 'user1' are producer_byte_rate=1024,consumer_byte_rate=2048,request_percentage=200
Configs for default user-principal are producer_byte_rate=1024,consumer_byte_rate=2048,request_percentage=200
Similarly for (user, client):
$ bin/kafka-configs.sh --bootstrap-server localhost:9092 --describe --entity-type users --entity-type clients
Configs for user-principal 'user1', default client-id are producer_byte_rate=1024,consumer_byte_rate=2048,request_percentage=200
Configs for user-principal 'user1', client-id 'clientA' are producer_byte_rate=1024,consumer_byte_rate=2048,request_percentage=200
6.2 Datacenters
Some deployments will need to manage a data pipeline that spans multiple datacenters. Our recommended approach to this is to deploy a local Kafka cluster in each datacenter, with application instances in each datacenter interacting only with their local cluster and mirroring data between clusters (see the documentation on Geo-Replication for how to do this).
This deployment pattern allows datacenters to act as independent entities and allows us to manage and tune inter-datacenter replication centrally. This allows each facility to stand alone and operate even if the inter-datacenter links are unavailable: when this occurs the mirroring falls behind until the link is restored at which time it catches up.

For applications that need a global view of all data you can use mirroring to provide clusters which have aggregate data mirrored from the local clusters in all datacenters. These aggregate clusters are used for reads by applications that require the full data set.

This is not the only possible deployment pattern. It is possible to read from or write to a remote Kafka cluster over the WAN, though obviously this will add whatever latency is required to get the cluster.

Kafka naturally batches data in both the producer and consumer so it can achieve high-throughput even over a high-latency connection. To allow this though it may be necessary to increase the TCP socket buffer sizes for the producer, consumer, and broker using the socket.send.buffer.bytes and socket.receive.buffer.bytes configurations. The appropriate way to set this is documented here.

It is generally not advisable to run a single Kafka cluster that spans multiple datacenters over a high-latency link. This will incur very high replication latency both for Kafka writes and ZooKeeper writes, and neither Kafka nor ZooKeeper will remain available in all locations if the network between locations is unavailable.

6.3 Geo-Replication (Cross-Cluster Data Mirroring)
Geo-Replication Overview
Kafka administrators can define data flows that cross the boundaries of individual Kafka clusters, data centers, or geo-regions. Such event streaming setups are often needed for organizational, technical, or legal requirements. Common scenarios include:

Geo-replication
Disaster recovery
Feeding edge clusters into a central, aggregate cluster
Physical isolation of clusters (such as production vs. testing)
Cloud migration or hybrid cloud deployments
Legal and compliance requirements
Administrators can set up such inter-cluster data flows with Kafka's MirrorMaker (version 2), a tool to replicate data between different Kafka environments in a streaming manner. MirrorMaker is built on top of the Kafka Connect framework and supports features such as:

Replicates topics (data plus configurations)
Replicates consumer groups including offsets to migrate applications between clusters
Replicates ACLs
Preserves partitioning
Automatically detects new topics and partitions
Provides a wide range of metrics, such as end-to-end replication latency across multiple data centers/clusters
Fault-tolerant and horizontally scalable operations
Note: Geo-replication with MirrorMaker replicates data across Kafka clusters. This inter-cluster replication is different from Kafka's intra-cluster replication, which replicates data within the same Kafka cluster.

What Are Replication Flows
With MirrorMaker, Kafka administrators can replicate topics, topic configurations, consumer groups and their offsets, and ACLs from one or more source Kafka clusters to one or more target Kafka clusters, i.e., across cluster environments. In a nutshell, MirrorMaker uses Connectors to consume from source clusters and produce to target clusters.

These directional flows from source to target clusters are called replication flows. They are defined with the format {source_cluster}->{target_cluster} in the MirrorMaker configuration file as described later. Administrators can create complex replication topologies based on these flows.

Here are some example patterns:

Active/Active high availability deployments: A->B, B->A
Active/Passive or Active/Standby high availability deployments: A->B
Aggregation (e.g., from many clusters to one): A->K, B->K, C->K
Fan-out (e.g., from one to many clusters): K->A, K->B, K->C
Forwarding: A->B, B->C, C->D
By default, a flow replicates all topics and consumer groups (except excluded ones). However, each replication flow can be configured independently. For instance, you can define that only specific topics or consumer groups are replicated from the source cluster to the target cluster.

Here is a first example on how to configure data replication from a primary cluster to a secondary cluster (an active/passive setup):

# Basic settings
clusters = primary, secondary
primary.bootstrap.servers = broker3-primary:9092
secondary.bootstrap.servers = broker5-secondary:9092

# Define replication flows
primary->secondary.enabled = true
primary->secondary.topics = foobar-topic, quux-.*
Configuring Geo-Replication
The following sections describe how to configure and run a dedicated MirrorMaker cluster. If you want to run MirrorMaker within an existing Kafka Connect cluster or other supported deployment setups, please refer to KIP-382: MirrorMaker 2.0 and be aware that the names of configuration settings may vary between deployment modes.

Beyond what's covered in the following sections, further examples and information on configuration settings are available at:

MirrorMakerConfig, MirrorConnectorConfig
DefaultTopicFilter for topics, DefaultGroupFilter for consumer groups
Example configuration settings in connect-mirror-maker.properties, KIP-382: MirrorMaker 2.0
Configuration File Syntax
The MirrorMaker configuration file is typically named connect-mirror-maker.properties. You can configure a variety of components in this file:

MirrorMaker settings: global settings including cluster definitions (aliases), plus custom settings per replication flow
Kafka Connect and connector settings
Kafka producer, consumer, and admin client settings
Example: Define MirrorMaker settings (explained in more detail later).

# Global settings
clusters = us-west, us-east   # defines cluster aliases
us-west.bootstrap.servers = broker3-west:9092
us-east.bootstrap.servers = broker5-east:9092

topics = .*   # all topics to be replicated by default

# Specific replication flow settings (here: flow from us-west to us-east)
us-west->us-east.enabled = true
us-west->us.east.topics = foo.*, bar.*  # override the default above
MirrorMaker is based on the Kafka Connect framework. Any Kafka Connect, source connector, and sink connector settings as described in the documentation chapter on Kafka Connect can be used directly in the MirrorMaker configuration, without having to change or prefix the name of the configuration setting.

Example: Define custom Kafka Connect settings to be used by MirrorMaker.

# Setting Kafka Connect defaults for MirrorMaker
tasks.max = 5
Most of the default Kafka Connect settings work well for MirrorMaker out-of-the-box, with the exception of tasks.max. In order to evenly distribute the workload across more than one MirrorMaker process, it is recommended to set tasks.max to at least 2 (preferably higher) depending on the available hardware resources and the total number of topic-partitions to be replicated.

You can further customize MirrorMaker's Kafka Connect settings per source or target cluster (more precisely, you can specify Kafka Connect worker-level configuration settings "per connector"). Use the format of {cluster}.{config_name} in the MirrorMaker configuration file.

Example: Define custom connector settings for the us-west cluster.

# us-west custom settings
us-west.offset.storage.topic = my-mirrormaker-offsets
MirrorMaker internally uses the Kafka producer, consumer, and admin clients. Custom settings for these clients are often needed. To override the defaults, use the following format in the MirrorMaker configuration file:

{source}.consumer.{consumer_config_name}
{target}.producer.{producer_config_name}
{source_or_target}.admin.{admin_config_name}
Example: Define custom producer, consumer, admin client settings.

# us-west cluster (from which to consume)
us-west.consumer.isolation.level = read_committed
us-west.admin.bootstrap.servers = broker57-primary:9092

# us-east cluster (to which to produce)
us-east.producer.compression.type = gzip
us-east.producer.buffer.memory = 32768
us-east.admin.bootstrap.servers = broker8-secondary:9092
Exactly once
Exactly-once semantics are supported for dedicated MirrorMaker clusters as of version 3.5.0.

For new MirrorMaker clusters, set the exactly.once.source.support property to enabled for all targeted Kafka clusters that should be written to with exactly-once semantics. For example, to enable exactly-once for writes to cluster us-east, the following configuration can be used:

us-east.exactly.once.source.support = enabled
For existing MirrorMaker clusters, a two-step upgrade is necessary. Instead of immediately setting the exactly.once.source.support property to enabled, first set it to preparing on all nodes in the cluster. Once this is complete, it can be set to enabled on all nodes in the cluster, in a second round of restarts.

In either case, it is also necessary to enable intra-cluster communication between the MirrorMaker nodes, as described in KIP-710. To do this, the dedicated.mode.enable.internal.rest property must be set to true. In addition, many of the REST-related configuration properties available for Kafka Connect can be specified the MirrorMaker config. For example, to enable intra-cluster communication in MirrorMaker cluster with each node listening on port 8080 of their local machine, the following should be added to the MirrorMaker config file:

dedicated.mode.enable.internal.rest = true
listeners = http://localhost:8080
Note that, if intra-cluster communication is enabled in production environments, it is highly recommended to secure the REST servers brought up by each MirrorMaker node. See the configuration properties for Kafka Connect for information on how this can be accomplished.

It is also recommended to filter records from aborted transactions out from replicated data when running MirrorMaker. To do this, ensure that the consumer used to read from source clusters is configured with isolation.level set to read_committed. If replicating data from cluster us-west, this can be done for all replication flows that read from that cluster by adding the following to the MirrorMaker config file:

us-west.consumer.isolation.level = read_committed
As a final note, under the hood, MirrorMaker uses Kafka Connect source connectors to replicate data. For more information on exactly-once support for these kinds of connectors, see the relevant docs page.

Creating and Enabling Replication Flows
To define a replication flow, you must first define the respective source and target Kafka clusters in the MirrorMaker configuration file.

clusters (required): comma-separated list of Kafka cluster "aliases"
{clusterAlias}.bootstrap.servers (required): connection information for the specific cluster; comma-separated list of "bootstrap" Kafka brokers
Example: Define two cluster aliases primary and secondary, including their connection information.

clusters = primary, secondary
primary.bootstrap.servers = broker10-primary:9092,broker-11-primary:9092
secondary.bootstrap.servers = broker5-secondary:9092,broker6-secondary:9092
Secondly, you must explicitly enable individual replication flows with {source}->{target}.enabled = true as needed. Remember that flows are directional: if you need two-way (bidirectional) replication, you must enable flows in both directions.

# Enable replication from primary to secondary
primary->secondary.enabled = true
By default, a replication flow will replicate all but a few special topics and consumer groups from the source cluster to the target cluster, and automatically detect any newly created topics and groups. The names of replicated topics in the target cluster will be prefixed with the name of the source cluster (see section further below). For example, the topic foo in the source cluster us-west would be replicated to a topic named us-west.foo in the target cluster us-east.

The subsequent sections explain how to customize this basic setup according to your needs.

Configuring Replication Flows
The configuration of a replication flow is a combination of top-level default settings (e.g., topics), on top of which flow-specific settings, if any, are applied (e.g., us-west->us-east.topics). To change the top-level defaults, add the respective top-level setting to the MirrorMaker configuration file. To override the defaults for a specific replication flow only, use the syntax format {source}->{target}.{config.name}.

The most important settings are:

topics: list of topics or a regular expression that defines which topics in the source cluster to replicate (default: topics = .*)
topics.exclude: list of topics or a regular expression to subsequently exclude topics that were matched by the topics setting (default: topics.exclude = .*[\-\.]internal, .*\.replica, __.*)
groups: list of topics or regular expression that defines which consumer groups in the source cluster to replicate (default: groups = .*)
groups.exclude: list of topics or a regular expression to subsequently exclude consumer groups that were matched by the groups setting (default: groups.exclude = console-consumer-.*, connect-.*, __.*)
{source}->{target}.enable: set to true to enable the replication flow (default: false)
Example:

# Custom top-level defaults that apply to all replication flows
topics = .*
groups = consumer-group1, consumer-group2

# Don't forget to enable a flow!
us-west->us-east.enabled = true

# Custom settings for specific replication flows
us-west->us-east.topics = foo.*
us-west->us-east.groups = bar.*
us-west->us-east.emit.heartbeats = false
Additional configuration settings are supported which can be left with their default values in most cases. See MirrorMaker Configs.

Securing Replication Flows
MirrorMaker supports the same security settings as Kafka Connect, so please refer to the linked section for further information.

Example: Encrypt communication between MirrorMaker and the us-east cluster.

us-east.security.protocol=SSL
us-east.ssl.truststore.location=/path/to/truststore.jks
us-east.ssl.truststore.password=my-secret-password
us-east.ssl.keystore.location=/path/to/keystore.jks
us-east.ssl.keystore.password=my-secret-password
us-east.ssl.key.password=my-secret-password
Custom Naming of Replicated Topics in Target Clusters
Replicated topics in a target cluster—sometimes called remote topics—are renamed according to a replication policy. MirrorMaker uses this policy to ensure that events (aka records, messages) from different clusters are not written to the same topic-partition. By default as per DefaultReplicationPolicy, the names of replicated topics in the target clusters have the format {source}.{source_topic_name}:

us-west         us-east
=========       =================
                bar-topic
foo-topic  -->  us-west.foo-topic
You can customize the separator (default: .) with the replication.policy.separator setting:

# Defining a custom separator
us-west->us-east.replication.policy.separator = _
If you need further control over how replicated topics are named, you can implement a custom ReplicationPolicy and override replication.policy.class (default is DefaultReplicationPolicy) in the MirrorMaker configuration.

Preventing Configuration Conflicts
MirrorMaker processes share configuration via their target Kafka clusters. This behavior may cause conflicts when configurations differ among MirrorMaker processes that operate against the same target cluster.

For example, the following two MirrorMaker processes would be racy:

# Configuration of process 1
A->B.enabled = true
A->B.topics = foo

# Configuration of process 2
A->B.enabled = true
A->B.topics = bar
In this case, the two processes will share configuration via cluster B, which causes a conflict. Depending on which of the two processes is the elected "leader", the result will be that either the topic foo or the topic bar is replicated, but not both.

It is therefore important to keep the MirrorMaker configuration consistent across replication flows to the same target cluster. This can be achieved, for example, through automation tooling or by using a single, shared MirrorMaker configuration file for your entire organization.

Best Practice: Consume from Remote, Produce to Local
To minimize latency ("producer lag"), it is recommended to locate MirrorMaker processes as close as possible to their target clusters, i.e., the clusters that it produces data to. That's because Kafka producers typically struggle more with unreliable or high-latency network connections than Kafka consumers.

First DC          Second DC
==========        =========================
primary --------- MirrorMaker --> secondary
(remote)                           (local)
To run such a "consume from remote, produce to local" setup, run the MirrorMaker processes close to and preferably in the same location as the target clusters, and explicitly set these "local" clusters in the --clusters command line parameter (blank-separated list of cluster aliases):

# Run in secondary's data center, reading from the remote `primary` cluster
$ bin/connect-mirror-maker.sh connect-mirror-maker.properties --clusters secondary
The --clusters secondary tells the MirrorMaker process that the given cluster(s) are nearby, and prevents it from replicating data or sending configuration to clusters at other, remote locations.
Example: Active/Passive High Availability Deployment
The following example shows the basic settings to replicate topics from a primary to a secondary Kafka environment, but not from the secondary back to the primary. Please be aware that most production setups will need further configuration, such as security settings.

# Unidirectional flow (one-way) from primary to secondary cluster
primary.bootstrap.servers = broker1-primary:9092
secondary.bootstrap.servers = broker2-secondary:9092

primary->secondary.enabled = true
secondary->primary.enabled = false

primary->secondary.topics = foo.*  # only replicate some topics
Example: Active/Active High Availability Deployment
The following example shows the basic settings to replicate topics between two clusters in both ways. Please be aware that most production setups will need further configuration, such as security settings.

# Bidirectional flow (two-way) between us-west and us-east clusters
clusters = us-west, us-east
us-west.bootstrap.servers = broker1-west:9092,broker2-west:9092
Us-east.bootstrap.servers = broker3-east:9092,broker4-east:9092

us-west->us-east.enabled = true
us-east->us-west.enabled = true
Note on preventing replication "loops" (where topics will be originally replicated from A to B, then the replicated topics will be replicated yet again from B to A, and so forth): As long as you define the above flows in the same MirrorMaker configuration file, you do not need to explicitly add topics.exclude settings to prevent replication loops between the two clusters.

Example: Multi-Cluster Geo-Replication
Let's put all the information from the previous sections together in a larger example. Imagine there are three data centers (west, east, north), with two Kafka clusters in each data center (e.g., west-1, west-2). The example in this section shows how to configure MirrorMaker (1) for Active/Active replication within each data center, as well as (2) for Cross Data Center Replication (XDCR).

First, define the source and target clusters along with their replication flows in the configuration:

# Basic settings
clusters: west-1, west-2, east-1, east-2, north-1, north-2
west-1.bootstrap.servers = ...
west-2.bootstrap.servers = ...
east-1.bootstrap.servers = ...
east-2.bootstrap.servers = ...
north-1.bootstrap.servers = ...
north-2.bootstrap.servers = ...

# Replication flows for Active/Active in West DC
west-1->west-2.enabled = true
west-2->west-1.enabled = true

# Replication flows for Active/Active in East DC
east-1->east-2.enabled = true
east-2->east-1.enabled = true

# Replication flows for Active/Active in North DC
north-1->north-2.enabled = true
north-2->north-1.enabled = true

# Replication flows for XDCR via west-1, east-1, north-1
west-1->east-1.enabled  = true
west-1->north-1.enabled = true
east-1->west-1.enabled  = true
east-1->north-1.enabled = true
north-1->west-1.enabled = true
north-1->east-1.enabled = true
Then, in each data center, launch one or more MirrorMaker as follows:

# In West DC:
$ bin/connect-mirror-maker.sh connect-mirror-maker.properties --clusters west-1 west-2

# In East DC:
$ bin/connect-mirror-maker.sh connect-mirror-maker.properties --clusters east-1 east-2

# In North DC:
$ bin/connect-mirror-maker.sh connect-mirror-maker.properties --clusters north-1 north-2
With this configuration, records produced to any cluster will be replicated within the data center, as well as across to other data centers. By providing the --clusters parameter, we ensure that each MirrorMaker process produces data to nearby clusters only.

Note: The --clusters parameter is, technically, not required here. MirrorMaker will work fine without it. However, throughput may suffer from "producer lag" between data centers, and you may incur unnecessary data transfer costs.

Starting Geo-Replication
You can run as few or as many MirrorMaker processes (think: nodes, servers) as needed. Because MirrorMaker is based on Kafka Connect, MirrorMaker processes that are configured to replicate the same Kafka clusters run in a distributed setup: They will find each other, share configuration (see section below), load balance their work, and so on. If, for example, you want to increase the throughput of replication flows, one option is to run additional MirrorMaker processes in parallel.

To start a MirrorMaker process, run the command:

$ bin/connect-mirror-maker.sh connect-mirror-maker.properties
After startup, it may take a few minutes until a MirrorMaker process first begins to replicate data.

Optionally, as described previously, you can set the parameter --clusters to ensure that the MirrorMaker process produces data to nearby clusters only.

# Note: The cluster alias us-west must be defined in the configuration file
$ bin/connect-mirror-maker.sh connect-mirror-maker.properties \
    --clusters us-west
Note when testing replication of consumer groups: By default, MirrorMaker does not replicate consumer groups created by the kafka-console-consumer.sh tool, which you might use to test your MirrorMaker setup on the command line. If you do want to replicate these consumer groups as well, set the groups.exclude configuration accordingly (default: groups.exclude = console-consumer-.*, connect-.*, __.*). Remember to update the configuration again once you completed your testing.

Stopping Geo-Replication
You can stop a running MirrorMaker process by sending a SIGTERM signal with the command:

$ kill <MirrorMaker pid>
Applying Configuration Changes
To make configuration changes take effect, the MirrorMaker process(es) must be restarted.

Monitoring Geo-Replication
It is recommended to monitor MirrorMaker processes to ensure all defined replication flows are up and running correctly. MirrorMaker is built on the Connect framework and inherits all of Connect's metrics, such source-record-poll-rate. In addition, MirrorMaker produces its own metrics under the kafka.connect.mirror metric group. Metrics are tagged with the following properties:

source: alias of source cluster (e.g., primary)
target: alias of target cluster (e.g., secondary)
topic: replicated topic on target cluster
partition: partition being replicated
Metrics are tracked for each replicated topic. The source cluster can be inferred from the topic name. For example, replicating topic1 from primary->secondary will yield metrics like:

target=secondary
topic=primary.topic1
partition=1
The following metrics are emitted:

# MBean: kafka.connect.mirror:type=MirrorSourceConnector,target=([-.w]+),topic=([-.w]+),partition=([0-9]+)
record-count            # number of records replicated source -> target
record-age-ms           # age of records when they are replicated
record-age-ms-min
record-age-ms-max
record-age-ms-avg
replication-latency-ms  # time it takes records to propagate source->target
replication-latency-ms-min
replication-latency-ms-max
replication-latency-ms-avg
byte-rate               # average number of bytes/sec in replicated records

# MBean: kafka.connect.mirror:type=MirrorCheckpointConnector,source=([-.w]+),target=([-.w]+)

checkpoint-latency-ms   # time it takes to replicate consumer offsets
checkpoint-latency-ms-min
checkpoint-latency-ms-max
checkpoint-latency-ms-avg
These metrics do not differentiate between created-at and log-append timestamps.

6.4 Multi-Tenancy
Multi-Tenancy Overview
As a highly scalable event streaming platform, Kafka is used by many users as their central nervous system, connecting in real-time a wide range of different systems and applications from various teams and lines of businesses. Such multi-tenant cluster environments command proper control and management to ensure the peaceful coexistence of these different needs. This section highlights features and best practices to set up such shared environments, which should help you operate clusters that meet SLAs/OLAs and that minimize potential collateral damage caused by "noisy neighbors".

Multi-tenancy is a many-sided subject, including but not limited to:

Creating user spaces for tenants (sometimes called namespaces)
Configuring topics with data retention policies and more
Securing topics and clusters with encryption, authentication, and authorization
Isolating tenants with quotas and rate limits
Monitoring and metering
Inter-cluster data sharing (cf. geo-replication)
Creating User Spaces (Namespaces) For Tenants With Topic Naming
Kafka administrators operating a multi-tenant cluster typically need to define user spaces for each tenant. For the purpose of this section, "user spaces" are a collection of topics, which are grouped together under the management of a single entity or user.

In Kafka, the main unit of data is the topic. Users can create and name each topic. They can also delete them, but it is not possible to rename a topic directly. Instead, to rename a topic, the user must create a new topic, move the messages from the original topic to the new, and then delete the original. With this in mind, it is recommended to define logical spaces, based on an hierarchical topic naming structure. This setup can then be combined with security features, such as prefixed ACLs, to isolate different spaces and tenants, while also minimizing the administrative overhead for securing the data in the cluster.

These logical user spaces can be grouped in different ways, and the concrete choice depends on how your organization prefers to use your Kafka clusters. The most common groupings are as follows.

By team or organizational unit: Here, the team is the main aggregator. In an organization where teams are the main user of the Kafka infrastructure, this might be the best grouping.

Example topic naming structure:

<organization>.<team>.<dataset>.<event-name>
(e.g., "acme.infosec.telemetry.logins")
By project or product: Here, a team manages more than one project. Their credentials will be different for each project, so all the controls and settings will always be project related.

Example topic naming structure:

<project>.<product>.<event-name>
(e.g., "mobility.payments.suspicious")
Certain information should normally not be put in a topic name, such as information that is likely to change over time (e.g., the name of the intended consumer) or that is a technical detail or metadata that is available elsewhere (e.g., the topic's partition count and other configuration settings).

To enforce a topic naming structure, several options are available:

Use prefix ACLs (cf. KIP-290) to enforce a common prefix for topic names. For example, team A may only be permitted to create topics whose names start with payments.teamA..
Define a custom CreateTopicPolicy (cf. KIP-108 and the setting create.topic.policy.class.name) to enforce strict naming patterns. These policies provide the most flexibility and can cover complex patterns and rules to match an organization's needs.
Disable topic creation for normal users by denying it with an ACL, and then rely on an external process to create topics on behalf of users (e.g., scripting or your favorite automation toolkit).
It may also be useful to disable the Kafka feature to auto-create topics on demand by setting auto.create.topics.enable=false in the broker configuration. Note that you should not rely solely on this option.
Configuring Topics: Data Retention And More
Kafka's configuration is very flexible due to its fine granularity, and it supports a plethora of per-topic configuration settings to help administrators set up multi-tenant clusters. For example, administrators often need to define data retention policies to control how much and/or for how long data will be stored in a topic, with settings such as retention.bytes (size) and retention.ms (time). This limits storage consumption within the cluster, and helps complying with legal requirements such as GDPR.

Securing Clusters and Topics: Authentication, Authorization, Encryption
Because the documentation has a dedicated chapter on security that applies to any Kafka deployment, this section focuses on additional considerations for multi-tenant environments.

Security settings for Kafka fall into three main categories, which are similar to how administrators would secure other client-server data systems, like relational databases and traditional messaging systems.

Encryption of data transferred between Kafka brokers and Kafka clients, between brokers, between brokers and ZooKeeper nodes, and between brokers and other, optional tools.
Authentication of connections from Kafka clients and applications to Kafka brokers, as well as connections from Kafka brokers to ZooKeeper nodes.
Authorization of client operations such as creating, deleting, and altering the configuration of topics; writing events to or reading events from a topic; creating and deleting ACLs. Administrators can also define custom policies to put in place additional restrictions, such as a CreateTopicPolicy and AlterConfigPolicy (see KIP-108 and the settings create.topic.policy.class.name, alter.config.policy.class.name).
When securing a multi-tenant Kafka environment, the most common administrative task is the third category (authorization), i.e., managing the user/client permissions that grant or deny access to certain topics and thus to the data stored by users within a cluster. This task is performed predominantly through the setting of access control lists (ACLs). Here, administrators of multi-tenant environments in particular benefit from putting a hierarchical topic naming structure in place as described in a previous section, because they can conveniently control access to topics through prefixed ACLs (--resource-pattern-type Prefixed). This significantly minimizes the administrative overhead of securing topics in multi-tenant environments: administrators can make their own trade-offs between higher developer convenience (more lenient permissions, using fewer and broader ACLs) vs. tighter security (more stringent permissions, using more and narrower ACLs).

In the following example, user Alice—a new member of ACME corporation's InfoSec team—is granted write permissions to all topics whose names start with "acme.infosec.", such as "acme.infosec.telemetry.logins" and "acme.infosec.syslogs.events".

# Grant permissions to user Alice
$ bin/kafka-acls.sh \
    --bootstrap-server localhost:9092 \
    --add --allow-principal User:Alice \
    --producer \
    --resource-pattern-type prefixed --topic acme.infosec.
You can similarly use this approach to isolate different customers on the same shared cluster.

Isolating Tenants: Quotas, Rate Limiting, Throttling
Multi-tenant clusters should generally be configured with quotas, which protect against users (tenants) eating up too many cluster resources, such as when they attempt to write or read very high volumes of data, or create requests to brokers at an excessively high rate. This may cause network saturation, monopolize broker resources, and impact other clients—all of which you want to avoid in a shared environment.

Client quotas: Kafka supports different types of (per-user principal) client quotas. Because a client's quotas apply irrespective of which topics the client is writing to or reading from, they are a convenient and effective tool to allocate resources in a multi-tenant cluster. Request rate quotas, for example, help to limit a user's impact on broker CPU usage by limiting the time a broker spends on the request handling path for that user, after which throttling kicks in. In many situations, isolating users with request rate quotas has a bigger impact in multi-tenant clusters than setting incoming/outgoing network bandwidth quotas, because excessive broker CPU usage for processing requests reduces the effective bandwidth the broker can serve. Furthermore, administrators can also define quotas on topic operations—such as create, delete, and alter—to prevent Kafka clusters from being overwhelmed by highly concurrent topic operations (see KIP-599 and the quota type controller_mutation_rate).

Server quotas: Kafka also supports different types of broker-side quotas. For example, administrators can set a limit on the rate with which the broker accepts new connections, set the maximum number of connections per broker, or set the maximum number of connections allowed from a specific IP address.

For more information, please refer to the quota overview and how to set quotas.

Monitoring and Metering
Monitoring is a broader subject that is covered elsewhere in the documentation. Administrators of any Kafka environment, but especially multi-tenant ones, should set up monitoring according to these instructions. Kafka supports a wide range of metrics, such as the rate of failed authentication attempts, request latency, consumer lag, total number of consumer groups, metrics on the quotas described in the previous section, and many more.

For example, monitoring can be configured to track the size of topic-partitions (with the JMX metric kafka.log.Log.Size.<TOPIC-NAME>), and thus the total size of data stored in a topic. You can then define alerts when tenants on shared clusters are getting close to using too much storage space.

Multi-Tenancy and Geo-Replication
Kafka lets you share data across different clusters, which may be located in different geographical regions, data centers, and so on. Apart from use cases such as disaster recovery, this functionality is useful when a multi-tenant setup requires inter-cluster data sharing. See the section Geo-Replication (Cross-Cluster Data Mirroring) for more information.

Further considerations
Data contracts: You may need to define data contracts between the producers and the consumers of data in a cluster, using event schemas. This ensures that events written to Kafka can always be read properly again, and prevents malformed or corrupt events being written. The best way to achieve this is to deploy a so-called schema registry alongside the cluster. (Kafka does not include a schema registry, but there are third-party implementations available.) A schema registry manages the event schemas and maps the schemas to topics, so that producers know which topics are accepting which types (schemas) of events, and consumers know how to read and parse events in a topic. Some registry implementations provide further functionality, such as schema evolution, storing a history of all schemas, and schema compatibility settings.

6.5 Kafka Configuration
Important Client Configurations
The most important producer configurations are:
acks
compression
batch size
The most important consumer configuration is the fetch size.
All configurations are documented in the configuration section.


A Production Server Config
Here is an example production server configuration:
# ZooKeeper
zookeeper.connect=[list of ZooKeeper servers]

# Log configuration
num.partitions=8
default.replication.factor=3
log.dir=[List of directories. Kafka should have its own dedicated disk(s) or SSD(s).]

# Other configurations
broker.id=[An integer. Start with 0 and increment by 1 for each new broker.]
listeners=[list of listeners]
auto.create.topics.enable=false
min.insync.replicas=2
queued.max.requests=[number of concurrent requests]
Our client configuration varies a fair amount between different use cases.
6.6 Java Version
Java 8, Java 11, and Java 17 are supported.
Note that Java 8 support project-wide has been deprecated since Apache Kafka 3.0 and Java 11 support for the broker and tools has been deprecated since Apache Kafka 3.7. Both will be removed in Apache Kafka 4.0.
![image](https://github.com/user-attachments/assets/2d3b78c3-0c52-40ed-ad13-65703e36f9c1)

Java 11 and later versions perform significantly better if TLS is enabled, so they are highly recommended (they also include a number of other performance improvements: G1GC, CRC32C, Compact Strings, Thread-Local Handshakes and more).

From a security perspective, we recommend the latest released patch version as older freely available versions have disclosed security vulnerabilities.

Typical arguments for running Kafka with OpenJDK-based Java implementations (including Oracle JDK) are:

-Xmx6g -Xms6g -XX:MetaspaceSize=96m -XX:+UseG1GC
-XX:MaxGCPauseMillis=20 -XX:InitiatingHeapOccupancyPercent=35 -XX:G1HeapRegionSize=16M
-XX:MinMetaspaceFreeRatio=50 -XX:MaxMetaspaceFreeRatio=80 -XX:+ExplicitGCInvokesConcurrent
For reference, here are the stats for one of LinkedIn's busiest clusters (at peak) that uses said Java arguments:
60 brokers
50k partitions (replication factor 2)
800k messages/sec in
300 MB/sec inbound, 1 GB/sec+ outbound
All of the brokers in that cluster have a 90% GC pause time of about 21ms with less than 1 young GC per second.
6.7 Hardware and OS
We are using dual quad-core Intel Xeon machines with 24GB of memory.
You need sufficient memory to buffer active readers and writers. You can do a back-of-the-envelope estimate of memory needs by assuming you want to be able to buffer for 30 seconds and compute your memory need as write_throughput*30.

The disk throughput is important. We have 8x7200 rpm SATA drives. In general disk throughput is the performance bottleneck, and more disks is better. Depending on how you configure flush behavior you may or may not benefit from more expensive disks (if you force flush often then higher RPM SAS drives may be better).

OS
Kafka should run well on any unix system and has been tested on Linux and Solaris.
We have seen a few issues running on Windows and Windows is not currently a well supported platform though we would be happy to change that.

It is unlikely to require much OS-level tuning, but there are three potentially important OS-level configurations:

File descriptor limits: Kafka uses file descriptors for log segments and open connections. If a broker hosts many partitions, consider that the broker needs at least (number_of_partitions)*(partition_size/segment_size) to track all log segments in addition to the number of connections the broker makes. We recommend at least 100000 allowed file descriptors for the broker processes as a starting point. Note: The mmap() function adds an extra reference to the file associated with the file descriptor fildes which is not removed by a subsequent close() on that file descriptor. This reference is removed when there are no more mappings to the file.
Max socket buffer size: can be increased to enable high-performance data transfer between data centers as described here.
Maximum number of memory map areas a process may have (aka vm.max_map_count). See the Linux kernel documentation. You should keep an eye at this OS-level property when considering the maximum number of partitions a broker may have. By default, on a number of Linux systems, the value of vm.max_map_count is somewhere around 65535. Each log segment, allocated per partition, requires a pair of index/timeindex files, and each of these files consumes 1 map area. In other words, each log segment uses 2 map areas. Thus, each partition requires minimum 2 map areas, as long as it hosts a single log segment. That is to say, creating 50000 partitions on a broker will result allocation of 100000 map areas and likely cause broker crash with OutOfMemoryError (Map failed) on a system with default vm.max_map_count. Keep in mind that the number of log segments per partition varies depending on the segment size, load intensity, retention policy and, generally, tends to be more than one.

Disks and Filesystem
We recommend using multiple drives to get good throughput and not sharing the same drives used for Kafka data with application logs or other OS filesystem activity to ensure good latency. You can either RAID these drives together into a single volume or format and mount each drive as its own directory. Since Kafka has replication the redundancy provided by RAID can also be provided at the application level. This choice has several tradeoffs.
If you configure multiple data directories partitions will be assigned round-robin to data directories. Each partition will be entirely in one of the data directories. If data is not well balanced among partitions this can lead to load imbalance between disks.

RAID can potentially do better at balancing load between disks (although it doesn't always seem to) because it balances load at a lower level. The primary downside of RAID is that it is usually a big performance hit for write throughput and reduces the available disk space.

Another potential benefit of RAID is the ability to tolerate disk failures. However our experience has been that rebuilding the RAID array is so I/O intensive that it effectively disables the server, so this does not provide much real availability improvement.

Application vs. OS Flush Management
Kafka always immediately writes all data to the filesystem and supports the ability to configure the flush policy that controls when data is forced out of the OS cache and onto disk using the flush. This flush policy can be controlled to force data to disk after a period of time or after a certain number of messages has been written. There are several choices in this configuration.
Kafka must eventually call fsync to know that data was flushed. When recovering from a crash for any log segment not known to be fsync'd Kafka will check the integrity of each message by checking its CRC and also rebuild the accompanying offset index file as part of the recovery process executed on startup.

Note that durability in Kafka does not require syncing data to disk, as a failed node will always recover from its replicas.

We recommend using the default flush settings which disable application fsync entirely. This means relying on the background flush done by the OS and Kafka's own background flush. This provides the best of all worlds for most uses: no knobs to tune, great throughput and latency, and full recovery guarantees. We generally feel that the guarantees provided by replication are stronger than sync to local disk, however the paranoid still may prefer having both and application level fsync policies are still supported.

The drawback of using application level flush settings is that it is less efficient in its disk usage pattern (it gives the OS less leeway to re-order writes) and it can introduce latency as fsync in most Linux filesystems blocks writes to the file whereas the background flushing does much more granular page-level locking.

In general you don't need to do any low-level tuning of the filesystem, but in the next few sections we will go over some of this in case it is useful.

Understanding Linux OS Flush Behavior
In Linux, data written to the filesystem is maintained in pagecache until it must be written out to disk (due to an application-level fsync or the OS's own flush policy). The flushing of data is done by a set of background threads called pdflush (or in post 2.6.32 kernels "flusher threads").
Pdflush has a configurable policy that controls how much dirty data can be maintained in cache and for how long before it must be written back to disk. This policy is described here. When Pdflush cannot keep up with the rate of data being written it will eventually cause the writing process to block incurring latency in the writes to slow down the accumulation of data.

You can see the current state of OS memory usage by doing

$ cat /proc/meminfo
The meaning of these values are described in the link above.
Using pagecache has several advantages over an in-process cache for storing data that will be written out to disk:

The I/O scheduler will batch together consecutive small writes into bigger physical writes which improves throughput.
The I/O scheduler will attempt to re-sequence writes to minimize movement of the disk head which improves throughput.
It automatically uses all the free memory on the machine
Filesystem Selection
Kafka uses regular files on disk, and as such it has no hard dependency on a specific filesystem. The two filesystems which have the most usage, however, are EXT4 and XFS. Historically, EXT4 has had more usage, but recent improvements to the XFS filesystem have shown it to have better performance characteristics for Kafka's workload with no compromise in stability.

Comparison testing was performed on a cluster with significant message loads, using a variety of filesystem creation and mount options. The primary metric in Kafka that was monitored was the "Request Local Time", indicating the amount of time append operations were taking. XFS resulted in much better local times (160ms vs. 250ms+ for the best EXT4 configuration), as well as lower average wait times. The XFS performance also showed less variability in disk performance.

General Filesystem Notes
For any filesystem used for data directories, on Linux systems, the following options are recommended to be used at mount time:
noatime: This option disables updating of a file's atime (last access time) attribute when the file is read. This can eliminate a significant number of filesystem writes, especially in the case of bootstrapping consumers. Kafka does not rely on the atime attributes at all, so it is safe to disable this.
XFS Notes
The XFS filesystem has a significant amount of auto-tuning in place, so it does not require any change in the default settings, either at filesystem creation time or at mount. The only tuning parameters worth considering are:
largeio: This affects the preferred I/O size reported by the stat call. While this can allow for higher performance on larger disk writes, in practice it had minimal or no effect on performance.
nobarrier: For underlying devices that have battery-backed cache, this option can provide a little more performance by disabling periodic write flushes. However, if the underlying device is well-behaved, it will report to the filesystem that it does not require flushes, and this option will have no effect.
EXT4 Notes
EXT4 is a serviceable choice of filesystem for the Kafka data directories, however getting the most performance out of it will require adjusting several mount options. In addition, these options are generally unsafe in a failure scenario, and will result in much more data loss and corruption. For a single broker failure, this is not much of a concern as the disk can be wiped and the replicas rebuilt from the cluster. In a multiple-failure scenario, such as a power outage, this can mean underlying filesystem (and therefore data) corruption that is not easily recoverable. The following options can be adjusted:
data=writeback: Ext4 defaults to data=ordered which puts a strong order on some writes. Kafka does not require this ordering as it does very paranoid data recovery on all unflushed log. This setting removes the ordering constraint and seems to significantly reduce latency.
Disabling journaling: Journaling is a tradeoff: it makes reboots faster after server crashes but it introduces a great deal of additional locking which adds variance to write performance. Those who don't care about reboot time and want to reduce a major source of write latency spikes can turn off journaling entirely.
commit=num_secs: This tunes the frequency with which ext4 commits to its metadata journal. Setting this to a lower value reduces the loss of unflushed data during a crash. Setting this to a higher value will improve throughput.
nobh: This setting controls additional ordering guarantees when using data=writeback mode. This should be safe with Kafka as we do not depend on write ordering and improves throughput and latency.
delalloc: Delayed allocation means that the filesystem avoid allocating any blocks until the physical write occurs. This allows ext4 to allocate a large extent instead of smaller pages and helps ensure the data is written sequentially. This feature is great for throughput. It does seem to involve some locking in the filesystem which adds a bit of latency variance.
fast_commit: Added in Linux 5.10, fast_commit is a lighter-weight journaling method which can be used with data=ordered journaling mode. Enabling it seems to significantly reduce latency.
Replace KRaft Controller Disk
When Kafka is configured to use KRaft, the controllers store the cluster metadata in the directory specified in metadata.log.dir -- or the first log directory, if metadata.log.dir is not configured. See the documentation for metadata.log.dir for details.

If the data in the cluster metadata directory is lost either because of hardware failure or the hardware needs to be replaced, care should be taken when provisioning the new controller node. The new controller node should not be formatted and started until the majority of the controllers have all of the committed data. To determine if the majority of the controllers have the committed data, run the kafka-metadata-quorum.sh tool to describe the replication status:

$ bin/kafka-metadata-quorum.sh --bootstrap-server localhost:9092 describe --replication
NodeId  LogEndOffset    Lag     LastFetchTimestamp      LastCaughtUpTimestamp   Status
1       25806           0       1662500992757           1662500992757           Leader
...     ...             ...     ...                     ...                     ...
Check and wait until the Lag is small for a majority of the controllers. If the leader's end offset is not increasing, you can wait until the lag is 0 for a majority; otherwise, you can pick the latest leader end offset and wait until all replicas have reached it. Check and wait until the LastFetchTimestamp and LastCaughtUpTimestamp are close to each other for the majority of the controllers. At this point it is safer to format the controller's metadata log directory. This can be done by running the kafka-storage.sh command.

$ bin/kafka-storage.sh format --cluster-id uuid --config server_properties
It is possible for the bin/kafka-storage.sh format command above to fail with a message like Log directory ... is already formatted. This can happen when combined mode is used and only the metadata log directory was lost but not the others. In that case and only in that case, can you run the kafka-storage.sh format command with the --ignore-formatted option.

Start the KRaft controller after formatting the log directories.

$ bin/kafka-server-start.sh server_properties
6.8 Monitoring
Kafka uses Yammer Metrics for metrics reporting in the server. The Java clients use Kafka Metrics, a built-in metrics registry that minimizes transitive dependencies pulled into client applications. Both expose metrics via JMX and can be configured to report stats using pluggable stats reporters to hook up to your monitoring system.
All Kafka rate metrics have a corresponding cumulative count metric with suffix -total. For example, records-consumed-rate has a corresponding metric named records-consumed-total.

The easiest way to see the available metrics is to fire up jconsole and point it at a running kafka client or server; this will allow browsing all metrics with JMX.

Security Considerations for Remote Monitoring using JMX
Apache Kafka disables remote JMX by default. You can enable remote monitoring using JMX by setting the environment variable JMX_PORT for processes started using the CLI or standard Java system properties to enable remote JMX programmatically. You must enable security when enabling remote JMX in production scenarios to ensure that unauthorized users cannot monitor or control your broker or application as well as the platform on which these are running. Note that authentication is disabled for JMX by default in Kafka and security configs must be overridden for production deployments by setting the environment variable KAFKA_JMX_OPTS for processes started using the CLI or by setting appropriate Java system properties. See Monitoring and Management Using JMX Technology for details on securing JMX.
We do graphing and alerting on the following metrics:
Description	Mbean name	Normal value
Message in rate	kafka.server:type=BrokerTopicMetrics,name=MessagesInPerSec,topic=([-.\w]+)	Incoming message rate per topic. Omitting 'topic=(...)' will yield the all-topic rate.
Byte in rate from clients	kafka.server:type=BrokerTopicMetrics,name=BytesInPerSec,topic=([-.\w]+)	Byte in (from the clients) rate per topic. Omitting 'topic=(...)' will yield the all-topic rate.
Byte in rate from other brokers	kafka.server:type=BrokerTopicMetrics,name=ReplicationBytesInPerSec	Byte in (from the other brokers) rate across all topics.
Controller Request rate from Broker	kafka.controller:type=ControllerChannelManager,name=RequestRateAndQueueTimeMs,brokerId=([0-9]+)	The rate (requests per second) at which the ControllerChannelManager takes requests from the queue of the given broker. And the time it takes for a request to stay in this queue before it is taken from the queue.
Controller Event queue size	kafka.controller:type=ControllerEventManager,name=EventQueueSize	Size of the ControllerEventManager's queue.
Controller Event queue time	kafka.controller:type=ControllerEventManager,name=EventQueueTimeMs	Time that takes for any event (except the Idle event) to wait in the ControllerEventManager's queue before being processed
Request rate	kafka.network:type=RequestMetrics,name=RequestsPerSec,request={Produce|FetchConsumer|FetchFollower},version=([0-9]+)	
Error rate	kafka.network:type=RequestMetrics,name=ErrorsPerSec,request=([-.\w]+),error=([-.\w]+)	Number of errors in responses counted per-request-type, per-error-code. If a response contains multiple errors, all are counted. error=NONE indicates successful responses.
Produce request rate	kafka.server:type=BrokerTopicMetrics,name=TotalProduceRequestsPerSec,topic=([-.\w]+)	Produce request rate per topic. Omitting 'topic=(...)' will yield the all-topic rate.
Fetch request rate	kafka.server:type=BrokerTopicMetrics,name=TotalFetchRequestsPerSec,topic=([-.\w]+)	Fetch request (from clients or followers) rate per topic. Omitting 'topic=(...)' will yield the all-topic rate.
Failed produce request rate	kafka.server:type=BrokerTopicMetrics,name=FailedProduceRequestsPerSec,topic=([-.\w]+)	Failed Produce request rate per topic. Omitting 'topic=(...)' will yield the all-topic rate.
Failed fetch request rate	kafka.server:type=BrokerTopicMetrics,name=FailedFetchRequestsPerSec,topic=([-.\w]+)	Failed Fetch request (from clients or followers) rate per topic. Omitting 'topic=(...)' will yield the all-topic rate.
Request size in bytes	kafka.network:type=RequestMetrics,name=RequestBytes,request=([-.\w]+)	Size of requests for each request type.
Temporary memory size in bytes	kafka.network:type=RequestMetrics,name=TemporaryMemoryBytes,request={Produce|Fetch}	Temporary memory used for message format conversions and decompression.
Message conversion time	kafka.network:type=RequestMetrics,name=MessageConversionsTimeMs,request={Produce|Fetch}	Time in milliseconds spent on message format conversions.
Message conversion rate	kafka.server:type=BrokerTopicMetrics,name={Produce|Fetch}MessageConversionsPerSec,topic=([-.\w]+)	Message format conversion rate, for Produce or Fetch requests, per topic. Omitting 'topic=(...)' will yield the all-topic rate.
Request Queue Size	kafka.network:type=RequestChannel,name=RequestQueueSize	Size of the request queue.
Byte out rate to clients	kafka.server:type=BrokerTopicMetrics,name=BytesOutPerSec,topic=([-.\w]+)	Byte out (to the clients) rate per topic. Omitting 'topic=(...)' will yield the all-topic rate.
Byte out rate to other brokers	kafka.server:type=BrokerTopicMetrics,name=ReplicationBytesOutPerSec	Byte out (to the other brokers) rate across all topics
Rejected byte rate	kafka.server:type=BrokerTopicMetrics,name=BytesRejectedPerSec,topic=([-.\w]+)	Rejected byte rate per topic, due to the record batch size being greater than max.message.bytes configuration. Omitting 'topic=(...)' will yield the all-topic rate.
Message validation failure rate due to no key specified for compacted topic	kafka.server:type=BrokerTopicMetrics,name=NoKeyCompactedTopicRecordsPerSec	0
Message validation failure rate due to invalid magic number	kafka.server:type=BrokerTopicMetrics,name=InvalidMagicNumberRecordsPerSec	0
Message validation failure rate due to incorrect crc checksum	kafka.server:type=BrokerTopicMetrics,name=InvalidMessageCrcRecordsPerSec	0
Message validation failure rate due to non-continuous offset or sequence number in batch	kafka.server:type=BrokerTopicMetrics,name=InvalidOffsetOrSequenceRecordsPerSec	0
Log flush rate and time	kafka.log:type=LogFlushStats,name=LogFlushRateAndTimeMs	
# of offline log directories	kafka.log:type=LogManager,name=OfflineLogDirectoryCount	0
Leader election rate	kafka.controller:type=ControllerStats,name=LeaderElectionRateAndTimeMs	non-zero when there are broker failures
Unclean leader election rate	kafka.controller:type=ControllerStats,name=UncleanLeaderElectionsPerSec	0
Is controller active on broker	kafka.controller:type=KafkaController,name=ActiveControllerCount	only one broker in the cluster should have 1
Pending topic deletes	kafka.controller:type=KafkaController,name=TopicsToDeleteCount	
Pending replica deletes	kafka.controller:type=KafkaController,name=ReplicasToDeleteCount	
Ineligible pending topic deletes	kafka.controller:type=KafkaController,name=TopicsIneligibleToDeleteCount	
Ineligible pending replica deletes	kafka.controller:type=KafkaController,name=ReplicasIneligibleToDeleteCount	
# of under replicated partitions (|ISR| < |all replicas|)	kafka.server:type=ReplicaManager,name=UnderReplicatedPartitions	0
# of under minIsr partitions (|ISR| < min.insync.replicas)	kafka.server:type=ReplicaManager,name=UnderMinIsrPartitionCount	0
# of at minIsr partitions (|ISR| = min.insync.replicas)	kafka.server:type=ReplicaManager,name=AtMinIsrPartitionCount	0
Producer Id counts	kafka.server:type=ReplicaManager,name=ProducerIdCount	Count of all producer ids created by transactional and idempotent producers in each replica on the broker
Partition counts	kafka.server:type=ReplicaManager,name=PartitionCount	mostly even across brokers
Offline Replica counts	kafka.server:type=ReplicaManager,name=OfflineReplicaCount	0
Leader replica counts	kafka.server:type=ReplicaManager,name=LeaderCount	mostly even across brokers
ISR shrink rate	kafka.server:type=ReplicaManager,name=IsrShrinksPerSec	If a broker goes down, ISR for some of the partitions will shrink. When that broker is up again, ISR will be expanded once the replicas are fully caught up. Other than that, the expected value for both ISR shrink rate and expansion rate is 0.
ISR expansion rate	kafka.server:type=ReplicaManager,name=IsrExpandsPerSec	See above
Failed ISR update rate	kafka.server:type=ReplicaManager,name=FailedIsrUpdatesPerSec	0
Max lag in messages btw follower and leader replicas	kafka.server:type=ReplicaFetcherManager,name=MaxLag,clientId=Replica	lag should be proportional to the maximum batch size of a produce request.
Lag in messages per follower replica	kafka.server:type=FetcherLagMetrics,name=ConsumerLag,clientId=([-.\w]+),topic=([-.\w]+),partition=([0-9]+)	lag should be proportional to the maximum batch size of a produce request.
Requests waiting in the producer purgatory	kafka.server:type=DelayedOperationPurgatory,name=PurgatorySize,delayedOperation=Produce	non-zero if ack=-1 is used
Requests waiting in the fetch purgatory	kafka.server:type=DelayedOperationPurgatory,name=PurgatorySize,delayedOperation=Fetch	size depends on fetch.wait.max.ms in the consumer
Request total time	kafka.network:type=RequestMetrics,name=TotalTimeMs,request={Produce|FetchConsumer|FetchFollower}	broken into queue, local, remote and response send time
Time the request waits in the request queue	kafka.network:type=RequestMetrics,name=RequestQueueTimeMs,request={Produce|FetchConsumer|FetchFollower}	
Time the request is processed at the leader	kafka.network:type=RequestMetrics,name=LocalTimeMs,request={Produce|FetchConsumer|FetchFollower}	
Time the request waits for the follower	kafka.network:type=RequestMetrics,name=RemoteTimeMs,request={Produce|FetchConsumer|FetchFollower}	non-zero for produce requests when ack=-1
Time the request waits in the response queue	kafka.network:type=RequestMetrics,name=ResponseQueueTimeMs,request={Produce|FetchConsumer|FetchFollower}	
Time to send the response	kafka.network:type=RequestMetrics,name=ResponseSendTimeMs,request={Produce|FetchConsumer|FetchFollower}	
Number of messages the consumer lags behind the producer by. Published by the consumer, not broker.	kafka.consumer:type=consumer-fetch-manager-metrics,client-id={client-id} Attribute: records-lag-max	
The average fraction of time the network processors are idle	kafka.network:type=SocketServer,name=NetworkProcessorAvgIdlePercent	between 0 and 1, ideally > 0.3
The number of connections disconnected on a processor due to a client not re-authenticating and then using the connection beyond its expiration time for anything other than re-authentication	kafka.server:type=socket-server-metrics,listener=[SASL_PLAINTEXT|SASL_SSL],networkProcessor=<#>,name=expired-connections-killed-count	ideally 0 when re-authentication is enabled, implying there are no longer any older, pre-2.2.0 clients connecting to this (listener, processor) combination
The total number of connections disconnected, across all processors, due to a client not re-authenticating and then using the connection beyond its expiration time for anything other than re-authentication	kafka.network:type=SocketServer,name=ExpiredConnectionsKilledCount	ideally 0 when re-authentication is enabled, implying there are no longer any older, pre-2.2.0 clients connecting to this broker
The average fraction of time the request handler threads are idle	kafka.server:type=KafkaRequestHandlerPool,name=RequestHandlerAvgIdlePercent	between 0 and 1, ideally > 0.3
Bandwidth quota metrics per (user, client-id), user or client-id	kafka.server:type={Produce|Fetch},user=([-.\w]+),client-id=([-.\w]+)	Two attributes. throttle-time indicates the amount of time in ms the client was throttled. Ideally = 0. byte-rate indicates the data produce/consume rate of the client in bytes/sec. For (user, client-id) quotas, both user and client-id are specified. If per-client-id quota is applied to the client, user is not specified. If per-user quota is applied, client-id is not specified.
Request quota metrics per (user, client-id), user or client-id	kafka.server:type=Request,user=([-.\w]+),client-id=([-.\w]+)	Two attributes. throttle-time indicates the amount of time in ms the client was throttled. Ideally = 0. request-time indicates the percentage of time spent in broker network and I/O threads to process requests from client group. For (user, client-id) quotas, both user and client-id are specified. If per-client-id quota is applied to the client, user is not specified. If per-user quota is applied, client-id is not specified.
Requests exempt from throttling	kafka.server:type=Request	exempt-throttle-time indicates the percentage of time spent in broker network and I/O threads to process requests that are exempt from throttling.
ZooKeeper client request latency	kafka.server:type=ZooKeeperClientMetrics,name=ZooKeeperRequestLatencyMs	Latency in milliseconds for ZooKeeper requests from broker.
ZooKeeper connection status	kafka.server:type=SessionExpireListener,name=SessionState	Connection status of broker's ZooKeeper session which may be one of Disconnected|SyncConnected|AuthFailed|ConnectedReadOnly|SaslAuthenticated|Expired.
Max time to load group metadata	kafka.server:type=group-coordinator-metrics,name=partition-load-time-max	maximum time, in milliseconds, it took to load offsets and group metadata from the consumer offset partitions loaded in the last 30 seconds (including time spent waiting for the loading task to be scheduled)
Avg time to load group metadata	kafka.server:type=group-coordinator-metrics,name=partition-load-time-avg	average time, in milliseconds, it took to load offsets and group metadata from the consumer offset partitions loaded in the last 30 seconds (including time spent waiting for the loading task to be scheduled)
Max time to load transaction metadata	kafka.server:type=transaction-coordinator-metrics,name=partition-load-time-max	maximum time, in milliseconds, it took to load transaction metadata from the consumer offset partitions loaded in the last 30 seconds (including time spent waiting for the loading task to be scheduled)
Avg time to load transaction metadata	kafka.server:type=transaction-coordinator-metrics,name=partition-load-time-avg	average time, in milliseconds, it took to load transaction metadata from the consumer offset partitions loaded in the last 30 seconds (including time spent waiting for the loading task to be scheduled)
Rate of transactional verification errors	kafka.server:type=AddPartitionsToTxnManager,name=VerificationFailureRate	Rate of verifications that returned in failure either from the AddPartitionsToTxn API response or through errors in the AddPartitionsToTxnManager. In steady state 0, but transient errors are expected during rolls and reassignments of the transactional state partition.
Time to verify a transactional request	kafka.server:type=AddPartitionsToTxnManager,name=VerificationTimeMs	The amount of time queueing while a possible previous request is in-flight plus the round trip to the transaction coordinator to verify (or not verify)
Consumer Group Offset Count	kafka.server:type=GroupMetadataManager,name=NumOffsets	Total number of committed offsets for Consumer Groups
Consumer Group Count	kafka.server:type=GroupMetadataManager,name=NumGroups	Total number of Consumer Groups
Consumer Group Count, per State	kafka.server:type=GroupMetadataManager,name=NumGroups[PreparingRebalance,CompletingRebalance,Empty,Stable,Dead]	The number of Consumer Groups in each state: PreparingRebalance, CompletingRebalance, Empty, Stable, Dead
Number of reassigning partitions	kafka.server:type=ReplicaManager,name=ReassigningPartitions	The number of reassigning leader partitions on a broker.
Outgoing byte rate of reassignment traffic	kafka.server:type=BrokerTopicMetrics,name=ReassignmentBytesOutPerSec	0; non-zero when a partition reassignment is in progress.
Incoming byte rate of reassignment traffic	kafka.server:type=BrokerTopicMetrics,name=ReassignmentBytesInPerSec	0; non-zero when a partition reassignment is in progress.
Size of a partition on disk (in bytes)	kafka.log:type=Log,name=Size,topic=([-.\w]+),partition=([0-9]+)	The size of a partition on disk, measured in bytes.
Number of log segments in a partition	kafka.log:type=Log,name=NumLogSegments,topic=([-.\w]+),partition=([0-9]+)	The number of log segments in a partition.
First offset in a partition	kafka.log:type=Log,name=LogStartOffset,topic=([-.\w]+),partition=([0-9]+)	The first offset in a partition.
Last offset in a partition	kafka.log:type=Log,name=LogEndOffset,topic=([-.\w]+),partition=([0-9]+)	The last offset in a partition.

Tiered Storage Monitoring
The following set of metrics are available for monitoring of the tiered storage feature:
![image](https://github.com/user-attachments/assets/4a23358c-3ee1-4eeb-b898-f63529167af4)

Metric/Attribute name	Description	Mbean name
Remote Fetch Bytes Per Sec	Rate of bytes read from remote storage per topic. Omitting 'topic=(...)' will yield the all-topic rate	kafka.server:type=BrokerTopicMetrics,name=RemoteFetchBytesPerSec,topic=([-.\w]+)
Remote Fetch Requests Per Sec	Rate of read requests from remote storage per topic. Omitting 'topic=(...)' will yield the all-topic rate	kafka.server:type=BrokerTopicMetrics,name=RemoteFetchRequestsPerSec,topic=([-.\w]+)
Remote Fetch Errors Per Sec	Rate of read errors from remote storage per topic. Omitting 'topic=(...)' will yield the all-topic rate	kafka.server:type=BrokerTopicMetrics,name=RemoteFetchErrorsPerSec,topic=([-.\w]+)
Remote Copy Bytes Per Sec	Rate of bytes copied to remote storage per topic. Omitting 'topic=(...)' will yield the all-topic rate	kafka.server:type=BrokerTopicMetrics,name=RemoteCopyBytesPerSec,topic=([-.\w]+)
Remote Copy Requests Per Sec	Rate of write requests to remote storage per topic. Omitting 'topic=(...)' will yield the all-topic rate	kafka.server:type=BrokerTopicMetrics,name=RemoteCopyRequestsPerSec,topic=([-.\w]+)
Remote Copy Errors Per Sec	Rate of write errors from remote storage per topic. Omitting 'topic=(...)' will yield the all-topic rate	kafka.server:type=BrokerTopicMetrics,name=RemoteCopyErrorsPerSec,topic=([-.\w]+)
Remote Copy Lag Bytes	Bytes which are eligible for tiering, but are not in remote storage yet. Omitting 'topic=(...)' will yield the all-topic sum	kafka.server:type=BrokerTopicMetrics,name=RemoteCopyLagBytes,topic=([-.\w]+)
Remote Copy Lag Segments	Segments which are eligible for tiering, but are not in remote storage yet. Omitting 'topic=(...)' will yield the all-topic count	kafka.server:type=BrokerTopicMetrics,name=RemoteCopyLagSegments,topic=([-.\w]+)
Remote Delete Requests Per Sec	Rate of delete requests to remote storage per topic. Omitting 'topic=(...)' will yield the all-topic rate	kafka.server:type=BrokerTopicMetrics,name=RemoteDeleteRequestsPerSec,topic=([-.\w]+)
Remote Delete Errors Per Sec	Rate of delete errors from remote storage per topic. Omitting 'topic=(...)' will yield the all-topic rate	kafka.server:type=BrokerTopicMetrics,name=RemoteDeleteErrorsPerSec,topic=([-.\w]+)
Remote Delete Lag Bytes	Tiered bytes which are eligible for deletion, but have not been deleted yet. Omitting 'topic=(...)' will yield the all-topic sum	kafka.server:type=BrokerTopicMetrics,name=RemoteDeleteLagBytes,topic=([-.\w]+)
Remote Delete Lag Segments	Tiered segments which are eligible for deletion, but have not been deleted yet. Omitting 'topic=(...)' will yield the all-topic count	kafka.server:type=BrokerTopicMetrics,name=RemoteDeleteLagSegments,topic=([-.\w]+)
Build Remote Log Aux State Requests Per Sec	Rate of requests for rebuilding the auxiliary state from remote storage per topic. Omitting 'topic=(...)' will yield the all-topic rate	kafka.server:type=BrokerTopicMetrics,name=BuildRemoteLogAuxStateRequestsPerSec,topic=([-.\w]+)
Build Remote Log Aux State Errors Per Sec	Rate of errors for rebuilding the auxiliary state from remote storage per topic. Omitting 'topic=(...)' will yield the all-topic rate	kafka.server:type=BrokerTopicMetrics,name=BuildRemoteLogAuxStateErrorsPerSec,topic=([-.\w]+)
Remote Log Size Computation Time	The amount of time needed to compute the size of the remote log. Omitting 'topic=(...)' will yield the all-topic time	kafka.server:type=BrokerTopicMetrics,name=RemoteLogSizeComputationTime,topic=([-.\w]+)
Remote Log Size Bytes	The total size of a remote log in bytes. Omitting 'topic=(...)' will yield the all-topic sum	kafka.server:type=BrokerTopicMetrics,name=RemoteLogSizeBytes,topic=([-.\w]+)
Remote Log Metadata Count	The total number of metadata entries for remote storage. Omitting 'topic=(...)' will yield the all-topic count	kafka.server:type=BrokerTopicMetrics,name=RemoteLogMetadataCount,topic=([-.\w]+)
Delayed Remote Fetch Expires Per Sec	The number of expired remote fetches per second. Omitting 'topic=(...)' will yield the all-topic rate	kafka.server:type=DelayedRemoteFetchMetrics,name=ExpiresPerSec,topic=([-.\w]+)
RemoteLogReader Task Queue Size	Size of the queue holding remote storage read tasks	org.apache.kafka.storage.internals.log:type=RemoteStorageThreadPool,name=RemoteLogReaderTaskQueueSize
RemoteLogReader Avg Idle Percent	Average idle percent of thread pool for processing remote storage read tasks	org.apache.kafka.storage.internals.log:type=RemoteStorageThreadPool,name=RemoteLogReaderAvgIdlePercent
RemoteLogManager Tasks Avg Idle Percent	Average idle percent of thread pool for copying data to remote storage	kafka.log.remote:type=RemoteLogManager,name=RemoteLogManagerTasksAvgIdlePercent
RemoteLogManager Avg Broker Fetch Throttle Time	The average time in millis remote fetches was throttled by a broker	kafka.server:type=RemoteLogManager, name=remote-fetch-throttle-time-avg
RemoteLogManager Max Broker Fetch Throttle Time	The max time in millis remote fetches was throttled by a broker	kafka.server:type=RemoteLogManager, name=remote-fetch-throttle-time-max
RemoteLogManager Avg Broker Copy Throttle Time	The average time in millis remote copies was throttled by a broker	kafka.server:type=RemoteLogManager, name=remote-copy-throttle-time-avg
RemoteLogManager Max Broker Copy Throttle Time	The max time in millis remote copies was throttled by a broker	kafka.server:type=RemoteLogManager, name=remote-copy-throttle-time-max

