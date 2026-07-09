# Quick Reference - Corrected Files

## pom.xml
Located at: `/home/cse/581-Devops/DevOps-Exp1/pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>devops-exp1</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.1.7</version>
        <relativePath/>
    </parent>

    <properties>
        <java.version>17</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

---

## RegistrationController.java
Located at: `/home/cse/581-Devops/DevOps-Exp1/src/main/java/com/example/registration/controller/RegistrationController.java`

```java
package com.example.registration.controller;

import com.example.registration.entity.User;
import com.example.registration.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // resolves to src/main/resources/templates/register.html
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, RedirectAttributes ra) {
        userRepository.save(user);
        ra.addAttribute("success", "true");
        return "redirect:/register";
    }

}
```

**Key Changes**:
1. Changed `@RestController` → `@Controller` (for MVC/templates support)
2. Added `@GetMapping("/register")` to display the form
3. Added `@ModelAttribute` for form data binding
4. Added redirect after POST (POST-Redirect-GET pattern)

---

## application.properties
Located at: `/home/cse/581-Devops/DevOps-Exp1/src/main/resources/application.properties`

```properties
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/eventdb
spring.datasource.username=root
spring.datasource.password=1234
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

**Key Points**:
- Port: 8080
- Database URL includes `/eventdb`
- Driver class: `com.mysql.cj.jdbc.Driver`
- DDL auto: `update` (creates/updates tables automatically)
- Show SQL: `true` (logs all queries)
- Dialect: `MySQL8Dialect`

---

## register.html (Template)
Located at: `/home/cse/581-Devops/DevOps-Exp1/src/main/resources/templates/register.html`

```html
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Event Registration Form</title>
</head>

<body>

<div class="container">

<h1>Event Registration</h1>
<p class="subtitle">Fill your details to register for the event</p>

<form action="/register" method="POST">

<label>First Name</label>
<input type="text" name="firstname" required>

<label>Last Name</label>
<input type="text" name="lastname" required>

<label>Username</label>
<input type="text" name="username" required>

<label>Password</label>
<input type="password" name="password" required>

<label>Email</label>
<input type="email" name="email">

<label>Phone Number</label>
<input type="tel" name="phone">

<button type="submit">Register Now</button>

</form>

</div>

</body>
</html>
```

**Important**: This file must be in `src/main/resources/templates/` so Thymeleaf can find it.

---

## User.java (Entity - No Changes Needed)
Located at: `/home/cse/581-Devops/DevOps-Exp1/src/main/java/com/example/registration/entity/User.java`

Already correct with all required annotations:
- `@Entity` - JPA entity
- `@Table(name="users")` - Maps to database table
- `@Id` - Primary key
- `@GeneratedValue(strategy=GenerationType.IDENTITY)` - Auto-increment

---

## UserRepository.java (No Changes Needed)
Located at: `/home/cse/581-Devops/DevOps-Exp1/src/main/java/com/example/registration/repository/UserRepository.java`

Already correct:
```java
public interface UserRepository extends JpaRepository<User, Long> {
}
```

---

## RegistrationApplication.java (No Changes Needed)
Located at: `/home/cse/581-Devops/DevOps-Exp1/src/main/java/com/example/registration/RegistrationApplication.java`

Already correct with `@SpringBootApplication` annotation.

---

## Start the Application

```bash
cd /home/cse/581-Devops/DevOps-Exp1
mvn -DskipTests spring-boot:run
```

Then open: `http://localhost:8080/register`

