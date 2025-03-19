public class MSNMessenger extends MessengerSystem {
    @Override
    public void enviarMensagem() {
        System.out.println("Enviando mensagem pelo MSN");
    }

    @Override
    public void receberMensagem() {
        System.out.println("Recebendo mensagem pelo MSN");
    }
}
