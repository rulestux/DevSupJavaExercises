package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<Object> myObjs = new ArrayList<Object>();

        // trazendo dados de 'myInts' para 'myObjs':
        copy(myInts, myObjs);
        // método para imprimir na tela:
        printList(myObjs);
        // apensando dados de 'myDoubles' ao final de 'myObjs':
        copy(myDoubles, myObjs);
        // método para imprimir na tela:
        printList(myObjs);
    }

    // definição do método 'copy', cujos argumentos são a origem (source) e o
    // destino (destiny): 'List<? extendes Number>', o 'source', é uma lista
    // específica do tipo 'Number' (que pode ser 'Integer', 'Double', 'Long' etc.)
    // e a lista 'List<? super Number>' equivale ao tipo 'Obejct' (super Number),
    // que abarca o tipo 'String' e 'Boolean', por ex.; em 'extends Number' há
    // um caso de COVARIÂNCIA (get sem put), enquanto em 'super Number',
    // um caso de CONTRAVARIÂNCIA (put sem get):
    public static void copy(List<? extends Number> source, List<? super Number> destiny){
        for (Number number : source) {
            destiny.add(number);
        }
    }

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
        System.out.println();
    }
}
