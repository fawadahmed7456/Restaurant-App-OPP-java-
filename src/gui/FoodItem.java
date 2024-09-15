package gui;


interface Food {
    String getName();
    double getPrice();
    String getImageURL();
}

class FoodItem implements Food {
    private String name;
    private double price;
    private String imageURL;

    public FoodItem(String name, double price, String imageURL) {
        this.name = name;
        this.price = price;
        this.imageURL = imageURL;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getImageURL() {
        return imageURL;
    }
}

class FastFood extends FoodItem {
    private String spiciness;

    public FastFood(String name, double price, String imageURL, String spiciness) {
        super(name, price, imageURL);
        this.spiciness = spiciness;
    }

    public String getSpiciness() {
        return spiciness;
    }
}

class Dessert extends FoodItem {
    private String topping;

    public Dessert(String name, double price, String imageURL, String topping) {
        super(name, price, imageURL);
        this.topping = topping;
    }

    public String getTopping() {
        return topping;
    }
}

class Drink extends FoodItem {
    private String coldness;

    public Drink(String name, double price, String imageURL, String coldness) {
        super(name, price, imageURL);
        this.coldness = coldness;
    }

    public String getColdness() {
        return coldness;
    }
}

