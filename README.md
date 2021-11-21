# What are Cookies?
Simply put, cookies are nothing but a piece of information that is stored on the client-side (i.e. in the browser). The client sends them to the server with each request and servers can tell the client which cookies to store.
### How Do Cookies Work?
Cookies are sent to the client by the server in an HTTP response and are stored in the client (user’s browser)
Let’s imagine a scenario where a user logs in. The client sends a request to the server with the user’s credentials. The server authenticates the user, creates a cookie with a user id encoded, and sets it in the response header. The header Set-Cookie in the HTTP response would look like this:
``Set-Cookie: user-id=c2FtLnNtaXRoQGV4YW1wbGUuY29t``Once the browser gets the cookie, it can send the cookie back to the server. To do this, the browser adds the cookie to an HTTP request by setting the header named Cookie
``Cookie: user-id=c2FtLnNtaXRoQGV4YW1wbGUuY29t`` The server reads the cookie from the request verifies if the user has been authenticated or not, based on the fact if the user-id is valid.
As mentioned, a cookie can have other optional attributes, so let’s explore them
## How to develop cookies by springboot?
### Create cookies
``createCookie(HttpServletResponse httpServletResponse)`` is the controller than has the role to create a cookie the use. first we create object from Cookie class ,and we initialize any attribute from Cookie class . after we need to add it to
``httpServletResponse``
### Reading cookies
if we use ``@CookieValue(name ="user-id",defaultValue = "default-user-id")String cookieName`` annotations and set up the cookie name we want to read we can have the cookie value when user send  Get request
### Delete cookies
by setting responseCookies value to null ``ResponseCookie responseCookie=ResponseCookie.from("user-id",null).build()`` we can delete the cookie from client side