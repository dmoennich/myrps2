package main.java.rps.ui;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Identifier<I,O> {

    private Map<I,O> identMap = new HashMap<I, O>();

    public void addIdentifier(I identifier, O object){
        identMap.put(identifier, object);
    }


    public O identify(I identifier) throws UnknownIdentifierException {
        O o = identMap.get(identifier);
        if(o != null){
            return o;
        } else {
            throw new UnknownIdentifierException(identifier.toString());
        }
    }


    public Set<I> getIdentifiers(){
        return identMap.keySet();
    }



}
