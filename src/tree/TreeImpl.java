/*
 * Copyright 2015 Alexandre Terrasa <alexandre@moz-code.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tree;

import java.util.ArrayList;

public class TreeImpl<E> implements Tree<E> {

    private ArrayList<TreeNode> nodes;
    private TreeNode root;

    public TreeImpl() {
        nodes = new ArrayList<>();
    }

    @Override
    public int size() {
        return nodes.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void setRoot(E rootValue) {
        root = new TreeNode(null, rootValue);
        nodes.add(root);
    }

    @Override
    public E getRoot() {
        return root.value;
    }

    @Override
    public boolean hasRoot() {
        return root != null;
    }

    @Override
    public void addNode(E parentNodeValue, E nodeValue) {
        TreeNode parent = getNode(nodeValue);
        nodes.add(new TreeNode(parent, nodeValue));
    }

    @Override
    public boolean hasNode(E nodeValue) {
        return getNode(nodeValue) != null;
    }

    private TreeNode getNode(E nodeValue) {
        for (TreeNode node : nodes) {
            if (node.value.equals(nodeValue)) {
                return node;
            }
        }
        return null;
    }

    class TreeNode {

        TreeNode parent;
        E value;

        public TreeNode(TreeNode parent, E value) {
            this.parent = parent;
            this.value = value;
        }
    }
}
