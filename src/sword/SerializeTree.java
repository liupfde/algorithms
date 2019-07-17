package sword;

/**
 * @author :liupf
 * @description :序列化和反序列化二叉树
 * @date :2019/06/10 20:25
 **/
public class SerializeTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode l = new TreeNode(6);
        TreeNode r = new TreeNode(10);
        TreeNode ll = new TreeNode(5);
        TreeNode lr = new TreeNode(7);
        TreeNode rl = new TreeNode(9);
        TreeNode rr = new TreeNode(11);

        root.left = l; root.right = r;
        l.left = ll; l.right = lr;
        r.left = rl; r.right = rr;

        System.out.println(serialize(root));
        TreeNode node = deserialize(serialize(root));
        System.out.println(node);
        int i = 0;
    }
    public static String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        String str = serialize(root, stringBuilder).toString();
        return str.substring(0, str.length() - 1);
    }

    private static StringBuilder serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return sb.append("#,");
        }
        sb.append(root.val).append(",");

        serialize(root.left, sb);
        serialize(root.right, sb);

        return sb;
    }

    private static final String SIGN = "#";
    public static TreeNode deserialize(String str) {
        if (str.length() == 0) {
            return null;
        }
        int index = 0;
        String[] strings = str.split(",");
        return deserialize(strings, index);
    }


    private static TreeNode deserialize(String[] strings, int index) {
        TreeNode node = null;
        if (index >= strings.length) {
            return node;
        }
        String s = String.valueOf(strings[index++]);
        if (!SIGN.equals(s)) {
            int val = Integer.valueOf(s);
            node = new TreeNode(val);
            node.left = deserialize(strings, index);
            node.right = deserialize(strings, index);
        }
        return node;
    }
}
