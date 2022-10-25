package action;

import java.util.Scanner;

//각 요청을 처리하는 *Action 클래스의 규격을 정의하는 인터페이스
public interface Action {
	void execute(Scanner scanner) throws Exception;
}
