package Labs4;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArithmeticExpression {

    // funkcija za presmetuvanje na izrazot pocnuvajki
    // od indeks l, zavrsuvajki vo indeks r
    static int presmetaj(char c[], int l, int r) {
        if(r-l+1==5){
            if(c[l+2]=='+'){
                return (c[l+1]-'0') + (c[l+3]-'0');
            }
            else {
                return (c[l + 1] - '0') - (c[l + 3] - '0');
            }
        }

        int zagrada=0;
        int sredina=0;

        for(int i=l;i<r;i++){
            if(c[i]=='('){
                zagrada++;
            }
            if(c[i]==')'){
                zagrada--;
            }
            if(c[i]=='+' || c[i]=='-'){
                if(zagrada==1){
                    sredina=i;
                    break;
                }
            }
        }
        if(c[sredina]=='+'){
            return presmetaj(c, l +1, sredina-1) + presmetaj(c, sredina+1, r-1);
        }
        else
            return presmetaj(c, l +1, sredina-1) - presmetaj(c, sredina+1, r-1);
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = presmetaj(exp, 0, exp.length-1);
        System.out.println(rez);

        br.close();

    }

}

