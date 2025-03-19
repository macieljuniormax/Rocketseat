public class MSNMessenger {
    public void enviarMensagem () {
        if (validaConectadoInternet()) {
            System.out.println("Enviando Mensgaem");
        } else {
            System.out.println("Computador offline");
        }
    }

    public void receberMensagem () {
        System.out.println("Recebendo Mensagem");
    }

    private boolean validaConectadoInternet () {
        System.out.println("Validando de está conectado à internet");
        return true;
    }

    private void salvarHistoricoMensagem () {
        System.out.println("Salvando o histórico de mensagens");
    }
}
