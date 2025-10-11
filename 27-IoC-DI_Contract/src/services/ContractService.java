package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {

    // injeção de dependência: associação com a interface
    // 'onlinePaymentService':
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    // método para instanciar os nós da lista 'installments',
    // através do getter 'getInstallments()':
    public void processContract(Contract contract, int months) {

        double basicQuota = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);

            // cálculo dos juros:
            double interest = onlinePaymentService.interest(basicQuota, i);
            // cálculo da taxa:
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);
            // cálculo final da parcela de cada mês:
            double quota = basicQuota + interest + fee;
            // instanciação de cada parcela:
            contract.getInstallments().add(new Installment(dueDate, quota));
        }
    }
}
