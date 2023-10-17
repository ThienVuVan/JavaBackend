<<<<<<- How Does Spring Security Work? Let Me Explain It ->>>>>

1.Spring Security Architecture / Flow

                    <---- Architecture ---->
    * Request --> Authentication Filter(extract info of client)
    * --> Authentication Manager (interface) --> Authentication Provider
    * --> UserDetailService (interface) --> return implementation of UserDetail interface
    * --> Save information authenticated of user in SecurityContextHolder to Authorization
    * --> go to endpoint;

                        <--- Flow --->
    * Request --> Security Filter Chain or Authentication Filter (it can be default filter chain or custom filter chain)
    * --> UsernamePasswordAuthenticationToken will hold username and password from request
    * --> Spring Security will default use AuthenticationManager is implemented by ProviderManager
    * --> call default Authentication Provider is implemented by some class like DaoAuthenticationProvider
    * --> call implementation of UserDetailService to retrieve Data and return implementation of UserDetail
    * --> comparing UsernamePasswordAuthenticationToken and UserDetail
    * --> true --> set authentication object to SecurityContextHolder
    * --> false ---> throw exception
    * --> go to endpoint;

2. Detail Implementation ( see code )

3. Spring Security Using Jwt Token
    3.1 Request Login Without Jwt Token
        * Target: create and send to client new jwt token and a refresh token
        * Explain Flow:
            * Request --> JWTLoginFilter (a custom filter)
            * Retrieve username and password set into UsernamePasswordAuthenticationToken(as token)
            * call Authentication Manager to authenticate token
            * success --> call TokenAuthenticationService(custom) to create Jwt token with username and authorities
                and other mandatory feature;
            * set jwt token to response header
    3.2 Request within Jwt Token
        * Request --> JWTAuthenticationFilter (a custom filter)
        * Retrieve JwtToken from header of request
        * retrieve username and authorities from JwtToken (need to update)
        * return an implementation of Authentication interface
        * and set into SecurityContextHolder to Authorization
        * go to endpoint

                --------------------------------- End --------------------------------------