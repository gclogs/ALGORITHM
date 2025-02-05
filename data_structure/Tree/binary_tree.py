class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
    
class Tree:
    def __init__(self):
        self.root = None
    
    # 레벨 순서 순회 함수
    def level_order(self):
        res = []
        if not self.root:
            return res
        queue = [self.root]
        while queue:
            node = queue.pop(0)
            res.append(node.data)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        return res
    
    def make_tree(self, arr):
        if not arr:
            return
        self.root = Node(arr[0])
        q = [self.root]
        index = 1
        while q and index < len(arr):
            node = q.pop(0)
            if arr[index] is not None:
                node.left = Node(arr[index])
                q.append(node.left)
            index += 1
            if arr[index] is not None:
                node.right = Node(arr[index])
                q.append(node.right)
            index += 1

    def preorder(self):
        def _preorder(node):
            if node is None:
                return
            print(node.data)
            _preorder(node.left)
            _preorder(node.right)
        res = []
        _preorder(self.root)
        return res
    
    def inorder(self):
        def _inorder(node):
            if node is None:
                return
            _inorder(node.left)
            print(node.data)
            _inorder(node.right)
        res = []
        _inorder(self.root)
        return res
    
    def postorder(self):
        def _postorder(node):
            if node is None:
                return
            _postorder(node.left)
            _postorder(node.right)
            print(node.data)
        res = []
        _postorder(self.root)
        return res
    
    def insert_key(tree, key):
        new_node = Node(key)
        if not tree.root:
            tree.root = new_node
        else:
            q = [tree.root]
            while q:
                node = q.pop(0)
                if node.left is None:
                    node.left = new_node
                    break
                else:
                    q.append(node.left)
                if node.right is None:
                    node.right = new_node
                    break
                else:
                    q.append(node.right)

if __name__ == "__main__":
    tree = Tree()
    tree.make_tree([10, 11, 9, 7, None, 15, 8])

    print("레벨 순회 결과:", tree.level_order())
    
    insert_key(tree, 12)
    print(tree.level_order())

    insert_key(tree, 12)
    print(tree.level_order())