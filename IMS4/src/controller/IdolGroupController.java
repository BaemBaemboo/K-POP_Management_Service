package controller;

import java.util.Scanner;

import action.Action;

//������� ��û�� �����ϴ� Ŭ����
public class IdolGroupController {
	public void processRequest(Action action, Scanner scanner) 
			throws Exception {
		action.execute(scanner);//������
	}
}
