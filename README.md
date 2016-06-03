[![Build Status](https://travis-ci.org/tvd12/restful-client.svg?branch=master)](https://travis-ci.org/tvd12/restful-client)
[![Dependency Status](https://www.versioneye.com/user/projects/5717990efcd19a00415b1f61/badge.svg?style=flat)](https://www.versioneye.com/user/projects/5717990efcd19a00415b1f61)
[![Coverage Status](https://coveralls.io/repos/github/tvd12/restful-client/badge.svg?branch=master)](https://coveralls.io/github/tvd12/restful-client?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.tvd12/restful-client/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.tvd12/restful-client)
[![Javadoc](https://javadoc-emblem.rhcloud.com/doc/com.tvd12/restful-client/badge.svg)](http://www.javadoc.io/doc/com.tvd12/restful-client)

#Synopsis

This project support to call restful api from client

#Code Example

**1. Call get method**

```java
	AccessTokenWrapper accessToken = RestCaller.create()
        .entity().header()
        .accept(MediaType.APPLICATION_JSON)
        .set("X-ConsumerKey", "abcxyz")
        .credential("Authorization", "email@email.com", "123456")
        .contentType(MediaType.APPLICATION_JSON)
        .done().done()
        .uri().url(URL).done()
        .template()
        .connectTimeOut(3 * 1000)
        .readTimeOut(3 * 1000)
        .done()
        .get(AccessTokenWrapper.class);
```

**2. Call post method**
```java
	AccessTokenWrapper accessToken = RestCaller.create()
        .entity().header()
        .accept(MediaType.APPLICATION_JSON)
        .set("X-ConsumerKey", "abcxyz")
        .credential("Authorization", "email@email.com", "123456")
        .contentType(MediaType.APPLICATION_JSON)
        .done().done()
        .uri().url(URL).done()
        .template()
        .connectTimeOut(3 * 1000)
        .readTimeOut(3 * 1000)
        .done()
        .post(AccessTokenWrapper.class); // also put and delete method
```
#Motivation

Use Spring framework to call restful api is a good choice and builder is a good design patter, so we combine them to make calling restful api more convenient

#Installation

```xml
	<dependency>
		<groupId>com.tvd12</groupId>
		<artifactId>restful-client</artifactId>
		<version>1.0.0</version>
	</dependency>
```
#API Reference

http://www.javadoc.io/doc/com.tvd12/restful-client

#Tests

mvn test

#Contributors

None

#License

- Apache License, Version 2.0
	


