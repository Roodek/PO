package zad4;

public class Polibiusz implements Algorithm{
    @Override
    public String crypt(String word) {
        char alphabet[][]={{'a','b','c','d','e'},{'f','g','h','i','k'},
                {'l','m','n','o','p'},{'q','r','s','t','u'},{'v','w','x','y','z'}};
        word=word.toLowerCase();
        word.replace('j','i');
        char array[] = word.toCharArray();
        String nowy = new String();

        for(int i=0;i<array.length;i++){
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    if(array[i]==alphabet[j][k]){
                        nowy+=Integer.toString(j+1)+Integer.toString(k+1);
                    }
                }
            }
        }
        //System.out.println(nowy);
        return nowy;
    }

    @Override
    public String decrypt(String word) {
        char alphabet[][]={{'a','b','c','d','e'},{'f','g','h','i','k'},
                {'l','m','n','o','p'},{'q','r','s','t','u'},{'v','w','x','y','z'}};

        char array[] = word.toCharArray();
        String nowy = new String();

        for(int i = 1;i<array.length;i+=2){

            nowy+=alphabet[array[i-1]-48-1][array[i]-48-1];
        }

        return nowy;
    }
}
