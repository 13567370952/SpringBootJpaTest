package com.anchora.mce.jpaTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.anchora.mce.jpaTest.dao.UserRepository;
import com.anchora.mce.jpaTest.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTestApplicationTests {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void find() {
		//查找所有
		List<User> list = userRepository.findAll();
//		list.forEach(x->System.out.println(x));
		 
		//排序查找　id 降序
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		list = userRepository.findAll(sort);
		list.forEach(x->System.out.println(x));
		 
		//分页查找
//		Pageable pageable =new PageRequest(0, 5);
		//分页降序查找
//		Pageable pageable = new PageRequest(0, 5, Sort.Direction.DESC,"id");
		Pageable pageable =new PageRequest(0, 5,sort);
		Page<User> datas = userRepository.findAll(pageable);
		datas.forEach(x->System.out.println(x));
		 
		//查找name不为null的
		list = userRepository.findByNameNotNull();
//		list.forEach(x->System.out.println("####"+x));
	}

	@Test
	public void insert() {
		// 创建10条记录
//		userRepository.save(new User("yshen", 10));
//		userRepository.save(new User("yshen1", 20));
//		userRepository.save(new User("yshen2", 30));
//		userRepository.save(new User("yshen3", 40));
//		userRepository.save(new User("yshen4", 50));
//		userRepository.save(new User("yshen5", 60));
//		userRepository.save(new User("yshne6", 70));
//		userRepository.save(new User("yshen7", 80));
//		userRepository.save(new User("yshen8", 90));
//		userRepository.save(new User("yshen9", 100));
	}
}
