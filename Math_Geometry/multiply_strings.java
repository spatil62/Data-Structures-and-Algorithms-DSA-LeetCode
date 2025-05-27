class Solution {
    public String multiply(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();

        int[] result = new int[len1+len2];

        for(int i=len1-1;i>=0;i--)
        for(int j=len2-1;j>=0;j--)
        {
            int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            int sum = mul + result[i+j+1];
            result[i+j+1]=sum%10;
            result[i + j] += sum / 10;  
        }

        // Convert the result array into a string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (sb.length() != 0 || num != 0) {  // Avoid leading zeros
                sb.append(num);
            }
        }
        
 
        // If the result is empty, return "0"
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

        /*int len1 = num1.length();
        int len2 = num2.length();
        
        // Result array to store the product of the digits
        int[] result = new int[len1 + len2];
        
        // Multiply each digit of num1 by each digit of num2
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                // Multiply the digits and add to the result array
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];  // Add to the current position
                result[i + j + 1] = sum % 10;  // Store the unit place of the sum
                result[i + j] += sum / 10;     // Add the carry to the next position
            }
        }
        

        for(int i=0;i<result.length;i++)
        System.out.println(" result[i] : " +result[i]);


        // Convert the result array into a string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {  // Avoid leading zeros
                sb.append(num);
            }
        }
        


        
        // If the result is empty, return "0"
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
*/
