package br.com.isedsonadriano.hello.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    public String hello(){
        return "Hello graphql";
    }

    public int soma (int a, int b){
        return a + b;
    }


}
