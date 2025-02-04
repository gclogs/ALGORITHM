def preorder(tree):
    def _preorder(tree, i = 0):
        if i >= len(tree) or tree[i] is not None:
            res.append(tree[i])
            _preorder(tree, 2 * i + 1)
            _preorder(tree, 2 * i + 2)

    res = []
    _preorder(tree)
    return res

def inorder(tree):
    def _inorder(tree, i = 0):
        if i > len(tree) or tree[i] is None:
            return
        _inorder(tree, 2 * i + 1)
        res.append(tree[i])
        _inorder(tree, 2 * i + 2)

    res = []
    _inorder(tree)
    return res

def postorder(tree):
    def _postorder(tree, i = 0):
        if i > len(tree) or tree[i] is None:
            return
        _postorder(tree, 2 * i + 1)
        _postorder(tree, 2 * i + 2)
        res.append(tree[i])

    res = []
    _postorder(tree)
    return res

tree = ["A", "B", "C", "D", "E", "F", None, "G"]
print(preorder(tree))
print(inorder(tree))