// Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
// Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль.

// 2. Customer: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Номер банковского счета.
// Создать массив объектов. Вывести:
// a) список покупателей в алфавитном порядке;
// b) список покупателей, у которых номер кредитной карточки находится в заданном интервале.

import java.util.*;

class Lab3_2_2 {
    public static void main(String[] args) {
        Customer cst1 = new Customer(
                "1234",
                "Dikarev",
                "Andrey",
                "Sergeevich",
                "Moscow",
                "1234-1234-1234-1234",
                "8934758927589235"
        );

        Customer cst2 = new Customer(
                "9823745",
                "Avdeenko",
                "Maxim",
                "Sergeevich2",
                "St. Petersburg",
                "4321-4321-4321-4321",
                "123904812904849"
        );

        Customers array = new Customers(new Customer[]{cst1, cst2});

        Customer[] filtered = array.getAlphabetically();
        for (Customer st: filtered) {
            System.out.println(st);
        }
    }
}

class Customers {
    protected Customer[] data;

    public Customers(Customer[] data) {
        this.data = data;
    }

    public Customer[] getAlphabetically() {
        Arrays.sort(this.data, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.lastName.compareToIgnoreCase(o2.lastName);
            }
        });

        return this.data;
    }

    public Customer[] getByCardNumRange(String min, String max) {
        ArrayList<Customer> result = new ArrayList<Customer>();
        long
            parsedMin = Long.parseUnsignedLong(min),
            parsedMax = Long.parseUnsignedLong(max);

        for (Customer cst: this.data) {
            String cleanedStr = cst.cardNum.replaceAll("-", "");
            long num = Long.parseUnsignedLong(cleanedStr);
            if (num > parsedMin && num < parsedMax) {
                result.add(cst);
            }
        }

        return result.toArray(new Customer[result.size()]);
    }
}

class Customer {
    protected String id;
    protected String lastName;
    protected String firstName;
    protected String patronymic;
    protected String address;
    protected String cardNum;
    protected String accountNum;

    public Customer(String id, String lastName, String firstName, String patronymic, String address, String cardNum, String accountNum) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.cardNum = cardNum;
        this.accountNum = accountNum;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNum() {
        return this.cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getAccountNum() {
        return this.accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", accountNum='" + accountNum + '\'' +
                '}';
    }
}