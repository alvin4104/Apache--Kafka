# Apache--Kafka

See our web site for details on the project.

You need to have Java installed.

We build and test Apache Kafka with 8 and 11. The release parameter in javac is set to 11 for the clients and streams modules, and 8 for the rest, ensuring compatibility with their respective minimum Java versions. Similarly, the release parameter in scalac is set to 8 for the streams modules and 11 for the rest.

Scala 2.12 is the only supported version in Apache Kafka.
![image](https://github.com/user-attachments/assets/d441b09b-d4a5-4fb5-b159-e5aee49fab73)

1. Set Up Maven Build for Apache Kafka
First, you need to convert your Gradle build setup to Maven. Below is an example pom.xml configuration for your project using Maven, which will set the project version, dependencies, plugins, and other configuration for building, testing, and running Kafka.

pom.xml Setup:
xml
Copy code
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>org.apache.kafka</groupId>
    <artifactId>kafka</artifactId>
    <version>2.12-3.6.2</version>
    <packaging>jar</packaging>

    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <flink.version>1.14.6</flink.version>
    </properties>

    <dependencies>
        <!-- Kafka Dependencies -->
        <dependency>
            <groupId>org.apache.kafka</groupId>
            <artifactId>kafka-clients</artifactId>
            <version>2.12-3.6.2</version>
        </dependency>

        <!-- Flink Dependencies -->
        <dependency>
            <groupId>org.apache.flink</groupId>
            <artifactId>flink-streaming-java_2.12</artifactId>
            <version>${flink.version}</version>
        </dependency>

        <!-- JUnit for testing -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13</version>
            <scope>test</scope>
        </dependency>

        <!-- Other necessary dependencies -->
    </dependencies>

    <build>
        <plugins>
            <!-- Plugin for Javadoc generation -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-javadoc-plugin</artifactId>
                <version>3.1.0</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>javadoc</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>

            <!-- Plugin for compiling sources with javac -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>

    <repositories>
        <!-- Add any necessary repositories here -->
    </repositories>
</project>
2. Steps to Build Apache Kafka with Maven
Build the JAR: To build your Kafka project using Maven, run:

bash
Copy code
mvn clean install
This will compile your code and install the JAR to your local Maven repository.

Build Javadoc: To generate Javadoc documentation, use:

bash
Copy code
mvn javadoc:javadoc
Run Tests: To run unit tests, use:

bash
Copy code
mvn test
To run integration tests:

bash
Copy code
mvn verify
Build Test JAR: To create a test JAR file:

bash
Copy code
mvn package -DskipTests
3. Run Apache Kafka on Ubuntu
To run Apache Kafka on Ubuntu, follow these steps:

Install Java 8 (if not already installed):

bash
Copy code
sudo apt update
sudo apt install openjdk-8-jdk
Install Kafka: Download the desired version of Apache Kafka and extract it:

bash
Copy code
wget https://downloads.apache.org/kafka/3.6.2/kafka_2.12-3.6.2.tgz
tar -xvf kafka_2.12-3.6.2.tgz
cd kafka_2.12-3.6.2
Start Kafka Broker: Before starting the broker, you need to format the storage and create a Kafka cluster:

bash
Copy code
KAFKA_CLUSTER_ID="$(./bin/kafka-storage.sh random-uuid)"
./bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c config/kraft/reconfig-server.properties
./bin/kafka-server-start.sh config/kraft/reconfig-server.properties
Using Docker to Run Kafka: Alternatively, you can run Kafka using Docker:

bash
Copy code
docker run -p 9092:9092 apache/kafka:3.7.0
4. Running System Tests
To run system tests on Kafka, you can use the following command after setting up your environment:

bash
Copy code
mvn clean test -Dtest=SystemTest
You may need to adjust the test configuration based on your setup.

5. Dependency Analysis
To perform dependency analysis in Maven, run the following command:

bash
Copy code
mvn dependency:tree
This will list the project dependencies and their versions.

6. Common Build Options
Some common build options you may use for your Maven-based Kafka project include:

Max parallel fork threads:

bash
Copy code
mvn test -DmaxParallelForks=4
Skip signing of artifacts:

bash
Copy code
mvn install -DskipSigning=true
Run a specific test:

bash
Copy code
mvn -Dtest=TestClassName test
7. Contributing to Kafka
To contribute to the Kafka project, follow these steps:

Fork the Kafka repository.
Make your changes and test them locally using the Maven build.
Submit a pull request following the guidelines listed on the Apache Kafka Contribution Page.
8. Running Vagrant
If you need to run Kafka in a Vagrant environment, follow the instructions in the vagrant/README.md file provided by the Kafka project. You can run Kafka on a virtual machine using Vagrant by executing:

bash
Copy code
vagrant up
This command will start the virtual machine and install Kafka on it.


Contribution
Apache Kafka is interested in building the community; we would welcome any thoughts or patches. You can reach us on the Apache mailing lists.

To contribute follow the instructions here:

https://kafka.apache.org/contributing.html

![image](https://github.com/user-attachments/assets/adc6ebba-cb6a-4c93-ae4c-73e3cce49e41)



