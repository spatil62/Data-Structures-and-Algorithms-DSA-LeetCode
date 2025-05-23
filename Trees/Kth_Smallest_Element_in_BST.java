/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
 //using dfs
class Solution {
    List<Integer> list;

    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        smallelementcheck_dfs(root,list);
        Collections.sort(list);
        return list.get(k-1);
    }

    public void smallelementcheck_dfs(TreeNode root, List<Integer> list){
        if(root==null)
        return;

        list.add(root.val);

        smallelementcheck_dfs(root.left, list);
        smallelementcheck_dfs(root.right, list);
    }
}

       /* PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(a,b));
        //List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node = q.poll();
                pq.add(node.val);

                if(node.left!=null)
                q.add(node.left);

                if(node.right!=null)
                q.add(node.right);
            }
        }

        for(int i=0;i<k-1;i++)
        pq.poll();

        return pq.poll();
    }
}*/

       /* List<Integer> elements = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

         q.add(root);

         while(!q.isEmpty())
         {
            TreeNode current = q.poll();
            elements.add(current.val);

            if(current.left!=null)
            q.add(current.left);

            if(current.right!=null)
            q.add(current.right);
         }

        Collections.sort(elements);

        return elements.get(k - 1);
        
    }
}*/
