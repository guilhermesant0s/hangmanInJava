import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] palavras = {"casa", "carro", "banana", "computador", "elefante"};
        String palavraEscolhida = palavras[(int) (Math.random() * palavras.length)];
        int tentativas = 6;
        char[] palavraAdivinhada = new char[palavraEscolhida.length()];

        // Inicializa o array palavraAdivinhada com traços
        for (int i = 0; i < palavraAdivinhada.length; i++) {
            palavraAdivinhada[i] = '_';
        }

        boolean jogoTerminado = false;
        while (!jogoTerminado) {
            System.out.println("Palavra: " + new String(palavraAdivinhada));
            System.out.println("Tentativas restantes: " + tentativas);
            System.out.print("Digite uma letra: ");
            char letra = scanner.nextLine().charAt(0);

            boolean letraCorreta = false;
            for (int i = 0; i < palavraEscolhida.length(); i++) {
                if (palavraEscolhida.charAt(i) == letra) {
                    palavraAdivinhada[i] = letra;
                    letraCorreta = true;
                }
            }

            if (!letraCorreta) {
                tentativas--;
                System.out.println("Letra incorreta!");
                if (tentativas == 0) {
                    jogoTerminado = true;
                    System.out.println("Você perdeu! A palavra correta era: " + palavraEscolhida);
                }
            }

            if (new String(palavraAdivinhada).equals(palavraEscolhida)) {
                jogoTerminado = true;
                System.out.println("Parabéns! Você adivinhou a palavra correta: " + palavraEscolhida);
            }
            tentativas -= 1;
        }

        scanner.close();
    }
}
