// Необходимо написать программу, которая будет выводить на экран текстовые данные из файла .txt,
// а потом в этот же файл перезаписывать текстовые данные, введенные вручную.
// Количество строк после перезаписи должно быть столько же, сколько и в изначальном варианте.

import java.io.*;

public class Task_17 {
        public static void main(String[] args) {
            String input, output;
            int linescount = 0;
            int lcount = 0;

            try {
                File file = new File("file.txt");
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while((input = bufferedReader.readLine()) != null) {
                    System.out.println(input);
                    linescount++;
                    }
                bufferedReader.close();
                //System.out.println("Количество строк в файле: " + linescount);
            }
            catch (IOException e) {
                System.out.println("Ошибка: " + e);
            }

            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                System.out.println("Введите сообщение");
            File file = new File("file.txt");

            try (FileWriter fileWriter = new FileWriter(file);){
                do {
                    output = bufferedReader.readLine();
                    if(linescount == lcount)
                        break;
                    System.out.print(" ");
                    output = output + "\r\n";
                    fileWriter.write(output);
                    lcount++;
                } while(linescount != lcount);
            } catch(IOException e){
                System.out.println("Ошибка: " + e);
        }
    }
}


