import java.util.Scanner;
class Node {
    int data;
    Node next, prev;
    Node(int newData) {
        data = newData;
        next = prev = null;
    }
}

public class DoublyLinkedList {
    // Insert a node at the beginning
    public static Node insertAtFront(Node head, int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        return newNode; // New node becomes the new head
    }

    // Insert a node at the end
    public static Node insertAtEnd(Node head, int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            return newNode;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;
        return head;
    }

    // Insert a node after a given node
    public static Node insertAfter(Node head, int key, int newData) {
        Node curr = head;
        while (curr != null && curr.data != key) {
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Key not found.");
            return head;
        }
        Node newNode = new Node(newData);
        newNode.next = curr.next;
        newNode.prev = curr;
        if (curr.next != null) {
            curr.next.prev = newNode;
        }
        curr.next = newNode;
        return head;
    }

    // Insert a node before a given node
    public static Node insertBefore(Node head, int key, int newData) {
        Node curr = head;
        while (curr != null && curr.data != key) {
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Key not found.");
            return head;
        }
        Node newNode = new Node(newData);
        newNode.next = curr;
        newNode.prev = curr.prev;
        if (curr.prev != null) {
            curr.prev.next = newNode;
        } else {
            head = newNode; // Update head if the current node is the head
        }
        curr.prev = newNode;
        return head;
    }

    // Insert a node at a specific position
    public static Node insertAtPosition(Node head, int pos, int newData) {
        if (pos == 1) {
            return insertAtFront(head, newData);
        }
        Node curr = head;
        for (int i = 1; i < pos - 1 && curr != null; i++) {
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Position out of bounds.");
            return head;
        }
        Node newNode = new Node(newData);
        newNode.next = curr.next;
        newNode.prev = curr;
        if (curr.next != null) {
            curr.next.prev = newNode;
        }
        curr.next = newNode;
        return head;
    }

    // Print the doubly linked list
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert at Front");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert After a Node");
            System.out.println("4. Insert Before a Node");
            System.out.println("5. Insert at Position");
            System.out.println("6. Print List");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Insert at front
                    System.out.print("Enter the value to insert: ");
                    int dataFront = sc.nextInt();
                    head = insertAtFront(head, dataFront);
                    break;
                case 2: // Insert at end
                    System.out.print("Enter the value to insert: ");
                    int dataEnd = sc.nextInt();
                    head = insertAtEnd(head, dataEnd);
                    break;
                case 3: // Insert after a node
                    System.out.print("Enter the key after which to insert: ");
                    int keyAfter = sc.nextInt();
                    System.out.print("Enter the value to insert: ");
                    int dataAfter = sc.nextInt();
                    head = insertAfter(head, keyAfter, dataAfter);
                    break;
                case 4: // Insert before a node
                    System.out.print("Enter the key before which to insert: ");
                    int keyBefore = sc.nextInt();
                    System.out.print("Enter the value to insert: ");
                    int dataBefore = sc.nextInt();
                    head = insertBefore(head, keyBefore, dataBefore);
                    break;
                case 5: // Insert at position
                    System.out.print("Enter the position to insert: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter the value to insert: ");
                    int dataPos = sc.nextInt();
                    head = insertAtPosition(head, pos, dataPos);
                    break;
                case 6: // Print the list
                    System.out.print("Doubly Linked List: ");
                    printList(head);
                    break;
                case 7: // Exit
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
