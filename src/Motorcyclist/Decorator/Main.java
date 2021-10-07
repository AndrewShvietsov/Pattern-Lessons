package Motorcyclist.Decorator;

public class Main {
    public static void main(String[] args) {
        JacketDecorate jacketDecorate = new JacketDecorate("Decorate Jacket", 1000, 6);
        HelmetDecorate helmetDecorate = new HelmetDecorate("Decorate Helmet", 500, 4);
        DecoratorCreate decoratorCreate = new DecoratorCreate(jacketDecorate);
        decoratorCreate = new DecoratorCreate(helmetDecorate);
        System.out.println(decoratorCreate.toString());
    }
}
