#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct tree {
	char key;
	struct tree *leftChild;
	struct tree *rightChild;
}treeNode;

void clear_inputBuffer();
void preorder(treeNode *root);
void inorder(treeNode *root);
void postorder(treeNode *root);
treeNode *makeBTreeNode(char key);
void search_Input(treeNode *root, char targetKey, char left, char right);


int main() {

	int num;
	treeNode *bt = (treeNode *)malloc(sizeof(treeNode));
	bt->key = bt->leftChild = bt->rightChild = NULL;

	scanf("%d", &num);

	if ((num > 26) || (num<1))
		return 0;

	for (int i = 0; i < num; i++) {
		char a, b, c;

		clear_inputBuffer();
		scanf("%c %c %c", &a, &b, &c);

		search_Input(bt, a, b, c);
	}

	preorder(bt);
	printf("\n");
	inorder(bt);
	printf("\n");
	postorder(bt);
	printf("\n");

	return 0;
}

void clear_inputBuffer() {
	while (getchar() != '\n');
}

void preorder(treeNode *root) {

	if (root) {
		printf("%c", root->key);
		preorder(root->leftChild);
		preorder(root->rightChild);
	}

}

void inorder(treeNode *root) {

	if (root) {
		inorder(root->leftChild);
		printf("%c", root->key);
		inorder(root->rightChild);
	}

}

void postorder(treeNode *root) {

	if (root) {
		postorder(root->leftChild);
		postorder(root->rightChild);
		printf("%c", root->key);
	}

}

treeNode *makeBTreeNode(char key) {
	treeNode *ptr = (treeNode *)malloc(sizeof(treeNode));

	ptr->key = key;

	ptr->leftChild = ptr->rightChild = NULL;
	return ptr;
}

void search_Input(treeNode *root, char targetKey, char left, char right) {
	if (root->key != NULL) {
		if (targetKey == root->key) {
			if (left != '.') {
				root->leftChild = makeBTreeNode(left);
			}
			if (right != '.') {
				root->rightChild = makeBTreeNode(right);
			}
			return;
		}
		else {
			if (root->leftChild) {
				search_Input(root->leftChild, targetKey, left, right);
			}
			if (root->rightChild) {
				search_Input(root->rightChild, targetKey, left, right);
			}
		}
	}
	else {
		root->key = targetKey;
		if (left != '.') {
			root->leftChild = makeBTreeNode(left);
		}
		if (right != '.') {
			root->rightChild = makeBTreeNode(right);
		}
	}

	return;
}
