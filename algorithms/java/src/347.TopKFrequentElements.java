/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Sep 20, 2020
    Update:     Sep 20, 2020
    Problem:    347. Top K Frequent Elements
    Difficulty: Medium
    Source:     https://leetcode.com/problems/top-k-frequent-elements/
    
    Notes:
        Given a non-empty array of integers, return the k most frequent elements.
        
    Examples:
    1.
        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]
        
    2.
        Input: nums = [1], k = 1
        Output: [1]

    Note:
        You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
        Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
        It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
        You can return the answer in any order.
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Dont care about sorting as long as i get the correct numbers in 
        //Maximum integer value to be k, thus k length of the array can be max integer value
        //lim k-> infinity
        int[] output = new int[k];
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();

        //This part counts the number of instances of unique integer and its counts 
        for (int i = 0; i < nums.length; i++){
            if(counts.containsKey(nums[i]) == true){
                int current_value = counts.get(nums[i]);
                counts.put(nums[i], 1 + current_value);
            }else{
                counts.put(nums[i], 1);
            }
        }
        
        //This will sort the entries by value in a int, int tuple
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry one, Map.Entry two){
                return - Integer.compare((int)one.getValue(), (int)two.getValue());
            }
        });
        
        
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()){
            maxHeap.add(entry);
        }
        
        for (int i = 0; i < k; i++){
            Map.Entry<Integer, Integer> a = maxHeap.poll();
            output[i] = a.getKey();
        }
        
        
        //We can use a dictionary/map because everything is O(1) for processing 

        //Process each tuple, the priority queue will have to compare by occurrences

        //we have to sort that dictionary in some way where it cant exceed  O(n log n)
        //we can use priority queue
        
        return output;
        //Return an array of size k
    }
}