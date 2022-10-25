package controller;

import java.util.Scanner;

import action.Action;

//사용자의 요청을 제어하는 클래스
public class IdolGroupController {
	public void processRequest(Action action, Scanner scanner) 
			throws Exception {
		action.execute(scanner);//다형성
	}
}
