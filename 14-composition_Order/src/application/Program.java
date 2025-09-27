package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.util.Scanner;

import entities.Product;
import entities.enums.OrderStatus;
import entities.Client;
import entities.Order;
import entities.OrderItem;

public class Program {

    public static void main(String[] args) throws ParseException {

    Scanner sc = new Scanner(System.in);

    DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    System.out.println("Enter client data:");
    System.out.print("Name: ");
    String name = sc.nextLine();
    System.out.print("E-mail: ");
    String email = sc.next();
    System.out.print("Birth date (DD/MM/YYYY): ");
    LocalDate birthDate = LocalDate.parse(sc.next(), fmt1);

    // instanciando o cliente:
    Client client = new Client(name, email, birthDate);

    System.out.println("Enter order data:");
    System.out.print("Status: ");
    OrderStatus status = OrderStatus.valueOf(sc.next());

    // instanciando o pedido com o cliente acima como parâmetro:
    Order order = new Order(LocalDateTime.now(), status, client);
    System.out.println("How many items to this order? ");
    int N = sc.nextInt();
    for (int i=1; i<=N; i++) {
        System.out.println("Enter #" + i + " item data:");
        System.out.print("Product name: ");
        sc.nextLine();
        String productName = sc.nextLine();
        System.out.print("Product price: ");
        double productPrice = sc.nextDouble();
        System.out.print("Quantity: ");
        int quantity =  sc.nextInt();

        // instanciando o produto:
        Product product = new Product(productName, productPrice);
        // instanciando o item de pedido associado a esse produto:
        OrderItem it = new OrderItem(quantity, productPrice, product);
        // inserindo item à lista de pedido:
        order.addItem(it);
    }

    System.out.println();
    System.out.println(order);

    sc.close();
    }
}

