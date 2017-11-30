package zad4;

import java.util.Scanner;



public class Main {
    public static void main(String[] args){



        int ans;//wybor uzytkownika
        int ans2;
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.szyfruj");
        System.out.println("2.deszyfruj");
        ans = scanner.nextInt();

        System.out.println("wybierz metode:");
        System.out.println("1.Rot11");
        System.out.println("2.Polibiusz");
        ans2 = scanner.nextInt();
        switch (ans){
            case 1:
                switch (ans2){
                    case 1:
                        System.out.println("opcja1.1");
                        Cryptographer.cryptfile("C:\\Users\\user\\Desktop\\mail.txt",
                                "C:\\Users\\user\\Desktop\\zaszyfr.txt",new ROT11());
                        break;
                    case 2:
                        System.out.println("opcja1.2");
                        Cryptographer.cryptfile("C:\\Users\\user\\Desktop\\mail.txt",
                                "C:\\Users\\user\\Desktop\\zaszyfr.txt",new Polibiusz());
                        break;
                    default:
                        System.out.println("opcja1.3");
                        System.out.println("brak opcji");
                        return;
                }
                break;
            case  2:
                switch(ans2) {
                    case 1:
                        System.out.println("opcja2.1");
                        Cryptographer.decryptfile("C:\\Users\\user\\Desktop\\zaszyfr.txt",
                                "C:\\Users\\user\\Desktop\\mail.txt", new ROT11());
                        break;
                    case 2:
                        System.out.println("opcja2.2");
                        Cryptographer.decryptfile("C:\\Users\\user\\Desktop\\zaszyfr.txt",
                                "C:\\Users\\user\\Desktop\\mail.txt", new Polibiusz());
                        break;
                    default:
                        System.out.println("opcja2.3");
                        System.out.println("brak opcji");
                }
        }
    }
}
