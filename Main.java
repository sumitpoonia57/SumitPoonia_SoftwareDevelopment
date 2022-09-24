import java.util.*;

public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            if(convert(s).length()!=0)
                System.out.println(convert(s));
            else
                System.out.println("Invalid Input");
        }
        sc.close();
    }

    //function to convert shuffled string to number
    public static String convert(String s){
        int[] arr = new int[10];
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'z'){
                arr[0]++;
            }
            else if(s.charAt(i) == 'w'){
                arr[2]++;
            }
            else if(s.charAt(i) == 'u'){
                arr[4]++;
            }
            else if(s.charAt(i) == 'x'){
                arr[6]++;
            }
            else if(s.charAt(i) == 'g'){
                arr[8]++;
            }
            else if(s.charAt(i) == 'o'){
                arr[1]++;
            }
            else if(s.charAt(i) == 'h'){
                arr[3]++;
            }
            else if(s.charAt(i) == 'f'){
                arr[5]++;
            }
            else if(s.charAt(i) == 's'){
                arr[7]++;
            }
            else if(s.charAt(i) == 'i'){
                arr[9]++;
            }
        }
        arr[1] = arr[1] - arr[0] - arr[2] - arr[4];
        arr[3] = arr[3] - arr[8];
        arr[5] = arr[5] - arr[4];
        arr[7] = arr[7] - arr[6];
        arr[9] = arr[9] - arr[5] - arr[6] - arr[8];

        //Using string buffer so we can use insert function
        StringBuffer ans = new StringBuffer();

        boolean flag = true;
        int firstNonZero=0;

        //loop to insert the numbers in the string
        for(int i=1; i<10; i++){
            for(int j=0; j<arr[i]; j++){
                if(flag)
                    firstNonZero = i;
                ans.append(i);
                flag = false;
            }
        }

        //inserting 0 after first non zero digit
        if(firstNonZero > 0){
            for(int i=0; i<arr[0]; i++){
                ans.insert(arr[firstNonZero], "0");
            }
        }

        //condition if number contains only 0
        else if(firstNonZero == 0 && arr[0] > 0){
            ans = ans.append("0");
        }
        
        return ans.toString();
    } 
}