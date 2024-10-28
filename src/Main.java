
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //inicia scanner para receber valores
        Scanner scanner = new Scanner (System.in);
        //Scanner iniciado

        String valoresConsumoSemanal = scanner.nextLine();
        //recebe valores em uma linha
        String  [] valoresDivididosPorVirgula = valoresConsumoSemanal.split(",");
        //dividi os valores por vírgula
        //proximo passo é usar o metodo parsedouble para converter cada valor da string para double.
        double[] valoresConvertidos = new double[valoresDivididosPorVirgula.length];
        for (int i=0; i < valoresDivididosPorVirgula.length; i++) {
            valoresConvertidos[i] = Double.parseDouble(valoresDivididosPorVirgula[i].trim());
        }
        
        System.out.println("Total mensal: " + valorMensal(valoresConvertidos) + " MB");
        System.out.println("Media semanal: " + mediaSemanal(valoresConvertidos) + " MB");
        int indiceMaiorConsumo = 0;
        double maiorValor = valoresConvertidos[0];
        
        for (int i = 1; i < valoresConvertidos.length; i++) {
            if (valoresConvertidos[i] > maiorValor) {
                maiorValor = valoresConvertidos[i];
                indiceMaiorConsumo = i;
            }
        }
        
        System.out.println("Maior consumo: Semana " + (indiceMaiorConsumo + 1));

    }
    
    private static int valorMensal(double[] valoresConvertidos){
        return (int) Arrays.stream(valoresConvertidos).sum();
    }

    private static int mediaSemanal (double [] valoresConvertidos){
        return (int) Arrays.stream(valoresConvertidos).average().orElse(0);
    }
}
