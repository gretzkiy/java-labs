// Построить модель программной системы.
// 2. Система Платежи. Клиент имеет Счет в банке и Кредитную Карту (КК).
// Клиент может оплатить Заказ, сделать платеж на другой Счет, заблокировать КК и аннулировать Счет.
// Администратор может заблокировать КК за превышение кредита.

class Lab3_4_2 {
    public static void main(String[] args) {
        Client client = new Client(
                "Andrey",
                new CreditCard(200000, "1234-1234-1234-1234"),
                new BankAccount("4132-1234-1234-5677")
        );

        Admin.blockCreditCard(client.creditCard);
        System.out.println(client.pay(1000));
    }
}

class Admin {
    static boolean blockCreditCard(CreditCard card) {
        return card.block();
    }
}

class Client {
    protected String name;
    protected CreditCard creditCard;
    protected BankAccount bankAccount;

    public Client(String name, CreditCard creditCard, BankAccount bankAccount) {
        this.name = name;
        this.creditCard = creditCard;
        this.bankAccount = bankAccount;
    }

    public boolean transferMoney(BankAccount to, double amount) {
        if (this.bankAccount.pay(amount)) {
            if (to.topUp(amount)) {
                return true;

            } else {
                this.bankAccount.topUp(amount);
                return false;
            }
        }

        return false;
    }

    public boolean pay(double amount) {
        return this.creditCard.pay(amount);
    }

    public boolean cancelBankAccount() {
        return this.bankAccount.cancel();
    }

    public boolean blockCreditCard() {
        return this.creditCard.block();
    }
}

class BankAccount {
    protected double balance = 0;
    protected boolean isCanceled = false;
    protected String num;

    public BankAccount(String num) {
        this.num = num;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public boolean topUp(double amount) {
        if (this.isCanceled) {
            return false;
        }

        this.balance += amount;
        return true;
    }

    public boolean cancel() {
        if (this.isCanceled) {
            return false;
        }

        this.balance = 0;
        this.isCanceled = true;
        return true;
    }

    public boolean pay(double amount) {
        if (this.isCanceled) {
            return false;
        }

        if (this.balance - amount < 0) {
            return false;
        }

        this.balance -= amount;
        return true;
    }
}

class CreditCard {
    protected boolean isBlocked = false;
    protected double maxCredit;
    protected double credit = 0;
    protected String num;

    public CreditCard(double maxCredit, String num) {
        this.maxCredit = maxCredit;
        this.num = num;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public double getMaxCredit() {
        return maxCredit;
    }

    public double getCredit() {
        return credit;
    }

    public boolean pay(double amount) {
        if (this.isBlocked) {
            return false;
        }

        this.credit -= amount;
        return true;
    }

    public boolean topUp(double amount) {
        if (this.isBlocked) {
            return false;
        }

        this.credit += amount;
        return true;
    }

    public boolean block() {
        if (this.isBlocked) {
            return false;
        }

        this.isBlocked = true;
        return true;
    }
}