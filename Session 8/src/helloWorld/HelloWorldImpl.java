package helloWorld;

import javax.jws.WebService;


@WebService(endpointInterface = "helloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World: " + name;
    }
}
