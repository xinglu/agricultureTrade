package com.sy.graduationPro;

import com.sy.graduationPro.common.util.StrUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraduationProApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(StrUtil.uuid());
	}

}
