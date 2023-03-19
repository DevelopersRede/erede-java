package br.com.userede.erede;

import junit.framework.TestCase;

import java.util.Date;

@SuppressWarnings("NewClassNamingConvention")
public class eRedeTest extends TestCase {
    private Store store;

    private int sequence;

    public void setUp() {
        // Configuração da loja
        store = new Store("36046288", "3cf40bfefad642d788c4a2721c0a0b11", Environment.sandbox());

        sequence = 0;
    }

    private String getReference() {
        String reference = (new Date()).getTime() + "";

        reference = reference.substring(reference.length() - 8);
        reference = String.format("pedido%s%02d", reference, sequence++);

        return reference;
    }

    public void testShouldAuthorizeACreditcardTransaction() {
        // Transação que será autorizada
        Transaction transaction = new Transaction(20.99, getReference())
                .creditCard(
                        "5448280000000007",
                        "123",
                        "12",
                        "2023",
                        "Fulano de Tal"
                );

        transaction.setCapture(false);

        // Autoriza a transação
        TransactionResponse transactionResponse = (new eRede(store).create(transaction));

        assertEquals("00", transactionResponse.getReturnCode());
        assertEquals("00", transactionResponse.getBrand().getReturnCode());
        assertNotNull(transactionResponse.getTid());

        System.out.printf(
                "Transação com referência %s foi autorizada com sucesso: %s\n",
                transaction.getReference(),
                transactionResponse.getTid()
        );
    }

    public void testShouldAuthorizeAndCaptureACreditcardTransaction() {
        // Transação que será autorizada
        Transaction transaction = new Transaction(20.99, getReference())
                .creditCard(
                        "5448280000000007",
                        "123",
                        "12",
                        "2023",
                        "Fulano de Tal"
                );

        transaction.setCapture(true);

        // Autoriza a transação
        TransactionResponse transactionResponse = (new eRede(store).create(transaction));

        assertEquals("00", transactionResponse.getReturnCode());
        assertEquals("00", transactionResponse.getBrand().getReturnCode());
        assertNotNull(transactionResponse.getTid());

        System.out.printf(
                "Transação com referência %s foi autorizada com sucesso: %s\n",
                transaction.getReference(),
                transactionResponse.getTid()
        );
    }

    public void testShouldAuthorizeACreditcardTransactionWithInstallments() {
        // Transação que será autorizada
        Transaction transaction = new Transaction(20.99, getReference())
                .creditCard(
                        "5448280000000007",
                        "123",
                        "12",
                        "2023",
                        "Fulano de Tal"
                );

        transaction.setInstallments(3);

        // Autoriza a transação
        TransactionResponse transactionResponse = (new eRede(store).create(transaction));

        assertEquals("00", transactionResponse.getReturnCode());
        assertEquals("00", transactionResponse.getBrand().getReturnCode());
        assertNotNull(transactionResponse.getTid());

        System.out.printf(
                "Transação com referência %s foi autorizada com sucesso com %d parcelas: %s\n",
                transaction.getReference(),
                transaction.getInstallments(),
                transactionResponse.getTid()
        );
    }

    public void testShouldAuthorizeACreditcardTransactionWithSoftdescriptor() {
        // Transação que será autorizada
        Transaction transaction = new Transaction(20.99, getReference())
                .creditCard(
                        "5448280000000007",
                        "123",
                        "12",
                        "2023",
                        "Fulano de Tal"
                );

        transaction.setSoftDescriptor("LojaTeste");

        // Autoriza a transação
        TransactionResponse transactionResponse = (new eRede(store).create(transaction));

        assertEquals("00", transactionResponse.getReturnCode());
        assertEquals("00", transactionResponse.getBrand().getReturnCode());
        assertNotNull(transactionResponse.getTid());

        System.out.printf(
                "Transação com referência %s foi autorizada com sucesso com o softdescriptor %s: %s\n",
                transaction.getReference(),
                transaction.getSoftDescriptor(),
                transactionResponse.getTid()
        );
    }

    public void testShouldAuthorizeACreditcardTransactionWithAdditionalGatewayAndModuleInformation() {
        // Transação que será autorizada
        Transaction transaction = new Transaction(20.99, getReference())
                .creditCard(
                        "5448280000000007",
                        "123",
                        "12",
                        "2023",
                        "Fulano de Tal"
                );

        transaction.setAdditional(
                new Additional(
                        "1234", "56"
                )
        );

        // Autoriza a transação
        TransactionResponse transactionResponse = (new eRede(store).create(transaction));

        assertEquals("00", transactionResponse.getReturnCode());
        assertEquals("00", transactionResponse.getBrand().getReturnCode());
        assertNotNull(transactionResponse.getTid());

        System.out.printf(
                "Transação com referência %s foi autorizada com sucesso: %s\n",
                transaction.getReference(),
                transactionResponse.getTid()
        );
    }

    public void testShouldCreateADebitcardTransactionWithAuthentication() {
        Transaction transaction = new Transaction(20.99, getReference())
                .debitCard(
                        "5448280000000007",
                        "123",
                        "12",
                        "2023",
                        "Fulano de Tal"
                );

        transaction.threeDSecure(
                new Device(
                        1,
                        "BROWSER",
                        false,
                        500,
                        500
                ),
                ThreeDSecure.DECLINE_ON_FAILURE,
                ThreeDSecure.MPI_REDE
        );

        transaction.addUrl("https://redirecturl.com/3ds/success", Url.THREE_D_SECURE_SUCCESS);
        transaction.addUrl("https://redirecturl.com/3ds/failure", Url.THREE_D_SECURE_FAILURE);

        TransactionResponse transactionResponse = (new eRede(store).create(transaction));

        assertEquals("220", transactionResponse.getReturnCode());

        System.out.printf(
                "Transação com referência %s deve ser autenticada: %s\n",
                transaction.getReference(),
                transactionResponse.getThreeDSecure().getUrl()
        );
    }
}
