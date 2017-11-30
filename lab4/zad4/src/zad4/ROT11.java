package zad4;

public class ROT11 implements Algorithm{
    @Override
    public String crypt(String word) {
        char array[] = word.toCharArray();
        String nowy = new String();

        for(int i=0;i<word.length();i++){
            int letterValue =(int)word.toCharArray()[i];
            if (letterValue == 32){nowy+=' ' ;continue;}
            if (letterValue < 41 ){nowy+=array[i] ;continue;}

            if(letterValue<91){
                if((int)array[i] + 11 > 90){
                    letterValue -= 26;
                }
                array[i] = (char)(letterValue+11);
                nowy+=array[i];
            }

            if(letterValue>96){
                if((int)array[i] + 11 > 122){
                    letterValue -= 26;
                }
                array[i] = (char)(letterValue+11);
                nowy+=array[i];
            }
        }
        return nowy;
    }

    @Override
    public String decrypt(String word) {
        char array[] = word.toCharArray();
        String nowy = new String();

        for (int i = 0; i < word.length(); i++) {
            int letterValue = (int) word.toCharArray()[i];
            if (letterValue == 32){nowy+=' ' ;continue;}
            if (letterValue < 41){nowy+=array[i] ;continue;}
            //System.out.println(letterValue);
            if (letterValue < 91) {

                if ((int) array[i] - 11 < 65) {
                    letterValue += 26;
                }
                array[i] = (char) (letterValue - 11);
                nowy += array[i];
            }

            if (letterValue > 96) {

                if ((int) array[i] - 11 < 97) {
                    letterValue += 26;
                }
                array[i] = (char) (letterValue - 11);
                nowy += array[i];
            }
        }
        return nowy;
    }
}
