class Solution {

    static class Node{
        int maxCapacity;
    }
    Node[] tree;
    int[] baskets;
    int n;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        this.baskets = baskets;
        this.tree = new Node[4 * n];
        for(int i = 0; i<tree.length; i++){
            tree[i] = new Node();
        }

        build(1, 0, n-1);
        int unplacedCount = 0;

        for(int fruitQuantity : fruits){
            int fruitBasketIndex = query(1, 0, n-1, fruitQuantity);
            if(fruitBasketIndex != -1){
                update(1, 0, n-1, fruitBasketIndex, 0);
            } else{
                unplacedCount++;
            }
        }
        return unplacedCount;
    }

    private void build(int node, int start, int end){
        if(start == end){
            tree[node].maxCapacity = baskets[start];
            return;
        }
        int mid = (start + end)/2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        tree[node].maxCapacity = Math.max(tree[2 * node].maxCapacity, tree[2 * node+1].maxCapacity);
    }

    private int query(int node, int start, int end, int target){
        if(tree[node].maxCapacity < target){
            return -1;
        }
        if(start == end){
            return start;
        }

        int mid = (start + end)/2;
        int p1 = query(2 * node, start, mid, target);
        if(p1 != -1){
            return p1;
        }

        return query(2 * node + 1, mid + 1, end, target);
    }

    private void update(int node, int start, int end, int idx, int val){
        if(start == end){
            baskets[idx] = val;
            tree[node].maxCapacity = val;
            return;
        }
        int mid = (start + end)/2;
        if (start <= idx && idx <= mid ){
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node].maxCapacity = Math.max(tree[2 * node].maxCapacity, tree[2* node + 1].maxCapacity);
    }
        
}