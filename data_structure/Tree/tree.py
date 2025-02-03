class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# 전위 순회
def pre_order(node):
    if node:
        pre_order(node.left)  # 왼쪽 서브트리 순회
        pre_order(node.right)  # 오른쪽 서브트리 순회
        print(node.data)  # 루트 노드 방문

# 중위 순회
def in_order(node):
    if node:
        in_order(node.left)  # 왼쪽 서브트리 순회
        in_order(node.right)  # 오른쪽 서브트리 순회
        print(node.data)  # 루트 노드 방문

# 후위 순회
def post_order(node):
    if node:
        post_order(node.left)  # 왼쪽 서브트리 순회
        post_order(node.right)  # 오른쪽 서브트리 순회
        print(node.data)  # 루트 노드 방문

root = Node('F',
            Node('D',
                 Node('B',
                      Node('A'),
                      Node('C')
                      ),
                 Node('E')
                 ),
            Node('G')
            )

preorder_traverse(root)