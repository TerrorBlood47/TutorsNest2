# Tutor's Nest

![Project Image](/Images/tutorsNestCoverPhoto.png)

>A javafx project 

Tutor's Nest is a user-friendly desktop application created using the JavaFX framework. Its main goal is to provide a centralized platform where students can effortlessly connect with private tutors who specialize in the subjects they need help with. With Tutor's Nest, students can easily navigate through its intuitive interface to search for tutors based on specific criteria such as subject, location, and availability. Once a suitable tutor is found, students can schedule a session, book it, and pay for it through the application, all in a secure and hassle-free manner. Tutor's Nest is designed to simplify the process of finding and booking private tutoring services, making academic help outside of the traditional classroom setting easily accessible to all.

---

### Table of Contents

- **[How To Install & Run Tutor's Nest](#how-to-install-and-run)**
- **[PLatform, Library & Tools](#platform-library-and-tools)**
- **[Project Interface](#project-interface)**
- **[Limitation](#limitations)**
- **[Reference](#reference)**
- **[Author Info](#author-info)**


---


# How To Install & Run Tutor's Nest

### Download & Installation

- Install _INTELLIJ IDEA Community Edition_ from the given link: [Intellij IDEA Community Edition](https://www.jetbrains.com/idea/download/#section=linux)
- Download and set up JDK and MySQL in your computer using these command lines
~~~
sudo apt-get update
sudo apt-get install openjdk-20-jdk openjfx
sudo apt-get install mysql-server
sudo mysql_secure_installation
~~~
- Download Javafx SDK 20 from here : [JavaFX SDK](https://openjfx.io)
- Download "mysql-connector-java-8.0.32.jar" from this link: [MySQL Connector Java](https://dev.mysql.com/downloads/connector/j/)

### Project SetUp

- Clone the git repository in the INTELLIJ ide
```
git clone https://github.com/fahim33-eng/tutorsNest2.git
```
- Go to File > Project Structure > Libraries , click the plus sign and add the path to the 'lib' folder of the 'SDK' folder you've downloaded
- Add "mysql-connector-java-8.0.32.jar" in File > Project Structure > Modules 

### Build & Run
- Go to src/main/java/com/example/javaproject/Main.java and run the file
