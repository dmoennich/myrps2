package main.java.rps.ui;


public class UnknownIdentifierException extends Exception{

    private String identifier = null;

    public UnknownIdentifierException(String identifier){
        this.identifier = identifier;
    }


    public String getMessage(){
        return "Invalid identifier: " +identifier;
    }

}
