package services;

import java.util.List;

    public class CalculationService {

    // como a operação da clase 'CalculationService' é static,
    // a classe não será instanciada;
    // declaração do tipo 'T' como 'Comparable' para que o 'compareTo()'
    // funcione, pois '<T extends Comparable<? super T>>' significa que
    // esse método pode trabalhar com qualquer tipo 'T', desde que tal seja
    // qualquer subtipo 'Comparable':
    public static <T extends Comparable<? super T>> T max(List<T> list) {
        if (list.isEmpty()) {
            // teste para verificar se a lista é vazia; o teste um boolean(?):
            throw new IllegalStateException("List can't be empty");
        }
        // iniciando a comparação a partir do elemento (nó) '0' da lista:
        T max = list.get(0);
        // para cada tipo T 'item' em 'list' aplica-se a verificação
        // com o método '.compareTo()', para comparar com outros
        // elementos (nós) 'max' na mesma lista; com o 'comparable',
        // se a diferença entre os elementos comparados for maior que zero,
        // significa que o primeiro 'item' é maior que o segundo 'max':
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                // se for maior, a variável 'max' é atualizada com o valor de 'item':
                max = item;
            }
        }
        return max;
    }
}
