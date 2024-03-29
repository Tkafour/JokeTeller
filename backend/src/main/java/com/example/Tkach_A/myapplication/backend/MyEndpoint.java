/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.Tkach_A.myapplication.backend;

import com.example.JokeSupply;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.Tkach_A.example.com",
    ownerName = "backend.myapplication.Tkach_A.example.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that provides a joke */
    @ApiMethod(name = "getJokes")
    public MyBean getJokes() {
        MyBean response = new MyBean();
        response.setData(JokeSupply.getJokes());

        return response;
    }

}
