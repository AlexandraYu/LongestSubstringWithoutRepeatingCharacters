public class LengthOfLongestSubstring{

     public int findLengthOfLongestSubstring(String s){
         int[] array = new int[128]; //need an array to contain 127 ascii codes
         int count =0, left=-1, max=0, current=0; 
         for (int i=0; i<128; i++) {
             array[i]=-1; //initialize the array to -1, as no index has been written in yet
         }
         for(int i=0; i<s.length(); i++) {//scan through the given string
            if(array[s.charAt(i)] ==-1 || array[s.charAt(i)] < left) { //it means the character hasn't appeared OR it's out of the "window"
            //s.charAt(i) means the ith character in string s
            //array[s.charAt(i)] returns the "index" of the s.charAt(i)
            //array[s.charAt(i)] < left means the re-occuring character isn't in the "window" anymore
  
                //we also need to write the new index into the array
                array[s.charAt(i)] = i; 
                //current length is current counter for lengh - left boundary
                current = i -left; 
                //compare the current length with max length
                if (current>max) max = current; 
            }
            else { //if the current character has appeared in the "window" already
            
                //we need to update the "left boundary" first, which is the next index of the repeated character's index; 
                left = array[s.charAt(i)];
                //we update the character's new index; 
                array[s.charAt(i)] = i;
                //calculate the length
                current = i -left; 
                //compare the current lenght with max length
                if (current > max) max = current; 
            }
         }
         return max; 
     }
     
     public static void main(String []args){
        int length=0; 
        LengthOfLongestSubstring lols = new LengthOfLongestSubstring(); 
        length = lols.findLengthOfLongestSubstring("bbcabegd");
        
        System.out.println("Longest lenght of the substring is "+length+"\n");
     }
}