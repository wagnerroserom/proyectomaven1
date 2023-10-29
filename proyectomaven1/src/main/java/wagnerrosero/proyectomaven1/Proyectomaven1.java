/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package wagnerrosero.proyectomaven1;

import java.security.SecureRandom;
import java.util.Scanner;

public class Proyectomaven1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom random = new SecureRandom();
        
        String[] positiveFeedback = {"¡Vaya, me sorprende tu intelecto!", "¡Eres genial para las matemáticas!", "¡Muy bien!", "¡Lo hiciste muy bien!", "¡Excelente!", "¡Buen trabajo!", "¡Sigue así!", "¡Wow, eso fué estupendo!"};
        String[] negativeFeedback = {"¡Vamos, un poco más de esfuerzo!", "¡Anda, pon a trabajar esas neuronas!", "No. tienes un nuevo intento.", "Incorrecto. intenta una vez más.", "¡No te rindas!", "No. Sigue intentando.", "¡Ya casi lo consigues!"};
        
        int correctCount = 0;
        int totalCount = 0;
        
        while (true) {
            System.out.println("Selecciona el nivel de dificultad por favor:");
            System.out.println("1. Números de un dígito");
            System.out.println("2. Números de dos dígitos máximo");
            int difficulty = scanner.nextInt();
            int maxValue = (difficulty == 1) ? 9 : 99;

            System.out.println("Selecciona el tipo de problema matemático que quieras resolver:");
            System.out.println("1. Problemas de suma");
            System.out.println("2. Problemas de resta");
            System.out.println("3. Problemas de multiplicación");
            System.out.println("4. Problemas de división");
            System.out.println("5. Mezcla aleatoria de problemas");
            int operationChoice = scanner.nextInt();
            
            correctCount = 0;
            totalCount = 0;

            while (correctCount < 10) {
                int num1 = random.nextInt(maxValue) + 1;
                int num2 = random.nextInt(maxValue) + 1;

                double correctAnswer = 0;
                int operation = operationChoice;
                
                if (operationChoice == 5) {
                    operation = random.nextInt(4) + 1;
                }
                
                switch (operation) {
                    case 1: correctAnswer = num1 + num2; break;
                    case 2: correctAnswer = num1 - num2; break;
                    case 3: correctAnswer = num1 * num2; break;
                    case 4: correctAnswer = (double) num1 / num2; break;
                }

                while (true) {
                    System.out.println("¿Cuánto es " + num1 + (operation == 1 ? " + " : operation == 2 ? " - " : operation == 3 ? " * " : " / ") + num2 + "?");
                    double userAnswer = scanner.nextDouble();
                    totalCount++;

                    if (Math.abs(userAnswer - correctAnswer) < 0.001) {
                        correctCount++;
                        System.out.println(positiveFeedback[random.nextInt(positiveFeedback.length)]);
                        break;
                    } else {
                        System.out.println(negativeFeedback[random.nextInt(negativeFeedback.length)]);
                    }
                }
            }

            double percentage = (double) correctCount / totalCount * 100;
            if (percentage < 75) {
                System.out.println("Por favor pide ayuda adicional a tu instructor.");
            } else {
                System.out.println("Felicidades, estás listo para pasar al siguiente nivel!");
            }

            System.out.println("¿Quieres volver a intentarlo? (si/no)");
            String response = scanner.next().toLowerCase();
            if (response.equals("no")) {
                break;
            }
        }
        scanner.close();
    }
}
