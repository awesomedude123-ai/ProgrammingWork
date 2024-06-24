package UnitTestingClassAssignment;

import java.util.ArrayList;

public class MergeList {

    ArrayList<Integer> merged;

    public ArrayList<Integer> mergeList(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        merged = new ArrayList<>();
        for(int x: l1){
            merged.add(x);
        }
        for(int x: l2){
            merged.add(x);
        }

        for(int i=0;i<merged.size();i++){
            for(int j=i+1;j<merged.size();j++){
                if(merged.get(i)>merged.get(j)){
                    int x = merged.get(j);
                    merged.set(j,merged.get(i));
                    merged.set(i,x);
                }
            }
        }

        /**
         * True Merge Algorithm
         *
         * int size = l1.size() + l2.size();
         *         if (l1.isEmpty() && l2.isEmpty()) {
         *             return merged;
         *         }
         *         if (l1.isEmpty() && !l2.isEmpty()) {
         *             return l2;
         *         } else if (l2.isEmpty() && !l1.isEmpty()) {
         *             return l1;
         *         } else {
         *             while (true) {
         *                 if (l1.isEmpty()) {
         *                     merged.add(l2.get(0));
         *                     l2.remove(0);
         *                 } else if (l2.isEmpty()) {
         *                     merged.add(l1.get(0));
         *                     l1.remove(0);
         *                 } else {
         *                     if (l1.get(0) == l2.get(0)) {
         *                         merged.add(l1.get(0));
         *                         merged.add(l2.get(0));
         *                         l1.remove(0);
         *                         l2.remove(0);
         *                     } else if (l1.get(0) < l2.get(0)) {
         *                         merged.add(l1.get(0));
         *                         l1.remove(0);
         *                     } else {
         *                         merged.add(l2.get(0));
         *                         l2.remove(0);
         *                     }//end if else
         *                 }//end if else
         *                 if (merged.size() == size) {
         *                     break;
         *                 }
         *
         *
         *             }//end while statement
         *        }//end if else statement
         */
        return merged;
        }

    @Override
    public String toString() {
        String mergedLList = "{";
        for (int i : this.merged) {
            mergedLList = mergedLList + i + ", ";
        }
        mergedLList = mergedLList + "}";
        return mergedLList;
    }
}
