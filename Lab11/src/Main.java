public class Main {

    public static void main(String[] args) {
        Parser.of("***ptr[x++][--y[i]]--").ParseS();
        Parser.of("aa[(*IDENT)][(++IDENT)--]").ParseS();
        Parser.of("aa[(*IDENT)][(++4IDENT)--]").ParseS(); // Должен вернуть ошибку
    }
}
