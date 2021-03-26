package com.rusanov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubleProperties {



    public static void main(String[] args) {

        DoubleProperties doubleProperties = new DoubleProperties();
        List<Argument> arguments = doubleProperties.parse(args, ';');
        Argument minimumArg = doubleProperties.getMinimumArg(arguments);
        System.out.println(minimumArg.toString());
    }




    private List<Argument> parse(String[] args, char separator) {
        checkArgs(args);
        List<Argument> arguments = new ArrayList<>();
        String[] separatedStrings = args[0].split(String.valueOf(separator));
        for (var property : separatedStrings) {
            String[] splittedProperty = property.split("=");

            Argument argument = parseProperty(splittedProperty);
            if(argument != null) {
                arguments.add(argument);
            }
        }
        return arguments;
    }

    private static void checkArgs(String[] args) {
        if(args == null || args.length  == 0) {
            System.out.println("Enter argument and rerun.");
            System.exit(1);
        }
        if(args.length > 1) {
            System.out.println("more than 1 arg.\nArguments pattern:\nprop1=value;prop2=value");
            System.exit(1);
        }
    }

    private Argument parseProperty(String[] splittedProperty) {
        if(splittedProperty.length != 2) {
            System.out.println("bad property:" + Arrays.toString(splittedProperty));
            return null;
        }
        String property = splittedProperty[0];
        Double value  = Double.parseDouble(splittedProperty[1]);
        return new Argument(property,value);
    }


    private Argument getMinimumArg(List<Argument> arguments) {
        return  arguments.stream().min(Argument::compareTo).orElseThrow();
    }
}
