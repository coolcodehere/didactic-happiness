

public class Parser {
  String input;

  public Parser(String input) {
    this.input = input;
  }

  public int getProdRule(String token, char input) {
    switch (token) {
      case "E": return E(input);
      case "Ep": return Ep(input);
      case "T": return T(input);
      case "Tp": return Tp(input);
      case "F": return F(input);
      default:
        return 0;
    }

  }

  private int E(char input) {
    switch(input) {
      case 'n':
      case '(':
        return 1;
      default:
        return 0;
    }
  }

  private int Ep(char input) {
    switch(input) {
      case '+':
        return 2;
      case '-':
        return 3;
      case ')':
      case '$':
        return 4;
      default:
        return 0;
    }
  }

  private int T(char input) {
    switch(input) {
      case 'n':
      case '(':
        return 5;
      default:
        return 0;
    }
  }

  private int Tp(char input) {
    switch(input) {
      case '+':
      case '-':
      case ')':
      case '$':
        return 8;
      case '*':
        return 6;
      case '/':
        return 7;

      default:
        return 0;
    }
  }

  private int F(char input) {
    switch (input) {
      case 'n':
        return 10;
      case '(':
        return 9;
      default:
        return 0;
    }
  }

  public String[] production(int rule) {
    switch (rule) {
      case 1:
        return ["T", "Ep"];
      case 2:
        return ["+", "T", "Ep"];
      case 3:
        return ["-", "T", "Ep"];
      case 4:
        return ["l"];
      case 5:
        return ["F", "Tp"];
      case 6:
        return ["*", "F", "Tp"];
      case 7:
        return ["/", "F", "Tp"];
      case 8:
        return ["l"];
      case 9:
        return ["(", "E", ")"];
      case 10:
        return ["n"];
    }
    return "";
  }
}