package backjun;

import java.util.*;
import java.io.*;
public class BOJ_1991_트리순회 {
	
	static class Node {
		char data;
		Node left, right;
		Node(char data){
			this.data=data;
		}
	}
	static class Tree{
		Node root;
		public void add(char data, char ld, char rd) {
			if(root==null) {
				if(data!='.') {
					root = new Node(data);
				}
				if(ld!='.') {
					root.left = new Node(ld);
				}
				if(rd!='.') {
					root.right = new Node(rd);
				}
			}else {
				search(root, data, ld, rd);
			}
		}
		public void search(Node root, char data, char ld, char rd) {
			if(root==null) {
				return ;
			}else if(root.data == data) {
				if(ld!='.') {
					root.left = new Node(ld);
				}
				if(rd!='.') {
					root.right = new Node(rd);
				}
			}else {
				search(root.right, data, ld, rd);
				search(root.left, data, ld, rd);
			}
		}
		public void preorder(Node root) {
			//루트->왼쪽->오른쪽
			System.out.print(root.data);
			if(root.left!=null)
				preorder(root.left);
			if(root.right!=null)
				preorder(root.right);
		}
		public void inorder(Node root) {
			//왼쪽->루트->오른쪽
			if(root.left!=null)
				inorder(root.left);
			System.out.print(root.data);
			if(root.right!=null)
				inorder(root.right);
		}
		public void postorder(Node root) {
			//왼쪽->오른쪽->루트
			if(root.left!=null)
				postorder(root.left);
			if(root.right!=null)
				postorder(root.right);
			System.out.print(root.data);
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Tree t = new Tree();
		for(int i=0; i<n; i++) {
			String str = br.readLine().replaceAll(" ", "");
			char[] go = str.toCharArray();
			t.add(go[0], go[1], go[2]);
		}
		t.preorder(t.root);
		System.out.println();
		t.inorder(t.root);
		System.out.println();
		t.postorder(t.root);
		System.out.println();
	}
	
}
