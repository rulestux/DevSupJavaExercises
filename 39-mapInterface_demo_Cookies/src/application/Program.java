package application;

import java.util.Map;
import java.util.TreeMap;

public class Program {

    public static void main(String[] args) {

        // sintaxe 'Map<key, value>':
        Map<String, String> cookies = new TreeMap<>();

        cookies.put("username", "Maria");
        cookies.put("email", "maria@gmail.com");
        cookies.put("phone", "99711122");

        // remover registro de email:
        cookies.remove("email");
        // inserir novo telefone, com a mesma chave
        // anterior, o valor dela é substituído:
        cookies.put("phone", "99771133");

        // testar se contém a chave fone:
        System.out.println("Contains 'phone'? " + cookies.containsKey("phone"));

        // retornar o valor de uma chave:
        System.out.println("Phone number: " + cookies.get("phone"));
        // retornar chave inexistente, feito o 'email' removido acima:
        System.out.println("Email: " + cookies.get("email"));
        // retornar comprimento do conjunto:
        System.out.println("Size " + cookies.size());

        System.out.println("ALL COOKIES:");
        // para cada 'String key' no conjunto de chaves
        // 'cookies.keySet()' (função que retorna um 'Set(k)'
        // com as chaves de um 'Map'), imprimir na tela
        // a chave e a função 'cookies.get(key)', passando
        // a chave como parâmetro:
        for (String key : cookies.keySet()) {
            System.out.println(key + ": " + cookies.get(key));
        }
    }
}
