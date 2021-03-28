package com.gwo.myblog;

import com.gwo.myblog.utils.Md5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {

		String s = "dasdafa";
		String[] temp = s.split("");

		System.out.println(Md5Util.encodeByMd5(s));
		for (String s1 : temp) {
			System.out.println(s1);
		}

	}

}
