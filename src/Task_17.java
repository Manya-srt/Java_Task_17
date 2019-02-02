// Необходимо написать программу, которая будет выводить на экран текстовые данные из файла .txt,
// а потом в этот же файл перезаписывать текстовые данные, введенные вручную.
// Количество строк после перезаписи должно быть столько же, сколько и в изначальном варианте.

import java.io.*;

public class Task_17 {
        public static void main(String[] args) {
            String input, output;

            try {
                File file = new File("file.txt");
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                int linescount = 0;

                while((input = bufferedReader.readLine()) != null) {
                    System.out.println(input);
                    linescount++;
                }
                bufferedReader.close();
                System.out.println("Количество строк в файле: " + linescount);
            }
            catch (IOException e) {
                System.out.println("Ошибка: " + e);
            }

            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                System.out.println("Чтобы остановить запись в файл - введите слово 'stop'");
            File file = new File("file.txt");

            try (FileWriter fileWriter = new FileWriter(file);){
                do {
                    System.out.print(" ");
                    output = bufferedReader.readLine();
                    if(output.compareTo("stop")== 0) break;
                    output = output + "\r\n";
                    fileWriter.write(output);
                } while(output.compareTo("stop") != 0);
            } catch(IOException e){
                System.out.println("Ошибка: " + e);
        }
    }
}


