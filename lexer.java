public class lexer{
    public static String lexema_atual = "";
    public static int token_id = 0;
    
    private static void identifyTokenPairs(char character, char nextCharacter){
        if(character == '=' && nextCharacter == '='){
            token_id = 11;
            lexema_atual = "EQ_OP";
            System.out.printf("( %s%s, %s, %s )\n", character, nextCharacter, lexema_atual, token_id); 
        }else if(character == ':' && nextCharacter == '='){
            token_id = 12;
            lexema_atual = "ASSIGN_OP";
            System.out.printf("( %s%s, %s, %s )\n", character, nextCharacter, lexema_atual, token_id);
        }else if(character == '=' && nextCharacter != '='){
            System.out.printf("");
        }
    }
    

    private static void identifyToken(char character){
        if(character == ' ' || character == '\n' || character == '\t' || character == '\r'){
            lexema_atual = "";
            System.out.println("");
        }
        else if(character >= 'a' && character <= 'z' || character >= 'A' && character <= 'Z'){
            //Chama Função Identify Operator
        }
        else if(character >= '0' && character <= '9'){
            //Chama Função Identify Int Literal
        }
        else if(character == '+' || character == '-' || character == '*' || character == '/' || character == '%'){
             tokenOperator(character);
        }
        else if(character == '(' || character == ')'){
             tokenParen(character);
        }
        else{
            System.out.println("Invalid");
        }
    }

    private static void tokenInteger(char character){
        switch (character){
            case 0:
                
                break;

            default:
                System.out.println("Invalid");
        }
    }

    private static void tokenParen(char character){
        if(character == '('){
            token_id = 3;
            lexema_atual = "LPAREN";
            System.out.printf("( %s, %s, %s )\n", character, lexema_atual, token_id);
        }
        else if(character == ')'){
            token_id = 4;
            lexema_atual = "LPAREN";
            System.out.printf("( %s, %s, %s )\n", character, lexema_atual, token_id);
        }
    }

    private static void tokenOperator(char character){
        if(character == '+'){
            token_id = 5;
            lexema_atual = "ADD_OP";
            System.out.printf("( %s, %s, %s )\n", character, lexema_atual, token_id);
        }
        else if(character == '-'){
            token_id = 6;
            lexema_atual = "SUB_OP";
            System.out.printf("( %s, %s, %s )\n", character, lexema_atual, token_id);
        }
        else if(character == '*'){
            token_id = 7;
            lexema_atual = "MUL_OP";
            System.out.printf("( %s, %s, %s )\n", character, lexema_atual, token_id);
        }
        else if(character == '/'){
            token_id = 8;
            lexema_atual = "DIV_OP";
            System.out.printf("( %s, %s, %s )\n", character, lexema_atual, token_id);
        }      
        else if(character == '>'){
            token_id = 9;
            lexema_atual = "GT_OP";
            System.out.printf("( %s, %s, %s )\n", character, lexema_atual, token_id);
        }
        else if(character == '<'){
            token_id = 10;
            lexema_atual = "LT_OP";
            System.out.printf("( %s, %s, %s )\n", character, lexema_atual, token_id);
        }  
    }

    private static char readCharacter(String word){
        if(word.length()==1){
            identifyToken(word.charAt(0));       
        }else{
            for(int i = 0; i < word.length(); i++){   
                if(!lexema_atual.equals("EQ_OP") && !lexema_atual.equals("ASSIGN_OP")){
                    if(word.charAt(i) == '=' || word.charAt(i) == ':'){
                        identifyTokenPairs(word.charAt(i), word.charAt(i+1));
                    }else{
                        identifyToken(word.charAt(i));
                    } 
                }
            } 
        }
        return '\0';
    } 
    public static void main(String[] args) {
        System.out.println(readCharacter("Andre:=+"));    
    }
}