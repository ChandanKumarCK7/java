package Leetcode.LCmedium;





public class PunishmentNumber {







        public static void main(String[] args){
            System.out.println(punishmentNumber(36));
        }

        public static int punishmentNumber(int n) {
            //to store punishment number
            int punishmentNum = 0;

            //traverse the array
//            for(int curr = 1;curr <= n ;curr++){

                //finding square
                int square = 36*36;

                if(canPartition(square,36))
                    punishmentNum += square;
//            }

            return punishmentNum;

        }
        public static boolean canPartition(int num, int target){
            //invalid
            if(num < target || target < 0)
                return false;

            if(num == target)
                return true;

            return (canPartition(num/10,target-(num%10))
                    || canPartition(num/100,target-(num%100))
                    || canPartition(num/1000,target-(num%1000)));
        }


}
