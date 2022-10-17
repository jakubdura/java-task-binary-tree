# Java task binary tree

Task: Encode the alphabet as a binary tree using the frequencies of letters in the given text.

- [x] For each character in the text calculate its number of occurrences.
eg. for string aba it would be a -> 2, b -> 1
- [x] For each character and its frequency create a one-node tree.
- [x] Take two trees T1 and T2 with the lowest frequencies and merge them into a larger tree T12
(T1 should become the left sub-tree and T2 the right subtree).
- [x] Repeat the previous step until there is only 1 tree left.

That last tree represents the created encoding. For example, given text abacaca you should get:

![This is an image](https://github.com/jakubdura/java-task-binary-tree/blob/main/ssTree.jpg)
