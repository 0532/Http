## Http
Tiny client for web services
====================
JavaLite HTTP is a tiny library for making HTTP requests and returning responses. It has no dependencies other than the JDK.

### How to GET

```Java
Get get = Http.get("http://yahoo.com");
System.out.println(get.text());
System.out.println(get.headers());
System.out.println(get.responseCode())
```
### How to POST

* POST binary content

```Java
byte[] content = ...; // fill with your data

Post post = Http.post("http://yahoo.com", content)
                .header(headerName, headerValue);
System.out.println(post.text());
System.out.println(post.headers());
System.out.println(post.responseCode())
```

* POST JSON content

```Java
Post post = Http.post(url, content)
                .header("Accept", "application/json")
```

### How to POST a form

Posting a single value is easy:

```Java
Post post = Http.post("http://example.com/hello")
                .param("name", "John");
System.out.println(post.text());
```

Posting multiple values can be done:

```Java
Post post = Http.post("http://example.com/hello")
                .param("first_name", "John")
                .param("last_name", "Doe");
System.out.println(post.text());
```

or even better:

```Java
Post post = Http.post("http://example.com/hello").params("first_name", "John", "last_name", "Doe");
System.out.println(post.text());
```

### How to PUT and DELETE

Similar to the above. You can find full JavaDoc here: `JavaLite HTTP JavaDoc`

* Basic authentication

```Java
String response = Http.get(url).basic(user, password).text();
```

* Sending multipart requests

In case you need to send `multipart messages`, you can do so simply by executing one line of code:

```Java
Multipart mp = Http.multipart("http://myserver.com/upload/")
                .field("name1", "val1")
                .file("file1", "/home/johndoe/test.txt");
System.out.println(mp.text());
```

You can use any combination of other methods to modify timeouts, basic authentication, headers, etc.

