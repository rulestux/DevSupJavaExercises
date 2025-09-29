package model.exceptions;

// estrutura de uma classe de exceção personalizada:
// estendendo a superclasse Java 'Exception'
// (ver nota abaixo):
public class DomainException extends Exception {
    // declaração da versão da classe 'serializable'
    // 'Exception':
    private static final long serialVersionUID = 1L;

    // construtor repassando uma string 'msg' a
    // ser armazenada dentro da exceção:
    public DomainException(String msg) {
        super(msg);
    }
}

// a superclasse Java 'Exception' exige que as
// exceções com 'throw' sejam tratadas já na
// assinatura dos métodos nas classes, no
// presente código, através da propagação
// com 'throws'; um alternativa é a superclasse
// 'RuntimeException', que desobriga essa abordagem.
