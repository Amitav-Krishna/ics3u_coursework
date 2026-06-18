#include <stdio.h>
struct doublyLinkedNode {
	struct doublyLinkedNode *previous;
	struct doublyLinkedNode *next;
	char value[10];
};
struct doublyLinkedList {
	struct doublyLinkedNode *firstNode;
	struct doublyLinkedNode *lastNode;
};
int main() {
	printf("%s", "Hello, world!");
	struct doublyLinkedList s1;

	struct doublyLinkedNode n_1;
	struct doublyLinkedNode n_2;
	struct doublyLinkedNode n_3;
	struct doublyLinkedNode n_4;
	struct doublyLinkedNode n_5;

	s1.firstNode = &n_1;
	s1.lastNode = &n_5;

	n_1.next = &n_2;
	n_1.value = {'P', 'a', 'n', 'd', 'a', '\0'}
	
	n_2.prev = &n_1;
	n_2.next = &n_3;
	n_2.value = {'H', 'e', 'l', 'l', 'o', '\0'}

	n_3.prev = &n_2;
	n_3.next = &n_4;
	n_3.value = {'A', 'l', 'l', 'o', '\0'}

	n_4.prev = &n_3;
	n_4.next = &n_5;
	n_4.value = {'D', 'o', 'g', '\0'}

	n_5.prev = &n_4;
	n_5.value = {'C', 'a', 't', '\0'}

	printf("%s\n", *(n_5.prev).value);
	return 0;
}

