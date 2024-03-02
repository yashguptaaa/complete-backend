package com.codewithyash.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codewithyash.blog.repositories.UserRepo;

@SpringBootTest
class BlogAppApIsApplicationTests {

	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest() {
		String className=this.userRepo.getClass().getName();
		String PackageName =this.userRepo.getClass().getPackageName();
	    System.out.println(className);
	    System.out.println(PackageName);
	}
}
