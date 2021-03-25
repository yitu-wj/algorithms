package com.yitu._06二叉搜索树;

import com.yitu._06二叉搜索树.file.Files;
import com.yitu.printer.BinaryTrees;


public class Main {
    private static void test1(){
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };
        BST<Integer> bst=new BST<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
        bst.remove(1);
        bst.remove(3);
        bst.remove(9);
        bst.remove(2);
        BinaryTrees.println(bst);
//        System.out.println(bst);
//        System.out.println("height:"+bst.height2());
//        System.out.println("height:"+bst.height());
//        bst.preorder(new BinarySearchTree.Visitor<Integer>() {
//            @Override
//            public boolean visit(Integer element) {
//                System.out.println(element);
//                return false;
//            }
//        });
    }
    private static void test2(){
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };
        BST<Person> bst1 = new BST<>();
        for (int i = 0; i < data.length; i++) {
            bst1.add(new Person(data[i]));
        }
        BinaryTrees.println(bst1);

        BST<Person> bst2 = new BST<>((o1, o2) -> o2.getAge() - o1.getAge());
        for (int i = 0; i < data.length; i++) {
            bst2.add(new Person(data[i]));
        }
        BinaryTrees.println(bst2);

    }
    private static void test3(){
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 40; i++) {
            bst.add((int)(Math.random() * 100));
        }

        String str = BinaryTrees.printString(bst);
        str += "\n";
        Files.writeToFile("E:/1.txt", str, true);
    }
    private static void test4(){
        BinaryTrees.println(new BST() {

            @Override
            public Object string(Object node) {
                return node.toString() + "_";
            }

            @Override
            public Object root() {
                return "A";
            }

            @Override
            public Object right(Object node) {
                if (node.equals("A")) return "C";
                if (node.equals("C")) return "E";
                return null;
            }

            @Override
            public Object left(Object node) {
                if (node.equals("A")) return "B";
                if (node.equals("C")) return "D";
                return null;
            }
        });
    }
    public static void main(String[] args) {
        test1();
//        test2();
//        test3();
//        test4();
    }
}
