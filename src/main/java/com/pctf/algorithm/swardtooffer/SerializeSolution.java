package com.pctf.algorithm.swardtooffer;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class SerializeSolution {
    int index = -1;

    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            return sb.append("#,").toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        index++;
        if (index >= str.length()) {
            return null;
        }
        String[] arr = str.split(",");
        String cha = arr[index];
        if ("#".equals(cha)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(cha));
        root.left = Deserialize(str);
        root.right = Deserialize(str);
        return root;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
