// Построить модель программной системы.
// 9. Система Интернет-магазин. Администратор добавляет информацию о Товаре. Клиент делает и оплачивает Заказ на Товары.
// Администратор регистрирует Продажу и может занести неплательщиков в «черный список».

import java.util.*;

class Lab3_4_9 {
    public static void main(String[] args) {
        Product product1 = new Product("Цветы красивые", "Розы", 150);
        Product product2 = new Product("Орехи вкусные", "Кедровые орехи", 200);

        Shop shop = new Shop();

        ShopAdmin admin = new ShopAdmin(shop);

        admin.addNewProduct(product1);
        admin.addNewProduct(product2);

        ArrayList<Product> orderProducts = new ArrayList<Product>();
        orderProducts.add(product1);
        Order order = new Order(orderProducts);

        ShopClient shopClient = new ShopClient("dikarev");
        shopClient.payOrder(order);

        admin.blackListClient(shopClient);
    }
}

class ShopAdmin {
    protected Shop shop;

    public ShopAdmin(Shop shop) {
        this.shop = shop;
    }

    public void blackListClient(ShopClient client) {
        this.shop.blacklistClient(client);
    }

    public void addNewProduct(Product product) {
        this.shop.addProduct(product);
    }
}

class Shop {
    protected ArrayList<Product> products;
    protected HashSet<ShopClient> blackList;

    public Shop() {
        this.blackList = new HashSet<ShopClient>();
        this.products = new ArrayList<Product>();
    }

    public void blacklistClient(ShopClient client) {
        this.blackList.add(client);
    }

    public boolean isClientBlacklisted(ShopClient client) {
        return this.blackList.contains(client);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}

class Order {
    protected double amount = 0;
    protected ArrayList<Product> products;
    protected boolean isPayed = false;

    public Order(ArrayList<Product> products) {
        this.products = products;
        for (Product product: this.products) {
            this.amount += product.price;
        }
    }

    public void pay() {
        this.isPayed = true;
    }
}

class ShopClient {
    protected String login;
    protected String id;

    public ShopClient(String login) {
        this.login = login;
        this.id = UUID.randomUUID().toString();
    }

    public void payOrder(Order order) {
        order.pay();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        };

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        ShopClient that = (ShopClient) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class Product {
    protected String info;
    protected String name;
    protected double price;
    protected String id;

    public Product(String info, String name, double price) {
        this.info = info;
        this.name = name;
        this.price = price;
        this.id = UUID.randomUUID().toString();
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        };

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Product that = (Product) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}