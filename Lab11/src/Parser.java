/*
<Expr>::= * <Expr> | <Prim>
<Tail> | <Op> <Expr>
<Tail>::= ε | <Op> <Tail> | [ <Expr> ] <Tail>
<Op>::= ++ | --
<Prim>::= IDENT | ( <Expr> )
 */

public class Parser {

    private final String StringToParse;
    int SymbolNum;

    private Parser(String StringToParse) {
        this.StringToParse = StringToParse;
        this.SymbolNum = 0;

    }

    public static Parser of(String StringToParse) {
        return new Parser(StringToParse);
    }
    void ParseS() {
        this.ParseExpr();
        if (SymbolNum != StringToParse.length()) {
            System.out.println("Syntax error at " + (SymbolNum + 1) + " col" + ", 1 line");
            System.exit(-1);
        }
    }
    void ParseExpr() {
        char Sym = StringToParse.charAt(SymbolNum);
        if (Sym == '*') {
            System.out.println("* <Expr>");
            this.SymbolNum++;
            this.ParseExpr();
        } else if (Sym == '+' || Sym == '-') {
            System.out.println("<Op> <Expr>");
            this.ParseOp();
            this.ParseExpr();
        } else {
            System.out.println("<Prim> <Tail>");
            this.ParsePrim();
            this.ParseTail();
        }
    }

    void ParseOp() {
        char Sym1 = StringToParse.charAt(SymbolNum);
        char Sym2 = StringToParse.charAt(SymbolNum + 1);
        if (Sym1 == Sym2) {
            if (Sym1 == '+') {
                System.out.println("++");
                SymbolNum += 2;
            } else if (Sym2 == '-') {
                System.out.println("--");
                SymbolNum += 2;
            } else {
                System.out.println("Syntax error at " + (SymbolNum + 1) + " col" + ", 1 line");
                System.exit(-1);
            }
        } else {
            System.out.println("Syntax error at " + (SymbolNum + 1) + " col" + ", 1 line");
            System.exit(-1);
        }
    }

    void ParsePrim() {
        char Sym = StringToParse.charAt(SymbolNum);
        if (Character.isLetter(Sym)) {
            System.out.println("IDENT");
            this.ParseIdent();
        } else if (Sym == '(') {
            System.out.println("( <Expr> )");
            SymbolNum++;
            this.ParseExpr();
            if (StringToParse.charAt(SymbolNum) == ')') {
                SymbolNum++;
            } else {
                System.out.println("Syntax error at " + (SymbolNum + 1) + " col" + ", 1 line");
                System.exit(-1);
            }
        } else {
            System.out.println("Syntax error at " + (SymbolNum + 1) + " col" + ", 1 line");
            System.exit(-1);
        }
    }

    void ParseIdent() {
        char Sym = StringToParse.charAt(SymbolNum);
        while (Character.isLetter(Sym) || Character.isDigit(Sym)) {
            SymbolNum++;
            Sym = StringToParse.charAt(SymbolNum);
        }
    }

    void ParseTail() {
        if (SymbolNum == StringToParse.length()) {
            System.out.println("Epsilon rule");
            return;
        }
        char Sym = StringToParse.charAt(SymbolNum);
        if (Sym == '+' || Sym == '-') {
            System.out.println("<Op> <Tail>");
            this.ParseOp();
            this.ParseTail();
        } else if (Sym == '[') {
            System.out.println("[ <Expr> ] <Tail>");
            SymbolNum++;
            this.ParseExpr();
            if (StringToParse.charAt(SymbolNum) != ']') {
                System.out.println("Syntax error at " + (SymbolNum + 1) + " col" + ", 1 line");
                System.exit(-1);
            }
            SymbolNum++;
            this.ParseTail();
        } else {
            System.out.println("Epsilon rule");
        }
    }


}
