package sayHello;



public class European extends PersonImpl {

    public European(String name) {
        super(name);

    }

    @Override
    public String sayHello() {
        return "Hello!";
    }
}
